package servlet;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Driver;
import modele.Usager;
import utils.Communication;
import utils.Utilitaire;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet("/CompteServlet")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteServlet() {
        super();
    }

    //===========================================//
    // Constantes
    
    // La longueur pour les mots de passe
    private static int PWD_NB_CHARS = 8;
    
    // Les caractères valides pour le mot de passe
    private static String PWD_CARACTERES_VALIDES = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%&";
    
    // L'adresse couriel de l'expéditeur pour l'envoi des email de confirmation
    private static String EMAIL_EXPEDITEUR = "boite.a.ingredient@gmail.com";
        
    // Le login pour l'authentification sur le serveur smtp
    private static String SMTP_LOGIN = "boite.a.ingredient@gmail.com";
    
    // Le mot de passe pour l'authentification sur le serveur smtp
    private static String SMTP_PASSWORD = "";
    
    // Le message pour le courriel de confirmation pour la création d'un nouveau compte
    private static String MSG_EMAIL_COMPTE = "Merci pour votre inscription\nPour compléter la création de votre compte, copiez le code ci-dessous dans la zone du formulaire.";
    		
    // Le message pour le courriel de confirmation pour la ré-initialisation du mot de passe    			
    private static String MSG_EMAIL_PASSWORD = "Votre mot de passe a été ré-initialisé. Votre nouveau mot de passe temporaire se trouve ci-dessous.";
    
    //===========================================//
            
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Récupération de la session
		HttpSession session = request.getSession();
		
		// Récupération de l'action demandée
		String action = (String) request.getParameter("action");
		
		// On vérifie si l'usager est déjà connecté
		Usager user = (Usager) session.getAttribute("Usager"); 
		if(user != null){			
			// L'usager est connecté --> redirection vers la page de bienvenue
			action = "CANCEL";
		}
		
		// Aiguillage selon l'action
		String nomUsager, email, password, codeConfirmation, message;
		String urlDestination = "/ConnexionServlet?action=none";
		switch(action){
			case "BIENVENUE" :
				// Chargement des recettes pour la page de bienvenue					
				request.setAttribute("recettesCarousel", Driver.chargerRecettesBienvenue(user));				
				urlDestination = "/bienvenue.jsp";
				break;
			case "CREATE_ACCOUNT" :
				
				// Récupération des paramètres
				nomUsager = request.getParameter("userName");
				email = request.getParameter("email");
				password = request.getParameter("pwd");
				
				// On vérifie si l'usager n'existe pas déjà et si le mot de passe est valide
				if(Driver.trouverUsager(email) != null){
					// Erreur : l'usager existe déjà
					request.setAttribute("usagerExistant", true);
					urlDestination = "/creerCompte.jsp";
				}
				else if(Utilitaire.validerMotDePasse(password, PWD_NB_CHARS, PWD_CARACTERES_VALIDES) == false){
					// Mot de passe invalide
					request.setAttribute("pwdInvalide", true);
					urlDestination = "/creerCompte.jsp";
				}
				else{					
					// Génération d'un code aléatoire
					codeConfirmation = Utilitaire.genererCodeAleatoire();
					
					// Création du nouvel l'usager
					user = Driver.creerNouvelUsager(nomUsager, email, password);
					
					// On met les informations dans la session en attendant la confirmation
					session.setAttribute("usagerTemp", user);
					session.setAttribute("codeConfirmationCompte", codeConfirmation);
					
					// Création du message à envoyer
					message = MSG_EMAIL_COMPTE + "\n\nVoici votre code d'activation: " + codeConfirmation;
						

					try {
						// Envoi du courriel de validation
						Communication.envoyerCourriel(email, EMAIL_EXPEDITEUR, "Confirmation d'inscription", message, SMTP_LOGIN, SMTP_PASSWORD);
						
						// Redirection vers la page de confirmation
						urlDestination = "/WEB-INF/confirmationEmail.jsp";	
					} catch (MessagingException e) {
						e.printStackTrace();
						// Affichage d'un message d'erreur					
						request.setAttribute("erreurEnvoiEmail", true);
						urlDestination = "/creerCompte.jsp";
					}	
				}
				
				break;
			case "CONFIRM_EMAIL_NEW_ACCOUNT" :
				
				// Récupération des paramètres
				user = (Usager) session.getAttribute("usagerTemp");
				String codeOriginal = (String) session.getAttribute("codeConfirmationCompte"); 
				String codeSoumis = request.getParameter("codeSoumis");
								
				// Vérification du code de confirmation
				if(codeSoumis.equals(codeOriginal)){			
					
					//On efface les infos temporaires de la session
					session.removeAttribute("codeConfirmation");
					session.removeAttribute("usagerTemp");
					
					// Enregistrement du nouvel usager
					Driver.enregistrer(user, Usager.class);
					
					// Affichage d'un message de confirmation
					request.setAttribute("compteCree", true);
					urlDestination = "/WEB-INF/confirmationEmail.jsp";											   
				}
				else{					
					// Affichage d'un message d'erreur
					request.setAttribute("erreurCodeConfirmation", true);
					urlDestination = "/WEB-INF/confirmationEmail.jsp";
				}				
				
				break;
			case "RESET_PASSWORD" :
				
				// Récupération des paramètres
				email = request.getParameter("email");
				
				// Récupération de l'usager par son identifiant
				Usager usager = Driver.trouverUsager(email); 
				
				if(usager != null){
					
					// Création d'un nouveau mot de passe
					String newPassword = Utilitaire.genererMotDePasse(PWD_NB_CHARS, PWD_CARACTERES_VALIDES);
										
					// Création du message à envoyer
					message = MSG_EMAIL_PASSWORD + "\n\n Voici votre nouveau mot de passe: " + newPassword;
					
					try {
						
						// Envoi du courriel de validation
						Communication.envoyerCourriel(email, EMAIL_EXPEDITEUR, "Ré-initialisation du mot de passe", message, SMTP_LOGIN, SMTP_PASSWORD);
						
						// Enregistrement du nouveau mot de passe, dans le profil de l'usager
						usager.setPassword(newPassword);
						Driver.enregistrer(usager, Usager.class);						
						
						request.setAttribute("confirmationEmail", true);
						
					} catch (MessagingException e) {
						// Erreur --> affichage d'un message d'erreur					
						request.setAttribute("erreurEnvoiEmail", true);
					}		
				}
				else{
					// Erreur: l'usager n'existe pas
					request.setAttribute("usagerInexistant", true);
				}
								
				urlDestination = "/resetPassword.jsp";
				
				break;
			case "CANCEL" :
				urlDestination = "/ConnexionServlet?action=none";
				break;
			default :
				break;
		}
		
		// Forward
		RequestDispatcher rd = request.getRequestDispatcher(urlDestination);
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

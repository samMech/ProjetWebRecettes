package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Driver;
import modele.Usager;
import utils.Utilitaire;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Récupération de la session
		HttpSession session = request.getSession();
		
		// Récupération de l'action demandée
		String action = (String) request.getParameter("action");
		if(action == null){
			action = "NONE";// Chargement initial
		}
		
		// On vérifie si l'usager est déjà connecté
		Usager user = (Usager) session.getAttribute("Usager"); 
		if(! action.equals("DECONNEXION") && user != null){			
			// L'usager est connecté --> redirection vers la page de bienvenue
			action = "BIENVENUE";
		}
		
		// Aiguillage selon l'action
		String urlDestination = "/accueil.jsp";
		switch(action){			
			case "BIENVENUE" :
				
				// Chargement des recettes pour la page de bienvenue					
				request.setAttribute("recettesRecentes", Driver.chargerRecettesBienvenue(user));				
				urlDestination = "/WEB-INF/bienvenue.jsp";
				
				break;
			case "SE_CONNECTER" :
				
				// Récupération du login et password
				String login = request.getParameter("email");
				String password = request.getParameter("pwd");
								
				// Recherche de l'usager
				user = Driver.trouverUsager(login);
				
				// Vérification du login et mot de passe
				if(user != null && user.getPassword().equals(password)){
										
					// Ajout de l'usager à la session
					session.setAttribute("Usager", user);
				
					// On vérifie si l'option resté connecté est activé
					String[] options = request.getParameterValues("optConnexion");
					if(options != null && options.length == 1){
						session.setMaxInactiveInterval(-1);// La session n'expire plus
					}
					
					// Chargement des recettes pour la page de bienvenue					
					request.setAttribute("recettesRecentes", Driver.chargerRecettesBienvenue(user));										
					urlDestination = "/WEB-INF/bienvenue.jsp";					
				}
				else{
					// Erreur --> on retourne à la page
					request.setAttribute("erreurConnexion", true);
				}				
				
				break;
			case "DECONNEXION" :
				
				// On efface les infos de l'usager de la session				
				session.removeAttribute("Usager");
				
				// On remet l'expiration de la session à la valeur normale
				session.setMaxInactiveInterval(Utilitaire.getDefaultSessionTimeOut(getServletContext()));
				
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

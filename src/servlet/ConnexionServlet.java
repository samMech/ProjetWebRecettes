package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Driver;
import utils.Authentification;

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
				
		// Récupération des paramètres
		String idUsager = (String) session.getAttribute("idUsager");
		if(idUsager != null && ! idUsager.isEmpty()){			
			// L'usager est connecté --> redirection vers la page de bienvenue
			action = "BIENVENUE";
		}
		
		// Aiguillage selon l'action
		String urlDestination = "/accueil.jsp";
		switch(action){
			case "SE_CONNECTER" :
				
				// Récupération du login et password
				String login = request.getParameter("email");
				String password = request.getParameter("pwd");
				
				// Vérification du login et mot de passe
				if(Authentification.validerUsager(login, password)){
					// Ajout de l'usager à la session
					session.setAttribute("idUsager", login);
					
					// Chargement des recettes pour la page de bienvenue					
					request.setAttribute("recettesCarousel", Driver.chargerRecettesBienvenue());										
					urlDestination = "/bienvenue.jsp";					
				}
				else{
					// Erreur --> on retourne à la page
					request.setAttribute("erreurConnexion", true);
				}			

				break;
			case "BIENVENUE" :
				// Chargement des recettes pour la page de bienvenue					
				request.setAttribute("recettesCarousel", Driver.chargerRecettesBienvenue());				
				urlDestination = "/bienvenue.jsp";
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

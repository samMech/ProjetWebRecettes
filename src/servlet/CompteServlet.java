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
		
		// La destination
		String urlDestination = "/ConnexionServlet?action=none";
		switch(action){
			case "CREATE_ACCOUNT" :
				
				// Récupération des paramètres
				String nomUsager = request.getParameter("userName");
				String email = request.getParameter("email");
				String password = request.getParameter("pwd");
				
				// TODO: Envoi du courriel de validation
								
				// TODO Création d'un nouveau compte
				
				urlDestination = "/creerCompte.jsp";
				break;
			case "RESET_PASSWORD" :
				
				
				
				// Ré-initialisation du mot de passe			
				
				
				
				urlDestination = "/resetPassword.jsp";
				break;
			case "CANCEL" :
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

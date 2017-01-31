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
		
		// R�cup�ration de la session
		HttpSession session = request.getSession();
		
		// R�cup�ration de l'action demand�e
		String action = (String) request.getParameter("action");
				
		// R�cup�ration des param�tres
		String idUsager = (String) session.getAttribute("idUsager");
		if(idUsager != null && ! idUsager.isEmpty()){			
			// L'usager est connect� --> redirection vers la page de bienvenue
			action = "BIENVENUE";
		}
		
		// La destination
		String urlDestination = "/ConnexionServlet?action=none";
		switch(action){
			case "CREATE_ACCOUNT" :
				
				// R�cup�ration des param�tres
				String nomUsager = request.getParameter("userName");
				String email = request.getParameter("email");
				String password = request.getParameter("pwd");
				
				// TODO: Envoi du courriel de validation
								
				// TODO Cr�ation d'un nouveau compte
				
				urlDestination = "/creerCompte.jsp";
				break;
			case "RESET_PASSWORD" :
				
				
				
				// R�-initialisation du mot de passe			
				
				
				
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

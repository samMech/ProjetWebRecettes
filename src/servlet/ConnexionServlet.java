package servlet;

import java.io.IOException;
import java.net.ConnectException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Driver;
import modele.Usager;

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

		// R�cup�ration de la session
		HttpSession session = request.getSession();
		if(session == null){
			response.sendRedirect("accueil.jsp");
			return;
		}		

		// R�cup�ration de l'action demand�e
		String action = (String) request.getParameter("action");
		if(action == null){
			action = "NONE";// Chargement initial
		}
		
		// On v�rifie si l'usager est d�j� connect�
		Usager user = (Usager) session.getAttribute("Usager"); 
		if(! action.equals("DECONNEXION") && user != null){			
			// L'usager est connect� --> redirection vers la page de bienvenue
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
				
				// R�cup�ration du login et password
				String login = request.getParameter("email");
				String password = request.getParameter("pwd");
				
				// Recherche de l'usager
				user = Driver.trouverUsager(login);
				
				// V�rification du login et mot de passe
				if(user != null && user.getPassword().equals(password)){
										
					// Ajout de l'usager � la session
					session.setAttribute("Usager", user);
				
					// On v�rifie si l'option rest� connect� est activ�
					String[] options = request.getParameterValues("optConnexion");
					if(options != null && options.length == 1){
						session.setMaxInactiveInterval(-1);// La session n'expire plus
					}
					
					// Chargement des recettes pour la page de bienvenue					
					request.setAttribute("recettesRecentes", Driver.chargerRecettesBienvenue(user));										
					urlDestination = "/WEB-INF/bienvenue.jsp";					
				}
				else{
					// Erreur --> on retourne � la page
					request.setAttribute("erreurConnexion", true);
				}	
				
				break;
			case "DECONNEXION" :
				
				// On invalide la session				
				session.invalidate();
				
				// On retourne � la page d'accueil
				response.sendRedirect("accueil.jsp");
				return;
				
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

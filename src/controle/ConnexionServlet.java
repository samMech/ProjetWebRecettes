package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		// R�cup�ration de l'action demand�e
		String action = (String) session.getAttribute("action");
		
		// R�cup�ration des param�tres
		String idUsager = (String) session.getAttribute("idUsager");
		if(idUsager != null && ! idUsager.isEmpty()){			
			// L'usager est connect� --> redirection vers la page de bienvenue
			action = "BIENVENUE";
		}
		
		// La destination
		String urlDestination;		

		switch(action){
			case "SE_CONNECTER" :
				
				// R�cup�ration du login et password
				String login = request.getParameter("login");
				String password = request.getParameter("password");
				
				// V�rification
				// TODO
				
				// Chargement du profil
				// TODO
				urlDestination = "/Bienvenue.jsp";
				break;
			case "BIENVENUE" :
				urlDestination = "/Bienvenue.jsp";
				break;
			default :
				urlDestination = "/Accueil.html";
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

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RechercheServlet
 */
@WebServlet("/RechercheServlet")
public class RechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheServlet() {
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
		if(action == null){
			action = "NONE";// Chargement initial
		}
		
		// TODO: r�cup�ration des crit�res de recherche....
		System.out.println("HELLOR !!!!");
		// Aiguillage selon l'action
		String urlDestination = "/WEB-INF/rechercheRecette.jsp";
		switch(action){			
			case "QUICK_SEARCH" :
				
				// On r�cup�re les crit�res de la recherche libre					
				String chaine = (String) request.getAttribute("texteRecherche");				
				
				// TODO: s�par� en mot et faire recherche avec nouvelles m�thodes DAO				
				
				break;
			case "SEARCH" :
				
				// R�cup�ration des crit�res de recherche
				
				// Recherche
				
				// Retour des r�sultats en XML (pour AJAX)
				
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

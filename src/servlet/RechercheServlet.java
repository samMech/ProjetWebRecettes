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
		
		// Récupération de la session
		HttpSession session = request.getSession();
		
		// Récupération de l'action demandée
		String action = (String) request.getParameter("action");
		if(action == null){
			action = "NONE";// Chargement initial
		}
		
		// TODO: récupération des critères de recherche....
		System.out.println("HELLOR !!!!");
		// Aiguillage selon l'action
		String urlDestination = "/WEB-INF/rechercheRecette.jsp";
		switch(action){			
			case "QUICK_SEARCH" :
				
				// On récupère les critères de la recherche libre					
				String chaine = (String) request.getAttribute("texteRecherche");				
				
				// TODO: séparé en mot et faire recherche avec nouvelles méthodes DAO				
				
				break;
			case "SEARCH" :
				
				// Récupération des critères de recherche
				
				// Recherche
				
				// Retour des résultats en XML (pour AJAX)
				
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

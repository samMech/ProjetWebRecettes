package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Driver;
import modele.CategoriesIngredient;
import modele.Recette;
import modele.TypesRecette;
import modele.Usager;

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
		
		// R�cup�ration de l'usag� connect�
		Usager user = (Usager) session.getAttribute("Usager");
		
		// R�cup�ration de l'action demand�e
		String action = (String) request.getParameter("action");
		if(action == null){
			action = "NONE";// Chargement initial
		}
		
		// R�cup�ration des crit�res de recherche....
		List<TypesRecette> types = Driver.getTypesRecette();
		List<CategoriesIngredient> categories = Driver.getCategories();
		request.setAttribute("typesRecette", types);
		request.setAttribute("categoriesIngredient", categories);
				
		// Cr�ation de la liste des recettes
		List<Recette> recettesTrouvees = null;
		
		// Aiguillage selon l'action
		String urlDestination = "/WEB-INF/rechercheRecette.jsp";
		switch(action){			
			case "QUICK_SEARCH" :				
				// On r�cup�re les crit�res de la recherche libre					
				String chaine = (String) request.getAttribute("texteRecherche");				
				request.setAttribute("quickSearch", chaine);
				
				// On r�cup�re la liste des recettes trouv�es
				recettesTrouvees = Driver.rechercheLibre(user, chaine);
				
				break;
			case "SEARCH" :
				
				// R�cup�ration des crit�res de recherche
				
				// Recherche
				
				// Retour des r�sultats en XML (pour AJAX)
				
				break;				
			default :
				break;
		}
		
		// TODO: ajax sur la liste des r�sulats !!!!
		
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

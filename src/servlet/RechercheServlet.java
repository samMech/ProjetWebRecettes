package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import modele.DureeMax;
import modele.Recette;
import modele.TypesRecette;
import modele.Usager;
import utils.Conversion;

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
		if(session == null){
			response.sendRedirect("accueil.jsp");
			return;
		}
		
		// Récupération de l'usagé connecté
		Usager user = (Usager) session.getAttribute("Usager");
		if(user == null){
			response.sendRedirect("accueil.jsp");
			return;
		}
		
		// Récupération de l'action demandée
		String action = (String) request.getParameter("action");
		if(action == null){
			action = "NONE";
		}
				
		// Création de la liste des recettes
		List<Recette> recettesTrouvees = new ArrayList<>();
		
		// Aiguillage selon l'action
		String urlDestination = "/WEB-INF/rechercheRecette.jsp";
		switch(action){		
			case "QUICK_SEARCH" :	
				// Récupération des critères de recherche...
				initCriteres(request);
				
				// On récupère les critères de la recherche libre					
				String chaine = (String) request.getParameter("texteRecherche");				
				request.setAttribute("texteRecherche", chaine);
								
				// On récupère la liste des recettes trouvées
				recettesTrouvees = Driver.rechercheLibre(user, chaine);
				
				break;
			case "SEARCH" :				
				// Récupération des critères de recherche
				String sType = request.getParameter("type");
				String sDuree = request.getParameter("duree"); 
				String[] sCategories = request.getParameterValues("categories");
						
				// On récupère la liste des recettes trouvées
				recettesTrouvees = Driver.recherche(user, sType, sDuree, sCategories);
				
				break;
			case "ALL" :
			case "NONE" :
				// On récupère la liste de toutes les recettes de l'usager
				recettesTrouvees = Driver.getRecettesUsager(user);	
				
				break;
			default :
				break;
		}		
		
		System.out.println("ACTION = " + action);
		System.out.println("NB RÉSULTATS = " + recettesTrouvees.size());

		// Ajout des résultats à la réponse
		ajouterResultats(response, recettesTrouvees);
		
		// Si on vient d'une autre page
		switch(action){
			case "NONE":
			case "QUICK_SEARCH" :
				
				// Récupération des critères de recherche...
				initCriteres(request);	
				
				// Forward vers la page de recherche
				RequestDispatcher rd = request.getRequestDispatcher(urlDestination);
				rd.forward(request, response);				
				break;
			default:
				break;
		}		
	}
	
	// Méthode pour charger les critères de recherche dans la page
	private void initCriteres(HttpServletRequest request){
		List<TypesRecette> types = Driver.getTypesRecette();
		List<CategoriesIngredient> categories = Driver.getCategories();
		DureeMax[] dureesMax = DureeMax.values();
		request.setAttribute("typesRecette", types);
		request.setAttribute("categoriesIngredient", categories);
		request.setAttribute("dureesMax", dureesMax);
	}

	// Méthode pour charger la réponse
	private void ajouterResultats(HttpServletResponse response, List<Recette> recettesTrouvees) throws IOException {		
		if(! recettesTrouvees.isEmpty()){
			// Conversion des résultats en XML
			StringBuffer sb = new StringBuffer();
			Conversion.convertirRecettesEnXML(sb, recettesTrouvees);
			
			// Ajout de la liste des résultats xml à la réponse
			response.setContentType("text/xml");        
		    response.setHeader("Cache-Control", "no-cache");        
		    response.getWriter().write("<recettes>" + sb.toString() + "</recettes>");
		} else {
			// Aucun résultat
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

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
import modele.DUREE;
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
		
		// R�cup�ration de la session
		HttpSession session = request.getSession();
		if(session == null){
			response.sendRedirect("accueil.jsp");
			return;
		}
		
		// R�cup�ration de l'usag� connect�
		Usager user = (Usager) session.getAttribute("Usager");
		if(user == null){
			response.sendRedirect("accueil.jsp");
			return;
		}
		
		// R�cup�ration de l'action demand�e
		String action = (String) request.getParameter("action");
		if(action == null){
			action = "NONE";
		}
				
		// Cr�ation de la liste des recettes
		List<Recette> recettesTrouvees = new ArrayList<>();
		
		// Aiguillage selon l'action
		String urlDestination = "";
		switch(action){		
			case "QUICK_SEARCH" :					
				/*
				 *  Une fois la page charg�e, la recherche va �tre lanc�e avec la cha�ne...
				 *  On ne fait donc pas la recherche ici.
				*/
				
				// On r�cup�re les crit�res de la recherche libre					
				String chaine = (String) request.getParameter("texteRecherche");		
				
				// On remet les crit�res dans la requ�te
				request.setAttribute("texteRecherche", chaine);	
				
				urlDestination = "/WEB-INF/rechercheRecette.jsp";
				break;
			case "SEARCH" :				
				// R�cup�ration des crit�res de recherche
				String sTexte = request.getParameter("texte");
				String sType = request.getParameter("type");
				String sDuree = request.getParameter("duree"); 
				String[] sCategories = request.getParameterValues("categories");
						
				// On r�cup�re la liste des recettes trouv�es
				recettesTrouvees = Driver.rechercherRecettes(user, sTexte, sType, sDuree, sCategories);				
				break;
			case "ALL" :
				// On r�cup�re la liste de toutes les recettes de l'usager
				recettesTrouvees = Driver.getRecettesUsager(user);					
				break;
			default :
				urlDestination = "/WEB-INF/rechercheRecette.jsp";
				break;
		}		
		
		System.out.println("ACTION = " + action);
		System.out.println("NB R�SULTATS = " + recettesTrouvees.size());
		
		// Si on vient d'une autre page
		if(! urlDestination.isEmpty()){						
			// R�cup�ration des crit�res de recherche...
			initCriteres(request);	
		
			// Forward vers la page de recherche
			RequestDispatcher rd = request.getRequestDispatcher(urlDestination);
			rd.forward(request, response);
		}		
		else{
			// Ajout des r�sultats � la r�ponse (re�u par AJAX dans la page de recherche)
			ajouterResultats(response, recettesTrouvees);
		}
	}
	
	// M�thode pour charger les crit�res de recherche dans la page
	private void initCriteres(HttpServletRequest request){
		List<TypesRecette> types = Driver.getTypesRecette();
		List<CategoriesIngredient> categories = Driver.getCategories();
		DUREE[] dureesMax = DUREE.values();
		request.setAttribute("typesRecette", types);
		request.setAttribute("categoriesIngredient", categories);
		request.setAttribute("dureesMax", dureesMax);
	}

	// M�thode pour charger la r�ponse
	private void ajouterResultats(HttpServletResponse response, List<Recette> recettesTrouvees) throws IOException {		
		if(! recettesTrouvees.isEmpty()){
			// Conversion des r�sultats en XML
			StringBuffer sb = new StringBuffer();
			Conversion.convertirRecettesEnXML(sb, recettesTrouvees);
			
			// Ajout de la liste des r�sultats xml � la r�ponse
			response.setContentType("text/xml");        
		    response.setHeader("Cache-Control", "no-cache");        
		    response.getWriter().write("<recettes>" + sb.toString() + "</recettes>");
		} else {
			// Aucun r�sultat
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

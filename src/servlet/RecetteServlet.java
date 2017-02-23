package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
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
import modele.Ingredient;
import modele.Instruction;
import modele.Mesure;
import modele.Recette;
import modele.TypesRecette;
import modele.Unite;
import modele.Usager;
import utils.Conversion;
import utils.Utilitaire;

/**
 * Servlet implementation class RecetteServlet
 * Cette servlet sera utilitée pour gérer la navigation reliée à la création/visualisation/modification/suppression des recettes. 
 */
@WebServlet("/RecetteServlet")
public class RecetteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecetteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// on recupere la session
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
		
		//on recupere le paramètre qui indique l'action à executer
		String action = request.getParameter("action");
		if(action == null){
			action = "NONE";// Chargement initial
		}
		//on prepare un objet recette qui va etre utiliser pour toutes les operations de la servlet
		Recette recette = null;
		
		//string contenant la page vers laquelle on redirige
		String pageDestination = "";
		
		switch(action){
		
		case "chargerFormulaire":
			
			List<TypesRecette> listeTypes = Driver.getTypesRecette();
			List<Unite> listeUnites = Driver.getUnites();
			List<CategoriesIngredient> listeCategories = Driver.getCategories();
			request.setAttribute("typesRecette", listeTypes);
			request.setAttribute("unites", listeUnites);
			request.setAttribute("categories", listeCategories);
			pageDestination = "/WEB-INF/FormRecette.jsp";
			break;
			
		case "ajouterRecette":
			
			//on crée un objet recette
			recette = new Recette();
			
			//on verifie si c'est une nouvelle recette ou une modification de recette
			String idAModifier = request.getParameter("idRecetteAModifier");
			if(idAModifier != null && idAModifier != ""){
				Long id = Long.parseLong(idAModifier);
				recette.setIdRecette(id);
			}
			
			//on ajoute le nom, description et durée dans l'objet recette
			recette.setNomRecette(request.getParameter("nomRecette"));
			recette.setDescriptionRecette(request.getParameter("descRecette"));
			int heure = Integer.parseInt(request.getParameter("heureRecette"));
			int minute = Integer.parseInt(request.getParameter("minRecette"));
			recette.setDureeRecette(utils.Conversion.convertirTemps(heure, minute));
			
			//on ajoute le type de la recette dans la recette
			long idType = Long.parseLong(request.getParameter("typeRecette"));	
			TypesRecette type = Driver.getTypeRecette(idType);
			recette.setTypesRecette(type);
			
			//parcourir la liste des ingredients et ajouter le nom, quantité et unité de mesure dans la recette
			int i = 1;
			while(request.getParameter("nomIngredient" +i) != null){	

				//recuperer l'ingredient, la quantité, l'unite de mesure et la categorie du formulaire
				String nomIngredient = request.getParameter("nomIngredient"+i);
				double qte = Double.parseDouble(request.getParameter("qte"+i));
				String unite = request.getParameter("unite"+i);
				String categorieIng = request.getParameter("categorie"+i);
				

				Unite unit = Driver.getUnite(Long.parseLong(unite));
				CategoriesIngredient categorie = Driver.getCategorie(Long.parseLong(categorieIng));
				
				Ingredient ing = new Ingredient();
				ing.setNomIngredient(nomIngredient);
				ing.setCategoriesIngredient(categorie);
				
				Mesure mesure = new Mesure();
				mesure.setQuantite(qte);
				mesure.setIngredient(ing);
				mesure.setUnite(unit);
				recette.addMesure(mesure);
				i++;
			}
			
			i=1;
			while(request.getParameter("instruction" + i) != null){
				Instruction instruction = new Instruction();
				instruction.setNumOrdre(i);
				instruction.setDescInstruction(request.getParameter("instruction" + i));
				recette.addInstruction(instruction);
				i++;
			}
			
			//on associe la recette à l'usager connecté
			recette.setUsager(user);
			
			//on enregistre la recette dans BD
			recette = Driver.enregistrer(recette, Recette.class);
			
			//on retourne a la servlet avec l'action voirRecette pour afficher
			//pour maintenir les fonctionnalités i18n
			pageDestination = "RecetteServlet?action=voirRecette&idRecette="+recette.getIdRecette();
			break;
			
		case "supprimerRecette":
			long idRecette = Long.parseLong(request.getParameter("idRecetteToDelete"));
			Driver.supprimerRecette(idRecette);
			pageDestination = "/ConnexionServlet?action=BIENVENUE";
			break;
		
		case "voirRecette":
			long id = Long.parseLong(request.getParameter("idRecette"));
			recette = Driver.getRecette(id);
			//trier la liste des instructions pour assurer l'ordre
			Utilitaire.trierListeInstructions(recette.getInstructions());
			request.setAttribute("recette", recette);
			request.setAttribute("dureeRecette", Conversion.convertirTemps(recette.getDureeRecette()));
			pageDestination = "/WEB-INF/ViewRecette.jsp";
			break;
		
		case "modifierRecette":
			long idRecetteAmodifier = Long.parseLong(request.getParameter("idRecetteToModify"));
			recette = Driver.getRecette(idRecetteAmodifier);
			//trier la liste des instructions pour assurer l'ordre
			Utilitaire.trierListeInstructions(recette.getInstructions());
			request.setAttribute("recette", recette);
			heure = Conversion.getHeure(recette.getDureeRecette());
			minute = Conversion.getMinute(recette.getDureeRecette());
			request.setAttribute("heureRecette", heure);
			request.setAttribute("minuteRecette", minute);
			
			listeTypes = Driver.getTypesRecette();
			listeUnites = Driver.getUnites();
			listeCategories = Driver.getCategories();
			request.setAttribute("typesRecette", listeTypes);
			request.setAttribute("unites", listeUnites);
			request.setAttribute("categories", listeCategories);
			pageDestination = "/WEB-INF/FormRecette.jsp";
			break;
		default:
			break;
		}
		
		if(action.equals("ajouterRecette")){
			response.sendRedirect(pageDestination);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher(pageDestination);
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

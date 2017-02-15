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
import modele.DaoJPA;
import modele.DaoRecette;
import modele.Ingredient;
import modele.Instruction;
import modele.Mesure;
import modele.Recette;
import modele.TypesRecette;
import modele.Unite;
import modele.Usager;
import utils.Conversion;

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
		
		//on recupere le paramètre qui indique l'action à executer
		String requete = request.getParameter("action");
		
		//on recupere l'objet dao
		DaoRecette dao  = Driver.getDaoRecette();
		
		Recette recette = null;
		//string contenant la page vers laquelle on redirige
		String pageDestination = "";
		
		switch(requete){
		
		case "chargerFormulaire":
			
			List<TypesRecette> listeTypes = Driver.getTypesRecette();
			request.setAttribute("typesRecette", listeTypes);
			pageDestination = "/WEB-INF/FormRecette.jsp";
			break;
		case "ajouterRecette":
			
			//on crée un objet recette
			recette = new Recette();
			
			//on ajoute le nom, description et durée dans l'objet recette
			recette.setNomRecette(request.getParameter("nomRecette"));
			recette.setDescriptionRecette(request.getParameter("descRecette"));
			int heure = Integer.parseInt(request.getParameter("heureRecette"));
			int minute = Integer.parseInt(request.getParameter("minRecette"));
			recette.setDureeRecette(utils.Conversion.convertirTemps(heure, minute));
			
			//on ajoute le type de la recette dans l'objet recette

			long idType = Long.parseLong(request.getParameter("typeRecette"));	
			TypesRecette type = Driver.getDaoType().chercherTypesRecette(idType);
			
			recette.setTypesRecette(type);
			
			//parcourir la liste des ingredients et ajouter le nom, quantité et unité de mesure dans la recette
			
			int i = 1;
			while(request.getParameter("nomIngredient" +i) != null){	
				System.out.println(request.getParameter("nomIngredient"+i));
				System.out.println(request.getParameter("qte"+i));
				System.out.println(request.getParameter("unite"+i));
				String nomIngredient = request.getParameter("nomIngredient"+i);
				double qte = Double.parseDouble(request.getParameter("qte"+i));
				String unite = request.getParameter("unite"+i);
				//TODO creer des unites dans la BD et les utiliser pour charger la liste d'options d'unités
				Unite unit = new Unite();
				unit.setNomUnite(unite);
				Ingredient ing = new Ingredient();
				ing.setNomIngredient(nomIngredient);
				
				//TODO: wtf is type d'unite???
				unit.setTypeUnite("fakeTypeUnite");
				//TODO: faire les categories reels
				CategoriesIngredient fake = new CategoriesIngredient();
				fake.setNomCategorieIng("fake");
				ing.setCategoriesIngredient(fake);
				
				Mesure mesure = new Mesure();
				mesure.setQuantite(qte);
				mesure.setIngredient(ing);
				mesure.setUnite(unit);
				System.out.println(mesure.getQuantite() + " " + mesure.getIngredient().getNomIngredient() + " " + mesure.getUnite().getNomUnite());
				recette.addMesure(mesure);
				i++;
			}
			
			i=1;
			while(request.getParameter("instruction" + i) != null){
				Instruction instruction = new Instruction();
				instruction.setDescInstruction(request.getParameter("instruction" + i));
				recette.addInstruction(instruction);
				i++;
			}
			
			//on ajoute l'id de l'usager dans la recette
			Usager usager = (Usager) session.getAttribute("Usager");
			recette.setUsager(usager);
			
			//on enregistre les mesures dans BD
			for(Mesure mesure : recette.getMesures()) {
				Driver.enregistrer(mesure.getIngredient(), Ingredient.class);
				Driver.enregistrer(mesure.getUnite(), Unite.class);
				Driver.enregistrer(mesure, Mesure.class);
			}
			
			//on enregistre les instructions dans BD
			for(Instruction inst : recette.getInstructions()){
				Driver.enregistrer(inst, Instruction.class);
			}
			
			//on enregistre la recette dans BD
			dao.enregistrer(recette);
			
			//on ajoute la recette dans la requete pour l'afficher dans la page viewRecette
			request.setAttribute("recette", recette);
			pageDestination = "/WEB-INF/ViewRecette.jsp";
			break;
			
		case "supprimerRecette":
			recette = (Recette) request.getAttribute("recette");
			dao.supprimer(recette);
			pageDestination = "/WEB-INF/Bienvenue.jsp";
			break;
		
		case "voirRecette":
			long id = Long.parseLong(request.getParameter("idRecette"));
			recette = dao.chercherRecette(id);
			int heureRecette = Conversion.getHeure(recette.getDureeRecette());
			int minuteRecette = Conversion.getMinute(recette.getDureeRecette());
			request.setAttribute("recette", recette);
			request.setAttribute("heureRecette", heureRecette);
			request.setAttribute("minuteRecette", minuteRecette);
			pageDestination = "/WEB-INF/ViewRecette.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(pageDestination);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.DaoRecette;
import modele.Ingredient;
import modele.Instruction;
import modele.Mesure;
import modele.Recette;
import modele.TypesRecette;
import modele.Unite;
import modele.Usager;

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
		DaoRecette dao  = new DaoRecette();
		
		Recette recette = null;
		//string contenant la page vers laquelle on redirige
		String pageDestination = "";
		
		switch(requete){
		
		case "chargerFormulaire":
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
			
			//TODO creer des types de recette dans la BD et les utiliser pour charger la liste d'options de type
			TypesRecette type = new TypesRecette();
			type.setTypeRecette(request.getParameter("typeRecette"));
			recette.setTypesRecette(type);

			
			//parcourir la liste des incredients et ajouter le nom, quantité et unité de mesure dans la recette
			String[] ingredient;
			int i = 0;
			while(request.getParameterValues("ingredient" + (i+1)) != null){
				ingredient = request.getParameterValues("ingredient"+(i+1));
				//TODO creer des unites dans la BD et les utiliser pour charger la liste d'options d'unités
				Unite unit = new Unite();
				unit.setNomUnite(ingredient[2]);
				
				Ingredient ing = new Ingredient();
				ing.setNomIngredient(ingredient[0]);
				
				Mesure mesure = new Mesure();
				mesure.setQuantite(Long.parseLong(ingredient[1]));
				mesure.setIngredient(ing);
				mesure.setUnite(unit);
				
				recette.addMesure(mesure);
				i++;
			}
			
			i=0;
			while(request.getParameter("instruction" + (i+1)) != null){
				Instruction instruction = new Instruction();
				instruction.setDescInstruction(request.getParameter("instruction" + (i+1)));
				recette.addInstruction(instruction);
				i++;
			}
			
			//on ajoute l'id de l'usager dans la recette
			Usager usager = (Usager) session.getAttribute("Usager");
			recette.setUsager(usager);
			
			//on enregistre la recette dans la BD
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
			request.setAttribute("recette", recette);
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

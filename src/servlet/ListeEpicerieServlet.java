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
import modele.Ingredient;
import modele.PanierRecettes;
import modele.Recette;
import modele.Usager;
import utils.Conversion;

/**
 * Servlet implementation class ListeEpicerieServlet
 */
@WebServlet("/ListeEpicerieServlet")
public class ListeEpicerieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeEpicerieServlet() {
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
			action = "NONE";// Chargement initial
		}
	
		// R�cup�ration du panier
		PanierRecettes panier = (PanierRecettes) session.getAttribute("panierRecettes");
		if(panier == null){
			panier = Driver.creerPanier();
		}
		
		// Aiguillage selon l'action
		Recette recette;
		long idRecette;
		String urlDestination = "";
		switch(action){
			case "INCREMENTER":
				// R�cup�ration de l'id de la recette
				idRecette = Long.parseLong(request.getParameter("idRecette"));
				
				// On incr�mente la quantit� de la recette dans le panier
				if(panier.augmenterQuantiteRecette(idRecette) == false){
					// On r�cup�re la nouvelle recette pour l'ajouter au panier
					recette = Driver.getRecette(idRecette);
					panier.ajouterRecette(recette);
				}
				
				break;
			case "DECREMENTER":
				// R�cup�ration de l'id de la recette
				idRecette = Long.parseLong(request.getParameter("idRecette"));
				
				// On retire la recette du panier
				panier.retirerRecette(idRecette);
				
				break;		
			case "CREER_LISTE":
				
				// R�cup�ration des recettes du panier
				List<Recette> listeRecettes = panier.getRecettes();
				
				// R�cup�ration de la liste de tous les ingr�dients
				List<Ingredient> listeEpicerie = Conversion.creerListeEpicerie(listeRecettes);
				
				// Ajout de la liste des ingr�dients � la requ�te
				request.setAttribute("listeEpicerie", listeEpicerie);
				
				urlDestination = "/WEB-INF/modificationListe.jsp";				
				break;
			case "AFFICHER_LISTE":// TODO
				
				// R�cup�ration de la liste des ingr�dients modifi�es
				
				
				// Ajout de la liste � la requ�te				
				
				urlDestination = "/WEB-INF/affichageListe.jsp";
				break;
			default:
				break;
		}
		
		// On remet le panier mis � jour dans la session
		session.setAttribute("panierRecettes", panier);
				
		// Forward
		if(! urlDestination.isEmpty()){
			// Si on va vers une autre page (i.e: pas une requ�te AJAX)
			RequestDispatcher rd = request.getRequestDispatcher(urlDestination);
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

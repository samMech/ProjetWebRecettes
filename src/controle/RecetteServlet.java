package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.DaoRecette;
import modele.Recette;

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
		
		//on recupere le paramètre qui indique l'action à executer
		String requete = request.getParameter("action");
		
		//on recupere l'objet dao
		DaoRecette dao  = (DaoRecette)request.getAttribute("dao");
		
		Recette recette = null;
		//string contenant la page vers laquelle on redirige
		String pageDestination;
		
		switch(requete){
		case "ajouterRecette":
			recette = new Recette();
			recette.setNomRecette(request.getParameter("nomRecette"));
			recette.setDescriptionRecette(request.getParameter("descRecette"));
			int heure = Integer.parseInt(request.getParameter("heureRecette"));
			int minute = Integer.parseInt(request.getParameter("minRecette"));
			recette.setDureeRecette(utils.Conversion.convertirTemps(heure, minute));
			//TODO: continuer le parcours du formulaire pour la creation de l'objet recette + insert avec dao
			
			pageDestination = "/WEB-INF/ViewRecette.jsp";
			break;
			
		case "supprimerRecette":
			recette = (Recette) request.getAttribute("recette");
			dao.supprimer(recette);
			pageDestination = "/WEB-INF/Bienvenue.jsp";
			break;
		
		case "voirRecette":
			String id = request.getParameter("idRecette");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

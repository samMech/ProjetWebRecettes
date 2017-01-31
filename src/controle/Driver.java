package controle;

import java.util.List;

import modele.DaoRecette;
import modele.Recette;

/**
 * Classe contrôleur pour la gestion du dao
 * 
 * @author Marc-André Malouin
 * @version 1.00 (31 janvier 2017)
 */
public class Driver {

	/**
	 * Méthode pour récupérer la liste des recettes à afficher sur la page de bienvenue
	 * 
	 * @return La liste des recettes à afficher
	 */
	public static List<Recette> chargerRecettesBienvenue(){
		DaoRecette dao = new DaoRecette();
		return dao.chercherRecettesRecentes(5);
	}	
}

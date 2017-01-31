package controle;

import java.util.List;

import modele.DaoRecette;
import modele.Recette;

/**
 * Classe contr�leur pour la gestion du dao
 * 
 * @author Marc-Andr� Malouin
 * @version 1.00 (31 janvier 2017)
 */
public class Driver {

	/**
	 * M�thode pour r�cup�rer la liste des recettes � afficher sur la page de bienvenue
	 * 
	 * @return La liste des recettes � afficher
	 */
	public static List<Recette> chargerRecettesBienvenue(){
		DaoRecette dao = new DaoRecette();
		return dao.chercherRecettesRecentes(5);
	}	
}

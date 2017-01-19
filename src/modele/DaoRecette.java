package modele;

import java.util.List;

/**
 * Classe pour un DAO sur des Recettes
 * 
 * @version 1.00 (19 janvier 2017)
 * @author Marc-André Malouin
 */
public class DaoRecette extends DaoJPA<Recette> {

	/**
	 * Constructeur par défaut
	 */
	public DaoRecette() {
		super(Recette.class);
	}
	
	//////////////
	// Méthodes //
	//////////////
	
	
	public List<Recette> chercherRecette(){
		
		return null;
	}
	

}

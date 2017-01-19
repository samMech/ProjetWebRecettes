package modele;

import java.util.List;

/**
 * Classe pour un DAO sur des Recettes
 * 
 * @version 1.00 (19 janvier 2017)
 * @author Marc-Andr� Malouin
 */
public class DaoRecette extends DaoJPA<Recette> {

	/**
	 * Constructeur par d�faut
	 */
	public DaoRecette() {
		super(Recette.class);
	}
	
	//////////////
	// M�thodes //
	//////////////
	
	
	public List<Recette> chercherRecette(){
		
		return null;
	}
	

}

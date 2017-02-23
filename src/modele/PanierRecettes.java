package modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe pour le panier contenant la liste des recettes choisies pour cr�er la liste d'�picerie
 * Le panier ne contient aucun doublon, mais la quantit� de chaque recette est conserv�e 
 *  
 * @author Marc-Andr� Malouin
 * @version 1.00 (22 f�vrier 2017)
 */
public class PanierRecettes {

	// La liste des recettes dans le panier
	List<Recette> recettes = new ArrayList<>();
	
	// La map pour associer chaque recette � sa quantit�
	Map<Long, Integer> quantite = new HashMap<>();
	
	/**
	 * Constructeur par d�faut
	 */
	public PanierRecettes(){
				
	}
	
	/**
	 * M�thode pour retourner la liste des recettes
	 * 
	 * @return La liste des recettes dans le panier
	 */
	public List<Recette> getRecettes(){
		return recettes;
	}
	
	/**
	 * M�thode pour retourner la quantit� d'une recette dans le panier
	 * 
	 * @param idRecette L'id de la recette
	 * @return La quantit� de cette recette dans le panier ou -1 si la recette n'est pas dans le panier
	 */
	public int getQuantite(long idRecette){
		if(quantite.containsKey(idRecette)){
			return quantite.get(idRecette);
		}
		return -1;
	}
	
	/**
	 * M�thode pour vider le panier
	 */
	public void viderPanier(){
		recettes.clear();
		quantite.clear();
	}
			
	/**
	 * M�thode pour ajouter une recette au panier
	 * 
	 * Si la recette existe d�j�, sa quantit� est augment�e
	 * 
	 * @param recette La recette � ajouter
	 */
	public void ajouterRecette(Recette recette){
		if(quantite.containsKey(recette.getIdRecette())){
			// On incr�mente la quantit� de la recette existante
			quantite.put(recette.getIdRecette(), quantite.get(recette.getIdRecette()) + 1);
		}
		else{
			// Ajout de la recette au panier
			recettes.add(recette);
			quantite.put(recette.getIdRecette(), 1);
		}
	}
		
	/**
	 * M�thode pour incrementer la quantit� d'une recette dans le panier
	 * 
	 * @param idRecette L'id de la recette
	 * @return false si la recette n'est pas dans le panier
	 */
	public boolean augmenterQuantiteRecette(long idRecette){
		if(quantite.get(idRecette) != null){
			// On incr�mente la quantit� de la recette existante
			quantite.put(idRecette, quantite.get(idRecette) + 1);
			return true;
		}
		return false;
	}
	
	/**
	 * M�thode pour retirer une recette du panier
	 * 
	 * Si la quantit� de la recette est plus grande que 1, sa quantit� est d�cr�ment�e
	 * Sinon, elle est supprim�e du panier
	 * 
	 * @param idRecette L'id de la recette � retirer
	 */
	public void retirerRecette(long idRecette){
		// Si la recette est dans le panier
		if(quantite.containsKey(idRecette)){				
			int qte = quantite.get(idRecette);
			if(qte == 1){
				// On supprime la recette
				quantite.remove(idRecette);
				for(int i=0; i < recettes.size(); i++){
					if(recettes.get(i).getIdRecette() == idRecette){
						recettes.remove(i);
						return;
					}
				}				
			}
			else{
				// On d�cr�mente la quantit�
				quantite.put(idRecette, qte - 1);
			}
		}
	}	
}

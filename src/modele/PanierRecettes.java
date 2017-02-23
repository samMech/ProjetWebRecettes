package modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe pour le panier contenant la liste des recettes choisies pour créer la liste d'épicerie
 * Le panier ne contient aucun doublon, mais la quantité de chaque recette est conservée 
 *  
 * @author Marc-André Malouin
 * @version 1.00 (22 février 2017)
 */
public class PanierRecettes {

	// La liste des recettes dans le panier
	List<Recette> recettes = new ArrayList<>();
	
	// La map pour associer chaque recette à sa quantité
	Map<Long, Integer> quantite = new HashMap<>();
	
	/**
	 * Constructeur par défaut
	 */
	public PanierRecettes(){
				
	}
	
	/**
	 * Méthode pour retourner la liste des recettes
	 * 
	 * @return La liste des recettes dans le panier
	 */
	public List<Recette> getRecettes(){
		return recettes;
	}
	
	/**
	 * Méthode pour retourner la quantité d'une recette dans le panier
	 * 
	 * @param idRecette L'id de la recette
	 * @return La quantité de cette recette dans le panier ou -1 si la recette n'est pas dans le panier
	 */
	public int getQuantite(long idRecette){
		if(quantite.containsKey(idRecette)){
			return quantite.get(idRecette);
		}
		return -1;
	}
	
	/**
	 * Méthode pour vider le panier
	 */
	public void viderPanier(){
		recettes.clear();
		quantite.clear();
	}
			
	/**
	 * Méthode pour ajouter une recette au panier
	 * 
	 * Si la recette existe déjà, sa quantité est augmentée
	 * 
	 * @param recette La recette à ajouter
	 */
	public void ajouterRecette(Recette recette){
		if(quantite.containsKey(recette.getIdRecette())){
			// On incrémente la quantité de la recette existante
			quantite.put(recette.getIdRecette(), quantite.get(recette.getIdRecette()) + 1);
		}
		else{
			// Ajout de la recette au panier
			recettes.add(recette);
			quantite.put(recette.getIdRecette(), 1);
		}
	}
		
	/**
	 * Méthode pour incrementer la quantité d'une recette dans le panier
	 * 
	 * @param idRecette L'id de la recette
	 * @return false si la recette n'est pas dans le panier
	 */
	public boolean augmenterQuantiteRecette(long idRecette){
		if(quantite.get(idRecette) != null){
			// On incrémente la quantité de la recette existante
			quantite.put(idRecette, quantite.get(idRecette) + 1);
			return true;
		}
		return false;
	}
	
	/**
	 * Méthode pour retirer une recette du panier
	 * 
	 * Si la quantité de la recette est plus grande que 1, sa quantité est décrémentée
	 * Sinon, elle est supprimée du panier
	 * 
	 * @param idRecette L'id de la recette à retirer
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
				// On décrémente la quantité
				quantite.put(idRecette, qte - 1);
			}
		}
	}	
}

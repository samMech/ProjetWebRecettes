package modele;

import java.util.ArrayList;
import java.util.List;

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
	
	// La liste des quantités pour chaque recette
	List<Integer> quantite = new ArrayList<>();
	
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
	 * @param pos La position de la recette dans le panier
	 * @return La quantité
	 */
	public int getQuantite(int pos){
		if(pos > 0 && pos < quantite.size()){
			return quantite.get(pos);
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
	 * Méthode pour retourner l'index d'une recette dans le panier panier
	 * 
	 * @param idRecette L'id de la recette
	 * @return L'index ou -1 si elle n'est pas dans le panier
	 */
	public int getPositionRecette(long idRecette){
		for(int i=0; i < recettes.size(); i++){
			if(recettes.get(i).getIdRecette() == idRecette){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Méthode pour ajouter une recette au panier
	 * 
	 * Si la recette existe déjà, sa quantité est augmentée
	 * 
	 * @param recette La recette à ajouter
	 */
	public void ajouterRecette(Recette recette){
		int pos = recettes.indexOf(recette);
		if(pos != -1){
			// La recette est déjà dans le panier
			quantite.set(pos, quantite.get(pos) + 1);
		}
		else{
			// Ajout de la recette au panier
			recettes.add(recette);
			quantite.add(1);
		}
	}
	
	/**
	 * Méthode pour augmenter la quantité d'une recette dans le panier
	 * 
	 * @param recette La position de la recette à incrémenter
	 */
	public void augmenterQuantiteRecette(int pos){
		if(pos > 0 && pos < quantite.size()){
			quantite.set(pos, quantite.get(pos) + 1);
		}
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
		int pos = getPositionRecette(idRecette);
		if(pos != -1){
			int qte = quantite.get(pos);
			if(qte == 1){
				// On enlève la recette
				recettes.remove(pos);
				quantite.remove(pos);
			}
			else{
				// On remet la nouvelle quantité décrémentée
				quantite.set(pos,  qte - 1);
			}
		}
	}	
}

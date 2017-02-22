package modele;

import java.util.ArrayList;
import java.util.List;

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
	
	// La liste des quantit�s pour chaque recette
	List<Integer> quantite = new ArrayList<>();
	
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
	 * @param pos La position de la recette dans le panier
	 * @return La quantit�
	 */
	public int getQuantite(int pos){
		if(pos > 0 && pos < quantite.size()){
			return quantite.get(pos);
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
	 * M�thode pour retourner l'index d'une recette dans le panier panier
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
	 * M�thode pour ajouter une recette au panier
	 * 
	 * Si la recette existe d�j�, sa quantit� est augment�e
	 * 
	 * @param recette La recette � ajouter
	 */
	public void ajouterRecette(Recette recette){
		int pos = recettes.indexOf(recette);
		if(pos != -1){
			// La recette est d�j� dans le panier
			quantite.set(pos, quantite.get(pos) + 1);
		}
		else{
			// Ajout de la recette au panier
			recettes.add(recette);
			quantite.add(1);
		}
	}
	
	/**
	 * M�thode pour augmenter la quantit� d'une recette dans le panier
	 * 
	 * @param recette La position de la recette � incr�menter
	 */
	public void augmenterQuantiteRecette(int pos){
		if(pos > 0 && pos < quantite.size()){
			quantite.set(pos, quantite.get(pos) + 1);
		}
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
		int pos = getPositionRecette(idRecette);
		if(pos != -1){
			int qte = quantite.get(pos);
			if(qte == 1){
				// On enl�ve la recette
				recettes.remove(pos);
				quantite.remove(pos);
			}
			else{
				// On remet la nouvelle quantit� d�cr�ment�e
				quantite.set(pos,  qte - 1);
			}
		}
	}	
}

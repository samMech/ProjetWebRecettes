package modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

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
	
	/**
	 * Méthode pour retourner la liste de toutes les recettes
	 * 
	 * @return La liste de toutes les recettes ou une liste vide si aucun résultat
	 */
	public List<Recette> getRecettes(){
		return lancerRequete("SELECT * FROM Recettes r");
	}
	
	/**
	 * Méthode pour trouver les n plus récentes recettes
	 * 
	 * @param nbRecettes Le nombre de recettes à retourner
	 * @return La liste des n plus récentes recettes ou une liste vide si aucun résultat
	 */
	public List<Recette> chercherRecettesRecentes(int nbRecettes){
		if(nbRecettes > 0){
			try{
	            // Ouverture de la connexion
	            ouvrirConnexion();
	            
	            // Construction de la requête
	            TypedQuery<Recette> query = em.createQuery("SELECT * FROM Recettes r ORDER BY idRecette DESC LIMIT :n", Recette.class);
	            query.setParameter("n", nbRecettes);

	            // Recherche
	            return query.getResultList();
	            
	        }finally{
	            // Fermeture de la connexion
	            fermerConnexion();
	        }
		}
		else{
			return new ArrayList<Recette>();
		}		
	}
	
	/**
	 * Méthode pour trouver une recette selon son id
	 * 
	 * @param idRecette L'id de la recette dans la table
	 * @return La recette trouvée ou null si inexistante
	 */
	public Recette chercherRecette(long idRecette){
		try{
            // Ouverture de la connexion
            ouvrirConnexion();
            
            // Construction de la requête
            TypedQuery<Recette> query = em.createQuery("SELECT * FROM Recettes r WHERE idRecette = :id", Recette.class);
            query.setParameter("id", idRecette);

            // Recherche
            return query.getSingleResult();
            
        }finally{
            // Fermeture de la connexion
            fermerConnexion();
        }
	}
	

}

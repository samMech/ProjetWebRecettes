package modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Classe pour un DAO sur des Recettes
 * 
 * @version 1.10 (15 février 2017)
 * @author Marc-André Malouin
 * @author Samy Mecheddal
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
	 * Méthode pour retourner un usager selon son login unique
	 * 
	 * @param email L'adresse courriel identifiant l'usager de manière unique
	 * @return L'usager correspondant ou null si inexistant
	 */
	public Usager getUsager(String email){
		if(email != null && ! email.isEmpty()){
			try{
	            // Ouverture de la connexion
	            ouvrirConnexion();
	            
	            // Construction de la requête
	            TypedQuery<Usager> query = em.createQuery("SELECT u FROM Usager u WHERE u.email = :email", Usager.class);
	            query.setParameter("email", email);

	            // Recherche
	            return query.getSingleResult();
			}
            catch(NoResultException e){
            	return null;
            }	            
	        finally{
	            // Fermeture de la connexion
	            fermerConnexion();
	        }
		}
		else{
			return null;
		}
	}
	
	/**
	 * Méthode pour trouver les n plus récentes recettes
	 * 
	 * @param usager L'usagé présentement connecté
	 * @param nbRecettes Le nombre de recettes à retourner
	 * @return La liste des n plus récentes recettes ou une liste vide si aucun résultat
	 */
	public List<Recette> chercherRecettesRecentes(Usager usager, int nbRecettes){
		if(nbRecettes > 0){
			try{
	            // Ouverture de la connexion
	            ouvrirConnexion();
	            
	            // Construction de la requête
	            TypedQuery<Recette> query = em.createQuery("SELECT r FROM Recette r WHERE r.usager = :user ORDER BY r.idRecette DESC", Recette.class);
	            query.setParameter("user",  usager);
	            
	            // Recherche
	            return query.setMaxResults(nbRecettes).getResultList();
	            
	        }catch(NoResultException e){
            	return new ArrayList<>();
            }	 
			finally{
	            // Fermeture de la connexion
	            fermerConnexion();
	        }
		}
		else{
			return new ArrayList<Recette>();
		}		
	}
	
	/**
	 * Methode pour retourner la liste de tous les enregistrements d'une table
	 * @return La liste de tous les enregistrements ou une liste vide si aucun resultat
	 */
	public <T> List<T> getAll(String table, Class<T> type){
		
		try{
            // Ouverture de la connexion
            ouvrirConnexion();
            
            // Construction de la requête
            TypedQuery<T> query = em.createQuery("SELECT t FROM "+table+" t", type);

            // Recherche
            return query.getResultList();
            
        }finally{
            // Fermeture de la connexion
            fermerConnexion();
        }
	}

	
	/**
	 * Méthode pour trouver un enregistrement selon son id
	 * 
	 * @param id L'id de l'enregistrement dans la table
	 * @return L'enregistrement trouvé ou null si n'existe pas
	 */
	
	public <T> T chercherParId(long id, String table, String typeId, Class<T> type){
		try{
            // Ouverture de la connexion
            ouvrirConnexion();
            
            // Construction de la requête
            TypedQuery<T> query = em.createQuery("SELECT t FROM "+table+ " t WHERE t."+typeId+" = :id", type);

            query.setParameter("id", id);

            // Recherche
            return query.getSingleResult();
            
        }finally{
            // Fermeture de la connexion
            fermerConnexion();
        }
	}
}

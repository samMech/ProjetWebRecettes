package modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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
	
	/**
	 * M�thode pour retourner un usager selon son login unique
	 * 
	 * @param id L'identifiant unique de l'usager
	 * @return L'usager correspondant ou null si inexistant
	 */
	public Usager getUsager(int id){
		try{
            // Ouverture de la connexion
            ouvrirConnexion();
            
            // Construction de la requ�te
            TypedQuery<Usager> query = em.createQuery("SELECT u FROM Usager u WHERE u.idUsager = :id", Usager.class);
            query.setParameter("id", id);

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
	
	/**
	 * M�thode pour retourner un usager selon son login unique
	 * 
	 * @param email L'adresse courriel identifiant l'usager de mani�re unique
	 * @return L'usager correspondant ou null si inexistant
	 */
	public Usager getUsager(String email){
		if(email != null && ! email.isEmpty()){
			try{
	            // Ouverture de la connexion
	            ouvrirConnexion();
	            
	            // Construction de la requ�te
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
	 * M�thode pour retourner la liste de toutes les recettes
	 * 
	 * @return La liste de toutes les recettes ou une liste vide si aucun r�sultat
	 */
	public List<Recette> getRecettes(){
		return lancerRequete("SELECT r FROM Recette r");
	}
	
	/**
	 * M�thode pour trouver les n plus r�centes recettes
	 * 
	 * @param nbRecettes Le nombre de recettes � retourner
	 * @return La liste des n plus r�centes recettes ou une liste vide si aucun r�sultat
	 */
	public List<Recette> chercherRecettesRecentes(int nbRecettes){
		if(nbRecettes > 0){
			try{
	            // Ouverture de la connexion
	            ouvrirConnexion();
	            
	            // Construction de la requ�te
	            TypedQuery<Recette> query = em.createQuery("SELECT r FROM Recette r ORDER BY r.idRecette DESC", Recette.class);

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
	 * M�thode pour trouver une recette selon son id
	 * 
	 * @param idRecette L'id de la recette dans la table
	 * @return La recette trouv�e ou null si inexistante
	 */
	public Recette chercherRecette(long idRecette){
		try{
            // Ouverture de la connexion
            ouvrirConnexion();
            
            // Construction de la requ�te
            TypedQuery<Recette> query = em.createQuery("SELECT r FROM Recette r WHERE idRecette = :id", Recette.class);
            query.setParameter("id", idRecette);

            // Recherche
            return query.getSingleResult();
            
        }finally{
            // Fermeture de la connexion
            fermerConnexion();
        }
	}
	

}

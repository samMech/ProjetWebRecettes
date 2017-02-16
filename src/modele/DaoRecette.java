package modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
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
	 * 
	 * @param table Le nom de la classe correspondant à la table
	 * @param type Le type d'objet correspondant aux enregistrements de la table
	 * @return La liste de tous les enregistrements ou une liste vide si aucun resultat
	 */
	public <T> List<T> getAll(String table, Class<T> type){
		
		try{
            // Ouverture de la connexion
            ouvrirConnexion();
            
            // Construction de la requête
            TypedQuery<T> query = em.createQuery("SELECT t FROM " + table + " t", type);

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
	 * @param table Le nom de la classe correspondant à la table
	 * @param typeId Le nom de la clé primaire dans la classe
	 * @param type Le type d'objet correspondant aux enregistrements de la table
	 * @return L'enregistrement trouvé ou null si n'existe pas
	 */
	
	public <T> T chercherParId(long id, String table, String typeId, Class<T> type){
		try{
            // Ouverture de la connexion
            ouvrirConnexion();
            
            // Construction de la requête
//            TypedQuery<T> query = em.createQuery("SELECT t FROM " + table +  " t WHERE t." + typeId + " = :id", type);
//
//            query.setParameter("id", id);
            
            return (T)em.find(type, id);
//
//            // Recherche
//            return query.getSingleResult();
            
        }finally{
            // Fermeture de la connexion
            fermerConnexion();
        }
	}
	
	public <T> T chercherParId(long id, Class<T> type){
		try{
            // Ouverture de la connexion
            ouvrirConnexion();
            
            return (T) em.find(type, id);
            
        }finally{
            // Fermeture de la connexion
            fermerConnexion();
        }
	}
	
	/**
	 * Méthode pour construire une requête paramétrée pour rechercher des recettes
	 * 
	 * @param params La liste des critères de recherche à utiliser
	 * @return La requête paramétrée à utiliser
	 */
	public static String construireRequetteRecette(Usager usager, List<CritereRecherche> criteres){
		
		// Si on n'a aucun critères, on retourne toutes les recettes
		if(criteres == null || criteres.isEmpty()){
			return "SELECT r FROM Recette r";
		}
		
		// Construction de la requête
		String requete = "SELECT r FROM Recette r"
					   + "JOIN r.instructions o"
					   + "JOIN r.typesRecette t"
					   + "JOIN r.mesures m"
					   + "JOIN m.ingredient i"
					   + "JOIN i.categoriesIngredient c"
					   + "WHERE r.usager = :user";
		
		// Ajout des conditions paramétrées d'après les critères
		int i = 1;
		String nomParam = "";
		boolean premierCritere = true;
		for (CritereRecherche c : criteres) {
			
			// Ajout du AND si plus d'un critère
			requete += premierCritere ? "" : " AND ";
			
			// Ajout de la condition
			nomParam = "c" + i;
			switch(c){
			case TEXTE:
				// Free search
				requete += "(r.nomRecette like :" + nomParam
						+ " OR r.descriptionRecette like :" + nomParam
						+ " OR o.descInstruction like :" + nomParam
						+ " OR t.typeRecette like :" + nomParam
						+ " OR i.nomIngredient like :" + nomParam
						+ " OR c.nomCategorieIng like :" + nomParam + ")";
				break;
			case TYPE:
				// Recherche par type de recette
				requete += "(t.typeRecette = " + nomParam + ")";
				break;
			case CATEGORIE:
				// Recherche par catégorie d'ingrédient
				requete += "(c.nomCategorieIng = " + nomParam + ")";
				break;
			case DUREE_MAX:
				// Recherche par durée maximale
				requete += "(r.dureeRecette < " + nomParam + ")";
				break;
			case NB_INGREDIENTS:
				// Recherche par nombre d'ingrédients
				requete += "(SELECT count(z) FROM Recette y JOIN y.mesures x JOIN x.ingredient z) = " + nomParam + ")";
				break;
			default:
				break;
			}
			
			i++;
		}
		
		// On ordonne les résultats
		requete += "ORDER BY r.nomRecette ASC";
		
		return requete;
	}
	
	/**
	 * Méthode pour ajouter initialiser les paramètres d'une requête paramétrée
	 * 
	 * @param requete La requête paramétrée
	 * @param params La liste des paramètres à initialiser
	 */
	public static void ajouterParametres(Query requete, List<Object> params){
		int i = 1;
		for(Object p : params){
			requete.setParameter("c" + i, p);
			i++;
		}		
	}
}

package modele;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * Classe abstraite pour une DAO implémentant des méthodes générales avec JPA
 *
 * @version 2.20 (22 nov. 2016)
 * @author Marc-André Malouin
 */
public class DaoJPA<T> {
    
    ///////////////
    // Attributs //
    ///////////////
	
    private final Class<T> type;
        
    private EntityManagerFactory emf;
    protected EntityManager em = null;
    private EntityTransaction et = null;
    
    ///////////////////
    // Constructeurs //
    ///////////////////
    
    /**
     * Constructeur par défaut
     * @param type Le type d'objet à manipuler
     */
    public DaoJPA(Class<T> type) {
        this.type = type;
        emf = Persistence.createEntityManagerFactory("jpaUnit");// Création initiale
    }
    
    //////////////
    // Méthodes //
    //////////////
    
    /**
     * Permet de lancer une requête sans paramètre
     *
     * @param <T> Le type des objets à rechercher
     * @param requete La requete à exécuter
     * @return La liste des objets de type T trouvés
     */
    protected final List<T> lancerRequete(String requete) {
        try{
            // Ouverture de la connexion
            ouvrirConnexion();
            
            // Construction de la requête            
            TypedQuery<T> query = em.createQuery(requete, type);
            
            // Recherche
            return query.getResultList();
            
        }catch(NoResultException e){
        	return new ArrayList<>();
        }	 
        finally{
            // Fermeture de la connexion
            fermerConnexion();
        }
    }        
    
    /**
     * Effectue la sauvegarde d'un objet T
     *
     * @param objet L'objet à sauvegarder
     */
    public final void enregistrer(T objet) {
        try{
            // Ouverture de la connexion
            ouvrirConnexion();
            
            // Sauvegarde
            em.merge(objet);
            
            // Validation
            validerChangements();
            
        }catch(PersistenceException e){
            // Annulation
            annulerChangements();
            throw(e);// On relance l'exception
        }finally{
            // Fermeture de la connexion
            fermerConnexion();
        }
    }
    
    /**
     * Supprime l'objet T de manière définitive
     *
     * @param objet L'objet à supprimer
     */
    public final void supprimer(T objet) {
        try{
            // Ouverture de la connexion
            ouvrirConnexion();
            
            // Sauvegarde
            em.remove(objet);
            
            // Validation
            validerChangements();
            
        }catch(PersistenceException e){
            // Annulation
            annulerChangements();
            throw e;// On relance l'exception
        }finally{
            // Fermeture de la connexion
            fermerConnexion();
        }
    }
    
    /**
     * Permet d'ouvrir la connexion
     *
     * @return La session pour la connexion ouverte
     */
    protected final EntityManager ouvrirConnexion() {
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();// Début de la transaction
        
        return em;
    }
    
    /**
     * Permet de fermer la connexion
     */
    protected final void fermerConnexion() {
        if(em != null){
            em.close();
        }
        et = null;
        em = null;
    }
    
    /**
     * Permet de valider les changements effectués lors d'une transaction (commit)
     */
    protected final void validerChangements() {
        if(et != null && et.isActive()){
            et.commit();
        }
    }
    
    /**
     * Permet d'annuler les changements effectués lors d'une transaction (rollback)
     */
    protected final void annulerChangements() {
        if(et != null && et.isActive()){
            et.rollback();
        }
    }
    
}
package modele;

import java.util.List;

import javax.persistence.TypedQuery;

/**
 * Classe pour un DAO sur des types de recettes
 * 
 * @version 1.00 (13 février 2017)
 * @author Samy Mecheddal
 */
public class DaoTypesRecette extends DaoJPA<TypesRecette> {

	/**
	 * Constructeur par defaut
	 */
	public DaoTypesRecette() {
		super(TypesRecette.class);
	}
	
	//Methodes
	
	/**
	 * Methode pour retourner la liste de tous les types de recette
	 * @return La liste de tous les types de recette ou une liste vide si aucun resultat
	 */
	public List<TypesRecette> getTypesRecette(){
		return lancerRequete("SELECT t FROM TypesRecette t");
	}

	
	/**
	 * Méthode pour trouver un type de Recette selon son nom
	 * 
	 * @param nomType Le nom du type dans la table
	 * @return Le type trouvé ou null si n'existe pas
	 */
	public TypesRecette chercherTypesRecette(String nomType){
		try{
            // Ouverture de la connexion
            ouvrirConnexion();
            
            // Construction de la requête
            TypedQuery<TypesRecette> query = em.createQuery("SELECT t FROM TypesRecette t WHERE t.typeRecette = :nom", TypesRecette.class);
            query.setParameter("nom", nomType);

            // Recherche
            return query.getSingleResult();
            
        }finally{
            // Fermeture de la connexion
            fermerConnexion();
        }
	}
}

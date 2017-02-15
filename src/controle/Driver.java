package controle;

import java.util.List;

import modele.CategoriesIngredient;
import modele.DaoJPA;
import modele.DaoRecette;
import modele.Recette;
import modele.TypesRecette;
import modele.Unite;
import modele.Usager;

/**
 * Classe contr�leur pour la gestion du dao
 * 
 * @author Marc-Andr� Malouin
 * @version 1.00 (31 janvier 2017)
 */
public class Driver {

	/**
	 * M�thode pour enregistrer les modifications d'un objet dans la base
	 * 
	 * @param objet L'objet � persister
	 * @param type Le type de l'objet � persister
	 */
	public static <T> void enregistrer(T objet, Class<T> type){
		DaoJPA<T> dao = new DaoJPA<>(type);
		dao.enregistrer(objet);
	}
	
	/**
	 * Methode pour supprimer un objet dans la BD
	 * @param objet L'objet � supprimer
	 * @param type Le type de l'objet a supprimer
	 */
	public static <T> void supprimer(T objet, Class<T> type){
		DaoJPA<T> dao = new DaoJPA<>(type);
		dao.supprimer(objet);
	}
	
	/**
	 * M�thode pour cr�er un nouvel usager
	 * 
	 * @param nom Le nom de l'usager
	 * @param email L'adresse courriel de l'usager
	 * @param password Le mot de passe de l'usager
	 * @return L'usager cr��
	 */
	public static Usager creerNouvelUsager(String nom, String email, String password){
		return new Usager(nom, email , password);	
	}
	
	/**
	 * M�thode pour trouver un usager par son email
	 * 
	 * @param email L'adresse courriel de l'usager (login)
	 * @return L'usager trouv� ou null si inexistant
	 */
	public static Usager trouverUsager(String email){
		DaoRecette dao = new DaoRecette();
		return dao.getUsager(email);		
	}
	
	/**
	 * M�thode pour trouver un usager par son id
	 * 
	 * @param id L'identifiant de l'usager
	 * @return L'usager trouv� ou null si inexistant
	 */
	public static Usager trouverUsager(long id){
		DaoRecette dao = new DaoRecette();
		return dao.chercherParId(id, "Usager", "idUsager", Usager.class);		
	}
	
	/**
	 * M�thode pour r�cup�rer la liste des recettes � afficher sur la page de bienvenue
	 * 
	 * @param usager L'usag� pr�sentement connect�
	 * @return La liste des recettes � afficher
	 */
	public static List<Recette> chargerRecettesBienvenue(Usager usager){
		DaoRecette dao = new DaoRecette();
		return dao.chercherRecettesRecentes(usager, 5);
	}
	
	/**
	 * M�thode pour retourner la liste de tous les types de recettes
	 * 
	 * @return La liste de tous les types de recette ou une liste vide si aucun r�sultat
	 */
	public static List<TypesRecette> getTypesRecette(){
		DaoRecette dao = new DaoRecette();
		return dao.getAll("TypesRecette", TypesRecette.class);
	}
	
	/**
	 * M�thode pour retourner la liste de tous les unites
	 * 
	 * @return La liste de tous les unites de mesures ou une liste vide si aucun r�sultat
	 */
	public static List<Unite> getUnites(){
		DaoRecette dao = new DaoRecette();
		return dao.getAll("Unite", Unite.class);
	}
	
	/**
	 * M�thode pour trouver un type de recette selon son id
	 * 
	 * @param idType L'id du type dans la table
	 * @return Le type de recette trouv� ou null si n'existe pas
	 */
	public static TypesRecette getTypeRecette(long idType){
		DaoRecette dao = new DaoRecette();
		TypesRecette type = dao.chercherParId(idType, "TypesRecette", "idType", TypesRecette.class);
		return type;
	}
	
	/**
	 * Methode pour trouver une recette par son id
	 *  @param idRecette l'ID de la recette
	 *  @return La recette trouv� ou null si n'existe pas
	 */
	public static Recette getRecette(long idRecette){
		DaoRecette dao = new DaoRecette();
		Recette recette = dao.chercherParId(idRecette, "Recette", "idRecette", Recette.class);
		return recette;
	}

	/**
	 * Methode pour trouver une Unite de mesure par son id
	 *  @param idUnite l'ID de l'unite
	 *  @return L'unite trouv� ou null si n'existe pas
	 */
	public static Unite getUnite(long idUnite) {
		DaoRecette dao = new DaoRecette();
		Unite unite = dao.chercherParId(idUnite, "Unite", "idUnite", Unite.class);
		return unite;
	}
	
	/**
	 * Methode pour trouver une recette par son id
	 *  @param idRecette l'ID de la recette
	 *  @return La recette trouv� ou null si n'existe pas
	 */
	public static CategoriesIngredient getCategorie(long idCategorie) {
		DaoRecette dao = new DaoRecette();
		CategoriesIngredient cat = dao.chercherParId(idCategorie, "CategoriesIngredient", "idCategorieIng", CategoriesIngredient.class);
		return cat;
	}

		/**
	 * M�thode pour retourner la liste de tous les unites
	 * 
	 * @return La liste de tous les unites de mesures ou une liste vide si aucun r�sultat
	 */
	public static List<CategoriesIngredient> getCategories(){
		DaoRecette dao = new DaoRecette();
		return dao.getAll("CategoriesIngredient", CategoriesIngredient.class);
	}
}

package controle;

import java.util.List;

import modele.DaoJPA;
import modele.DaoRecette;
import modele.DaoTypesRecette;
import modele.Recette;
import modele.TypesRecette;
import modele.Usager;

/**
 * Classe contrôleur pour la gestion du dao
 * 
 * @author Marc-André Malouin
 * @version 1.00 (31 janvier 2017)
 */
public class Driver {

	/**
	 * Méthode pour enregistrer les modifications d'un objet dans la base
	 * 
	 * @param objet L'objet à persister
	 * @param type Le type de l'objet à persister
	 */
	public static <T> void enregistrer(T objet, Class<T> type){
		DaoJPA<T> dao = new DaoJPA<>(type);
		dao.enregistrer(objet);
	}
	
	/**
	 * Méthode pour créer un nouvel usager
	 * 
	 * @param nom Le nom de l'usager
	 * @param email L'adresse courriel de l'usager
	 * @param password Le mot de passe de l'usager
	 * @return L'usager créé
	 */
	public static Usager creerNouvelUsager(String nom, String email, String password){
		return new Usager(nom, email , password);	
	}
	
	/**
	 * Méthode pour trouver un usager par son email
	 * 
	 * @param email L'adresse courriel de l'usager (login)
	 * @return L'usager trouvé ou null si inexistant
	 */
	public static Usager trouverUsager(String email){
		DaoRecette dao = new DaoRecette();
		return dao.getUsager(email);		
	}
	
	/**
	 * Méthode pour trouver un usager par son id
	 * 
	 * @param id L'identifiant de l'usager
	 * @return L'usager trouvé ou null si inexistant
	 */
	public static Usager trouverUsager(long id){
		DaoRecette dao = new DaoRecette();
		return dao.getUsager(id);		
	}
	
	/**
	 * Méthode pour récupérer la liste des recettes à afficher sur la page de bienvenue
	 * 
	 * @param usager L'usagé présentement connecté
	 * @return La liste des recettes à afficher
	 */
	public static List<Recette> chargerRecettesBienvenue(Usager usager){
		DaoRecette dao = new DaoRecette();
		return dao.chercherRecettesRecentes(usager, 5);
	}
	
	/**
	 * Méthode pour retourner la liste de tous les types de recettes
	 * 
	 * @return La liste de tous les types de recette ou une liste vide si aucun résultat
	 */
	public static List<TypesRecette> getTypesRecette(){
		DaoTypesRecette dao = new DaoTypesRecette();
		return dao.getTypesRecette();
	}
	
	public static DaoRecette getDaoRecette(){
		DaoRecette dao = new DaoRecette();
		return dao;
	}
	
	public static DaoTypesRecette getDaoType(){
		DaoTypesRecette dao = new DaoTypesRecette();
		return dao;
	}
}

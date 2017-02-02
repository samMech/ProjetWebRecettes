package controle;

import java.util.List;

import modele.DaoJPA;
import modele.DaoRecette;
import modele.Recette;
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
	 * M�thode pour cr�er un nouvel usager
	 * 
	 * @param nom Le nom de l'usager
	 * @param email L'adresse courriel de l'usager
	 * @param password Le mot de passe de l'usager
	 */
	public static void creerNouvelUsager(String nom, String email, String password){
		Usager usager = new Usager(nom, email , password);
		enregistrer(usager, Usager.class);		
	}
	
	/**
	 * M�thode pour v�rifier si un usager existe d�j�
	 * 
	 * @param email L'adresse courriel de l'usager (login)
	 * @return L'usager trouv� ou null si inexistant
	 */
	public static Usager trouverUsager(String email){
		DaoRecette dao = new DaoRecette();
		return dao.getUsager(email);		
	}
	
	/**
	 * M�thode pour r�cup�rer la liste des recettes � afficher sur la page de bienvenue
	 * 
	 * @return La liste des recettes � afficher
	 */
	public static List<Recette> chargerRecettesBienvenue(){
		DaoRecette dao = new DaoRecette();
		return dao.chercherRecettesRecentes(5);
	}	
}

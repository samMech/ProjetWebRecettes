package utils;

/**
 * Classe utilitaire pour l'authentification des usagers
 * 
 * @version 1.00 (30 janvier 2017)
 * @author Marc-André Malouin
 */
public class Authentification {

	/**
	 * Méthode ppour valider les informations de connexion d'un usager
	 * @param login L'identifiant de l'usager
	 * @param password Le mot de passe de l'usager
	 * @return Vrai seulement si l'usager existe et que son mot de passe est valide
	 */
	public static boolean validerUsager(String login, String password){
		if(login.equals("test@bdeb.qc.ca") && password.equals("test")){
			return true;
		}
		else{
			return false;
		}		
	}
	
}

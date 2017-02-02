package utils;

import java.util.UUID;

/**
 * Classe utilitaire pour des m�thodes g�n�rales
 * 
 * @author Marc-Andr� Malouin
 * @version 1.00 (31 janvier 2017)
 */
public class Utilitaire {
	
	/**
	 * M�thode pour g�n�rer une code al�atoire
	 * 
	 * @return Le code g�n�r�
	 */
	public static String genererCodeAleatoire(){				
		return UUID.randomUUID().toString();
	}

	/**
	 * M�thode pour g�n�rer un mot de passe al�atoire d'apr�s une liste de caract�res valides
	 * 
	 * @param nbChars Le nombre de caract�re du mot de passe
	 * @param charsValides Une cha�ne contenant les caract�res valides
	 * @return Le mot de passe g�n�r�
	 */
	public static String genererMotDePasse(int nbChars, String charsValides){
		
		// Le nombre de caract�res valides
		int nbCharsValides = charsValides.length();
		
		// G�n�ration du mot de passe
		int idx;
		String pwd = "";
		for(int i=0; i < nbChars; i++){
			// On s�lectionne un index al�atoire pour le caract�re � ajouter
			idx = (int)(Math.random() * nbCharsValides);
			
			// On ajoute le caract�re choisit au mot de passe
			pwd += charsValides.charAt(idx);			
		}		
		
		return pwd;
	}

	/**
	 * M�thode pour valider si un mot de passe est valide
	 * 
	 * @param pwd Le mot de passe � valider
	 * @param nbChars La longueur pour un mot de passe valide
	 * @param charsValides La cha�ne contenant les caract�res accept�s
	 * @return
	 */
	public static boolean validerMotDePasse(String pwd, int nbChars, String charsValides){
		
		// 1) Test de la longueur
		if(pwd.length() != nbChars){
			return false;
		}
		
		// 2) Test des caract�res dans le mot de passe
		for(int i=0; i < pwd.length(); i++){
			if(! charsValides.contains("" + pwd.charAt(i))){
				return false;
			}
		}		
		
		// Mot de passe valide
		return true;		
	}
	
}

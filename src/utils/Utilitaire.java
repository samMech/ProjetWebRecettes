package utils;

import java.util.UUID;

/**
 * Classe utilitaire pour des méthodes générales
 * 
 * @author Marc-André Malouin
 * @version 1.00 (31 janvier 2017)
 */
public class Utilitaire {
	
	/**
	 * Méthode pour générer une code aléatoire
	 * 
	 * @return Le code généré
	 */
	public static String genererCodeAleatoire(){				
		return UUID.randomUUID().toString();
	}

	/**
	 * Méthode pour générer un mot de passe aléatoire d'après une liste de caractères valides
	 * 
	 * @param nbChars Le nombre de caractère du mot de passe
	 * @param charsValides Une chaîne contenant les caractères valides
	 * @return Le mot de passe généré
	 */
	public static String genererMotDePasse(int nbChars, String charsValides){
		
		// Le nombre de caractères valides
		int nbCharsValides = charsValides.length();
		
		// Génération du mot de passe
		int idx;
		String pwd = "";
		for(int i=0; i < nbChars; i++){
			// On sélectionne un index aléatoire pour le caractère à ajouter
			idx = (int)(Math.random() * nbCharsValides);
			
			// On ajoute le caractère choisit au mot de passe
			pwd += charsValides.charAt(idx);			
		}		
		
		return pwd;
	}

	/**
	 * Méthode pour valider si un mot de passe est valide
	 * 
	 * @param pwd Le mot de passe à valider
	 * @param nbChars La longueur pour un mot de passe valide
	 * @param charsValides La chaîne contenant les caractères acceptés
	 * @return
	 */
	public static boolean validerMotDePasse(String pwd, int nbChars, String charsValides){
		
		// 1) Test de la longueur
		if(pwd.length() != nbChars){
			return false;
		}
		
		// 2) Test des caractères dans le mot de passe
		for(int i=0; i < pwd.length(); i++){
			if(! charsValides.contains("" + pwd.charAt(i))){
				return false;
			}
		}		
		
		// Mot de passe valide
		return true;		
	}
	
}

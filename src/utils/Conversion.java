package utils;

/**
 * Classe utilitaire pour des m�thodes de conversion de donn�es
 * 
 * @version 1.10 (30 janvier 2017)
 * @author Marc-Andr� Malouin
 * @author Samy Mecheddal
 */
public class Conversion {

	// Conversion objet en xml / json
	
	/**
	 * Methode permettant la conversion d'un temps en minutes
	 * @param heure nombre d'heure
	 * @param minute nombre de minutes
	 * @return Retourne une dur�e en minutes
	 */
	public static int convertirTemps(int heure, int minute){	
		return (heure*60)+minute;
	}
	
	/**
	 * Methode permettant de convertir une duree en minutes en heure
	 * @param temps nombre de minutes a convertir
	 * @return Le nombre d'heure dans une dur�e en minutes
	 */
	public static int getHeure(int temps){
		return temps/60;
	}
	
	/**
	 * Methode qui retourne le nombre de minutes restante apres conversion en heures
	 * @param temps dur�e en minutes a convertir
	 * @return Le nombre de minutes restantes apres une conversion de minutes en heures.
	 */
	public static int getMinute(int temps){
		return temps%60;
	}
}

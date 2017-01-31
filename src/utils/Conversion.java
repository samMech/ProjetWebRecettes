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
}

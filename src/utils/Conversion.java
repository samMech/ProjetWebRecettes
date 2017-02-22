package utils;

import java.util.List;

import modele.Recette;

/**
 * Classe utilitaire pour des m�thodes de conversion de donn�es
 * 
 * @version 1.10 (30 janvier 2017)
 * @author Marc-Andr� Malouin
 * @author Samy Mecheddal
 */
public class Conversion {

	/**
	 * Constante pour le format de l'heure
	 */
	public static final String FORMAT_HEURE = "%2dh%2dmin";
	
	/**
	 * Constante pour le format de l'heure avec seulement des minutes
	 */
	public static final String FORMAT_MINUTES = "%2dmin";
	
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
	 * M�thode pour convertir un temps en minutes en cha�ne de format h :mm
	 * @param  Le temps en minutes
	 * @return La dur�e formatt�e
	 */
	public static String convertirTemps(int minutes){
		int h = getHeure(minutes);
		int m = getMinute(minutes);		
	    return h == 0 ? String.format(FORMAT_MINUTES, m) : String.format(FORMAT_HEURE, h, m);
	}
	
	/**
	 * Methode permettant de convertir un nombre de minutes en heure
	 * @param temps nombre de minutes a convertir
	 * @return Le nombre d'heures enti�res
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
	
	/**
	 * M�thode pour convertir une liste de recette en fichier XML;
	 * @param sb
	 * @param listeRecettes
	 */
	public static void convertirRecettesEnXML(StringBuffer sb, List<Recette> listeRecettes){		
		// Ajout des recettes
		for(Recette r : listeRecettes){
			sb.append("<recette>");
			sb.append("<id>" + r.getIdRecette() + "</id>");
			sb.append("<nom>" + r.getNomRecette() + "</nom>");
			sb.append("<duree>" + convertirTemps(r.getDureeRecette()) + "</duree>");
			sb.append("<description>" + r.getDescriptionRecette() + "</description>");
			sb.append("</recette>");
		}
	}
	
}

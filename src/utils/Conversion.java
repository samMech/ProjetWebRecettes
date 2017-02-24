package utils;

import java.util.ArrayList;
import java.util.List;

import modele.Ingredient;
import modele.Mesure;
import modele.Recette;
import modele.UNITE_MESURE;

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
	
	/**
	 * M�thode pour cr�er une liste d'�picerie � partir d'une liste de recette
	 * 
	 * Les ingr�dients en double sont combin�s si leurs unit�s sont compatibles
	 * 
	 * @param listeRecettes La liste des recettes
	 * @return La liste de tous les ingr�dients combin�s
	 */
	public static List<Mesure> creerListeEpicerie(List<Recette> listeRecettes){
		
		// Cr�ation de la liste d'�picerie
		List<Mesure> listeEpicerie = new ArrayList<>();
		
		// Ajout des ingr�dients de toutes les recettes
		Mesure m1;
		UNITE_MESURE u1, u2;
		for (Recette r : listeRecettes) {
			for(Mesure m2: r.getMesures()){
				
				// On v�rifie si l'ingr�dient est d�j� dans la liste d'�picerie
				m1 = getMesureAvecIngredient(listeEpicerie, m2.getIngredient());
				if(m1 != null){
					
					// R�cup�ration des unit�s de mesure
					u1 = UNITE_MESURE.valueOf(m1.getUnite().getNomUnite());
					u2 = UNITE_MESURE.valueOf(m2.getUnite().getNomUnite());
					
					// On obtient le taux de conversion de la nouvelle mesure vers celle existante
					double taux = UNITE_MESURE.getTauxConversion(u2, u1);
					if(taux == 0){
						// Les unit�s sont incompatibles, on gardes les mesures s�par�es
						listeEpicerie.add(m2);
					}
					else{
						// On augmentre la quantit� de la mesure existante
						m1.setQuantite(m1.getQuantite() + taux * m2.getQuantite());
					}
				}
				else{
					// Ajout de la nouvelle mesure
					listeEpicerie.add(m2);
				}
			}
		}
		
		return listeEpicerie;
	}
	
	/**
	 * M�thode pour savoir si une liste de mesure contient un ingr�dient
	 * 
	 * @param listeMesures La liste des mesures
	 * @return La mesure contenant l'ingr�dient ou null si l'ingr�dient n'est pas trouv�
	 */
	public static Mesure getMesureAvecIngredient(List<Mesure> listeMesures, Ingredient ingredient){
		for(Mesure m : listeMesures){
			if(m.getIngredient().getNomIngredient().equals(ingredient.getNomIngredient())){
				return m;
			}
		}
		return null;		
	}	
}

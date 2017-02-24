package utils;

import java.util.ArrayList;
import java.util.List;

import modele.Ingredient;
import modele.Mesure;
import modele.Recette;
import modele.UNITE_MESURE;

/**
 * Classe utilitaire pour des méthodes de conversion de données
 * 
 * @version 1.10 (30 janvier 2017)
 * @author Marc-André Malouin
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
	 * @return Retourne une durée en minutes
	 */
	public static int convertirTemps(int heure, int minute){	
		return (heure*60)+minute;
	}
	
	/**
	 * Méthode pour convertir un temps en minutes en chaîne de format h :mm
	 * @param  Le temps en minutes
	 * @return La durée formattée
	 */
	public static String convertirTemps(int minutes){
		int h = getHeure(minutes);
		int m = getMinute(minutes);		
	    return h == 0 ? String.format(FORMAT_MINUTES, m) : String.format(FORMAT_HEURE, h, m);
	}
	
	/**
	 * Methode permettant de convertir un nombre de minutes en heure
	 * @param temps nombre de minutes a convertir
	 * @return Le nombre d'heures entières
	 */
	public static int getHeure(int temps){
		return temps/60;
	}
	
	/**
	 * Methode qui retourne le nombre de minutes restante apres conversion en heures
	 * @param temps durée en minutes a convertir
	 * @return Le nombre de minutes restantes apres une conversion de minutes en heures.
	 */
	public static int getMinute(int temps){
		return temps%60;
	}
	
	/**
	 * Méthode pour convertir une liste de recette en fichier XML;
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
	 * Méthode pour créer une liste d'épicerie à partir d'une liste de recette
	 * 
	 * Les ingrédients en double sont combinés si leurs unités sont compatibles
	 * 
	 * @param listeRecettes La liste des recettes
	 * @return La liste de tous les ingrédients combinés
	 */
	public static List<Mesure> creerListeEpicerie(List<Recette> listeRecettes){
		
		// Création de la liste d'épicerie
		List<Mesure> listeEpicerie = new ArrayList<>();
		
		// Ajout des ingrédients de toutes les recettes
		Mesure m1;
		UNITE_MESURE u1, u2;
		for (Recette r : listeRecettes) {
			for(Mesure m2: r.getMesures()){
				
				// On vérifie si l'ingrédient est déjà dans la liste d'épicerie
				m1 = getMesureAvecIngredient(listeEpicerie, m2.getIngredient());
				if(m1 != null){
					
					// Récupération des unités de mesure
					u1 = UNITE_MESURE.valueOf(m1.getUnite().getNomUnite());
					u2 = UNITE_MESURE.valueOf(m2.getUnite().getNomUnite());
					
					// On obtient le taux de conversion de la nouvelle mesure vers celle existante
					double taux = UNITE_MESURE.getTauxConversion(u2, u1);
					if(taux == 0){
						// Les unités sont incompatibles, on gardes les mesures séparées
						listeEpicerie.add(m2);
					}
					else{
						// On augmentre la quantité de la mesure existante
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
	 * Méthode pour savoir si une liste de mesure contient un ingrédient
	 * 
	 * @param listeMesures La liste des mesures
	 * @return La mesure contenant l'ingrédient ou null si l'ingrédient n'est pas trouvé
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

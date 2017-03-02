package modele;

import java.util.HashMap;
import java.util.Map;

/**
 * Énumération pour différentes unités de mesure
 * 
 * @author Marc-andré Malouin
 * @author Samy Mecheddal
 */
public enum UNITE_MESURE {
	ONCE("U08"),
	LIVRE("U09"),
	MILLIGRAMME("U05"),
	GRAMME("U06"),
	KILOGRAMME("U07"),
	CUILLEREACAFE_US("U02"),
	CUILLEREASOUPE_US("U03"),
	TASSE_US("U04"),
	MILLILITRE("U10"),
	LITRE("U11");
		
	private String value;
	
    private UNITE_MESURE(String value) {
    	this.value = value;
	}
    
    public String getValue(){
    	return value;
    }
    
    /**
     * Méthode pour obtenir le taux de conversion entre 2 unités de mesure
     * 
     * @param u1 L'unité d'origine
     * @param u2 L'unité de destination
     * @return Le taux de conversion tel que (u1 * taux = u2) ou 0 si les unités sont incompatibles (e.g: masse et volume)
     */
    public static double getTauxConversion(UNITE_MESURE u1, UNITE_MESURE u2){
    	Double taux = FACTEUR_CONVERSION_UNITE.get(u1).get(u2);
    	return taux == null ? 0 : taux;
    }
    
    // Constante pour la conversion entre les unités
 	private static final Map<UNITE_MESURE, Map<UNITE_MESURE, Double>> FACTEUR_CONVERSION_UNITE;
 	static{
 		// Bloc d'initialisation de la constante
 		FACTEUR_CONVERSION_UNITE = new HashMap<>();
 		
 		//////////////////////////////////////////////////////////////////////
 		// Masses
 		
 		Map<UNITE_MESURE, Double> temp = new HashMap<>();
 		FACTEUR_CONVERSION_UNITE.put(LIVRE, temp);
 		temp.put(MILLIGRAMME, 453592.0);
 		temp.put(GRAMME, 453.592);
 		temp.put(KILOGRAMME, 0.453592);
 		temp.put(ONCE, 16.0);
 		temp.put(LIVRE, 1.0);
 		
 		temp = new HashMap<>();
 		FACTEUR_CONVERSION_UNITE.put(ONCE, temp);
 		temp.put(MILLIGRAMME, 28349.5);
 		temp.put(GRAMME, 28.3495);
 		temp.put(KILOGRAMME, 0.0283495);
 		temp.put(ONCE, 1.0);
 		temp.put(LIVRE, 0.0625);
 				
 		temp = new HashMap<>();
 		FACTEUR_CONVERSION_UNITE.put(MILLIGRAMME, temp);
 		temp.put(MILLIGRAMME, 1.0);
 		temp.put(GRAMME, 0.001);
 		temp.put(KILOGRAMME, 0.000001);
 		temp.put(ONCE, 0.000035274);
 		temp.put(LIVRE, 0.0000022046);
 				
 		temp = new HashMap<>();
 		FACTEUR_CONVERSION_UNITE.put(GRAMME, temp);
 		temp.put(MILLIGRAMME, 1000.0);
 		temp.put(GRAMME, 1.0);
 		temp.put(KILOGRAMME, 0.001);
 		temp.put(ONCE, 0.035274);
 		temp.put(LIVRE, 0.00220462);
 		
 		temp = new HashMap<>();
 		FACTEUR_CONVERSION_UNITE.put(KILOGRAMME, temp);
 		temp.put(MILLIGRAMME, 1000000.0);
 		temp.put(GRAMME, 1000.0);
 		temp.put(KILOGRAMME, 1.0);
 		temp.put(ONCE, 35.274);
 		temp.put(LIVRE, 2.20462);
 		
 		//////////////////////////////////////////////////////////////////////
 		// Volumes
 		
 		temp = new HashMap<>();
 		FACTEUR_CONVERSION_UNITE.put(CUILLEREACAFE_US, temp);
 		temp.put(CUILLEREACAFE_US, 1.0);
 		temp.put(CUILLEREASOUPE_US, 0.333333);		
 		temp.put(TASSE_US, 0.0205372);
 		temp.put(MILLILITRE, 4.92892);
 		temp.put(LITRE, 0.00492892);
 		
 		temp = new HashMap<>();
 		FACTEUR_CONVERSION_UNITE.put(CUILLEREASOUPE_US, temp);
 		temp.put(CUILLEREACAFE_US, 3.0);
 		temp.put(CUILLEREASOUPE_US, 1.0);		
 		temp.put(TASSE_US, 0.0616115);
 		temp.put(MILLILITRE, 14.7868);
 		temp.put(LITRE, 0.0147868);
 		
 		temp = new HashMap<>();
 		FACTEUR_CONVERSION_UNITE.put(TASSE_US, temp);
 		temp.put(CUILLEREACAFE_US, 48.6922);
 		temp.put(CUILLEREASOUPE_US, 16.2307);
 		temp.put(TASSE_US, 1.0);
 		temp.put(MILLILITRE, 240.0);
 		temp.put(LITRE, 0.24);
 		
 		temp = new HashMap<>();
 		FACTEUR_CONVERSION_UNITE.put(MILLILITRE, temp);		
 		temp.put(CUILLEREACAFE_US, 0.202884);
 		temp.put(CUILLEREASOUPE_US, 0.067628);
 		temp.put(TASSE_US, 0.00416667);
 		temp.put(MILLILITRE, 1.0);
 		temp.put(LITRE, 0.001);
 		
 		temp = new HashMap<>();
 		FACTEUR_CONVERSION_UNITE.put(LITRE, temp);		
 		temp.put(CUILLEREACAFE_US, 202.884);
 		temp.put(CUILLEREASOUPE_US, 67.628);
 		temp.put(TASSE_US, 4.16667);
 		temp.put(MILLILITRE, 1000.0);
 		temp.put(LITRE, 1.0);					
 	}
}


package modele;

/**
 * Énumération pour les intervalles de durée pour la recherche par durée maximale
 * 
 * @author Marc-andré Malouin
 * @author Samy Mecheddal
 */
public enum DUREE {
	CINQ("5"),
	DIX("10"),
	VINGTS("20"),
	TRENTE("30"),
	QUARANTE_CINQ("45"),
	SOIXANTE("60"),
	QUATRE_VINGTS_DIX("90"),
	CENT_VINGTS("120"),
	CENT_VINGTS_PLUS("121");
		
	private String value;

    private DUREE(String value) {
        this.value = value;
	}
    
    public String getValue(){
    	return value;
    }
}

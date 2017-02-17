package modele;

/**
 * �num�ration pour les intervalles de dur�e pour la recherche par dur�e maximale
 * 
 * @author Marc-Andr�
 *
 */
public enum DureeMax {
	CINQ("5"),
	DIX("10"),
	VINGTS("20"),
	TRENTE("30"),
	QUARANTE_CINQ("45"),
	SOIXANTE("60"),
	QUATRE_VINGTS_DIX("90"),
	CENT_VINGTS("120"),
	CENT_VINGTS_PLUS("120+");
		
	private String value;

    private DureeMax(String value) {
        this.value = value;
	}
    
    public String getValue(){
    	return value;
    }
}

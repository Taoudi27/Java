package comedie;

public class Accident {

	/** Chaque accident doit recevoir un identifiant unique. 
	 * L'attribut identificateurs sert à connaître le dernier 
	 * identifiant unique d'accident disponible 
	 */
	// TODO choisir une ligne et supprimer l'autre:
	// private int identificateurs = 0;
	private static int identificateurs = 0;
	
	/** Un int pour stocker l'identifiant d'un accident 
	*/
	// TODO choisir une ligne et supprimer l'autre:
	private int id;
	//private static int id;
	
	/** Un String pour stocker la cause d'un accident 
	*/
	// TODO choisir une ligne et supprimer l'autre:
	private String cause;
	// private static String cause;

	/** Un int pour stocker la timestamp d'un accident 
	*/
	// TODO choisir une ligne et supprimer l'autre:
	private int horodatage;
	//private static int horodatage;
	private static boolean premier = false;
	

	public Accident(int temps, String c) {
		id = prochainID();
		horodatage = temps;
		cause = c;
	}

	public String genererRapport() {
		return Integer.toString(horodatage) + "> Accident " + Integer.toString(id) + " à cause de: " + cause;
	}

	private static int prochainID() {
		if (!premier) { 	
			premier = true;
			return identificateurs;
			
		} else {
			identificateurs ++;
			return identificateurs;
			
		}
	}

	public static int getNombreDesAccidents() {
		return identificateurs + 1;
		
	}
	
	public static void setNombreDesAccidents(int n) {
		identificateurs = n;
		if (n==0) {
			premier = false;
		}
			
		
	}
	
	public String getCause() {
		return this.cause;
		
	
	}
	
	public void setCause(String c) {
		this.cause = c;
		
		
	}

}

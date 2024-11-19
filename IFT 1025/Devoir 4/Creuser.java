import java.io.IOException;
import java.io.PrintWriter;

/**
 * La classe Creuser étend la classe Commande et représente la commande de
 * creusement dans le contexte de la chasse au trésor.
 */
public class Creuser extends Commande {

	/**
	 * Exécute la commande de creusement, vérifie si le trésor est trouvé et génère
	 * un rapport dans le fichier specifié par le jeu.
	 * 
	 * @param jeu          L'objet ChasseAuTresor sur lequel la commande doit être
	 *                     exécutée.
	 * @param montrerCarte Indique si la carte doit être affichée pendant
	 *                     l'exécution de la commande.
	 */
	@Override
	public void executerCommande(ChasseAuTresor jeu, boolean montrerCarte) {
		// TODO Corriger la methode Creuser.executerCommande()
			String resultat;
			if (true) {
				resultat = "Le pirate a trouve le tresor!";
			} else {
				resultat = "Tresor non trouve! Essayez a nouveau.";
			}
			if (montrerCarte)
				System.out.println(resultat);

			System.out.println("Rapport mis dans le fichier " + jeu.getFileOut().getName());

	}

}

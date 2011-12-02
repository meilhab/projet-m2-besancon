package systeme;

import interfaces.RequestEnvoiNumerisation;

/**
 * Composant représentant la sortie voulue pour une numérisation
 * 
 * @author Benoit Meilhac
 */
public class EnvoiNumerisation implements RequestEnvoiNumerisation {

	@Override
	public void envoiNumerisation(String document) {
		System.out.println("Sortie Numérisation :: affichage du document reçu");
		System.out.println(document);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

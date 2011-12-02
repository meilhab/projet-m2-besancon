package systeme;

import interfaces.RequestEnvoiImpression;

/**
 * Composant représentant la sortie voulue pour une impression
 * 
 * @author Benoit Meilhac
 */
public class EnvoiImpression implements RequestEnvoiImpression {

	@Override
	public void envoiImpression(String document, int nombre) {
		System.out.println("Sortie Impression :: affichage du document imprimé");
		for (int i = 0; i < nombre; i++) {
			System.out.println((i + 1) + " : "); 
			System.out.println(document);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

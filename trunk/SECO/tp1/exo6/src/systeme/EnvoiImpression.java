package systeme;

import interfaces.RequestEnvoiImpression;

public class EnvoiImpression implements RequestEnvoiImpression {

	@Override
	public void envoiImpression(String document, int nombre) {
		for (int i = 0; i < nombre; i++) {
			System.out.println((i + 1) + " : " + document);
		}
	}

}

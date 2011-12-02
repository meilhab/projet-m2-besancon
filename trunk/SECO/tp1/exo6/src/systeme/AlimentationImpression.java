package systeme;

import interfaces.RequestAlim;

/**
 * Composant représentant l'alimentation associée à l'imprimante
 * 
 * @author Benoit Meilhac
 */
public class AlimentationImpression implements RequestAlim {
	private boolean alimentee = false;

	@Override
	public boolean etatAlimentation() {
		return alimentee;
	}

	@Override
	public void changerEtatImprimante() {
		alimentee = !alimentee;
	}

}

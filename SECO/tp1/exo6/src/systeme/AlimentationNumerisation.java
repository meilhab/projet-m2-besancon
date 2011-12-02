package systeme;

import interfaces.RequestAlim;

/**
 * Composant représentant l'alimentation associée au numériseur
 * 
 * @author Benoit Meilhac
 */
public class AlimentationNumerisation implements RequestAlim {
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

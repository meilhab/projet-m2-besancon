package systeme;

import interfaces.RequestAlim;

public class AlimentationNumerisation implements RequestAlim {
	private boolean alimentee = false;

	@Override
	public boolean etatAlimentation() {
		return alimentee;
	}

	public void changerEtatImprimante() {
		alimentee = !alimentee;
	}

}

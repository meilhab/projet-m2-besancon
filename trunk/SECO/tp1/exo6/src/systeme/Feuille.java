package systeme;

import interfaces.RequestFeuille;

public class Feuille implements RequestFeuille {
	private int nombreFeuille = 0;
	public static final int CAPACITEMAXBACFEUILLE = 10;

	@Override
	public boolean etatFeuille() {
		if (nombreFeuille > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getNombreFeuille() {
		return nombreFeuille;
	}

	@Override
	public void rechargementBacFeuille() {
		nombreFeuille = CAPACITEMAXBACFEUILLE;
	}

	@Override
	public void impressionFeuille(int nombre) {
		if (nombreFeuille > 0) {
			nombreFeuille -= nombre;
		}
		if (nombreFeuille < 0) {
			nombreFeuille = 0;
		}
	}

}

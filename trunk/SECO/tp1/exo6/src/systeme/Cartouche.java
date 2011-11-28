package systeme;

import interfaces.RequestCartoucheC;
import interfaces.RequestCartoucheN;

public class Cartouche implements RequestCartoucheN, RequestCartoucheC {
	private int niveauEncreCouleur = 0;
	private int niveauEncreNoire = 0;
	public static final int NIVEAUMAXCARTOUCHECOULEUR = 10;
	public static final int NIVEAUMAXCARTOUCHENOIRE = 10;

	@Override
	public boolean etatCartoucheC() {
		if (niveauEncreCouleur > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean etatCartoucheN() {
		if (niveauEncreNoire > 0) {
			return true;
		}
		return false;
	}

	public int getNiveauEncreCouleur() {
		return niveauEncreCouleur;
	}

	public int getNiveauEncreNoire() {
		return niveauEncreNoire;
	}

	public void rechargementEncreCouleur() {
		niveauEncreCouleur = NIVEAUMAXCARTOUCHECOULEUR;
	}

	public void rechargementEncreNoire() {
		niveauEncreNoire = NIVEAUMAXCARTOUCHENOIRE;
	}

	@Override
	public void impressionCouleur(int nombre) {
		if (niveauEncreCouleur > 0) {
			niveauEncreCouleur -= nombre;
		}
		if (niveauEncreCouleur < 0) {
			niveauEncreCouleur = 0;
		}
	}

	@Override
	public void impressionNoire(int nombre) {
		if (niveauEncreNoire > 0) {
			niveauEncreNoire -= nombre;
		}
		if (niveauEncreNoire < 0) {
			niveauEncreNoire = 0;
		}
	}
}

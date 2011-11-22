package systeme;

import interfaces.RequestCartoucheC;
import interfaces.RequestCartoucheN;

public class Cartouche implements RequestCartoucheN, RequestCartoucheC {
	private int niveauEncreCouleur = 0;
	private int niveauEncreNoire = 0;

	@Override
	public boolean etatCartoucheC() {
		if(niveauEncreCouleur > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean etatCartoucheN() {
		if(niveauEncreNoire > 0) {
			return true;
		}
		return false;
	}

	public int getNiveauEncreCouleur(){
		return niveauEncreCouleur;
	}
	
	public int getNiveauEncreNoire(){
		return niveauEncreNoire;
	}
	
	public void rechargementEncreCouleur(){
		niveauEncreCouleur = 10;
	}
	
	public void rechargementEncreNoire(){
		niveauEncreNoire = 10;
	}

	@Override
	public void impressionCouleur() {
		if(niveauEncreCouleur > 0){
			niveauEncreCouleur --;
		}
	}

	@Override
	public void impressionNoire() {
		if(niveauEncreNoire > 0){
			niveauEncreNoire --;
		}
	}
}

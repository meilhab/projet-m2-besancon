package systeme;

import org.objectweb.fractal.api.NoSuchInterfaceException;
import org.objectweb.fractal.api.control.BindingController;
import org.objectweb.fractal.api.control.IllegalBindingException;
import org.objectweb.fractal.api.control.IllegalLifeCycleException;

import outils.RecuperationClavier;

import interfaces.RequestAlim;
import interfaces.RequestCartoucheC;
import interfaces.RequestCartoucheN;
import interfaces.RequestEnvoiImpression;
import interfaces.RequestFeuille;
import interfaces.RequestImpression;

public class ControleurImpression implements RequestImpression, BindingController {
	private RequestEnvoiImpression envoiImpression;
	private RequestFeuille feuille;
	private RequestCartoucheN cartoucheN;
	private RequestCartoucheC cartoucheC;
	private RequestAlim alimentation;

	@Override
	public void bindFc(String arg0, Object arg1)
			throws NoSuchInterfaceException, IllegalBindingException,
			IllegalLifeCycleException {
		if(arg0.equals("f")){
			feuille = (RequestFeuille) arg1;
		} else if (arg0.equals("cn")) {
			cartoucheN = (RequestCartoucheN) arg1;
		} else if (arg0.equals("cc")) {
			cartoucheC = (RequestCartoucheC) arg1;
		} else if (arg0.equals("a")) {
			alimentation = (RequestAlim) arg1;
		} else if (arg0.equals("e")) {
			envoiImpression = (RequestEnvoiImpression) arg1;
		}
	}

	@Override
	public String[] listFc() {
		return new String[] { "f" , "cn", "cc", "a" , "e" };
	}

	@Override
	public Object lookupFc(String arg0) throws NoSuchInterfaceException {
		if(arg0.equals("f")){
			return feuille;
		} else if (arg0.equals("cn")) {
			return cartoucheN;
		} else if (arg0.equals("cc")) {
			return cartoucheC;
		} else if (arg0.equals("a")) {
			return alimentation;
		} else if (arg0.equals("e")) {
			return envoiImpression;
		}
		return null;
	}

	@Override
	public void unbindFc(String arg0) throws NoSuchInterfaceException,
			IllegalBindingException, IllegalLifeCycleException {
		if(arg0.equals("f")){
			feuille = null;
		} else if (arg0.equals("cn")) {
			cartoucheN = null;
		} else if (arg0.equals("cc")) {
			cartoucheC = null;
		} else if (arg0.equals("a")) {
			alimentation = null;
		} else if (arg0.equals("e")) {
			envoiImpression = null;
		}
	}

	@Override
	public void impression() {
		System.out.println("----------------------------------------------------");
		System.out.println("Controleur Impression :: Vérification des composants");
		System.out.println("----------------------------------------------------");

		boolean enCouleur = true;

		if (!gestionAlimentation()) {
			System.out.println("\tImprimer en noir et blanc seulement (o/n)?");
			if (!RecuperationClavier.resultatSaisie("o", "n")) {
				System.out.println("Controleur Impression :: impression annulée");
				return;
			}
			enCouleur = false;
		}
		if (!gestionCartoucheC()) {
			System.out.println("Controleur Impression :: impression annulée");
			return;
		}
		if (!gestionCartoucheN()) {
			System.out.println("Controleur Impression :: impression annulée");
			return;
		}

		System.out.println("Controleur Impression :: impression en cours...");
		if(enCouleur){
			cartoucheC.impressionCouleur();
		}
		cartoucheN.impressionNoire();
		
		// numerisation
	}

	private boolean gestionAlimentation() {
		System.out.println("Controleur Impression :: Alimentation");
		if (!alimentation.etatAlimentation()) {
			System.out.println("\tImprimante éteinte : allumer (o/n)?");
			return !RecuperationClavier.resultatSaisie("o", "n");
		}
		return true;
	}

	private boolean gestionCartoucheC() {
		System.out.println("Controleur Impression :: Cartouche couleur");
		System.out.println("Niveau d'encre couleur : "
				+ cartoucheC.getNiveauEncreCouleur());
		if (!cartoucheC.etatCartoucheC()) {
			System.out.println("\tCartouche couleur vide : recharger (o/n)?");
			return !RecuperationClavier.resultatSaisie("o", "n");
		}
		return true;
	}

	private boolean gestionCartoucheN() {
		System.out.println("Controleur Impression :: Cartouche noire");
		System.out.println("Niveau d'encre noire : "
				+ cartoucheN.getNiveauEncreNoire());
		if (!cartoucheN.etatCartoucheN()) {
			System.out.println("\tCartouche noire vide : recharger (o/n)?");

			return RecuperationClavier.resultatSaisie("o", "n");
		}
		return true;
	}

}

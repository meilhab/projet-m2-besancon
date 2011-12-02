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

/**
 * Composant représentant le contrôleur gérant l'impression
 * 
 * @author Benoit Meilhac
 */
public class ControleurImpression implements RequestImpression,
		BindingController {
	private RequestFeuille feuille;
	private RequestCartoucheN cartoucheN;
	private RequestCartoucheC cartoucheC;
	private RequestAlim alimentation;
	private RequestEnvoiImpression envoiImpression;

	@Override
	public void bindFc(String arg0, Object arg1)
			throws NoSuchInterfaceException, IllegalBindingException,
			IllegalLifeCycleException {
		if (arg0.equals("f")) {
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
		return new String[] { "f", "cn", "cc", "a", "e" };
	}

	@Override
	public Object lookupFc(String arg0) throws NoSuchInterfaceException {
		if (arg0.equals("f")) {
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
		if (arg0.equals("f")) {
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
	public void impression(String document, int nombre, boolean enCouleur) {
		System.out
				.println("----------------------------------------------------");
		System.out
				.println("Controleur Impression :: Vérification des composants");
		System.out
				.println("----------------------------------------------------");

		boolean termineImpression = false;
		int nombreImpressionsCycle = 0;

		while (!termineImpression) {

			System.out.println();
			System.out
					.println("----------------------------------------------------");
			System.out.println("Nombre de feuilles restantes à imprimer : "
					+ nombre);
			System.out
					.println("----------------------------------------------------");

			// contrôle des composants
			if (!gestionGeneraleImpression(enCouleur)) {
				System.out
						.println("Controleur Impression :: impression annulée");
				return;
			}
			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// récupération du nombre de feuilles maximum imprimables pour ce
			// cycle
			if (enCouleur) {
				nombreImpressionsCycle = cartoucheC.getNiveauEncreCouleur();
			} else {
				nombreImpressionsCycle = cartoucheN.getNiveauEncreNoire();
			}

			if (feuille.getNombreFeuille() < nombreImpressionsCycle) {
				nombreImpressionsCycle = feuille.getNombreFeuille();
			}

			if (nombre > nombreImpressionsCycle) {
				nombre -= nombreImpressionsCycle;
			} else {
				nombreImpressionsCycle = nombre;
				termineImpression = true;
			}

			// une fois le total des actions vérifiées, on lance le processus :
			// retire des feuilles et de l'encre
			System.out
					.println("Controleur Impression :: impression en cours de "
							+ nombreImpressionsCycle + " feuilles...");
			if (enCouleur) {
				cartoucheC.impressionCouleur(nombreImpressionsCycle);
			} else {
				cartoucheN.impressionNoire(nombreImpressionsCycle);
			}
			feuille.impressionFeuille(nombreImpressionsCycle);
			envoiImpression.envoiImpression(document, nombreImpressionsCycle);

		}
	}

	/**
	 * Vérifie que les composants nécessaires à un impression sont disponibles
	 * 
	 * @param enCouleur
	 *            précise si on contrôle une cartouche couleur ou noire
	 * @return true si tous les composants sont opérationnels, false sinon
	 */
	private boolean gestionGeneraleImpression(boolean enCouleur) {
		if (!gestionAlimentation()) {
			return false;
		}
		System.out.println();
		if (enCouleur && !gestionCartoucheC()) {
			return false;
		}
		if (!enCouleur && !gestionCartoucheN()) {
			return false;
		}
		System.out.println();
		if (!gestionFeuille()) {
			return false;
		}
		return true;
	}

	/**
	 * Vérifie que l'alimentation est disponible, demande à l'utilisateur si
	 * elle ne l'est pas
	 * 
	 * @return état de l'imprimante
	 */
	private boolean gestionAlimentation() {
		System.out.println("Controleur Impression :: Alimentation");
		if (!alimentation.etatAlimentation()) {
			System.out.println("\tImprimante éteinte : allumer (o/n)?");
			if (!RecuperationClavier.resultatSaisie("o", "n")) {
				return false;
			}
			alimentation.changerEtatImprimante();
		}
		return true;
	}

	/**
	 * Vérifie que la cartouche couleur est rempli, demande à l'utilisateur si
	 * elle ne l'est pas
	 * 
	 * @return état de la cartouche couleur
	 */
	private boolean gestionCartoucheC() {
		System.out.println("Controleur Impression :: Cartouche couleur");
		System.out.println("\tNiveau d'encre couleur : "
				+ cartoucheC.getNiveauEncreCouleur());
		if (!cartoucheC.etatCartoucheC()) {
			System.out
					.println("\tCartouche couleur :: niveau encre vide : recharger (o/n)?");
			if (!RecuperationClavier.resultatSaisie("o", "n")) {
				return false;
			}
			System.out
					.println("\tCartouche couleur :: rechargement de la cartouche");
			cartoucheC.rechargementEncreCouleur();
		}
		return true;
	}

	/**
	 * Vérifie que la cartouche noire est rempli, demande à l'utilisateur si
	 * elle ne l'est pas
	 * 
	 * @return état de la cartouche noire
	 */
	private boolean gestionCartoucheN() {
		System.out.println("Controleur Impression :: Cartouche noire");
		System.out.println("\tNiveau d'encre noire : "
				+ cartoucheN.getNiveauEncreNoire());
		if (!cartoucheN.etatCartoucheN()) {
			System.out
					.println("\tCartouche noire :: niveau encre vide : recharger (o/n)?");
			if (!RecuperationClavier.resultatSaisie("o", "n")) {
				return false;
			}
			System.out
					.println("\tCartouche noire :: rechargement de la cartouche");
			cartoucheN.rechargementEncreNoire();
		}
		return true;
	}

	/**
	 * Vérifie que le bac de feuilles est rempli, demande à l'utilisateur si il
	 * ne l'est pas
	 * 
	 * @return état du bac de feuilles
	 */
	private boolean gestionFeuille() {
		System.out.println("Controleur Impression :: Bac de feuilles");
		System.out.println("\tNombre de feuilles disponibles : "
				+ feuille.getNombreFeuille());
		if (!feuille.etatFeuille()) {
			System.out.println("\tBac de feuilles :: vide : recharger (o/n)?");
			if (!RecuperationClavier.resultatSaisie("o", "n")) {
				return false;
			}
			System.out.println("\tBac de feuilles :: rechargement du bac");
			feuille.rechargementBacFeuille();
		}
		return true;
	}

}

package systeme;

import interfaces.RequestImpression;
import interfaces.RequestNumerisation;

import org.objectweb.fractal.api.NoSuchInterfaceException;
import org.objectweb.fractal.api.control.BindingController;
import org.objectweb.fractal.api.control.IllegalBindingException;
import org.objectweb.fractal.api.control.IllegalLifeCycleException;

import outils.RecuperationClavier;

/**
 * Composant représentant le contrôleur recevant une demande de l'utilisateur au
 * photocopieur
 * 
 * @author Benoit Meilhac
 */
public class ControleurPrincipal implements Runnable, BindingController {
	private RequestImpression impression;
	private RequestNumerisation numerisation;

	@Override
	public void bindFc(String arg0, Object arg1)
			throws NoSuchInterfaceException, IllegalBindingException,
			IllegalLifeCycleException {
		if (arg0.equals("i")) {
			impression = (RequestImpression) arg1;
		} else if (arg0.equals("n")) {
			numerisation = (RequestNumerisation) arg1;
		}
	}

	@Override
	public String[] listFc() {
		return new String[] { "i", "n" };
	}

	@Override
	public Object lookupFc(String arg0) throws NoSuchInterfaceException {
		if (arg0.equals("i")) {
			return impression;
		} else if (arg0.equals("n")) {
			return numerisation;
		}
		return null;
	}

	@Override
	public void unbindFc(String arg0) throws NoSuchInterfaceException,
			IllegalBindingException, IllegalLifeCycleException {
		if (arg0.equals("i")) {
			impression = null;
		} else if (arg0.equals("n")) {
			numerisation = null;
		}
	}

	@Override
	public void run() {
		boolean continuer = false;
		boolean choix = true; // true = numérisation, false = impression
		int nombrePage = 1;
		boolean enCouleur = true;
		boolean impression = false;
		String chemin = "";

		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("Système de gestion d'un photocopieur");
		System.out.println("------------------------------------");
		System.out.println();

		do {
			System.out
					.println("Choix du programme (n : numérisation / i : impression)");
			choix = RecuperationClavier.resultatSaisie("n", "i");
			System.out.println();

			if (choix) {
				System.out
						.println("Numérisation :: impression du résultat (o/n)");
				impression = RecuperationClavier.resultatSaisie("o", "n");
				System.out.println();

				if (impression) {
					System.out
							.println("Numérisation : Impression :: nombre de copies");
					nombrePage = RecuperationClavier.entierSaisie();
					System.out.println();
					System.out
							.println("Numérisation : Impression :: impression couleur (o/n) ");
					enCouleur = RecuperationClavier.resultatSaisie("o", "n");
					System.out.println();
					numerisation
							.numerisation(impression, nombrePage, enCouleur);

				} else {
					numerisation.numerisation(false, 0, false);
				}
			} else {
				System.out
						.println("Impression :: chemin vers le document à imprimer");
				chemin = RecuperationClavier.cheminSaisie();
				System.out.println();
				System.out.println("Impression :: nombre de copies");
				nombrePage = RecuperationClavier.entierSaisie();
				System.out.println();
				System.out.println("Impression :: impression couleur (o/n)");
				enCouleur = RecuperationClavier.resultatSaisie("o", "n");
				System.out.println();
				this.impression.impression(
						RecuperationClavier.recuperationFichier(chemin),
						nombrePage, enCouleur);
			}

			System.out.println();
			System.out.println("Effectuer une nouvelle tâche (o/n)");
			continuer = RecuperationClavier.resultatSaisie("o", "n");
		} while (continuer);

		System.out.println();
		System.out
				.println("---------------------------------------------------------");
		System.out
				.println("Fin d'utilisation du système de gestion d'un photocopieur");
		System.out
				.println("---------------------------------------------------------");
		System.out.println();
	}

}

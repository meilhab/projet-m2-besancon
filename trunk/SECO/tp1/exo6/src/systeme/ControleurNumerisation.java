package systeme;

import org.objectweb.fractal.api.NoSuchInterfaceException;
import org.objectweb.fractal.api.control.BindingController;
import org.objectweb.fractal.api.control.IllegalBindingException;
import org.objectweb.fractal.api.control.IllegalLifeCycleException;

import outils.RecuperationClavier;

import interfaces.RequestAlim;
import interfaces.RequestDoc;
import interfaces.RequestEnvoiNumerisation;
import interfaces.RequestImpression;
import interfaces.RequestNumerisation;

/**
 * Composant représentant le contrôleur gérant la numérisation
 * 
 * @author Benoit Meilhac
 */
public class ControleurNumerisation implements RequestNumerisation,
		BindingController {
	private RequestImpression impression;
	private RequestDoc document;
	private RequestAlim alimentation;
	private RequestEnvoiNumerisation envoiNumerisation;

	@Override
	public void bindFc(String arg0, Object arg1)
			throws NoSuchInterfaceException, IllegalBindingException,
			IllegalLifeCycleException {
		if (arg0.equals("i")) {
			impression = (RequestImpression) arg1;
		} else if (arg0.equals("d")) {
			document = (RequestDoc) arg1;
		} else if (arg0.equals("a")) {
			alimentation = (RequestAlim) arg1;
		} else if (arg0.equals("e")) {
			envoiNumerisation = (RequestEnvoiNumerisation) arg1;
		}
	}

	@Override
	public String[] listFc() {
		return new String[] { "i", "d", "a", "e" };
	}

	@Override
	public Object lookupFc(String arg0) throws NoSuchInterfaceException {
		if (arg0.equals("i")) {
			return impression;
		} else if (arg0.equals("d")) {
			return document;
		} else if (arg0.equals("a")) {
			return alimentation;
		} else if (arg0.equals("e")) {
			return envoiNumerisation;
		}
		return null;
	}

	@Override
	public void unbindFc(String arg0) throws NoSuchInterfaceException,
			IllegalBindingException, IllegalLifeCycleException {
		if (arg0.equals("i")) {
			impression = null;
		} else if (arg0.equals("d")) {
			document = null;
		} else if (arg0.equals("a")) {
			alimentation = null;
		} else if (arg0.equals("e")) {
			envoiNumerisation = null;
		}
	}

	@Override
	public void numerisation(boolean impression, int nbPage, boolean enCouleur) {
		System.out
				.println("------------------------------------------------------");
		System.out
				.println("Controleur Numérisation :: Vérification des composants");
		System.out
				.println("------------------------------------------------------");
		
		System.out.println();
		// contrôle des composants
		if (!gestionAlimentation()) {
			System.out
					.println("Controleur Numérisation :: numérisation annulée");
			return;
		}
		System.out.println();
		
		// récupération du document
		String doc = document.numeriserDocument();
		
		System.out.println("Controleur Numérisation :: récupération du document");
		System.out.println(doc);
		System.out.println();
		
		envoiNumerisation.envoiNumerisation(doc);
		System.out.println();
		
		if(impression){
			System.out.println("Controleur Numérisation :: impression demandée");
			System.out.println("----------------------------------------------");
			System.out.println();
			this.impression.impression(doc, nbPage, enCouleur);
		}
		
	}

	/**
	 * Vérifie que l'alimentation est disponible, demande à l'utilisateur si
	 * elle ne l'est pas
	 * 
	 * @return état de l'imprimante
	 */
	private boolean gestionAlimentation() {
		System.out.println("Controleur Numérisation :: Alimentation");
		if (!alimentation.etatAlimentation()) {
			System.out.println("\tNumériseur éteint : allumer (o/n)?");
			if (!RecuperationClavier.resultatSaisie("o", "n")) {
				return false;
			}
			alimentation.changerEtatImprimante();
		}
		return true;
	}
	
}

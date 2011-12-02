package systeme;

import outils.RecuperationClavier;

import interfaces.RequestDoc;

/**
 * Composant représentant le document à numériser
 * 
 * @author Benoit Meilhac
 */
public class Document implements RequestDoc {

	@Override
	public String numeriserDocument() {
		System.out.println("\tDocument :: Chemin vers le document à numériser : ");
		String chemin = RecuperationClavier.cheminSaisie();
		System.out.println("\tDocument :: Récupération du document en cours...");
		System.out.println();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return RecuperationClavier.recuperationFichier(chemin);
	}

}

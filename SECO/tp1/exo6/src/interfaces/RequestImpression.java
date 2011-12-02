package interfaces;

/**
 * Méthode permettant l'impression d'un document un certain nombre de fois et en
 * couleur ou non
 * 
 * @author Benoit Meilhac
 */
public interface RequestImpression {
	/**
	 * Lancement de la procèdure d'impression d'un document
	 * 
	 * @param document
	 *            document à imprimer
	 * @param nombre
	 *            nombre de copies
	 * @param enCouleur
	 *            impression en couleur ou non
	 */
	public void impression(String document, int nombre, boolean enCouleur);
}

package interfaces;

/**
 * Méthode permettant la numérisation d'un document avec éventuellement
 * l'impression un certain nombre de fois en couleur ou non
 * 
 * @author Benoit Meilhac
 */
public interface RequestNumerisation {
	/**
	 * Lancement de la procédure de numérisation d'un document
	 * 
	 * @param impression
	 *            impression ou non du document suite à la numérisation
	 * @param nbPage
	 *            nombre de copies si impression
	 * @param enCouleur
	 *            impression en couleur ou non si demandée
	 */
	public void numerisation(boolean impression, int nbPage, boolean enCouleur);
}

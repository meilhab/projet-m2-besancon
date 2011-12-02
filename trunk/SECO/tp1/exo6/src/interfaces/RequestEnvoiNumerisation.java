package interfaces;

/**
 * Méthode permettant le traitement de numérisation d'un document
 * 
 * @author Benoit Meilhac
 */
public interface RequestEnvoiNumerisation {
	/**
	 * Réception du document numérisé et affichage de celui-ci
	 * 
	 * @param document
	 *            document numérisé
	 */
	public void envoiNumerisation(String document);

}

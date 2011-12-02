package interfaces;

/**
 * Méthode permettant le traitement d'impression d'un document
 * 
 * @author Benoit Meilhac
 */
public interface RequestEnvoiImpression {
	/**
	 * Réception du document et du nombre de copies que l'on veut. Il est
	 * affiché le nombre de fois voulu
	 * 
	 * @param document
	 *            document envoyé à l'impression
	 * @param nombre
	 *            nombre de copies du document voulu
	 */
	void envoiImpression(String document, int nombre);
}

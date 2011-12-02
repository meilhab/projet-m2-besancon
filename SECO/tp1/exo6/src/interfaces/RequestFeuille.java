package interfaces;

/**
 * Méthodes permettant la vérification du bac de feuille de l'imprimante
 * 
 * @author Benoit Meilhac
 */
public interface RequestFeuille {
	/**
	 * Informe sur la présence ou non de feuilles dans le bac à feuilles
	 * 
	 * @return présence de feuilles ou non
	 */
	public boolean etatFeuille();

	/**
	 * Permet de connaître le nombre de feuilles dans le bac à feuilles
	 * 
	 * @return nombre de feuilles
	 */
	public int getNombreFeuille();

	/**
	 * Recharge le bac de feuilles
	 */
	public void rechargementBacFeuille();

	/**
	 * Donne un nombre de feuilles à imprimer et retire du total de feuilles
	 * disponibles ce nombre
	 * 
	 * @param nombre
	 *            nombre de feuilles à retirer du bac
	 */
	public void impressionFeuille(int nombre);
}

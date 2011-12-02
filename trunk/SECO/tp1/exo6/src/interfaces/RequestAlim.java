package interfaces;

/**
 * Méthodes permettant de gérer l'alimentation
 * 
 * @author Benoit Meilhac
 */
public interface RequestAlim {
	/**
	 * Informe sur l'état de l'alimentation, allumée ou non
	 * 
	 * @return état de l'alimentation
	 */
	public boolean etatAlimentation();

	/**
	 * Change l'état actuel de l'alimentation
	 */
	public void changerEtatImprimante();
}

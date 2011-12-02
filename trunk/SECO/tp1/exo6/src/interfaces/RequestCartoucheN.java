package interfaces;

/**
 * Méthodes permettant la gestion d'une cartouche d'encre noire
 * 
 * @author Benoit Meilhac
 */
public interface RequestCartoucheN {
	/**
	 * Informe sur l'état de la cartouche, vide ou non
	 * 
	 * @return état de la cartouche couleur
	 */
	public boolean etatCartoucheN();

	/**
	 * Informe sur la quantité d'encre restante
	 * 
	 * @return niveau d'encre actuel
	 */
	public int getNiveauEncreNoire();

	/**
	 * Recharge l'encre au maximum de ses capacités
	 */
	public void rechargementEncreNoire();

	/**
	 * Récupère le nombre de page à imprimer et déduit l'encre nécessaire pour
	 * cette impression : une feuille = un niveau d'encre
	 * 
	 * @param nombre
	 *            nombre de feuille à imprimer
	 */
	public void impressionNoire(int nombre);
}

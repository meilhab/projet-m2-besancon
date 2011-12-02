package interfaces;

/**
 * Méthodes permettant la gestion d'une cartouche de couleur
 * 
 * @author Benoit Meilhac
 */
public interface RequestCartoucheC {
	/**
	 * Informe sur l'état de la cartouche couleur, vide ou non
	 * 
	 * @return état de la cartouche couleur
	 */
	public boolean etatCartoucheC();

	/**
	 * Informe sur la quantité d'encre couleur restante
	 * 
	 * @return niveau d'encre actuel
	 */
	public int getNiveauEncreCouleur();

	/**
	 * Recharge l'encre au maximum de ses capacités
	 */
	public void rechargementEncreCouleur();

	/**
	 * Récupère le nombre de page à imprimer et déduit l'encre nécessaire pour
	 * cette impression : une feuille = un niveau d'encre
	 * 
	 * @param nombre
	 *            nombre de feuille à imprimer
	 */
	public void impressionCouleur(int nombre);
}

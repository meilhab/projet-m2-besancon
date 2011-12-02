package interfaces;

/**
 * Méthode permettant de récupérer un document "numérisé"
 * 
 * @author bmeilhac
 */
public interface RequestDoc {
	/**
	 * Permet la "numérisation" d'un document -> demande un chemin et retourne le contenu
	 * 
	 * @return contenu du document "numérisé"
	 */
	public String numeriserDocument();
}

package outils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Classe récupérée permettant de traiter les entrées clavier en fonction du
 * type d'information que l'on veut
 */
public final class Clavier {

	private static BufferedReader bufIn = null;

	private static StringTokenizer st = null;

	private Clavier() {
	}

	private static void initialise() {
		if (bufIn == null)
			bufIn = new BufferedReader(new InputStreamReader(System.in));
	}

	/* Lecture d'une information dans le buffer */
	private static void read() {
		if (bufIn == null) // Ce test ne peut être vrai qu'une fois
			initialise(); // définition du buffer
		try {
			String s = bufIn.readLine(); // Lecture d'une ligne du buffer
			st = new StringTokenizer(s); // Instanciation objet d'analyse
		} catch (IOException e) {
			System.err.println("read" + " " + e.getMessage());
			System.exit(2); // Une erreur s'est produite, on sort du programme.
		}
	}

	/**
	 * analyse la prochaine entité dans le buffer comme une constante de type
	 * int (entier). <BR>
	 * Les espaces, tabulations et sauts de lignes sont "passés". La lecture
	 * attend l'arrivée d'autres caractères dans le buffer. <br>
	 * 
	 * @return le nombre lu de type int
	 * @exception NumberFormatException
	 *                erreur si la prochaine entité n'est pas de type int.
	 */
	public static int lireInt() {
		if (st == null)
			read();
		while (!st.hasMoreTokens())
			read();
		String ss = st.nextToken();
		int i = Integer.parseInt(ss);
		return (i);
	}

	/**
	 * analyse la prochaine entité dans le buffer comme une constante de type
	 * long (entier). <BR>
	 * Les espaces, tabulations et sauts de lignes sont "passés". La lecture
	 * attend l'arrivée d'autres caractères dans le buffer. <br>
	 * 
	 * @return le nombre lu de type long
	 * @exception NumberFormatException
	 *                erreur si la prochaine entité n'est pas de type long
	 */
	public static long lireLong() {
		if (st == null)
			read();
		while (!st.hasMoreTokens())
			read();
		String ss = st.nextToken();
		long i = Long.parseLong(ss);
		return (i);
	}

	/**
	 * analyse la prochaine entité dans le buffer comme une constante de type
	 * float (réel flottant). <BR>
	 * Les espaces, tabulations et sauts de lignes sont "passés". La lecture
	 * attend l'arrivée d'autres caractères dans le buffer. <br>
	 * 
	 * @return le nombre lu de type float
	 * @exception NumberFormatException
	 *                erreur si la prochaine entité n'est pas de type float
	 */
	public static float lireFloat() {
		if (st == null)
			read();
		while (!st.hasMoreTokens())
			read();
		String ss = st.nextToken();
		float f = Float.parseFloat(ss);
		return (f);
	}

	/**
	 * analyse la prochaine entité dans le buffer comme une constante de type
	 * double (réel flottant en double précision). <BR>
	 * Les espaces, tabulations et sauts de lignes sont "passés". La lecture
	 * attend l'arrivée d'autres caractères dans le buffer. <br>
	 * 
	 * @return le nombre lu de type double
	 * @exception NumberFormatException
	 *                erreur si la prochaine entité n'est pas de type double
	 */
	public static double lireDouble() {
		if (st == null)
			read();
		while (!st.hasMoreTokens())
			read();
		String ss = st.nextToken();
		double f = Double.parseDouble(ss);
		return (f);
	}

	/**
	 * analyse la prochaine entité dans le buffer comme une constante de type
	 * chaine de caractères. <BR>
	 * Les espaces, tabulations et sauts de lignes sont "passés". La lecture
	 * attend l'arrivée d'autres caractères dans le buffer. <br>
	 * En particulier, on ne peut pas saisir une chaîne vide, ou une chaîne avec
	 * des espaces.
	 * 
	 * @return la chaine de caractères lue de type String
	 */
	public static String lireString() {
		if (st == null)
			read();
		while (!st.hasMoreTokens())
			read();
		return (st.nextToken());
	}

	/**
	 * Retourne la chaîne composée de tous les caractères rencontrés jusqu'au
	 * prochain retour chariot. <BR>
	 * Permet de saisir une chaîne vide, ou une chaîne avec des espaces. Si une
	 * information (par exemple un entier) a déjà été récupérée, ne donne que la
	 * fin de la ligne (à partir du premier caractère, après l'information,
	 * différent de l'espace et de la tabulation).
	 * 
	 * @return la chaine de caractères lue de type String
	 */
	public static String lireLigne() {
		String s = "";
		if ((st == null) || (!st.hasMoreTokens())) {
			if (bufIn == null)
				initialise();
			try {
				s = bufIn.readLine();
			} catch (IOException e) {
				System.err.println("lireString" + " " + e.getMessage());
				System.exit(2); // Une erreur s'est produite, on sort du
								// programme.
			}
			return s;
		} else {
			System.out.println("Autre cas");
			return (st.nextToken(System.getProperty("line.separator")));
		}
	}
}
package outils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Fonctions outil permettant de gérer les entrées clavier de l'utilisateur
 * 
 * @author Benoit Meilhac
 */
public class RecuperationClavier {
	/**
	 * Résultat d'une saisie clavier : on attend 2 chaînes ("oui"/"non") par
	 * exemple, tant qu'on ne récupère pas en entrée clavier ces deux chaînes,
	 * on attend une nouvelle saisie.<br />
	 * Une fois un des deux récupéré, on retourne true si la première chaîne est
	 * entrée, sinon false
	 * 
	 * @param arg1
	 *            première chaïne attendue éventuellement
	 * @param arg2
	 *            deuxième chaîne attendue éventuellement
	 * @return true si première chaîne récupérée, false sinon
	 */
	public static boolean resultatSaisie(String arg1, String arg2) {
		String choix = Clavier.lireString();
		while (!choix.equalsIgnoreCase(arg1) && !choix.equalsIgnoreCase(arg2)) {
			System.out.println("Choix invalide, nouvelle saisie");
			choix = Clavier.lireString();
		}

		if (choix.equalsIgnoreCase(arg1)) {
			return true;
		}

		return false;
	}

	/**
	 * Permet la récupération d'une chaîne de caractères en entrée
	 * 
	 * @return chaîne de caractères saisie
	 */
	public static String cheminSaisie() {
		return Clavier.lireString();
	}

	/**
	 * Permet la récupération d'un entier en entrée
	 * 
	 * @return entier saisie
	 */
	public static int entierSaisie() {
		return Clavier.lireInt();
	}

	/**
	 * Permet de récupérer le contenu d'un fichier et de le retourner. Si le
	 * fichier n'est pas trouvé, on retourne la chaîne vide
	 * 
	 * @param chemin
	 *            emplacement du fichier à récupérer
	 * @return contenu du fichier s'il a été trouvé
	 */
	public static String recuperationFichier(String chemin) {
		BufferedReader lecteurAvecBuffer = null;
		String ligne;
		String fichier = "";
		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader(chemin));
			while ((ligne = lecteurAvecBuffer.readLine()) != null) {
				fichier += ligne + "\n";
			}
			lecteurAvecBuffer.close();
		} catch (FileNotFoundException exc) {
			System.out.println("Fichier non trouvé au chemin : " + chemin);
			return "";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fichier;
	}
}

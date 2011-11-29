package outils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RecuperationClavier {
	public static boolean resultatSaisie(String arg1, String arg2){
		String choix = Clavier.lireString();
		while (!choix.equalsIgnoreCase(arg1)
				&& !choix.equalsIgnoreCase(arg2)){
			System.out.println("Choix invalide, nouvelle saisie");
			choix = Clavier.lireString();
		} 
		
		if (choix.equalsIgnoreCase(arg1)) {
			return true;
		}
		
		return false;
	}
	
	public static String cheminSaisie(){
		return Clavier.lireString();
	}
	
	public static int entierSaisie(){
		return Clavier.lireInt();
	}
	
	public static String recuperationFichier(String chemin) {
		BufferedReader lecteurAvecBuffer = null;
		String ligne;
		String fichier = "";
		try {
			lecteurAvecBuffer = new BufferedReader(new FileReader(chemin));
			while ((ligne = lecteurAvecBuffer.readLine()) != null){
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

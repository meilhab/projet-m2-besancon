package outils;

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
}

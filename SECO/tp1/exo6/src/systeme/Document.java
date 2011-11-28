package systeme;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import outils.RecuperationClavier;

import interfaces.RequestDoc;

public class Document implements RequestDoc {

	@Override
	public String numeriserDocument() {
		System.out.println("Chemin vers le document à numériser : ");
		String chemin = RecuperationClavier.cheminSaisie();
		
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

package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO Ã  completer
		
		Boolean estVillageois = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!estVillageois) {
			System.out.println(String.format("Je suis désolé %s mais il faut êtr un habitant de noter village pour commercer ici.", nomAcheteur));
		}
		else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.nextLine();
			Etal[] etalsProduit = controlAcheterProduit.trouverProduit(produit);
			if (etalsProduit == null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
			else {
				for (int i=0; i<etalsProduit.length; i++) {
					System.out.println(String.format("%d - %s", i, etalsProduit[i].getVendeur().getNom()));
				}
				String vendeurChoisi = scan.nextLine();
			}
			
		}
	}
}

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
	
		
		Boolean estVillageois = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!estVillageois) {
			System.out.println(String.format("Je suis désolé %s mais il faut �tr un habitant de noter village pour commercer ici.", nomAcheteur));
		}
		else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.nextLine();
			String[] nomsVendeurs = controlAcheterProduit.trouverProduit(produit);
			if (nomsVendeurs == null) {
				System.out.println("Désolé, personne ne vend ce produit au march�.");
			}
			else {
				System.out.println(String.format("Chez quel commerçant voulez-vous acheter des %s", produit));
				for (int i=0; i<nomsVendeurs.length; i++) {
					System.out.println(String.format("%d - %s", i+1, nomsVendeurs[i]));
				}
				String nomVendeur = nomsVendeurs[Integer.parseInt(scan.nextLine())-1];
				System.out.println(String.format("%s se déplace jusqu'à l'étal du vendeur %s", nomAcheteur, nomVendeur));
				System.out.println(String.format("Bonjour %s\nCombien de %s voulez-vous acheter?", nomAcheteur, produit));
				int quantite = Integer.parseInt(scan.nextLine());
				int stockDisponible = controlAcheterProduit.stockEtal(nomVendeur);
				if (stockDisponible==0) {
					System.out.println(String.format("%s veut acheter %d %s, malheureusement il n'y en a plus!", nomAcheteur, quantite, produit));
				}
				else if (stockDisponible<quantite) {
					System.out.println(String.format("%s veut acheter %d %s, malheureusement %s n'en a plus que %d. %s achète tout le stock de %s.", nomAcheteur, quantite, produit, nomVendeur, stockDisponible, nomAcheteur, nomVendeur));
					controlAcheterProduit.acheterProduit(nomVendeur, stockDisponible);
				}
				else {
					System.out.println(String.format("%s achète %d %s à %s.",nomAcheteur, quantite, produit, nomVendeur));
					controlAcheterProduit.acheterProduit(nomVendeur, quantite);
				}
			}
		}
	}
	
	
}

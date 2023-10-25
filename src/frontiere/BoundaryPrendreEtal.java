package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//TODO a completer
		Boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println(String.format("je suis désolé %s mais il faut être un habitantde notre village pour commercer ici.", nomVendeur));
		}
		else {
			System.out.println(String.format("Bonjour %s, je vais regarder si  je peux vous trouver un étal", nomVendeur));
			Boolean etalDisponible=controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println(String.format("Désolé %s je n'ai plus d'étal qui ne soit pas occupé.", nomVendeur));
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
		System.out.println("C'est parfait, il me reste un étal pour vous!\nIl me faudrait plus de renseignements:\nquel produit souhaitez-vous vendre?\n");
		String produit = scan.nextLine();
		int nb_produits = Clavier.entrerEntier("Combien souhaitez-vous en vendre?");
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nb_produits);
		if (numEtal!=-1) {
			System.out.println(String.format("Le vendeur %s c'est installé à l'étal n° %d.", nomVendeur, numEtal+1));
		}
		System.out.println(String.format("En revoir %s, passez une bonne journée.", nomVendeur));
	}
}

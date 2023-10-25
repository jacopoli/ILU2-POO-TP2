package frontiere;

import controleur.ControlLibererEtal;


public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		//TODO a completer
		Boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("mais vous n'êtes pas inscrit sur notre marché ajourd'hui!");
		}
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if (donneesEtal[0]!=null) {
			System.out.println(String.format("Vous avez vendu %s sur %s %s.", donneesEtal[4], donneesEtal[3], donneesEtal[2]));
			}
		}
	}

}

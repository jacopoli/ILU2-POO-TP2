package controleur;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private ControlTrouverEtalVendeur control;
	private Gaulois vendeur;
	
	@BeforeEach
	protected void initTest() {
		village = new Village("le village", 10, 10);
		Chef chef = new Chef ("chef", 1, village);
		village.setChef(chef);
		vendeur = new Gaulois("gaulois", 1);
		village.installerVendeur(vendeur, "fleur", 3);
		control = new ControlTrouverEtalVendeur(village);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(control);
	}

	@Test
	void testTrouverEtalVendeur() {
		assertNull(control.trouverEtalVendeur("germain"));
		assertNull(control.trouverEtalVendeur("gaulois"));
		village.ajouterHabitant(vendeur);
		assertEquals(control.trouverEtalVendeur("gaulois").getVendeur(),vendeur);
		
	}

}

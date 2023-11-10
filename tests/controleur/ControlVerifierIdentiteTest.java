package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private ControlVerifierIdentite control;
	
	@BeforeEach
	protected void initVillage() {
		village = new Village("pueblo", 10, 10);
		Chef chef  = new Chef("chef", 2, village);
		village.setChef(chef);
		control = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(control);
	}

	@Test
	void testVerifierIdentite() {
		assertFalse(control.verifierIdentite("Asterix"));
		Gaulois gaulois = new Gaulois("Asterix", 2);
		village.ajouterHabitant(gaulois);
		assertTrue(control.verifierIdentite("Asterix"));
	}

}

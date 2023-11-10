package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village ;
	private ControlVerifierIdentite controlIdentite ;
	private ControlPrendreEtal control;
	private Gaulois gaulois;
	
	@BeforeEach
	protected void initTest() {
		village = new Village ("le village", 10, 1);
		Chef chef = new Chef("chef", 2, village);
		village.setChef(chef);
		gaulois = new Gaulois("Asterix", 2);
		controlIdentite = new ControlVerifierIdentite(village);
		control = new ControlPrendreEtal(controlIdentite, village);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(control);
	}

	@Test
	void testResteEtals() {
		assertTrue(control.resteEtals());
		village.ajouterHabitant(gaulois);
		control.prendreEtal("Asterix", "fleur", 10);
		assertFalse(control.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		assertTrue(control.resteEtals());
		village.ajouterHabitant(gaulois);
		control.prendreEtal("Asterix", "fleur", 10);
		assertFalse(control.resteEtals());
	}

	@Test
	void testVerifierIdentite() {
		assertFalse(control.verifierIdentite("Asterix"));
		village.ajouterHabitant(gaulois);
		assertTrue(control.verifierIdentite("Asterix"));
	}

}

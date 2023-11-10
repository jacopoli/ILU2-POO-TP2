package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private ControlAfficherVillage control;
	private Village village;
	
	@BeforeEach
	void initTest() {
		village = new Village("village", 10, 10);
		Chef chef = new Chef ("chef", 1, village);
		village.setChef(chef);
		control= new ControlAfficherVillage(village);
		village.ajouterHabitant(new Gaulois("Asterix", 1));
	}
	

	@Test
	void testControlAfficherVillage() {
		assertNotNull(control);
	}

	@Test
	void testDonnerNomsVillageois() {
		
		assertEquals(control.donnerNomsVillageois()[0], "chef");
		assertEquals(control.donnerNomsVillageois()[1], "Asterix");
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(control.donnerNomVillage(),"village");
	}

	@Test
	void testDonnerNbEtals() {
		assertTrue(control.donnerNbEtals()==10);
	}

}

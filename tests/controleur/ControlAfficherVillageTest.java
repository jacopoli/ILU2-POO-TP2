package controleur;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
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
		village.ajouterHabitant(new Druide("Mario",4,4,4));
	}
	

	@Test
	void testControlAfficherVillage() {
		assertNotNull(control);
	}

	@Test
	void testDonnerNomsVillageois() {
		String[] villageois = {"chef", "Asterix", "le druide Mario"};
		assertArrayEquals(control.donnerNomsVillageois(), villageois);
		assertEquals(control.donnerNomsVillageois()[1], "Asterix");
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(control.donnerNomVillage(),"village");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(control.donnerNbEtals(),10);
	}

}

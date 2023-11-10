package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private ControlAfficherMarche control;
	
	@BeforeEach
	void initTest() {
		village = new Village("village", 10, 10);
		Chef chef = new Chef ("chef", 1, village);
		village.setChef(chef);
		control = new ControlAfficherMarche(village);
		village.installerVendeur(chef, "fleur", 3);
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(control);
	}

	@Test
	void testDonnerInfosmarche() {
		String[] infos = {"chef", "3", "fleur"};
		assertArrayEquals(control.donnerInfosmarche(), infos);
	}

}

package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private ControlEmmenager control;
	
	@BeforeEach
	private void initTest() {
		village = new Village("le village", 10, 10);
		Chef chef = new Chef ("chef", 1, village);
		village.setChef(chef);
		control = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(control);
	}

	@Test
	void testIsHabitant() {
		assertFalse(control.isHabitant("Asterix"));
		control.ajouterGaulois("Asterix", 3);
		assertTrue(control.isHabitant("Asterix"));
	}

	@Test
	void testAjouterDruide() {
		assertFalse(control.isHabitant("le druide"));
		control.ajouterDruide("le druide", 4, 4, 4);
		assertTrue(control.isHabitant("le druide"));
	}

	@Test
	void testAjouterGaulois() {
		assertFalse(control.isHabitant("Asterix"));
		control.ajouterGaulois("Asterix", 3);
		assertTrue(control.isHabitant("Asterix"));
	}

}

package controleur;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private ControlAcheterProduit control;
	
	@BeforeEach
	void initTest(){
		village= new Village("village", 10, 10);
		Chef chef = new Chef ("chef", 1, village);
		village.setChef(chef);
		village.installerVendeur(chef, "rose", 10);
		ControlVerifierIdentite controlVerif = new ControlVerifierIdentite(village);
		ControlTrouverEtalVendeur controlTrouverEtal = new ControlTrouverEtalVendeur(village);
		control = new ControlAcheterProduit(controlVerif, controlTrouverEtal, village);
	}

	@Test
	void testControlAcheterProduit() {
		assertNotNull(control);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(control.verifierIdentite("chef"));
		assertFalse(control.verifierIdentite("Obelix"));
	}

	@Test
	void testTrouverProduit() {
		String[] vendeursRose = {"chef"};
		assertArrayEquals(control.trouverProduit("rose"), vendeursRose);
		assertNull(control.trouverProduit("tulipe"));
	}

	@Test
	void testStockEtal() {
		assertEquals(control.stockEtal("chef"),10);
	}

	@Test
	void testAcheterProduit() {
		control.acheterProduit("chef", 1);
		assertEquals(control.stockEtal("chef"),9);
		control.acheterProduit("chef", 0);
		assertEquals(control.stockEtal("chef"),9);
		control.acheterProduit("chef", 12);
		assertEquals(control.stockEtal("chef"), 0);
		control.acheterProduit("chef", 1);
		assertEquals(control.stockEtal("chef"), 0);
		
	}

}

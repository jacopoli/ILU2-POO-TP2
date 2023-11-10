package controleur;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village ;
	private ControlTrouverEtalVendeur controlTrouverEtal;
	private ControlLibererEtal control;
	private Gaulois gaulois;
	
	@BeforeEach
	void initTest() {
		village = new Village ("le village", 10, 1);
		Chef chef = new Chef("chef", 2, village);
		village.setChef(chef);
		gaulois = new Gaulois("Asterix", 1);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleur", 2);
		controlTrouverEtal = new ControlTrouverEtalVendeur(village);
		control = new ControlLibererEtal(controlTrouverEtal);
	}

	@Test
	void testControlLibererEtal() {
		assertNotNull(control);
	}

	@Test
	void testIsVendeur() {
		assertFalse(control.isVendeur("Obelix"));
		assertTrue(control.isVendeur("Asterix"));
	}

	@Test
	void testLibererEtal() {
		assertNull(control.libererEtal("Obelix"));
		assertNotNull(control.libererEtal("Asterix"));
		
		
//		//liberer etal inexistant
//		assertFalse(control.isVendeur("Obelix"));
//		assertNull(control.libererEtal("Obelix"));
	}
	
	

}

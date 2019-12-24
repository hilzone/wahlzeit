package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GamepadTypeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	private GamepadType gt= new GamepadType("Homemade", "PotatoController");
	@Test
	public void testGamepadType() {
		assertNotNull(new GamepadType("Homemade", "PotatoController"));
	}

	@Test
	public void testGetManufacturer() {
		assertEquals("Homemade",gt.getManufacturer());
		gt.setManufacturer("Me");
		assertEquals("Me",gt.getManufacturer());
	}
	@Test
	public void testSetManufacturer() {
		assertEquals("Homemade",gt.getManufacturer());
		gt.setManufacturer("Me");
		assertEquals("Me",gt.getManufacturer());
	}



	@Test
	public void testGetTypeName() {
		assertEquals("PotatoController",gt.getTypeName());
	}

	@Test
	public void testGetSuperType() {
		gt.setSuperType(gt);
		assertEquals(gt,gt.getSuperType());
	}



}

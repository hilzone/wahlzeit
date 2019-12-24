package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GamepadTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	private GamepadType gt= new GamepadType("blaystation", "twinstick");
	private Gamepad gamepad = new Gamepad(gt, "green");
	@Test
	public void testGetcolorOfGamepad() {
		assertEquals("green", gamepad.getcolorOfGamepad());
	}



	@Test
	public void testSetColorOfGamepad() {
		gamepad.setColorOfGamepad("blue");
		assertEquals("blue", gamepad.getcolorOfGamepad());
	}


}

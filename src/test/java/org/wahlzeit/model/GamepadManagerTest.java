package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class GamepadManagerTest {
	

	private GamepadManager gamepadManagerInstance = new GamepadManager();
	private GamepadType gt = gamepadManagerInstance.createGamepadType("Nindendo","Twinstick");
	private GamepadType bt;
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());
	
	@BeforeClass
	public  static void setUpBeforeClass() throws Exception {
	//	gamepadManagerInstance = GamepadManager.getGamepadManagerInstance();
	}

	@Test
	public void testGetGamepadManagerInstance() {
		assertNotNull(gamepadManagerInstance);
	}

	@Test
	public void testCreateGamepad() {
		Gamepad gamepad = gamepadManagerInstance.createGamepad("Blue", "Twinstick");
		assertEquals(gamepad, GamepadManager.getGamepads().get(gamepad.getId()));
	}

	@Test
	public void testCreateGamepadTypeStringString() {
		bt = gamepadManagerInstance.createGamepadType("Nindendo","Twinstick");
		assertEquals(bt, gt);
		assertEquals("Nindendo",bt.getManufacturer());
	}

	@Test
	public void testCreateGamepadTypeStringStringString() {
		bt = gamepadManagerInstance.createGamepadType("Nindendo","Procontroller","Twinstick");
		assertEquals(bt.superType.getTypeName(),"Twinstick");
		assertTrue(gt.getSubTypes().contains(bt));
	}

}

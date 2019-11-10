package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;



public class GamepadPhotoManagerTest {


	@ClassRule
	public static RuleChain ruleChain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

//	@Test
//	public void testGamepadPhotoManager() {
//		fail("Not yet implemented");
//	}

	@Test
	public void initializeTest() {
		assertNotNull(new GamepadPhotoManager());
	}
	


}

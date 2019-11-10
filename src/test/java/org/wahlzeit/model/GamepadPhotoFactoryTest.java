package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class GamepadPhotoFactoryTest {
	  GamepadPhotoFactory instance =new GamepadPhotoFactory();
	@ClassRule
	public static RuleChain ruleChain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());
	@Before
	public  void setUp() throws Exception {
	//	instance = new GamepadPhotoFactory();
	//	GamepadPhotoFactory.initialize();
	}

	@Test public void createPhotoTest() {
		Photo Photo = instance.createPhoto();
		assertNotNull(Photo);
	}
	@Test public void createGamepadPhotoTest() {
		GamepadPhoto Photo = instance.createGamepadPhoto();
		assertNotNull(Photo);
	}
	
	@Test public void initializeTest(){
		GamepadPhotoFactory instance = new GamepadPhotoFactory();
		//should be already initialized 
		assertNotNull(instance);
	}
	


}

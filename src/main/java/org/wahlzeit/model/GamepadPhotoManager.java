package org.wahlzeit.model;

import java.util.logging.Logger;

@PatternInstance(
		patternName = "Singleton",
		participants = {"GamepadPhotoManager"}
	)

public class GamepadPhotoManager extends PhotoManager {

	
	protected static final GamepadPhotoManager instance= new GamepadPhotoManager(); //Called by ModelMain


	
	private static final Logger log = Logger.getLogger(GamepadPhotoManager.class.getName());
	
	/**
	 *
	 */
	GamepadPhotoManager() {
		//photoTagCollector = GamepadPhotoFactory.getInstance().createPhotoTagCollector();
		//super();
	}

	/**
	 *
	 */
	
	public static GamepadPhotoManager getGamepadPhotoManagerInstance() {
		return instance;
	}
//	public static void setInstance(GamepadPhotoManager gamepadPhotoManager) {
//		gamepadPhotoManager = gamepadPhotoManager;
//	}
	

}

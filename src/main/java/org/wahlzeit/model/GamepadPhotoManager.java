package org.wahlzeit.model;

import java.util.logging.Logger;



public class GamepadPhotoManager extends PhotoManager {

	
	protected static final GamepadPhotoManager instance= new GamepadPhotoManager();


	
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

package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

public class GamepadPhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(GamepadPhotoFactory.class.getName());
	
	public GamepadPhotoFactory() {
	//	super();
		// TODO Auto-generated constructor stub
	}

	protected static GamepadPhotoFactory instance;

	
	/**
	 * @methodtype factory
	 */
	@Override
	public GamepadPhoto createPhoto() {
		return new GamepadPhoto();
	}
	/**
	 * Public singleton access method.
	 */
	
	public static synchronized GamepadPhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
			setInstance(new PhotoFactory());
		}

		return instance;
	}
	
	/**
	 * Creates a new gamepadphoto with the specified id
	 */
	
	@Override
	public Photo createPhoto(PhotoId id) {
		return new Photo(id);
	}
	public GamepadPhoto createGamepadPhoto() {
		GamepadPhoto gamepadPhoto;
		gamepadPhoto = new GamepadPhoto();
		return gamepadPhoto;
	}
	
	public GamepadPhoto createGamepadPhoto(PhotoId id) {
		GamepadPhoto gamepadPhoto;
		gamepadPhoto = new GamepadPhoto(id);
		return gamepadPhoto;
	}
	/**
	 * Method to set the singleton instance of GamepadPhotoFactory.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}
	
	
	protected static synchronized void setInstance(GamepadPhotoFactory gamepadPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("already initialized");
		}

		instance = gamepadPhotoFactory;
	}
 
}

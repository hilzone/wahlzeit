package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.exceptions.PhotoCreationFailedException;
import org.wahlzeit.services.LogBuilder;

@PatternInstance(
		patternName = "Abstract Factory",
		participants = {"PhotoFactory, GamepadPhotoFactory"}
	)


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
	 * @throws PhotoCreationFailedException 
	 */
	
	@Override
	public Photo createPhoto(PhotoId id) throws PhotoCreationFailedException  {
		Photo photo;
		try {
		photo = new Photo(id);
		} catch (IllegalArgumentException e) {
			throw new PhotoCreationFailedException( e.getMessage());
		}
		return photo;
	}
	/**
	 * Creates a new gamepadphoto 
	 *  
	 */
	
	public GamepadPhoto createGamepadPhoto()   {
		GamepadPhoto gamepadPhoto;
		
		gamepadPhoto = new GamepadPhoto();
		
		
		return gamepadPhoto;
	}
	
	public GamepadPhoto createGamepadPhoto(PhotoId id)throws PhotoCreationFailedException {
		GamepadPhoto gamepadPhoto;
		try {
		gamepadPhoto = new GamepadPhoto(id);
		} catch (IllegalArgumentException e) {
			throw new PhotoCreationFailedException(e.getMessage());
		}
		return gamepadPhoto;
	}
	
	public GamepadPhoto createGamepadPhoto(Gamepad gamepad) {
		GamepadPhoto gamepadPhoto;
		gamepadPhoto = new GamepadPhoto(gamepad);
		return gamepadPhoto;
	}
	
	/**
	 * Method to set the singleton instance of GamepadPhotoFactory.
	 */
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}
	/**
	 * Sets the Instance
	 */
	
	protected static synchronized void setInstance(GamepadPhotoFactory gamepadPhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("already initialized");
		}

		instance = gamepadPhotoFactory;
	}
 
}

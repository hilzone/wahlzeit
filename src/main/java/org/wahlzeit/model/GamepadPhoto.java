package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;

public class GamepadPhoto extends Photo {

	/** Documentation on how a gamepadPhoto is instantiated.
	 * 
	 * The GamepadPhotoFactory and GamepadPhotoManager are initialized in the ModelMain class.
	 * doHandlePost of UploadPhotoFormHanlder uses the GamepadPhotoManager’s inherited createPhoto method.
	 * Here the Photo id is set and PhotoUtil#createPhoto is called.
	 * PhotoUtil#createPhoto in return calls the gamepadPhotoFactory#createGamepadPhoto to proceed with the actual creation and instantiation of a gamepadPhoto.
	 * Finally, the gamepadPhotoFactory uses the createGamepadPhoto() method, which in return uses the GamepadPhoto() constructor to instantiate a new GamepadPhoto.
	 */
	//private static final long serialVersionUID = 1L;
	private Gamepad gamepad;
	public GamepadPhoto(Gamepad gamepad) {
		super();
		this.gamepad=gamepad;
	}

	
	public GamepadPhoto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GamepadPhoto(PhotoId myId) throws IllegalArgumentException {
		super(myId);
		// TODO Auto-generated constructor stub
	}
}

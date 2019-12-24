package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;

public class GamepadPhoto extends Photo {

	/**
	 * 
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

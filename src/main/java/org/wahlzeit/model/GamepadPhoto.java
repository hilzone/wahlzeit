package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;

public class GamepadPhoto extends Photo {

	
	private String TypeOfGamepad = "";
	private String ColorOfGamepad = "";

	public String getColorOfGamepad() {
		return ColorOfGamepad;
	}

	public void setColorOfGamepad(String colorOfGamepad) {
		
		try {
			assertNotNull(colorOfGamepad);
			} catch(Throwable e) {
				throw new IllegalArgumentException("Null dectected, Color of Gamepad may not be null");
			}
		ColorOfGamepad = colorOfGamepad;
	}

	public String getTypeOfGamepad() {
		return TypeOfGamepad;
	}

	public void setTypeOfGamepad(String typeOfGamepad) {
		TypeOfGamepad = typeOfGamepad;
		try {
			assertNotNull(typeOfGamepad);
			} catch(Throwable e) {
				throw new IllegalArgumentException("Null dectected, Type of Gamepad may not be null");
			}
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

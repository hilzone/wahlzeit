package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;

public class Gamepad {
	protected GamepadType gamepadType = null;
	

	private String colorOfGamepad = "";

	private static int gamepadIDCounter = 0;
	private int gamepadID;



	public String getcolorOfGamepad() {
		return colorOfGamepad;
	}

	public Gamepad(GamepadType gamepadType, String colorOfGamepad) {
		super();
		this.gamepadType = gamepadType;
		this.colorOfGamepad = colorOfGamepad;
		this.gamepadID = gamepadIDCounter;
		gamepadIDCounter++;
		}
		
	

	public void setColorOfGamepad(String colorOfGamepad) {
		
		try {
			assertNotNull(colorOfGamepad);
			} catch(Throwable e) {
				throw new IllegalArgumentException("Null dectected, Color of Gamepad may not be null");
			}
		this.colorOfGamepad = colorOfGamepad;
	}


	


	public GamepadType getType() {
		// TODO Auto-generated method stub
		return this.gamepadType;
	}

	public String getId() {
		
		// TODO Auto-generated method stub
		return Integer.toString(gamepadID);
	}


	
	
}

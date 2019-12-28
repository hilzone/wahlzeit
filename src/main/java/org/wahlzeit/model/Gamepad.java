package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;



/*Documentation on how a gamepad domain instance is instantiated
 * 
 *The prerequisite for a Gamepad to be created is that GamepadType already exists, which can be checked in the gamepadTypes map of the GamepadManager.
 *In the GamepadManager the createGamepad(String colorOfGamepad, String TypeName) method is executed the method asserts that the TypeName defines a valid type of Gamepad.
 *Then the GamepadType passed a as an argument is retrieved and assigned to gamepadType-object. The object is used to call the method createInstance(String colorOfGamepad).
 * createInstance uses the Gamepad constructor, Gamepad(GamepadType gamepadType, String colorOfGamepad), which finally instantiates a new Gamepad-object.
 * The newly instantiated object is returned to the GamepadManager via the createInstance method.
 * Lastly, the newly instantiated Gamepad-object is added to the Gamepads map to keep track of it.
*/
public class Gamepad {
	protected GamepadType gamepadType = null;
	

	private String colorOfGamepad = "";

	private static int gamepadIDCounter = 0;
	private int gamepadID;



	public String getcolorOfGamepad() {
		return colorOfGamepad;
	}
	/**
	 *Constructs a Gamepad of specific Type and Color
	 */
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

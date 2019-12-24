package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

public class GamepadManager {
	private static final GamepadManager gamepadManagerInstance = new GamepadManager();
	
	private static final Map<String, Gamepad> gamepads = new HashMap<String, Gamepad>();
	private static final Map<String, GamepadType> gamepadTypes = new HashMap<String, GamepadType>();
	
	public static GamepadManager getGamepadManagerInstance() {
		return gamepadManagerInstance;
	}
	
	
	/* 
	 * Create a GamepadInstance 
	 * */
	
	public synchronized Gamepad  createGamepad(String colorOfGamepad, String typeName){ //Has to be synchronized so that two Gamepads do not get the Same Id
		assertIsValidGamepadTypeName(typeName);
		GamepadType gt = getGamepadType(typeName);
		Gamepad result = gt.createInstance(typeName);
		getGamepads().put(result.getId(), result);
		return result;
		}
	
	/* 
	 * Create a Type of Gamepad 
	 * */
	
	public synchronized GamepadType  createGamepadType(String manufacturer, String typeName){ //No Subtype
		assertIsValidGamepadTypeName(typeName);
		
		if(gamepadTypes.containsKey(typeName)) {
			return gamepadTypes.get(typeName);
		} else {
			GamepadType result = new GamepadType(manufacturer, typeName);
			gamepadTypes.put(typeName, result);
			return result;
			}
		}

	/* 
	 * Create a Subtype of Gamepad 
	 * */
	public synchronized GamepadType createGamepadType(String manufacturer, String typeName, String superType) throws IllegalArgumentException{ 
		assertIsValidGamepadTypeName(typeName);
		if(!gamepadTypes.containsKey(superType)){
			throw new IllegalArgumentException("Type does not exist yet");
		}
		if(gamepadTypes.containsKey(typeName)) {
			return gamepadTypes.get(typeName);
		} else {
			GamepadType result = new GamepadType(manufacturer, typeName);
			GamepadType superTypeOfCreatedPad =getGamepadType(superType);
			superTypeOfCreatedPad.addSubType(result);
			result.setSuperType(superTypeOfCreatedPad);
			
			gamepadTypes.put(typeName, result);
			return result;
			}
		}
		
	
	private GamepadType getGamepadType(String typeName) throws IllegalArgumentException{
		if(gamepadTypes.containsKey(typeName)){
			return gamepadTypes.get(typeName);
		}else { throw new IllegalArgumentException("Type does not exist yet");
			
		}
		
		
	}
	private void assertIsValidGamepadTypeName(String typeName) {
		if(typeName == null) {
			throw new NullPointerException("typeName can not be null");
		
		}
	}
	/* 
	 * Getter only used for testing purposes
	 * */
	
	public static Map<String, Gamepad> getGamepads() { 
		return gamepads;
	}
}

package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;

public class GamepadType extends DataObject {

	private String manufacturer;


	private String typeName;

	protected GamepadType superType = null;
	
	protected Set<GamepadType> subTypes = new HashSet<GamepadType>();
	
	
	public GamepadType(String manufacturer, String typeName) {
		super();
		this.manufacturer = manufacturer;
		this.typeName = typeName;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getTypeName() {
		return typeName;
	}
	
	public GamepadType getSuperType() {
		return superType;
	}

	//private Set<GamepadType> subtypeIterator = newHashSet<GamepadType>();
	
	
	public Set<GamepadType> getSubTypes() {
		return subTypes;
	}



	public void setSubTypes(Set<GamepadType> subTypes) {
		this.subTypes = subTypes;
	}

	public void setSuperType(GamepadType superType) {
		this.superType = superType;
	}

	public Iterator<GamepadType> getSubTypeIterator(){
		return subTypes.iterator();
	}
	
	public void addSubType(GamepadType gt) {
		assert(gt!=null) : "tried to set null sub-type";
		gt.setSuperType(this);
		subTypes.add(gt);
	}
	
	public boolean hasInstance(Gamepad gamepad) {
		assert(gamepad != null) : "asked about null object";
		
		if (gamepad.getType()== this) {
			return true;
		}
		for (GamepadType type : subTypes) {
			if(type.hasInstance(gamepad)) {
				return true;
			}
		}

		return false;
	}
	
	public Gamepad createInstance(String colorOfGamepad) {
		return new Gamepad(this, colorOfGamepad);
	}
	
}

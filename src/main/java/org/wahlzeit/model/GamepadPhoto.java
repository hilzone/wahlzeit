package org.wahlzeit.model;

public class GamepadPhoto extends Photo {

	
	private String TypeOfGamepad = "";
	private String ColorOfGamepad = "";

	public String getColorOfGamepad() {
		return ColorOfGamepad;
	}

	public void setColorOfGamepad(String colorOfGamepad) {
		ColorOfGamepad = colorOfGamepad;
	}

	public String getTypeOfGamepad() {
		return TypeOfGamepad;
	}

	public void setTypeOfGamepad(String typeOfGamepad) {
		TypeOfGamepad = typeOfGamepad;
	}

	public GamepadPhoto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GamepadPhoto(PhotoId myId) {
		super(myId);
		// TODO Auto-generated constructor stub
	}
}

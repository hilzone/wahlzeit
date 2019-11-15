package org.wahlzeit.model;

public class Location {
private DepractedCoordinate coordinate;

public Location(DepractedCoordinate coordinate) {
	super();
	this.coordinate = coordinate;
}

public DepractedCoordinate getCoordinate() {
	return coordinate;
}

public void setCoordinate(DepractedCoordinate coordinate) {
	this.coordinate = coordinate;
}

}

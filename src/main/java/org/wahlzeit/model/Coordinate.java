package org.wahlzeit.model;

public interface Coordinate {

public CartesianCoordinate asCartesianCoordinate();

public double getCartesianDistance(Coordinate Coord);

public SphericCoordinate asSphericCoordinate();

public double getCentralAngle(Coordinate Coord);

public boolean isEqual(Coordinate Coord);


}

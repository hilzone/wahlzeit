package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;

import org.wahlzeit.exceptions.PhotoCreationFailedException;

@PatternInstance(
		patternName = "Template Method",
		participants = {"AbstractCoordinate", "CartesianCoordinate", "SphericCoordinate"}
	)

public abstract class AbstractCoordinate implements Coordinate {

	/**
	 * Converts a any Coordinate to a Cartesian Coordinate 
	 */
	
	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();

	
	/**
	 * Returns the cartesian-distance between two coordinates
	 */
	@Override
	public   double getCartesianDistance(Coordinate coord) {
		assertNotNull(coord);
		double distance = this.asCartesianCoordinate().doGetDistance(coord);
		
		return distance;
	}
	protected abstract double doGetDistance(Coordinate coord);
	@Override
	
	/**
	 * Converts any type of coordinate to a spheric-coordinate
	 */
	
	
	public abstract SphericCoordinate asSphericCoordinate();
	
	/**
	 * gets the central angle between the coordinate that was called upon and the and an inputed coordinate 
	 */
	@Override
	public double getCentralAngle(Coordinate coord) {
		assertNotNull(coord);
		double centralAngle = this.asSphericCoordinate().doGetCentralAngle(coord);
		return centralAngle;
	}
	protected abstract double doGetCentralAngle(Coordinate coord);
	/**
	 * Tests for equality of two Coordinates 
	 */

	@Override
	public abstract boolean isEqual(Coordinate Coord);
	

}

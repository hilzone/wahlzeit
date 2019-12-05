package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;

public abstract class AbstractCoordinate implements Coordinate {

	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();

	@Override
	public   double getCartesianDistance(Coordinate coord) {
		assertNotNull(coord);
		double distance = this.asCartesianCoordinate().doGetDistance(coord);
		
		return distance;
	}
	protected abstract double doGetDistance(Coordinate coord);
	@Override
	public abstract SphericCoordinate asSphericCoordinate();

	@Override
	public double getCentralAngle(Coordinate coord) {
		assertNotNull(coord);
		double centralAngle = this.asSphericCoordinate().doGetCentralAngle(coord);
		return centralAngle;
	}
	protected abstract double doGetCentralAngle(Coordinate coord);
	

	@Override
	public abstract boolean isEqual(Coordinate Coord);
	

}

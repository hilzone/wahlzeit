package org.wahlzeit.model;

public abstract class abstractCoordinate implements Coordinate {

	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();

	@Override
	public   double getCartesianDistance(Coordinate coord) {
		return this.asCartesianCoordinate().doGetDistance(coord);
	}
	protected abstract double doGetDistance(Coordinate coord);
	@Override
	public abstract SphericCoordinate asSphericCoordinate();

	@Override
	public double getCentralAngle(Coordinate coord) {
		return this.asSphericCoordinate().doGetCentralAngle(coord);
	}
	protected abstract double doGetCentralAngle(Coordinate coord);
	

	@Override
	public abstract boolean isEqual(Coordinate Coord);
	

}

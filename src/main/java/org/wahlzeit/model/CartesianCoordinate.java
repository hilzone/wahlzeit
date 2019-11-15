package org.wahlzeit.model;

import java.util.Objects;

public class CartesianCoordinate implements Coordinate {

	private double x;
	private double y;
	private double z;
	


	public CartesianCoordinate(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}


	  @Override
	    public int hashCode() {
	        return Objects.hash(x, y, z);
	    }
	
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}
	@Override
	public double getCartesianDistance(Coordinate Coord) {
		 return doGetCartesianDistance(Coord.asCartesianCoordinate());
	}

	public double doGetCartesianDistance(CartesianCoordinate coord) {
		double result = Math.sqrt(
				Math.pow((coord.asCartesianCoordinate().x - this.x), 2)
				+ Math.pow((coord.asCartesianCoordinate().y - this.y), 2)
				+ Math.pow((coord.asCartesianCoordinate().z - this.z), 2)
			);
		return result;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		SphericCoordinate sphCoord = new SphericCoordinate(calcRadius(this.x, this.y, this.z), calcPhi(), calcTheta());
		return sphCoord;
	}

	@Override
	public double getCentralAngle(Coordinate Coord) {
		return this.asSphericCoordinate().getCentralAngle(Coord);
		
	}

	private double doGetCentralAngle(Coordinate coord) {
		return getCentralAngle(coord.asSphericCoordinate());
		
	}

	@Override
	public boolean isEqual(Coordinate comparedCoord) {
		
		double checkX = comparedCoord.asCartesianCoordinate().x - this.x;
		double checkY = comparedCoord.asCartesianCoordinate().y - this.y;
		double checkZ = comparedCoord.asCartesianCoordinate().z - this.z;
		return (checkDelta(checkX) && checkDelta(checkY) && checkDelta(checkZ)) ? true : false;

	}
	//since precision might be lost from spherical to cartesian conversion check delta
	private boolean checkDelta(double checkme) {  
		return (checkme <= 0.01 && checkme >= -0.01) ? true : false;
	}
	private double calcRadius(double x, double y, double z){
		double radius = Math.sqrt((x*x)+(y*y)+(z*z));
		return radius;
	}
	
	private double calcPhi() {
		double phi = Math.atan(this.y/this.x);
		return phi;
	}
	
	private double calcTheta() {
		double theta = Math.acos(this.z/Math.sqrt((x*x)+(y*y)+(z*z)));
		return theta;
	}

	
}

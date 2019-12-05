package org.wahlzeit.model;

import java.util.Objects;

import static org.junit.Assert.assertNotNull;
import static org.wahlzeit.model.AssertionMethods.assertDistanceDouble;

public class CartesianCoordinate extends AbstractCoordinate {

	private double x;
	private double y;
	private double z;
	


	public CartesianCoordinate(double x, double y, double z) {
		super();
		assertNotNull(x);
		assertNotNull(y);
		assertNotNull(z);
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		assertClassInvariants();
		return x;
	}

	public void setX(double x) { 
		this.x = x;
	}

	public double getY() {
		assertClassInvariants() ;
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		assertClassInvariants();
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
	

	public double doGetDistance(Coordinate coord) {
		assertClassInvariants(); 
		double result = Math.sqrt(
				Math.pow((coord.asCartesianCoordinate().x - this.x), 2)
				+ Math.pow((coord.asCartesianCoordinate().y - this.y), 2)
				+ Math.pow((coord.asCartesianCoordinate().z - this.z), 2)
			);
		assertClassInvariants();
		assertDistanceDouble(result);
		return result;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		SphericCoordinate sphCoord = new SphericCoordinate(calcRadius(this.x, this.y, this.z), calcPhi(), calcTheta());
		assertSphericCoord(sphCoord);
		return sphCoord;
	}

	@Override
	public double getCentralAngle(Coordinate Coord) {
		return this.asSphericCoordinate().getCentralAngle(Coord);
		
	}

	protected double doGetCentralAngle(Coordinate coord) {
		return 0; //placeHolder
		
	}

	@Override
	public boolean isEqual(Coordinate comparedCoord) {
		if(comparedCoord == this) {
			return true;
		}
		
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
	private void assertClassInvariants() {
		assertNotNull(this.x);
		assertNotNull(this.y);
		assertNotNull(this.z);
	}
	
	public void assertSphericCoord(Coordinate Coord) {
		assertNotNull(Coord);
		assert(Coord instanceof SphericCoordinate);
	}	

	
}

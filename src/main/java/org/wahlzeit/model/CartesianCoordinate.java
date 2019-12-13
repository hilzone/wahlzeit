package org.wahlzeit.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

import static org.junit.Assert.assertNotNull;
import static org.wahlzeit.model.AssertionMethods.assertDistanceDouble;

public class CartesianCoordinate extends AbstractCoordinate {

	private final double x;
	private final double y;
	private final double z;
	


	private CartesianCoordinate(double x, double y, double z) {
		
		assertNotNull(x);
		assertNotNull(y);
		assertNotNull(z);
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	private static HashMap<String, CartesianCoordinate> alreadyInitCartCoords = new HashMap<String, CartesianCoordinate>();
		
	
	

	public double getX() {
		assertClassInvariants();
		return x;
	}


	public double getY() {
		assertClassInvariants() ;
		return y;
	}


	public double getZ() {
		assertClassInvariants();
		return z;
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
		SphericCoordinate sphCoord = SphericCoordinate.getSphericCoordinatePointer(calcRadius(this.x, this.y, this.z), calcPhi(), calcTheta());
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
				//
				//
				// HELPER METHODS
				// 
				//
	
	public static CartesianCoordinate getCartesianCoordinatePointer(double x, double y, double z){
		String keyForCoordinate = keybuilder(x, y, z); //Turns x, y, z into a String key
		CartesianCoordinate coordToBeChecked = alreadyInitCartCoords.get(keyForCoordinate);
		if(coordToBeChecked== null) {
			synchronized (alreadyInitCartCoords) {
				if((alreadyInitCartCoords.get(keyForCoordinate))== null) {
					coordToBeChecked = new CartesianCoordinate(x, y, z);
					alreadyInitCartCoords.put(keyForCoordinate, coordToBeChecked);
				}
			}
		}
		return coordToBeChecked;		
	}
	public static String  keybuilder(double x, double y , double z) { //removes trailing zeroes and turns into string -> so that e.g. key "6.230" = "6.23" uses BigDecimal.stripTrailingZeros for that
		BigDecimal xValue = new BigDecimal(Double.toString(x)) ;
		BigDecimal yValue = new BigDecimal(Double.toString(y)) ;
		BigDecimal zValue = new BigDecimal(Double.toString(z)) ;
		String xString = xValue.stripTrailingZeros().toPlainString(); 
		String yString = yValue.stripTrailingZeros().toPlainString(); 
		String zString = zValue.stripTrailingZeros().toPlainString(); 
		String key ="x=" + xString + "y=" + yString + "z=" + zString;
		return key;
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
	
			//
			//
			// ASSERTION AND CLASSINVARIANTS
			//
			//
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

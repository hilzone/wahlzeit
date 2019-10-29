
package org.wahlzeit.model;
import java.util.Objects;

public class Coordinate {
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

	private double x;
	private double y;
	private double z;

	@Override
    public boolean equals(Object o) {
		if(o instanceof Coordinate) {
		return isEqual((Coordinate)o);}
		else{return false;}
	}
	
	   @Override
	    public int hashCode() {
	        return Objects.hash(x, y, z);
	    }
	
	
	public Coordinate(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getDistance(Coordinate comparedCoordinate) {
		double result = Math.sqrt(
							Math.pow((comparedCoordinate.x - this.x), 2)
							+ Math.pow((comparedCoordinate.y - this.y), 2)
							+ Math.pow((comparedCoordinate.z - this.z), 2)
						);
		return result;
	}

	public boolean isEqual(Coordinate comparedCoordinate) {
		double checkX = comparedCoordinate.x - this.x;
		double checkY = comparedCoordinate.y - this.y;
		double checkZ = comparedCoordinate.z - this.z;
		return ((checkX == 0) && (checkY == 0) && (checkZ == 0)) ? true : false;

	}
}

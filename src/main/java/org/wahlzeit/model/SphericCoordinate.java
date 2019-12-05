package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;
import static org.wahlzeit.model.AssertionMethods.*;

public class SphericCoordinate extends AbstractCoordinate  {
 private double longitude;    // arccos(z/r)  azimuth
 private double latitude;  // arctan(y/x)  inclination
 private double radius; //Root(square(x)+square(y)+square(z))
 

public SphericCoordinate(double longitude, double latitude, double radius) {
	
	this.longitude = longitude;
	this.latitude = latitude;
	this.radius = radius;
}
//private double deltaSigma; // central angle
@Override
public CartesianCoordinate asCartesianCoordinate() {
	double x = calcX(this.longitude, this.latitude, this.radius);
	double y =calcY(this.longitude, this.latitude, this.radius);
	double z = calcZ(this.longitude, this.latitude, this.radius);
	CartesianCoordinate coordCart = new CartesianCoordinate(x, y, z);
	assertCartesianCoord(coordCart);
	assertClassInvariants();
	
	return coordCart;
}

//private double DoGetCartesianDistance(Coordinate coord) {
	
//	return getCartesianDistance(coord.asCartesianCoordinate());
//}

public double getLongitude() {
	assertClassInvariants();
	return longitude;
}

public void setLongitude(double longitude) {
	this.longitude = longitude;
}
public double getLatitude() {
	assertClassInvariants();
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}
public double getRadius() {
	assertClassInvariants();
	return radius;
}
public void setRadius(double radius) {
	this.radius = radius;
}
@Override
public SphericCoordinate asSphericCoordinate() {
	return this;
}
@Override
protected double doGetCentralAngle(Coordinate coord) {
	assertClassInvariants();
	
	SphericCoordinate sphCoord =coord.asSphericCoordinate();
	assertNotNull (sphCoord.radius);
	assertLongitude(sphCoord.longitude);
	assertLatitude(sphCoord.latitude);
	double lati= 1.5708 - this.latitude; // latitude = 1.5708 - theta
	double longi = this.longitude;
	double lati2 = 1.5708 - sphCoord.latitude;
	double longi2 = sphCoord.longitude;
	double centralAngle;
	centralAngle = //Vincenty Formula
			Math.atan(
				Math.sqrt(
						Math.pow(
								Math.cos(lati2)*Math.sin(Math.abs(longi2-longi)), 2
						)
								+
						(Math.pow(
								Math.cos(lati)*Math.sin(lati2)
								-Math.sin(lati)*Math.cos(lati2)*Math.cos(Math.abs(longi2-longi)), 2
						)
								)
						
				)/
				(Math.sin(lati)*Math.sin(lati2)+Math.cos(lati)*Math.cos(lati2)*Math.cos(Math.abs(longi2-longi)))
			);
	assertClassInvariants();
	return centralAngle;
}
// use isEqual implementation of CartesianCoordinate
@Override
public boolean isEqual(Coordinate Coord) {
	assertClassInvariants();
	return this.asCartesianCoordinate().isEqual(Coord.asCartesianCoordinate());
}

private double calcX(double longitude, double latitude , double radius) {
	double x = radius*(Math.sin(latitude))*(Math.cos(longitude));
	return x;
}

private double calcY(double longitude, double latitude , double radius) {
	double y = radius*(Math.sin(latitude))*(Math.sin(longitude));
	return y;
}

private double calcZ(double longitude, double latitude , double radius) {
	double z = radius*(Math.cos(latitude));
	return z;
}
@Override
protected double doGetDistance(Coordinate coord) {
	// TODO Auto-generated method stub
	return 0;
}

private void assertClassInvariants() {
	assertNotNull (this.radius);
	assertLongitude(this.longitude);
	assertLatitude(this.latitude);
}
public void assertCartesianCoord(Coordinate Coord) {
	assertNotNull(Coord);
	assert(Coord instanceof CartesianCoordinate);
}	
}

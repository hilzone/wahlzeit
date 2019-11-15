package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate  {
 private double phi;    // arccos(z/r)  azimuth
 private double theta;  // arctan(y/x)  inclination
 private double radius; //Root(square(x)+square(y)+square(z))
 

public SphericCoordinate(double phi, double theta, double radius) {
	
	this.phi = phi;
	this.theta = theta;
	this.radius = radius;
}
//private double deltaSigma; // central angle
@Override
public CartesianCoordinate asCartesianCoordinate() {
	double x = calcX(this.phi, this.theta, this.radius);
	double y =calcY(this.phi, this.theta, this.radius);
	double z = calcZ(this.phi, this.theta, this.radius);
	CartesianCoordinate coordCart = new CartesianCoordinate(x, y, z);
	return coordCart;
}
@Override
public double getCartesianDistance(Coordinate coord) {
	return this.asCartesianCoordinate().getCartesianDistance(coord);
}
//private double DoGetCartesianDistance(Coordinate coord) {
	
//	return getCartesianDistance(coord.asCartesianCoordinate());
//}

@Override
public SphericCoordinate asSphericCoordinate() {
	return this;
}
@Override
public double getCentralAngle(Coordinate coord) {
	return doGetCentralAngle(coord.asSphericCoordinate());
	 
}
private double doGetCentralAngle(SphericCoordinate sphCoord) {
	double lati= 1.5708 - this.theta;
	double longi = this.phi;
	double lati2 = 1.5708 - sphCoord.theta;
	double longi2 = sphCoord.phi;
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
	return centralAngle;
}
// use isEqual implementation of CartesianCoordinate
@Override
public boolean isEqual(Coordinate Coord) {
	
	return this.asCartesianCoordinate().isEqual(Coord.asCartesianCoordinate());
}

private double calcX(double phi, double theta , double radius) {
	double x = radius*(Math.sin(theta))*(Math.cos(phi));
	return x;
}

private double calcY(double phi, double theta , double radius) {
	double y = radius*(Math.sin(theta))*(Math.sin(phi));
	return y;
}

private double calcZ(double phi, double theta , double radius) {
	double z = radius*(Math.cos(theta));
	return z;
}

 
}

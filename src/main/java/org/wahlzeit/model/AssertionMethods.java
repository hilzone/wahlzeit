package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;

import org.wahlzeit.exceptions.IllegalDistanceException;

public class AssertionMethods {

	public static final double latitudeMax = Math.PI;
	public static final double latitudeMin = -Math.PI;;
	public static final double longitudeMax = Math.PI*2;
	public static final double longitudeMin = -Math.PI*2;

	public static void assertDistanceDouble(double distance) {
		if (distance < 0) {
			throw new IllegalDistanceException(distance);
		}
	}
	
	public static void assertLongitude(double longi) {
		try {
		assertNotNull(longi);
		} catch(Throwable e) {
			throw new IllegalArgumentException("Null dectected, Longitude may not be null");
		}
		if (longi > longitudeMax || longi < longitudeMin) {
			throw new IllegalArgumentException("IllegalArgument, Longitude must be between 2PI and -2PI");
		}
	}
	
	public static void assertLatitude(double lati) {
		try {
			assertNotNull(lati);
			} catch(Throwable e) {
				throw new IllegalArgumentException("Null dectected, Latitude may not be null");
			}
		if (lati > latitudeMax || lati < latitudeMin) {
			throw new IllegalArgumentException("IllegalArgument, Latitude must be between PI and -PI");
		}
	}

}

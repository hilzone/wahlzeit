package org.wahlzeit.model;

import static org.junit.Assert.assertNotNull;

public class AssertionMethods {

	public static final double latitudeMax = 1.5708;
	public static final double latitudeMin = -1.5708;
	public static final double longitudeMax = 3.14159;
	public static final double longitudeMin = -3.14159;

	public static void assertDistanceDouble(double distance) {
		assert distance >= 0;
	}
	
	public static void assertLongitude(double longi) {
		assertNotNull(longi);
		assert (longi <= longitudeMax);
		assert (longi >= longitudeMin);
	}
	
	public static void assertLatitude(double lati) {
		assertNotNull(lati);
		assert (lati <= latitudeMax);
		assert (lati >= latitudeMin);
	}

}

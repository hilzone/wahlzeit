package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class LocationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

//	@Test
//	public void testLocation() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetCoordinate() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetCoordinate() {
		Coordinate cord = CartesianCoordinate.getCartesianCoordinatePointer(1, 1, 1);
		Location loc1= new Location(cord);
		assertTrue(loc1.getCoordinate().isEqual(cord));
	}

}

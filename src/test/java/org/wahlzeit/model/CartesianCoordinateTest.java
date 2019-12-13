package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CartesianCoordinateTest {

//	@Before
//	public static void setUp() throws Exception {
		
//	}

	@Test
	public void testAsCartesianCoordinate() {
		Coordinate cordSph = SphericCoordinate.getSphericCoordinatePointer(0.79, 0.96 , 1.7320); // radians
		//assertTrue(cordSph.asCartesianCoordinate().getClass() == CartesianCoordinate.class);
		assertTrue(cordSph.asCartesianCoordinate() instanceof CartesianCoordinate);
	}
	@Test
	public void testGetCartesianDistance() {
		Coordinate cordSph = SphericCoordinate.getSphericCoordinatePointer(0.79, 0.96 , 1.7320);
		Coordinate cordSph2 = SphericCoordinate.getSphericCoordinatePointer(1.57, 0.78 , 1.4142);
		Coordinate cordCart2 = CartesianCoordinate.getCartesianCoordinatePointer(1, 1, 0);
		Coordinate cordCart = CartesianCoordinate.getCartesianCoordinatePointer(1, 1, 1);
		assertEquals(cordCart2.getCartesianDistance(cordSph), 1 , 0.01);
		assertEquals(cordCart2.getCartesianDistance(cordCart), 1 , 0.01);
		assertEquals(cordSph.getCartesianDistance(cordSph2), 1 , 0.01);
	}
	
	@Test
	public void testAsSphericCoordinate() {
		Coordinate coordCart = CartesianCoordinate.getCartesianCoordinatePointer(1, 1, 0);
		
		assertTrue(coordCart.asSphericCoordinate() instanceof SphericCoordinate);
	}
	@Test
	public void testisEqual() {
		Coordinate cordCart2 = CartesianCoordinate.getCartesianCoordinatePointer(1, 1, 0);
		cordCart2.isEqual(cordCart2.asSphericCoordinate());
		cordCart2.asSphericCoordinate().isEqual(cordCart2.asSphericCoordinate());
	}
	@Test
	public void testGetCentralAngle() {
		Coordinate cordCart2 = CartesianCoordinate.getCartesianCoordinatePointer(1, 1, 0);
		Coordinate cordSph = SphericCoordinate.getSphericCoordinatePointer(0.79, 0.96 , 1.7320);
		double centralAngle= cordCart2.getCentralAngle(cordSph);
		assertEquals(cordCart2.getCentralAngle(cordSph),centralAngle, 0.002);
	}

}

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
	
	@Test
	public void testGetX(){
		Coordinate cordCart1 = CartesianCoordinate.getCartesianCoordinatePointer(1, 2, 3);
		double xValue = cordCart1.asCartesianCoordinate().getX();
		assertEquals(xValue, 1.0, 0.01);
		
	}
	
	@Test
	public void testGetY(){
		Coordinate cordCart1 = CartesianCoordinate.getCartesianCoordinatePointer(1, 2, 3);
		double yValue = cordCart1.asCartesianCoordinate().getY();
		assertEquals(yValue, 2.0, 0.01);
		
	}
	
	@Test
	public void testGetZ(){
		Coordinate cordCart1 = CartesianCoordinate.getCartesianCoordinatePointer(1, 2, 3);
		double zValue = cordCart1.asCartesianCoordinate().getZ();
		assertEquals(zValue, 3.0, 0.01);
		
	}
	@Test
	public void testGetCartesianCoordinatePointer(){
		Coordinate cordCart1 = CartesianCoordinate.getCartesianCoordinatePointer(1, 2, 3);
		Coordinate cordCart2 = CartesianCoordinate.getCartesianCoordinatePointer(1, 2, 3);
		assertEquals(cordCart1, cordCart2);
	}


}

package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {

	
	@Test
	public void testGetDistance() {
		Coordinate cord1 = new Coordinate(2,2,3);
		Coordinate cord2 = new Coordinate(2, 2, 2);
		double output = cord1.getDistance(cord2);
		assertEquals(1.0,output, 0.0001);
	}
	
}

package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

@PatternInstance(
		patternName = "Value Object",
		participants = {"CartesianCoordinate"}
	)

public class SphericCoordinateTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testIsEqual() {
		SphericCoordinate Coord1 = SphericCoordinate.getSphericCoordinatePointer(0.7, 0.9 ,7);
		SphericCoordinate Coord2 = SphericCoordinate.getSphericCoordinatePointer(0.7, 0.9 ,7);
		assertTrue(Coord1.isEqual(Coord2));
		assertTrue(Coord1.asCartesianCoordinate().isEqual(Coord2));
	}

}

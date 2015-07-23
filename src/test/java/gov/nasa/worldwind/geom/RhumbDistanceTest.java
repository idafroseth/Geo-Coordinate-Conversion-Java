/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.nasa.worldwind.geom;

import gov.nasa.worldwind.geom.LatLon;
import junit.framework.TestCase;

/**
 *
 * @author alex
 */
public class RhumbDistanceTest extends TestCase {

	private static final double THRESHOLD = 1e-10;

	//////////////////////////////////////////////////////////
	// Test equivalent points. Distance should always be 0.
	//////////////////////////////////////////////////////////
	@org.junit.Test
	public void testTrivialEquivalentPointsA() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		LatLon end = LatLon.fromDegrees(0.0, 0.0);
		double distance = LatLon.rhumbDistance(begin, end).degrees;
		assertEquals("Trivial equivalent points A", 0.0, distance, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialEquivalentPointsB() {
		LatLon begin = LatLon.fromDegrees(0.0, -180.0);
		LatLon end = LatLon.fromDegrees(0.0, 180.0);
		double distance = LatLon.rhumbDistance(begin, end).degrees;
		assertEquals("Trivial equivalent points B", 0.0, distance, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialEquivalentPointsC() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		LatLon end = LatLon.fromDegrees(0.0, 360.0);
		double distance = LatLon.rhumbDistance(begin, end).degrees;
		assertEquals("Trivial equivalent points C", 0.0, distance, THRESHOLD);
	}

	@org.junit.Test
	public void testEquivalentPoints() {
		LatLon begin = LatLon.fromDegrees(53.0902505, 112.8935442);
		LatLon end = LatLon.fromDegrees(53.0902505, 112.8935442);
		double distance = LatLon.rhumbDistance(begin, end).degrees;
		assertEquals("Equivalent points", 0.0, distance, THRESHOLD);
	}

	@org.junit.Test
	public void testKnownDistance() {
		LatLon begin = LatLon.fromDegrees(90.0, 45.0);
		LatLon end = LatLon.fromDegrees(36.0, 180.0);
		double distance = LatLon.rhumbDistance(begin, end).degrees;
		assertEquals("Known spherical distance", 54.11143196539475, distance, 1e-5); // Custom threshold
	}

	@org.junit.Test
	public void testKnownDistanceCloseToZero() {
		LatLon begin = LatLon.fromDegrees(-12.0, 87.0);
		LatLon end = LatLon.fromDegrees(-12.0000001, 86.9999999);
		double distance = LatLon.rhumbDistance(begin, end).degrees;
		assertEquals("Known spherical distance (close to zero)", 1.398846933590201e-7, distance, THRESHOLD);
	}

	@org.junit.Test
	public void testKnownDistanceCloseTo180() {
		LatLon begin = LatLon.fromDegrees(-12.0, 87.0);
		LatLon end = LatLon.fromDegrees(11.9999999, -93.0000001);
		double distance = LatLon.rhumbDistance(begin, end).degrees;
		assertEquals("Known spherical distance (close to 180)", 180.28382072652187, distance, THRESHOLD);
	}

	@org.junit.Test
	public void testProblemPointsA() {
		LatLon begin = LatLon.fromDegrees(36.0, -118.0);
		LatLon end = LatLon.fromDegrees(36.0, -117.0);
		double distance = LatLon.rhumbDistance(begin, end).degrees;
		assertEquals("Problem points A", 0.8090169943749475, distance, THRESHOLD);
	}

}

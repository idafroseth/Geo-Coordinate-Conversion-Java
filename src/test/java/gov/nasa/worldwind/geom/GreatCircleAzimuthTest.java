/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.nasa.worldwind.geom;

import gov.nasa.worldwind.geom.LatLon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class GreatCircleAzimuthTest {

	private static final double THRESHOLD = 1e-5;

	//////////////////////////////////////////////////////////
	// Test trivial Azimuth angles.
	//////////////////////////////////////////////////////////
	@org.junit.Test
	public void testTrivialNorth() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		LatLon end = LatLon.fromDegrees(90, 0.0);
		double azimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
		assertEquals("Trivial North greatCircleAzimuth", 0.0, azimuth, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialEast() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		LatLon end = LatLon.fromDegrees(0.0, 90.0);
		double azimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
		assertEquals("Trivial East greatCircleAzimuth", 90.0, azimuth, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialSouth() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		LatLon end = LatLon.fromDegrees(-90.0, 0.0);
		double azimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
		assertEquals("Trivial South greatCircleAzimuth", 180.0, azimuth, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialWest() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		LatLon end = LatLon.fromDegrees(0.0, -90.0);
		double azimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
		assertEquals("Trivial West greatCircleAzimuth", -90.0, azimuth, THRESHOLD);
	}

	//////////////////////////////////////////////////////////
	// Test Azimuth angles between equivalent points.
	// Azimuth should always be 0 or 360.
	//////////////////////////////////////////////////////////
	@org.junit.Test
	public void testTrivialEquivalentPointsA() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		LatLon end = LatLon.fromDegrees(0.0, 0.0);
		double azimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
		assertEquals("Trivial equivalent points A", 0.0, azimuth, THRESHOLD);
	}

	//@Test
	//public void testTrivialEquivalentPointsB()
	//{
	//    LatLon begin = LatLon.fromDegrees(0.0, -180.0);
	//    LatLon end   = LatLon.fromDegrees(0.0, 180.0);
	//    double greatCircleAzimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
	//    assertEquals("Trivial equivalent points B", 0.0, greatCircleAzimuth, THRESHOLD);
	//}
	@org.junit.Test
	public void testTrivialEquivalentPointsC() {
		LatLon begin = LatLon.fromDegrees(90.0, 0.0);
		LatLon end = LatLon.fromDegrees(90.0, 0.0);
		double azimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
		assertEquals("Trivial equivalent points C", 0.0, azimuth, THRESHOLD);
	}

	//@Test
	//public void testTrivialEquivalentPointsD()
	//{
	//    LatLon begin = LatLon.fromDegrees(90.0, 0.0);
	//    LatLon end   = LatLon.fromDegrees(90.0, 45.0);
	//    double greatCircleAzimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
	//    assertEquals("Trivial equivalent points D", 0.0, greatCircleAzimuth, THRESHOLD);
	//}
	@org.junit.Test
	public void testEquivalentPoints() {
		LatLon begin = LatLon.fromDegrees(53.0902505, 112.8935442);
		LatLon end = LatLon.fromDegrees(53.0902505, 112.8935442);
		double azimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
		assertEquals("Equivalent points", 0.0, azimuth, THRESHOLD);
	}

	//////////////////////////////////////////////////////////
	// Test points known to have a certain Azimuth.
	//////////////////////////////////////////////////////////
	@org.junit.Test
	public void testKnownAzimuthA() {
		LatLon begin = LatLon.fromDegrees(-90.0, -180.0);
		LatLon end = LatLon.fromDegrees(90.0, 180.0);
		double azimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
		assertEquals("Known Azimuth A", 0.0, azimuth, THRESHOLD);
	}

	@org.junit.Test
	public void testKnownAzimuthB() {
		LatLon begin = LatLon.fromDegrees(53.0902505, 112.8935442);
		LatLon end = LatLon.fromDegrees(-53.0902505, -67.1064558);
		double azimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
		assertEquals("Known Azimuth B", -90.0, azimuth, THRESHOLD);
	}

	@org.junit.Test
	public void testKnownAzimuthC() {
		LatLon begin = LatLon.fromDegrees(-12.0, 87.0);
		LatLon end = LatLon.fromDegrees(-12.0000001, 86.9999999);
		double azimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
		assertEquals("Known Azimuth C", -135.6329170237546, azimuth, THRESHOLD);
	}

	@org.junit.Test
	public void testKnownAzimuthD() {
		LatLon begin = LatLon.fromDegrees(-12.0, 87.0);
		LatLon end = LatLon.fromDegrees(11.9999999, -93.0000001);
		double azimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
		assertEquals("Known Azimuth D", 135.6329170162944, azimuth, THRESHOLD);
	}

	@org.junit.Test
	public void testKnownAzimuthE() {
		LatLon begin = LatLon.fromDegrees(-12.0, 87.0);
		LatLon end = LatLon.fromDegrees(53.0902505, -67.1064558);
		double azimuth = LatLon.greatCircleAzimuth(begin, end).degrees;
		assertEquals("Known Azimuth E", -21.38356223882703, azimuth, THRESHOLD);
	}

}

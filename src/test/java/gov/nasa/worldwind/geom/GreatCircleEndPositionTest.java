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
public class GreatCircleEndPositionTest {

	private static final double THRESHOLD = 1e-10;

	//////////////////////////////////////////////////////////
	// Test trivial Azimuths and distances.
	// End point should be equivalent to begin point.
	//////////////////////////////////////////////////////////
	@org.junit.Test
	public void testTrivialDistanceA() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		double azimuthRadians = Math.toRadians(0.0);
		double distanceRadians = Math.toRadians(0.0);
		LatLon end = LatLon.greatCircleEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Trivial distance A (lat)", 0.0, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Trivial distance A (lon)", 0.0, end.getLongitude().degrees, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialDistanceB() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		double azimuthRadians = Math.toRadians(0.0);
		double distanceRadians = Math.toRadians(360.0);
		LatLon end = LatLon.greatCircleEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Trivial distance B (lat)", 0.0, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Trivial distance B (lon)", 0.0, end.getLongitude().degrees, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialAzimuthA() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		double azimuthRadians = Math.toRadians(90.0);
		double distanceRadians = Math.toRadians(0.0);
		LatLon end = LatLon.greatCircleEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Trivial Azimuth A (lat)", 0.0, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Trivial Azimuth A (lon)", 0.0, end.getLongitude().degrees, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialAzimuthB() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		double azimuthRadians = Math.toRadians(90.0);
		double distanceRadians = Math.toRadians(360.0);
		LatLon end = LatLon.greatCircleEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Trivial Azimuth B (lat)", 0.0, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Trivial Azimuth B (lon)", 0.0, end.getLongitude().degrees, THRESHOLD);
	}

	//////////////////////////////////////////////////////////
	// Test antipodal points.
	// End point should be antipodal to begin point.
	//////////////////////////////////////////////////////////
	@org.junit.Test
	public void testTrivialAntipodalPointsA() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		double azimuthRadians = Math.toRadians(0.0);
		double distanceRadians = Math.toRadians(180.0);
		LatLon end = LatLon.greatCircleEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Trivial antipodal points A (lat)", 0.0, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Trivial antipodal points A (lon)", 180.0, end.getLongitude().degrees, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialAntipodalPointsB() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		double azimuthRadians = Math.toRadians(90.0);
		double distanceRadians = Math.toRadians(180.0);
		LatLon end = LatLon.greatCircleEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Trivial antipodal points B (lat)", 0.0, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Trivial antipodal points B (lon)", 180.0, end.getLongitude().degrees, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialAntipodalPointsC() {
		LatLon begin = LatLon.fromDegrees(-90.0, 0.0);
		double azimuthRadians = Math.toRadians(0.0);
		double distanceRadians = Math.toRadians(180.0);
		LatLon end = LatLon.greatCircleEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Trivial antipodal points C (lat)", 90.0, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Trivial antipodal points C (lon)", 0.0, end.getLongitude().degrees, THRESHOLD);
	}

	@org.junit.Test
	public void testAntipodalPointsA() {
		LatLon begin = LatLon.fromDegrees(53.0902505, 112.8935442);
		double azimuthRadians = Math.toRadians(-90.0);
		double distanceRadians = Math.toRadians(180.0);
		LatLon end = LatLon.greatCircleEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Antipodal points A (lat)", -53.0902505, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Antipodal points A (lon)", -67.1064558, end.getLongitude().degrees, THRESHOLD);
	}

	@org.junit.Test
	public void testAntipodalPointsB() {
		LatLon begin = LatLon.fromDegrees(-12.0, 87.0);
		double azimuthRadians = Math.toRadians(-90.0);
		double distanceRadians = Math.toRadians(180.0);
		LatLon end = LatLon.greatCircleEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Antipodal points B (lat)", 12.0, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Antipodal points B (lon)", -93.0, end.getLongitude().degrees, THRESHOLD);
	}

	//////////////////////////////////////////////////////////
	// Test known points.
	//////////////////////////////////////////////////////////
	@org.junit.Test
	public void testKnownPointsA() {
		LatLon begin = LatLon.fromDegrees(-53.0902505, -67.1064558);
		double azimuthRadians = Math.toRadians(15.2204311);
		double distanceRadians = Math.toRadians(-88.7560694);
		LatLon end = LatLon.greatCircleEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Known points A (lat)", -36.63477988750917, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Known points A (lon)", 131.98550742812412, end.getLongitude().degrees, THRESHOLD);
	}

	@org.junit.Test
	public void testKnownPointsB() {
		LatLon begin = LatLon.fromDegrees(53.0902505, 112.8935442);
		double azimuthRadians = Math.toRadians(-68.4055227);
		double distanceRadians = Math.toRadians(10.53630354);
		LatLon end = LatLon.greatCircleEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Known points B (lat)", 55.7426290038835, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Known points B (lon)", 95.313127193979270, end.getLongitude().degrees, THRESHOLD);
	}

}

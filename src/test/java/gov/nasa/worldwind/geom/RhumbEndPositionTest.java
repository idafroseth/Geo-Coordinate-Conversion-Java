/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.nasa.worldwind.geom;

import gov.nasa.worldwind.geom.LatLon;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author alex
 */
public class RhumbEndPositionTest {

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
		LatLon end = LatLon.rhumbEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Trivial distance A (lat)", 0.0, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Trivial distance A (lon)", 0.0, end.getLongitude().degrees, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialDistanceB() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		double azimuthRadians = Math.toRadians(0.0);
		double distanceRadians = Math.toRadians(360.0);
		LatLon end = LatLon.rhumbEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Trivial distance B (lat)", 0.0, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Trivial distance B (lon)", 0.0, end.getLongitude().degrees, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialAzimuthA() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		double azimuthRadians = Math.toRadians(90.0);
		double distanceRadians = Math.toRadians(0.0);
		LatLon end = LatLon.rhumbEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Trivial Azimuth A (lat)", 0.0, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Trivial Azimuth A (lon)", 0.0, end.getLongitude().degrees, THRESHOLD);
	}

	@org.junit.Test
	public void testTrivialAzimuthB() {
		LatLon begin = LatLon.fromDegrees(0.0, 0.0);
		double azimuthRadians = Math.toRadians(90.0);
		double distanceRadians = Math.toRadians(360.0);
		LatLon end = LatLon.rhumbEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Trivial Azimuth B (lat)", 2.204291436880279e-14, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Trivial Azimuth B (lon)", -96.67061650574995, end.getLongitude().degrees, 1e-1); // Custom threshold
	}

	//////////////////////////////////////////////////////////
	// Test known points.
	//////////////////////////////////////////////////////////
	@org.junit.Test
	public void testKnownPointsA() {
		LatLon begin = LatLon.fromDegrees(-53.0902505, -67.1064558);
		double azimuthRadians = Math.toRadians(15.2204311);
		double distanceRadians = Math.toRadians(88.7560694);
		LatLon end = LatLon.rhumbEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Known points A (lat)", 32.55251684755035, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Known points A (lon)", -40.62266365697857, end.getLongitude().degrees, THRESHOLD);
	}

	@org.junit.Test
	public void testKnownPointsB() {
		LatLon begin = LatLon.fromDegrees(53.0902505, 112.8935442);
		double azimuthRadians = Math.toRadians(-68.4055227);
		double distanceRadians = Math.toRadians(10.53630354);
		LatLon end = LatLon.rhumbEndPosition(begin, azimuthRadians, distanceRadians);
		assertEquals("Known points B (lat)", 56.9679782407693, end.getLatitude().degrees, THRESHOLD);
		assertEquals("Known points B (lon)", 95.78434282105843, end.getLongitude().degrees, THRESHOLD);
	}

}

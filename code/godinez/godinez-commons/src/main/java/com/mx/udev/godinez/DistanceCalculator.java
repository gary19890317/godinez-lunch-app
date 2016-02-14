package com.mx.udev.godinez;

/**
 * The Class DistanceCalculator.
 */
public final class DistanceCalculator {

	/** The distance calculator. */
	private static DistanceCalculator distanceCalculator;
	
	/**
	 * Instantiates a new distance calculator.
	 */
	private DistanceCalculator(){
		
	}
	
	
	/**
	 * Gets the single instance of DistanceCalculator.
	 *
	 * @return single instance of DistanceCalculator
	 */
	public static DistanceCalculator getInstance(){
		if(distanceCalculator == null){
			distanceCalculator = new DistanceCalculator();
		}
		return distanceCalculator;
	}
	
	
	/**
	 * Distance.
	 *
	 * @param lat1 the lat1
	 * @param lon1 the lon1
	 * @param lat2 the lat2
	 * @param lon2 the lon2
	 * @param unit the unit
	 * @return the double
	 */
	public double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == 'K') {
			dist = dist * 1.609344;
		} else if (unit == 'N') {
			dist = dist * 0.8684;
		}
		return (dist);
	}

	
	/**
	 * This function converts decimal degrees to radians.
	 * 
	 * @param deg the deg
	 * @return the double
	 */
	private double deg2rad(double deg) {
	  return (deg * Math.PI / 180.0);
	}

	
	
	/**
	 * This function converts radians to decimal degrees.
	 *
	 * @param rad the rad
	 * @return the double
	 */
	private double rad2deg(double rad) {
	  return (rad * 180.0 / Math.PI);
	}
	
}

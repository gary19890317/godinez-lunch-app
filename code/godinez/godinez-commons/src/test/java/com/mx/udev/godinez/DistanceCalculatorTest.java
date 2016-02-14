package com.mx.udev.godinez;

import org.junit.Test;

import junit.framework.Assert;

/**
 * The Class DistanceCalculatorTest.
 */
public class DistanceCalculatorTest{
	
	@Test
	public void getDistanceMiles(){
		double result = DistanceCalculator.getInstance().distance(19.404794, -99.1471684, 19.4359582, -99.1441562, 'M');
		Assert.assertEquals(2.162061815024795, result);
	}
	
	@Test
	public void getDistanceKilometers(){
		double result = DistanceCalculator.getInstance().distance(19.404794, -99.1471684, 19.4359582, -99.1441562, 'K');
		Assert.assertEquals(3.479501209639264, result);
	}
	
	@Test
	public void getDistanceNauticalMiles(){
		double result = DistanceCalculator.getInstance().distance(19.404794, -99.1471684, 19.4359582, -99.1441562, 'N');
		Assert.assertEquals(1.877534480167532, result);
	}
	
}

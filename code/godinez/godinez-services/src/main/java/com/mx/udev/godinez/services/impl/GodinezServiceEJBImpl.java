package com.mx.udev.godinez.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mx.udev.godinez.services.IFondaService;
import com.mx.udev.godinez.services.IGodinezService;
import com.mx.udev.godinez.vo.FondaVO;

/**
 * The Class GodinezServiceEJBImpl.
 */
@Stateless
public class GodinezServiceEJBImpl implements IGodinezService{

	/** The i fonda service. */
	@EJB
	private IFondaService iFondaService;
	
	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.services.IGodinezService#calculateDistance(double, double, double, double)
	 */
	public double calculateDistance(double latitud1, double longitud1, double latitud2, 
		double longitud2) {
		return iFondaService.calculateDistance(latitud1, longitud1, latitud2, longitud2);
	}

	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.services.IGodinezService#getNearbyPlaces(double, double, double)
	 */
	public List<FondaVO> getNearbyPlaces(double latitud, double longitud, double maxDistance) {
		return iFondaService.getNearbyPlaces(latitud, longitud, maxDistance);
	}

}

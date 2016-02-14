package com.mx.udev.godinez.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mx.udev.godinez.dao.IFondaDAO;
import com.mx.udev.godinez.services.IFondaService;
import com.mx.udev.godinez.vo.FondaVO;

/**
 * The Class FondaServiceEJBImpl.
 */
@Stateless
public class FondaServiceEJBImpl implements IFondaService{

	/** The i fonda service. */
	@EJB
	private IFondaDAO iFondaDAO;
	
	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.services.IFondaService#calculateDistance(double, double, double, double)
	 */
	public double calculateDistance(double latitud1, double longitud1,
		double latitud2, double longitud2) {
		return iFondaDAO.calculateDistance(latitud1, longitud1, latitud2, longitud2);
	}

	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.services.IFondaService#getNearbyPlaces(double, double, double)
	 */
	public List<FondaVO> getNearbyPlaces(double latitud, double longitud,
		double maxDistance) {
		return iFondaDAO.getNearbyPlaces(latitud, longitud, maxDistance);
	}

}

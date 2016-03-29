package com.mx.udev.godinez;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.mx.udev.godinez.services.IGodinezService;
import com.mx.udev.godinez.vo.CategoriaVO;
import com.mx.udev.godinez.vo.FondaVO;

/**
 * The Class GodinezServiceImpl.
 */
@Stateless(name = "godinezServiceEJB", mappedName = "ejb/GodinezServiceEJB", 
	description = "EJB para la administracion de la aplicaci\u00F3n")
@Remote({
	IGodinezServiceIntegrator.class
})
public class GodinezServiceImpl implements IGodinezServiceIntegrator{

	/** The i godinez service. */
	@EJB
	IGodinezService iGodinezService;
	
	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.IGodinezServiceIntegrator#calculateDistance(double, double, double, double)
	 */
	public double calculateDistance(double latitud1, double longitud1, double latitud2, 
		double longitud2) {
		return iGodinezService.calculateDistance(latitud1, longitud1, latitud2, longitud2);
	}

	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.IGodinezServiceIntegrator#getNearbyPlaces(double, double, double)
	 */
	public List<FondaVO> getNearbyPlaces(double latitud, double longitud,
			double maxDistance) {
		return iGodinezService.getNearbyPlaces(latitud, longitud, maxDistance);
	}

	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.IGodinezServiceIntegrator#getAllCategories()
	 */
	public List<CategoriaVO> getAllCategories() {
		return iGodinezService.getAllCategories();
	}

	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.IGodinezServiceIntegrator#getMyFavorites(long)
	 */
	public List<FondaVO> getMyFavorites(long userId) {
		return iGodinezService.getMyFavorites(userId);
	}
	
}

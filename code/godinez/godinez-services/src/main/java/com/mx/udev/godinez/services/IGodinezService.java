package com.mx.udev.godinez.services;

import java.util.List;

import javax.ejb.Local;

import com.mx.udev.godinez.vo.CategoriaVO;
import com.mx.udev.godinez.vo.FondaVO;

/**
 * The Interface IGodinezService.
 */
@Local
public interface IGodinezService {
	
	/**
	 * Calculate distance.
	 *
	 * @param latitud1 the latitud1
	 * @param longitud1 the longitud1
	 * @param latitud2 the latitud2
	 * @param longitud2 the longitud2
	 * @return the double
	 */
	double calculateDistance(double latitud1, double longitud1, double latitud2, 
		double longitud2);
	
	/**
	 * Gets the nearby places.
	 *
	 * @param latitud the latitud
	 * @param longitud the longitud
	 * @param maxDistance the max distance
	 * @return the nearby places
	 */
	List<FondaVO> getNearbyPlaces(double latitud, double longitud, double maxDistance);
	
	/**
	 * Gets the all categories.
	 *
	 * @return the all categories
	 */
	List<CategoriaVO> getAllCategories();
	
	/**
	 * Gets the nearby places.
	 *
	 * @param userId the user id
	 * @return the nearby places
	 */
	List<FondaVO> getMyFavorites(long userId);
	
}

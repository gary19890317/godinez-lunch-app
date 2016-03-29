package com.mx.udev.godinez.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.dozer.DozerBeanMapper;

import com.mx.udev.godinez.DistanceCalculator;
import com.mx.udev.godinez.dao.IFondaDAO;
import com.mx.udev.godinez.model.FondaDTO;
import com.mx.udev.godinez.model.UsuarioDTO;
import com.mx.udev.godinez.vo.FondaVO;

/**
 * The Class FondaDAOImpl.
 */
@Stateless
public class FondaDAOImpl extends GenericDAOImpl<FondaDTO> implements IFondaDAO{
	
	/** The mapper. */
	private DozerBeanMapper mapper = new DozerBeanMapper(Arrays.asList(new String[]{"META-INF/dozer-global-config.xml"}));
	
	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.dao.IFondaDAO#calculateDistance(double, double, double, double)
	 */
	public double calculateDistance(double latitud1, double longitud1, double latitud2, 
		double longitud2) {
		return DistanceCalculator.getInstance().distance(latitud1, longitud1, latitud2, longitud2, 'K');
	}

	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.dao.IFondaDAO#getNearbyPlaces(double, double, double)
	 */
	public List<FondaVO> getNearbyPlaces(double latitud, double longitud,
		double maxDistance) {
		List<FondaVO> restaurants = new ArrayList<FondaVO>();
		try{
			logger.info("Entity Manager -> " + getEntityManager());
			TypedQuery<FondaDTO> query = getEntityManager().createQuery("from FondaDTO f", FondaDTO.class);
			List<FondaDTO> restaurantsTmp = query.getResultList();
			if(logger.isDebugEnabled()){
				logger.debug("Restaurant size-> " + restaurants.size());
			}
			if(!restaurantsTmp.isEmpty()){
				for(FondaDTO rest : restaurantsTmp){
					double distance = DistanceCalculator.getInstance().distance(latitud, longitud, Double.parseDouble(rest.getLatitud()), 
						Double.parseDouble(rest.getLongitud()), 'K');
					if(distance <= maxDistance){
						logger.info("Restaurant [ " + rest.getNombre() + " ] se encuentra en el rango de los " + maxDistance + " KM.");
						restaurants.add(mapper.map(rest, FondaVO.class, "mapping_DTO_TO_VO"));
						
					}else{
						logger.info("Restaurant [ " + rest.getNombre() + " ] se encuentra fuera del rango de los " + maxDistance + " KM.");
					}
				}
			}else{
				logger.info("La consulta no arroj\u00F3 resulados");
			}
		} catch (NoResultException e) {
			logger.error(e);
		}
		return restaurants;
	}

	
	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.dao.IFondaDAO#getMyFavorites(long)
	 */
	public List<FondaVO> getMyFavorites(long userId){
		List<FondaVO> restaurants = new ArrayList<FondaVO>();
		try{
			logger.info("Entity Manager -> " + getEntityManager());
			UsuarioDTO usr = getEntityManager().find(UsuarioDTO.class, new Long(userId));
			if(usr != null){
				if(logger.isDebugEnabled()){
					logger.debug("User -> " + usr.getNombre());
				}
				for(FondaDTO rest : usr.getRestaurants()){
					restaurants.add(mapper.map(rest, FondaVO.class, "mapping_DTO_TO_VO"));
				}
			}else{
				logger.info("La consulta no arroj\u00F3 resulados");
			}
		} catch (NoResultException e) {
			logger.error(e);
		}
		return restaurants;
	}
}

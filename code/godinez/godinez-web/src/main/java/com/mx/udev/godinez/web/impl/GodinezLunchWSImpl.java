package com.mx.udev.godinez.web.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.mx.udev.godinez.IGodinezServiceIntegrator;
import com.mx.udev.godinez.vo.CategoriaVO;
import com.mx.udev.godinez.vo.FondaVO;
import com.mx.udev.godinez.web.GodinezLunchWS;
import com.mx.udev.godinez.web.types.CalculateDistanceRequest;
import com.mx.udev.godinez.web.types.CalculateDistanceRequest.FinalLocation;
import com.mx.udev.godinez.web.types.CalculateDistanceRequest.InitialLocation;
import com.mx.udev.godinez.web.types.CategorieType;
import com.mx.udev.godinez.web.types.GetAllCategoriesRequest;
import com.mx.udev.godinez.web.types.GetAllCategoriesResponse;
import com.mx.udev.godinez.web.types.GetMyFavoritesRequest;
import com.mx.udev.godinez.web.types.GetMyFavoritesResponse;
import com.mx.udev.godinez.web.types.RestaurantType.About;
import com.mx.udev.godinez.web.types.CalculateDistanceResponse;
import com.mx.udev.godinez.web.types.GetNearbyPlacesRequest;
import com.mx.udev.godinez.web.types.GetNearbyPlacesResponse;
import com.mx.udev.godinez.web.types.RestaurantType;
import com.mx.udev.godinez.web.types.RestaurantType.ServiceDetail;
import com.mx.udev.godinez.web.types.RestaurantType.ServiceDetail.Day;

/**
 * The Class GodinezLunchWSImpl.
 * 
 * @author ocastellanos
 * @version 1.0
 * @created October-6-2015 12:56:56 p.m.
 */
@WebService(endpointInterface = "com.mx.udev.godinez.web.GodinezLunchWS",
	targetNamespace = "http://www.xmlns.udev.com/GodinezLunch/GL/wsdl/1.0/GodinezLunchWS")
public class GodinezLunchWSImpl implements GodinezLunchWS{

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(GodinezLunchWSImpl.class);
	
	/** The i godinez service integrator. */
	@EJB
	IGodinezServiceIntegrator iGodinezServiceIntegrator;

	/**
	 * Instantiates a new godinez lunch ws impl.
	 */
	public GodinezLunchWSImpl(){
		logger.info("Constructor of GodinezLunchWSImpl");
	}
	
	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.web.GodinezLunchWS#calculateDistance(com.mx.udev.godinez.web.types.CalculateDistanceRequest)
	 */
	public CalculateDistanceResponse calculateDistance(
			CalculateDistanceRequest calculateDistanceRequest) {
		CalculateDistanceResponse calResponse = new CalculateDistanceResponse();
		
		//get request values
		InitialLocation initLocation = calculateDistanceRequest.getInitialLocation();
		FinalLocation finalLocation = calculateDistanceRequest.getFinalLocation();
		
		//calculating distance between two places
		calResponse.setDistance(iGodinezServiceIntegrator.calculateDistance(initLocation.getLatitude(), initLocation.getLongitude(), 
			finalLocation.getLatitude(), finalLocation.getLongitude()));
		
		//return the value
		return calResponse;
	}

	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.web.GodinezLunchWS#getNearbyPlaces(com.mx.udev.godinez.web.types.GetNearbyPlacesRequest)
	 */
	public GetNearbyPlacesResponse getNearbyPlaces(
			GetNearbyPlacesRequest getNearbyPlacesRequest) {
		GetNearbyPlacesResponse nearbyPlacesRs = new GetNearbyPlacesResponse();
		
		//getting nearby places
		List<FondaVO> restaurants = iGodinezServiceIntegrator.getNearbyPlaces(getNearbyPlacesRequest.getLatitude(), 
			getNearbyPlacesRequest.getLongitude(), getNearbyPlacesRequest.getMaxDistance());
		
		if(!restaurants.isEmpty()){
			for(FondaVO rest : restaurants){
				RestaurantType restaurant = new RestaurantType();
				restaurant.setKey(rest.getId());
				restaurant.setName(rest.getNombre());
				//set about data
				About about = new About();
				about.setLongitude(rest.getLatitud());
				about.setLatitude(rest.getLongitud());
				about.setEnabled(rest.getHabilitado().intValue() == 1 ? true : false);
				about.setPhone(rest.getTelefono());
				restaurant.setAbout(about);
				
				//add hour of service
				ServiceDetail serviceDetail = new ServiceDetail();
				//rest.get
				Day day = new Day();
				serviceDetail.getDay().add(day);
				restaurant.setServiceDetail(serviceDetail);
				
				//add restaurant to list
				nearbyPlacesRs.getRestaurants().add(restaurant);
			}
		}else{
			logger.info("Restaurants nearby from customer unavaliable");
		}
		
		return nearbyPlacesRs;
	}

	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.web.GodinezLunchWS#getAllCategories(com.mx.udev.godinez.web.types.GetAllCategoriesRequest)
	 */
	public GetAllCategoriesResponse getAllCategories(
		GetAllCategoriesRequest getAllCategoriesRequest) {
		GetAllCategoriesResponse categoriesRs = new GetAllCategoriesResponse();
		
		//getting list of categories
		List<CategoriaVO> categories = iGodinezServiceIntegrator.getAllCategories();
		if(!categories.isEmpty()){
			for(CategoriaVO cat : categories){
				CategorieType categorieType = new CategorieType();
				categorieType.setKey(cat.getId());
				categorieType.setDescription(cat.getDescripcion());
				categoriesRs.getCategories().add(categorieType);
			}
		}else{
			logger.info("Categories are empty");
		}
		return categoriesRs;
	}

	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.web.GodinezLunchWS#getMyFavorites(com.mx.udev.godinez.web.types.GetMyFavoritesRequest)
	 */
	public GetMyFavoritesResponse getMyFavorites(
		GetMyFavoritesRequest getMyFavoritesRequest) {
		GetMyFavoritesResponse getMyFavoritesRs = new GetMyFavoritesResponse();
		
		//get favorites places
		List<FondaVO> restaurants = iGodinezServiceIntegrator.getMyFavorites(getMyFavoritesRequest.getUserId());
		
		if(!restaurants.isEmpty()){
			for(FondaVO rest : restaurants){
				RestaurantType restaurant = new RestaurantType();
				restaurant.setKey(rest.getId());
				restaurant.setName(rest.getNombre());
				//set about data
				About about = new About();
				about.setLongitude(rest.getLatitud());
				about.setLatitude(rest.getLongitud());
				about.setEnabled(rest.getHabilitado().intValue() == 1 ? true : false);
				about.setPhone(rest.getTelefono());
				restaurant.setAbout(about);
				//add restaurant to list
				getMyFavoritesRs.getRestaurants().add(restaurant);
			}
		}else{
			logger.info("Restaurants nearby from customer unavaliable");
		}
		
		return getMyFavoritesRs;
	}

}

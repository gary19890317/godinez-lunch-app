
package com.mx.udev.godinez.web.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mx.udev.godinez.web.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CalculateDistanceResponse_QNAME = new QName("http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", "calculateDistanceResponse");
    private final static QName _GetMyFavoritesResponse_QNAME = new QName("http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", "getMyFavoritesResponse");
    private final static QName _CalculateDistanceRequest_QNAME = new QName("http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", "calculateDistanceRequest");
    private final static QName _GetNearbyPlacesResponse_QNAME = new QName("http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", "getNearbyPlacesResponse");
    private final static QName _GetAllCategoriesResponse_QNAME = new QName("http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", "getAllCategoriesResponse");
    private final static QName _GetNearbyPlacesRequest_QNAME = new QName("http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", "getNearbyPlacesRequest");
    private final static QName _GetAllCategoriesRequest_QNAME = new QName("http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", "getAllCategoriesRequest");
    private final static QName _GetMyFavoritesRequest_QNAME = new QName("http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", "getMyFavoritesRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mx.udev.godinez.web.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculateDistanceRequest.FinalLocation }
     * 
     */
    public CalculateDistanceRequest.FinalLocation createCalculateDistanceRequestFinalLocation() {
        return new CalculateDistanceRequest.FinalLocation();
    }

    /**
     * Create an instance of {@link RestaurantType }
     * 
     */
    public RestaurantType createRestaurantType() {
        return new RestaurantType();
    }

    /**
     * Create an instance of {@link GetMyFavoritesResponse }
     * 
     */
    public GetMyFavoritesResponse createGetMyFavoritesResponse() {
        return new GetMyFavoritesResponse();
    }

    /**
     * Create an instance of {@link RestaurantType.About }
     * 
     */
    public RestaurantType.About createRestaurantTypeAbout() {
        return new RestaurantType.About();
    }

    /**
     * Create an instance of {@link RestaurantType.ServiceDetail.Day }
     * 
     */
    public RestaurantType.ServiceDetail.Day createRestaurantTypeServiceDetailDay() {
        return new RestaurantType.ServiceDetail.Day();
    }

    /**
     * Create an instance of {@link CalculateDistanceRequest }
     * 
     */
    public CalculateDistanceRequest createCalculateDistanceRequest() {
        return new CalculateDistanceRequest();
    }

    /**
     * Create an instance of {@link CategorieType }
     * 
     */
    public CategorieType createCategorieType() {
        return new CategorieType();
    }

    /**
     * Create an instance of {@link GetNearbyPlacesResponse }
     * 
     */
    public GetNearbyPlacesResponse createGetNearbyPlacesResponse() {
        return new GetNearbyPlacesResponse();
    }

    /**
     * Create an instance of {@link GetAllCategoriesResponse }
     * 
     */
    public GetAllCategoriesResponse createGetAllCategoriesResponse() {
        return new GetAllCategoriesResponse();
    }

    /**
     * Create an instance of {@link RestaurantType.ServiceDetail }
     * 
     */
    public RestaurantType.ServiceDetail createRestaurantTypeServiceDetail() {
        return new RestaurantType.ServiceDetail();
    }

    /**
     * Create an instance of {@link RestaurantType.ServiceDetail.Day.Hour }
     * 
     */
    public RestaurantType.ServiceDetail.Day.Hour createRestaurantTypeServiceDetailDayHour() {
        return new RestaurantType.ServiceDetail.Day.Hour();
    }

    /**
     * Create an instance of {@link GetNearbyPlacesRequest }
     * 
     */
    public GetNearbyPlacesRequest createGetNearbyPlacesRequest() {
        return new GetNearbyPlacesRequest();
    }

    /**
     * Create an instance of {@link CalculateDistanceRequest.InitialLocation }
     * 
     */
    public CalculateDistanceRequest.InitialLocation createCalculateDistanceRequestInitialLocation() {
        return new CalculateDistanceRequest.InitialLocation();
    }

    /**
     * Create an instance of {@link GetAllCategoriesRequest }
     * 
     */
    public GetAllCategoriesRequest createGetAllCategoriesRequest() {
        return new GetAllCategoriesRequest();
    }

    /**
     * Create an instance of {@link GetMyFavoritesRequest }
     * 
     */
    public GetMyFavoritesRequest createGetMyFavoritesRequest() {
        return new GetMyFavoritesRequest();
    }

    /**
     * Create an instance of {@link CalculateDistanceResponse }
     * 
     */
    public CalculateDistanceResponse createCalculateDistanceResponse() {
        return new CalculateDistanceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateDistanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", name = "calculateDistanceResponse")
    public JAXBElement<CalculateDistanceResponse> createCalculateDistanceResponse(CalculateDistanceResponse value) {
        return new JAXBElement<CalculateDistanceResponse>(_CalculateDistanceResponse_QNAME, CalculateDistanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMyFavoritesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", name = "getMyFavoritesResponse")
    public JAXBElement<GetMyFavoritesResponse> createGetMyFavoritesResponse(GetMyFavoritesResponse value) {
        return new JAXBElement<GetMyFavoritesResponse>(_GetMyFavoritesResponse_QNAME, GetMyFavoritesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateDistanceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", name = "calculateDistanceRequest")
    public JAXBElement<CalculateDistanceRequest> createCalculateDistanceRequest(CalculateDistanceRequest value) {
        return new JAXBElement<CalculateDistanceRequest>(_CalculateDistanceRequest_QNAME, CalculateDistanceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNearbyPlacesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", name = "getNearbyPlacesResponse")
    public JAXBElement<GetNearbyPlacesResponse> createGetNearbyPlacesResponse(GetNearbyPlacesResponse value) {
        return new JAXBElement<GetNearbyPlacesResponse>(_GetNearbyPlacesResponse_QNAME, GetNearbyPlacesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCategoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", name = "getAllCategoriesResponse")
    public JAXBElement<GetAllCategoriesResponse> createGetAllCategoriesResponse(GetAllCategoriesResponse value) {
        return new JAXBElement<GetAllCategoriesResponse>(_GetAllCategoriesResponse_QNAME, GetAllCategoriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNearbyPlacesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", name = "getNearbyPlacesRequest")
    public JAXBElement<GetNearbyPlacesRequest> createGetNearbyPlacesRequest(GetNearbyPlacesRequest value) {
        return new JAXBElement<GetNearbyPlacesRequest>(_GetNearbyPlacesRequest_QNAME, GetNearbyPlacesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCategoriesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", name = "getAllCategoriesRequest")
    public JAXBElement<GetAllCategoriesRequest> createGetAllCategoriesRequest(GetAllCategoriesRequest value) {
        return new JAXBElement<GetAllCategoriesRequest>(_GetAllCategoriesRequest_QNAME, GetAllCategoriesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMyFavoritesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xmlns.udev.com/GodinezLunch/GL/datatypes/1.0", name = "getMyFavoritesRequest")
    public JAXBElement<GetMyFavoritesRequest> createGetMyFavoritesRequest(GetMyFavoritesRequest value) {
        return new JAXBElement<GetMyFavoritesRequest>(_GetMyFavoritesRequest_QNAME, GetMyFavoritesRequest.class, null, value);
    }

}


package com.mx.udev.godinez.web.types;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for calculateDistanceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="calculateDistanceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InitialLocation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FinalLocation">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculateDistanceRequest", propOrder = {
    "initialLocation",
    "finalLocation"
})
public class CalculateDistanceRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "InitialLocation", required = true)
    protected CalculateDistanceRequest.InitialLocation initialLocation;
    @XmlElement(name = "FinalLocation", required = true)
    protected CalculateDistanceRequest.FinalLocation finalLocation;

    /**
     * Gets the value of the initialLocation property.
     * 
     * @return
     *     possible object is
     *     {@link CalculateDistanceRequest.InitialLocation }
     *     
     */
    public CalculateDistanceRequest.InitialLocation getInitialLocation() {
        return initialLocation;
    }

    /**
     * Sets the value of the initialLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link CalculateDistanceRequest.InitialLocation }
     *     
     */
    public void setInitialLocation(CalculateDistanceRequest.InitialLocation value) {
        this.initialLocation = value;
    }

    /**
     * Gets the value of the finalLocation property.
     * 
     * @return
     *     possible object is
     *     {@link CalculateDistanceRequest.FinalLocation }
     *     
     */
    public CalculateDistanceRequest.FinalLocation getFinalLocation() {
        return finalLocation;
    }

    /**
     * Sets the value of the finalLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link CalculateDistanceRequest.FinalLocation }
     *     
     */
    public void setFinalLocation(CalculateDistanceRequest.FinalLocation value) {
        this.finalLocation = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "latitude",
        "longitude"
    })
    public static class FinalLocation
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        protected double latitude;
        protected double longitude;

        /**
         * Gets the value of the latitude property.
         * 
         */
        public double getLatitude() {
            return latitude;
        }

        /**
         * Sets the value of the latitude property.
         * 
         */
        public void setLatitude(double value) {
            this.latitude = value;
        }

        /**
         * Gets the value of the longitude property.
         * 
         */
        public double getLongitude() {
            return longitude;
        }

        /**
         * Sets the value of the longitude property.
         * 
         */
        public void setLongitude(double value) {
            this.longitude = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *         &lt;element name="longitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "latitude",
        "longitude"
    })
    public static class InitialLocation
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        protected double latitude;
        protected double longitude;

        /**
         * Gets the value of the latitude property.
         * 
         */
        public double getLatitude() {
            return latitude;
        }

        /**
         * Sets the value of the latitude property.
         * 
         */
        public void setLatitude(double value) {
            this.latitude = value;
        }

        /**
         * Gets the value of the longitude property.
         * 
         */
        public double getLongitude() {
            return longitude;
        }

        /**
         * Sets the value of the longitude property.
         * 
         */
        public void setLongitude(double value) {
            this.longitude = value;
        }

    }

}

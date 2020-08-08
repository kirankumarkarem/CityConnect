/**
 * 
 */
package com.mastercard.city.connected.api.models;

/**
 * @author Kirankumar K
 *
 */
public class CityConnectedNode {
	
	private String cityName;

	public CityConnectedNode(String cityName) {
	this.cityName=cityName;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	

}

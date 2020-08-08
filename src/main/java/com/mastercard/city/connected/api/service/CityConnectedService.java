/**
 * 
 */
package com.mastercard.city.connected.api.service;

import com.mastercard.city.connected.api.exceptions.CityConnectedApplicationException;

/**
 * @author Kirankumar K
 *
 */
public interface CityConnectedService {
	public String getCityConnected(String origin, String destination) throws CityConnectedApplicationException;

}

/**
 * 
 */
package com.mastercard.city.connected.api.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.city.connected.api.exceptions.CityConnectedApplicationException;
import com.mastercard.city.connected.api.service.CityConnectedService;

/**
 * @author Kirankumar K
 *
 */

@Component
public class CityConnectedHandler {
	
	@Autowired
	CityConnectedService cityConnectedService;
	
	public String getCityConnected(String origin,String destination) throws CityConnectedApplicationException
	{
		return cityConnectedService.getCityConnected(origin, destination);
	}

}

/**
 * 
 */
package com.mastercard.city.connected.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.city.connected.api.handler.CityConnectedHandler;

/**
 * @author Kirankumar K
 *
 */
@RestController
public class CityConnectedController {
	
	@Autowired
	CityConnectedHandler  cityConnectedHandler;
	
	@RequestMapping(value="/connected",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCityConnected(@RequestParam String origin ,@RequestParam String destination)
	{
		String results=null;
		try {
			results=cityConnectedHandler.getCityConnected(origin, destination);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		return new ResponseEntity<String>(results,HttpStatus.OK);
	}

}

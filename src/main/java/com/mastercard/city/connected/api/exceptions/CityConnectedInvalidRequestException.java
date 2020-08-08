/**
 * 
 */
package com.mastercard.city.connected.api.exceptions;

import java.util.List;

/**
 * @author Tane
 *
 */
public class CityConnectedInvalidRequestException  extends CityConnectedApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8366520545907001133L;

	public CityConnectedInvalidRequestException() {
		super();
	}

	public CityConnectedInvalidRequestException(String message, List<ErrorResponse> errorResponses) {
		super(message, errorResponses);
		}

	public CityConnectedInvalidRequestException(String message, Throwable throwable,
			List<ErrorResponse> errorResponses) {
		super(message, throwable, errorResponses);
	}

	public CityConnectedInvalidRequestException(String message, Throwable caThrowable) {
		super(message, caThrowable);
	}

	public CityConnectedInvalidRequestException(String message) {
		super(message);
	}

	public CityConnectedInvalidRequestException(Throwable throwable, List<ErrorResponse> errorResponses) {
		super(throwable, errorResponses);
	}

	public CityConnectedInvalidRequestException(Throwable throwable) {
		super(throwable);
	}
	
	
	

}

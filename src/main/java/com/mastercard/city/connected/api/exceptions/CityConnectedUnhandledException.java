/**
 * 
 */
package com.mastercard.city.connected.api.exceptions;

import java.util.List;

/**
 * @author Tane
 *
 */
public class CityConnectedUnhandledException extends CityConnectedApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4564747707293030926L;

	public CityConnectedUnhandledException() {
		super();
	}

	public CityConnectedUnhandledException(String message, List<ErrorResponse> errorResponses) {
		super(message, errorResponses);
	}

	public CityConnectedUnhandledException(String message, Throwable throwable, List<ErrorResponse> errorResponses) {
		super(message, throwable, errorResponses);
	}

	public CityConnectedUnhandledException(String message, Throwable caThrowable) {
		super(message, caThrowable);
	}

	public CityConnectedUnhandledException(String message) {
		super(message);
	}

	public CityConnectedUnhandledException(Throwable throwable, List<ErrorResponse> errorResponses) {
		super(throwable, errorResponses);
	}

	public CityConnectedUnhandledException(Throwable throwable) {
		super(throwable);
	}
	
	

}

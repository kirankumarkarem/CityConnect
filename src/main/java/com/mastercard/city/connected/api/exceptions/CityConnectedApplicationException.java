/**
 * 
 */
package com.mastercard.city.connected.api.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirankumar K
 *
 */
public class CityConnectedApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1305971334116038394L;

	private List<ErrorResponse> erros = null;

	public CityConnectedApplicationException() {
		super();
	}

	public CityConnectedApplicationException(String message) {
		super(message);

	}

	public CityConnectedApplicationException(String message, Throwable caThrowable) {
		super(message, caThrowable);

	}

	public CityConnectedApplicationException(Throwable throwable) {

		super(throwable);

	}

	public CityConnectedApplicationException(String message,List<ErrorResponse> errorResponses) {

		super(message);
		this.erros=errorResponses;

	}
	
	public CityConnectedApplicationException(String message,Throwable throwable,List<ErrorResponse> errorResponses) {

		super(message,throwable);
		this.erros=errorResponses;

	}
	
	public CityConnectedApplicationException(Throwable throwable,List<ErrorResponse> errorResponses) {

		super(throwable);
		this.erros=errorResponses;

	}

	/**
	 * @return the erros
	 */
	public List<ErrorResponse> getErros() {
		if(erros==null)
			erros=new ArrayList<ErrorResponse>();
		return erros;
	}

	/**
	 * @param erros
	 *            the erros to set
	 */
	public void setErros(List<ErrorResponse> erros) {
		this.erros = erros;
	}

}

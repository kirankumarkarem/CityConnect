/**
 * 
 */
package com.mastercard.city.connected.api.exceptions;

import java.util.List;

/**
 * @author Kirankumar K
 *
 */
public class CityConnectedErrorResponse {
	private String errorMessage;
	private List<ErrorResponse> erros;
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the erros
	 */
	public List<ErrorResponse> getErros() {
		return erros;
	}
	/**
	 * @param erros the erros to set
	 */
	public void setErros(List<ErrorResponse> erros) {
		this.erros = erros;
	}
	
	

}

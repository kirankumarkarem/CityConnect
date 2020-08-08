/**
 * 
 */
package com.mastercard.city.connected.api.exceptions;

/**
 * @author Kirankumar K
 *
 */
public class ErrorResponse {
	private int errorCode;
	private String message;
	private String developerMessage;

	public ErrorResponse() {

		super();

	}

	public ErrorResponse(int errorCode, String message, String developerMessage) {

		this.errorCode = errorCode;
		this.message = message;
		this.developerMessage = developerMessage;

	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the developerMessage
	 */
	public String getDeveloperMessage() {
		return developerMessage;
	}

	/**
	 * @param developerMessage
	 *            the developerMessage to set
	 */
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}

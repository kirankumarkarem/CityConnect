/**
 * 
 */
package com.mastercard.city.connected.api.exceptions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

/**
 * @author Kirankumar K
 *
 */

@ControllerAdvice
public class CityConnectedApplicationExceptionControllerAdvice extends ExceptionHandlerExceptionResolver {
	
	private static final Logger logger=LoggerFactory.getLogger(CityConnectedApplicationExceptionControllerAdvice.class);
	
	@ExceptionHandler(CityConnectedApplicationException.class)
	public ResponseEntity<CityConnectedErrorResponse> exceptionHandler(CityConnectedApplicationException ex)
	{
		CityConnectedErrorResponse cityConnectedErrorResponse=new CityConnectedErrorResponse();
		String exceptionMessage=getStackTraceAsString(getInitialCasue(ex));
		logger.error(exceptionMessage,ex);
		HttpStatus httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
		if(ex.getErros()!=null)
			cityConnectedErrorResponse.setErros(ex.getErros());
		if(ex instanceof CityConnectedInvalidRequestException || ex.getCause() instanceof CityConnectedInvalidRequestException)
		{
			cityConnectedErrorResponse.setErrorMessage(HttpStatus.BAD_REQUEST.toString() + buildDeveloperMessageString(ex.getErros())+exceptionMessage);
			httpStatus=HttpStatus.BAD_REQUEST; 
		}
		else if(ex instanceof CityConnectedUnhandledException || ex.getCause() instanceof CityConnectedUnhandledException)
		{
			cityConnectedErrorResponse.setErrorMessage(HttpStatus.BAD_REQUEST.toString() + buildDeveloperMessageString(ex.getErros())+exceptionMessage);
			httpStatus=HttpStatus.BAD_REQUEST; 

		}
		
		else
		{
			cityConnectedErrorResponse.setErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString() + buildDeveloperMessageString(ex.getErros())+exceptionMessage);
			httpStatus=HttpStatus.INTERNAL_SERVER_ERROR; 

		}
		//Note: We can implemented mutlipe exception class based on the project requirements.
		return ResponseEntity.status(httpStatus).body(cityConnectedErrorResponse);
	} 
	
	private String buildDeveloperMessageString(List<ErrorResponse> errors) {
		StringBuilder sb=new StringBuilder();
		for(ErrorResponse error:errors)
		{
			sb.append(error.getDeveloperMessage() +"\n");
		}
		return sb.toString();
	}

	public Throwable getInitialCasue(Throwable t)
	{
		Throwable rootCause=t.getCause();
		if(null!=rootCause) 
		{
			Throwable tt=getInitialCasue(rootCause);
			return tt==null?rootCause:tt;
		}
		return rootCause==null?t:rootCause; 
	}
	
	public String getStackTraceAsString(Throwable t)
	{
		try {
			if(null!=t)
				return t.getMessage();
		} catch (Throwable e) {
			
		}
		if(null!=t && t.getCause()!=null)
			return t.getCause().getMessage();
		else
			return null;
		
	}

}

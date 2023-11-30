package com.ups.oauth.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

	public ErrorResponse (int httpStatus, String errorCode, String errorDescription)
	{
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;		
	}
	


	private int httpStatus;
	private String errorCode;
	private String errorDescription;

	public int getHttpStatus() {		
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getErrorCode() {
		String response = errorCode;
		
		int start = errorCode.indexOf("[");
		int end = errorCode.indexOf("]");	
		if (start != -1 && end != -1)
		{
			response = errorCode.substring(start + 1, end);
		}
		return response;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		String response = errorDescription;
		int start = errorDescription.indexOf("[");
		int end = errorDescription.indexOf("]");	
		if (start != -1 && end != -1)
		{
			response =  errorDescription.substring(start + 1, end);
		}
		return response;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}


	public String toString()
	{
		return System.lineSeparator() + "HttpStatus = " + getHttpStatus() + System.lineSeparator() + "Error = " + getErrorCode() + System.lineSeparator() + "Error Description = " + getErrorDescription();
	}

}

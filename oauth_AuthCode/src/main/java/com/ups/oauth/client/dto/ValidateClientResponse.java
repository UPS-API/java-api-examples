package com.ups.oauth.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidateClientResponse {

	private String result;
	private String type;
	private String lassoRedirectURL;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLassoRedirectURL() {
		return lassoRedirectURL;
	}

	@JsonProperty(value = "LassoRedirectURL")
	public void setLassoRedirectURL(String lassoRedirectURL) {
		this.lassoRedirectURL = lassoRedirectURL;
	}

}

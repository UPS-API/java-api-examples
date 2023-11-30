package com.ups.oauth.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorizeClientResponse  {
	
	private String location;
	private String appname;
	private String displayname;
	
	private static final Logger log = LoggerFactory.getLogger(AuthorizeClientResponse.class);
	

	public AuthorizeClientResponse ( String location, String appname, String displayname)
	{		
		this.location = location;
		this.appname = appname;
		this.displayname = displayname;		
	}	
	
	public String getLocation() {
		String response = "";
			int start = location.indexOf("[");
			int end = location.indexOf("]");	
			if (start != -1 && end != -1)
			{
				response = location.substring(start + 1, end);
			}
		return response;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAppname() {
		String response = "";		
			int start = appname.indexOf("[");
			int end = appname.indexOf("]");		
			if (start != -1 && end != -1)
			{
				response = appname.substring(start + 1, end);
			}
		return response;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}	

	public String getDisplayname() {
		String response = "";
		
			int start = displayname.indexOf("[");
			int end = displayname.indexOf("]");		
			if (start != -1 && end != -1)
			{
				response = displayname.substring(start + 1, end);
			}
			return response;
	}
	
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}		
	
	public String toString()
	{
		String response = "";
		String url = getLocation();
		if (url.equalsIgnoreCase("https://www.ups.com/error.page"))
		{
			response = url;
		}
		else
		{
			System.out.println("toString valid page page ");
			response = System.lineSeparator() + "location = " + getLocation() + System.lineSeparator() + "appname = " + getAppname()	+ System.lineSeparator()  + "displayname = " + getDisplayname();
		}
		return response;
	}
		
		
}

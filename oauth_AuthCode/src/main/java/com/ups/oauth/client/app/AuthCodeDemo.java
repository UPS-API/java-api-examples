package com.ups.oauth.client.app;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import com.ups.oauth.client.dto.AuthTokenResponce;
import com.ups.oauth.client.dto.AuthorizeClientResponse;
import com.ups.oauth.client.dto.ErrorResponse;
import org.springframework.boot.CommandLineRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ups.oauth.client.app.AppConfig;


@Service
public class AuthCodeDemo implements CommandLineRunner  {

	private static final Logger log = LoggerFactory.getLogger(AuthCodeDemo.class);

	@Autowired
	private AppConfig appConfig;

	int methodCase = 1;
	String method = "";
	String variable = ""; 		

	@Override
	public void run(String... args) throws Exception {

		log.info("AuthCodeDemo::run");
		try {
			method = args[0];
			variable = args[1];			
			methodCase  = Integer.valueOf(method);
			
			log.info("AuthCodeDemo::run:method = " + method);
			log.info("AuthCodeDemo::run:variable = " + variable);
			

		}catch (Exception e) {
			log.info("Using default (Authorize Client)");
			methodCase = 1;
		}	

		switch (methodCase) {
		case 1:	
			authorizeClient(appConfig.getClientId(), appConfig.getRedirectUrl());				
			break;

		case 2:				
			genToken(variable);
			break;

		case 3:	
			refreshToken(variable);		
			break;					
		}
		System.exit(0);
	}




	/**
	 * validate client and prepare redirect url
	 */
	public void authorizeClient(String clientId, String redirectUri) {	

		log.info("AuthCodeDemo::run:authorizeClient");
		
	//	getUUID();

		
		AuthorizeClientResponse authorizeClientResponse = null;
		try {
			HttpClient httpClient = HttpClient.newBuilder().build();
			HashMap<String, String> params = new HashMap<>();
			params.put("client_id", appConfig.getClientId());
			params.put("redirect_uri", appConfig.getRedirectUrl());
			params.put("response_type", appConfig.getCode());
			params.put("state", appConfig.getState());
			params.put("scope", appConfig.getScope());			

			String finalValidateClientUrl = appConfig.getAuthorizeUrl() + "?client_id=" + appConfig.getClientId() + "&redirect_uri="
					+ URLEncoder.encode(appConfig.getRedirectUrl(), StandardCharsets.UTF_8) + "&response_type=code" + "&state=" + appConfig.getState()
					+ "&scope=" + appConfig.getScope();
			
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(finalValidateClientUrl))
					.header("Content-Type", "application/x-www-form-urlencoded")		
					.build();
					
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			
			java.net.http.HttpHeaders headers = response.headers();	
			
			int status = response.statusCode();
			log.info("AuthCodeDemo::authorizeClient:status = " + status);
			
			if (status == 302) {
				authorizeClientResponse = new AuthorizeClientResponse(headers.firstValue​("location").toString(),
						headers.firstValue​("appname").toString(), headers.firstValue​("displayname").toString());
				if (authorizeClientResponse.getLocation().equalsIgnoreCase("https://www.ups.com/error.page"))
				{					
					log.info("Authorize client is not available at this time, please try again later.");
					log.info(authorizeClientResponse.getLocation());
				}
				else {				
					log.info(authorizeClientResponse.toString());
				}
			} else if (status == 400 || status == 401) {
				ErrorResponse errorResponse = new ErrorResponse(response.statusCode(),
						headers.firstValue​("errorcode").toString(),
						headers.firstValue​("errordescription").toString());
			} else {
				log.info("status = " + status);
				log.info("Authorize client is not available at this time, please try again later.");
			}	


		} catch (Exception e) {			
			log.info("Authorize client is not available at this time, please try again later.");
		}		
	}


	/**
	 * this method used for generate auth code base JWT token
	 */	
	public void genToken(String code) {

		log.info("AuthCodeDemo::run:genToken");
		
		var httpClient = HttpClient.newBuilder().build();
		String authStr = appConfig.getClientId() + ":" + appConfig.getSecretId();			
		String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());			

		HashMap<String, String> params = new HashMap<>();
		params.put("grant_type", "authorization_code");
		params.put("code", code);
		params.put("redirect_uri", appConfig.getRedirectUrl());

		String query = params.keySet().stream()
				.map(key -> key + "=" + URLEncoder.encode(params.get(key), StandardCharsets.UTF_8))
				.collect(Collectors.joining("&")); 

		HttpRequest request = HttpRequest.newBuilder()
				.POST(HttpRequest.BodyPublishers.ofString(query))
				.uri(URI.create(appConfig.getTokenUrl()))
				.header("Content-Type", "application/x-www-form-urlencoded")
				.header("x-merchant-id", "")
				.header("Authorization", "Basic " + base64Creds)
				.build();

		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			int status = response.statusCode();					
			if (status == 200) 	{
				ObjectMapper mapper = new ObjectMapper();
				AuthTokenResponce authTokenResponce = mapper.readValue(response.body(), AuthTokenResponce.class);
				log.info("authTokenResponce = " + authTokenResponce.toString());	    		
			} else if (status == 400 || status == 401 || status == 403 || status == 429) {	  
				String err = response.body();	    			 
				ErrorResponse errorResponse = new ErrorResponse(status, err.substring(err.indexOf("\":[{\"code\":\"") + 12, err.indexOf("\",\"")),  err.substring(err.indexOf(",\"message\":\"") + 12, err.indexOf("\"}]}")));
				log.info(errorResponse.toString());	    			 

			} else {
				log.info("status = " + status);
				log.info("Generate token is not available at this time, please try again later.");
			}
		} catch (Exception e) {
			log.info("Generate token is not available at this time, please try again later.");
		}   
	}

	/**
	 * this method used for generate JWT token based on refresh token
	 */
	public void refreshToken(String token) {
		
		log.info("AuthCodeDemo::run:refreshToken");

		var httpClient = HttpClient.newBuilder().build();		
		String authStr = appConfig.getClientId() + ":" + appConfig.getSecretId();
		String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());		
		HashMap<String, String> params = new HashMap<>();
		params.put("grant_type", "refresh_token");
		params.put("refresh_token", token);

		String form = params.keySet().stream()
				.map(key -> key + "=" + URLEncoder.encode(params.get(key), StandardCharsets.UTF_8))
				.collect(Collectors.joining("&"));

		HttpRequest request = HttpRequest.newBuilder()
				.POST(HttpRequest.BodyPublishers.ofString(form))
				.uri(URI.create(appConfig.getRefreshUrl()))
				.header("Content-Type", "application/x-www-form-urlencoded")
				.header("Authorization", "Basic " + base64Creds)
				.build();

		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());					
			int status = response.statusCode();				
			if (status == 200) {
				ObjectMapper mapper = new ObjectMapper();
				AuthTokenResponce authTokenResponce = mapper.readValue(response.body(), AuthTokenResponce.class);
				log.info("authTokenResponce = " + authTokenResponce.toString());	    		
			} else if (status == 400 || status == 401 || status == 403 || status == 429) {	    		
				String err = response.body();	    			 
				ErrorResponse errorResponse = new ErrorResponse(status, err.substring(err.indexOf("\":[{\"code\":\"") + 12, err.indexOf("\",\"")),  err.substring(err.indexOf(",\"message\":\"") + 12, err.indexOf("\"}]}")));
				log.info(errorResponse.toString());	   
			} else {
				log.info("status = " + status);
				log.info ("Refresh token is not available at this time, please try again later.");
			}
		} catch (Exception e) {					
			log.info ("Refresh token is not available at this time, please try again later.");
		}   
	}
	
	//////////////////////////////////////////
public void getUUID() {
	
			
		log.info("AuthCodeDemo::run:getUUID");

		var httpClient = HttpClient.newBuilder().build();		
		String authStr = appConfig.getClientId() + ":" + appConfig.getSecretId();
		String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());		

		HttpRequest request = HttpRequest.newBuilder().
				uri(URI.create("https://onlinetoolss.ups.com/profile/v1/siteidentifier/GG"))
				.header("Content-Type", "application/x-www-form-urlencoded")
				.header("Accept", "application/x-www-form-urlencoded")				
				.header("transactionId", "testing")
				.header("transactionSrc", "gg")
				.header("userName", "upswwedev")
				.header("Password", "Password1@")	
				.build();

		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());	
			log.info("getUUID Respone = " + response.toString());	
			
			
			
		} catch (Exception e) {		
			e.printStackTrace();
			log.info ("getUUID token is not available at this time, please try again later.");
		}   
	}
	
	
	
	
	/////////////////////////////////////////
}



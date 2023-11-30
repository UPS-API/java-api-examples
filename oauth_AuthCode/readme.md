# Oauth Code service 
## Introduction
OAuth code, microservice is providing functionality to validate client based on your client id and redirect url once validate client and it's return redirect url. Other oauth code based generate token and refresh token based generate token.

## Getting Started
### Prerequisites
- You will need to have Maven and the Java Development Kit installed.

### Download
- You can either download a local copy or clone the repository:

```sh
git clone https://github.com/UPS-API/java-api-examples.git
```

### Insert Your Information
- Update your OAuth Client information in <project home>/src/main/resources/application.properties file. These values can be found in the UPS Developer Portal under Apps and your specific application's information.

|Property Name|Description|
| :------: | :------: |
|```api.oauth.partner.client.id```| client id obtained in the onboarding process|
|```api.oauth.partner.secret```| client secret obtained in the onboarding process|
|```redirect.url```| redirect uri obtained in the onboarding process|
|```api.base.url```| https://wwwcie.ups.com/|
|```token.api.url```| ${api.base.url}/security/v1/oauth/token|
|```api.valid.client.url```| ${api.base.url}security/v1/oauth/validate-client|
|```refresh.api.url```| ${api.base.url}/security/v1/oauth/refresh|
>    These are the properties in a section marked with "# UPS partner specific properties (change them!)" where you update with your client specific information like client id, secret, redirect uri obtained as part of onboarding process.


### Build and run

- Build the project using Maven
```sh
cd <project home>
mvn clean package
```
- Run the project that is generated in the <project home>/target directory.

```sh
Authorize the user
java -jar oauth_AuthCode-x.x.x.jar 1 
Once logged in the flow will return to the redirect URL of the client.
The client then has to get the code from the URL https://<your application>?code=<your code>&scope=read&state=test

Generate a token
java -jar oauth_AuthCode-x.x.x.jar 2 <your code> from the previous step
Both an access_token and a refresh_token will be returned in the response
"access_token": "<token>",
"refresh_token": "<refresh token>",
The access Token is valid for 4 hours.
If you wish to generate a token that is valid for 60 days you will need to generate  refresh token.

Generate a refresh token
java -jar oauth_AuthCode-x.x.x.jar 3 <refresh token> from the previous step.
Again, both an access_token and the refresh_token will be returned in the response, however the new token is valid for 60 days
"access_token": "<token>",
"refresh_token": "<refresh token>",

```
- Check the console for the application's REST response.

## Code Walk Through
There are 3 noticable class in this tutorial, namely com.ups.oauth.client.controller.ClientController and com.ups.oauth.client.service.ClientServiceImpl. The ClientController class is a for declaring rest method and ClientServiceImpl is written bussiness logic for calling UPS rest service like validating client,generate JWT token and refresh token based generate JWT token.


> uthorizing client.

```java
	public void authorizeClient(String clientId, String redirectUri) {	

		log.info("AuthCodeDemo::run:authorizeClient");
		
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
					+ URLEncoder.encode(appConfig.getRedirectUrl(), StandardCharsets.UTF_8) + "&response_type="+ appConfig.getCode() + "&state=" + appConfig.getState()
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
```
> generate auth code base JWT token.

```java
	public void genToken(String code) {
		
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


```

> generate JWT token based on refresh token.

```java
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

```

> Prepare generate token api, load a sample request 



### Sample Request/Response for generate token and refresh token

```json
{
  "refresh_token_expires_in": "604799",
  "refresh_token_status": "approved",
  "token_type": "Bearer",
  "issued_at": "1666267689724",
  "client_id": "<your client id you can get>",
  "access_token": "<you can get new generated token>",
  "refresh_token": "<you can get new refresh token >",
  "scope": "",
  "refresh_token_issued_at": "1666267689724",
  "expires_in": "14399",
  "refresh_count": "0",
  "status": "approved"
}
```

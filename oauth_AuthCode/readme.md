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
java -jar oauth_AuthCode-x.x.x.jar
```
- Check the console for the application's REST response.

## Code Walk Through
There are 3 noticable class in this tutorial, namely com.ups.oauth.client.controller.ClientController and com.ups.oauth.client.service.ClientServiceImpl. The ClientController class is a for declaring rest method and ClientServiceImpl is written bussiness logic for calling UPS rest service like validating client,generate JWT token and refresh token based generate JWT token.


> validating client.

```java
public LassoRedirectModel getValidateClient(String clientId, String redirectUri) {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        Map<String, String> params = new HashMap<>();
        params.put("client_id", clientId);
        params.put("redirect_uri", redirectUri);

        String finalValidateClientUrl = validateClientUrl + "?client_id=" + clientId + "&redirect_uri=" + redirectUri;

        log.info("url client validation api :- {}", finalValidateClientUrl);
        ResponseEntity<ValidateClientResponse> res = restTemplate.exchange(finalValidateClientUrl, HttpMethod.GET,
        entity, ValidateClientResponse.class, params);
        String callbackURL =null;

        ValidateClientResponse validateClient = res.getBody();

        if(null != validateClient  && null != validateClient.getLassoRedirectURL() && null !=validateClient.getType()) {
        callbackURL = validateClient.getLassoRedirectURL() + "?client_id=" + clientId + "&redirect_uri="
        + redirectUri + "&response_type=code&scope=read&&type=" + validateClient.getType();

        }
        LassoRedirectModel lassoRedirectModel = new LassoRedirectModel();
        lassoRedirectModel.setLassoRedirectURL(callbackURL);
        return lassoRedirectModel;

        }
```
> generate auth code base JWT token.

```java
public AuthTokenResponce genToken(String code) {

        String authStr = clientId + ":" + secretId;
        String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + base64Creds);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "authorization_code");
        map.add("code", code);
        map.add("redirect_uri", redirectUrl);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<AuthTokenResponce> res = restTemplate.postForEntity(tokenUrl, entity, AuthTokenResponce.class);
        return res.getBody();

        }

```

> generate JWT token based on refresh token.

```java
public AuthTokenResponce refreshToken(String token) {

		String authStr = clientId + ":" + secretId;
		String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic " + base64Creds);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", "refresh_token");
		map.add("refresh_token", token);
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
		ResponseEntity<AuthTokenResponce> res = restTemplate.postForEntity(refreshUrl, entity, AuthTokenResponce.class);
		return res.getBody();
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

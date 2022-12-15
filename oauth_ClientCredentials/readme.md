# Client credential 
## Introduction
Client credential, is an api provides function obtaining the client id and secreat id base generate JWT token for UPS Client.

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

|Property Name |
| :------: |
|```api.oauth.partner.client.id```|
|```api.oauth.partner.secret```|


### Build and run

- Build the project using Maven
```sh
cd <project home>
mvn clean package
```

- Run the project that is generated in the <project home>/target directory.
```sh
java -jar oauth_ClientCredential-x.x.x.jar
```
- Check the console for the application's REST response.

## Code Walk Through
There are 2 noticable class in this tutorial, namely com.ups.api.app.AppConfig and com.ups.api.app.ClientCredentialDemo.  The AppConfig class is a configuration class leveraging Spring injection to incorporate the property values from application properties file.  The ClientCredentialDemo is to illustrat how to use the client credential api.

```java
 String accessToken = getAccessToken(appConfig,restTemplate);
```
> Get an access token via api.

```java
 public static String getAccessToken(final AppConfig appConfig, final RestTemplate restTemplate) {

        if (!readExpiryToleranceFromConfig) {
            TOKEN_EXPIRY_TOLERANCE_IN_SEC.set(appConfig.getTokenExipryToleranceInSec());
            readExpiryToleranceFromConfig = true;
        }
        String accessToken = appConfig.getAccessTokenStore().get(appConfig.getClientID());
        if (null == accessToken || isTokenExpired()) {
            synchronized (ClientCredentialDemo.class) {
                if (null == accessToken || isTokenExpired()) {
                    OAuthApi oauthApi = new OAuthApi(new ApiClient(restTemplate));
                    final String encodedClientIdAndSecret = Base64.getEncoder().encodeToString(
                            (appConfig.getClientID() + ':' + appConfig.getSecret()).
                                    getBytes(StandardCharsets.UTF_8));
                    oauthApi.getApiClient().setBasePath(appConfig.getOauthBaseUrl());
                    oauthApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, BASIC_AUTH + encodedClientIdAndSecret);
                    log.info("ecnoded clientId and secret: [{}]", encodedClientIdAndSecret);

                    try {
                        GenerateTokenSuccessResponse generateAccessTokenResponse = oauthApi.generateToken(CLIENT_CREDENTIALS, null);
                        accessToken = generateAccessTokenResponse.getAccessToken();
                        EXPIRY.set(new Date().getTime() / 1000 + Long.parseLong(generateAccessTokenResponse.getExpiresIn()) - 2);
                    } catch (HttpClientErrorException httpClientException) {
                        log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
                    } catch (Exception ex) {
                        applicationErrorHandler(ex);
                    }
                }
            }
        }
        log.info("access token [{}], expiry [{}]", accessToken, EXPIRY.get());
        appConfig.getAccessTokenStore().put(appConfig.getClientID(), accessToken);
        return accessToken;
    }
```
> Prepare generate token api, load a sample request 

### Data Schema

- [Response Schema GenerateTokenSuccessResponse](docs/GenerateTokenSuccessResponse.md)
### Sample Response
```json
{
  "token_type": "Bearer",
  "issued_at": "1665748432802",
  "client_id": "<client id>",
  "access_token": "<generated token>",
  "scope": "",
  "expires_in": "14399",
  "refresh_count": "0",
  "status": "approved"
}
```

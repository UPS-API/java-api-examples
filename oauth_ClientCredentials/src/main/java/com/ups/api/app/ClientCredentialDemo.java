package com.ups.api.app;


import com.ups.oauth.client.ApiClient;
import com.ups.oauth.client.api.OAuthApi;
import com.ups.oauth.client.model.TokenSuccessResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Component
@AllArgsConstructor
@Slf4j
public class ClientCredentialDemo implements CommandLineRunner {

    RestTemplate restTemplate;
    AppConfig appConfig;

    private static final String CLIENT_CREDENTIALS = "client_credentials";
    private static final String BASIC_AUTH = "Basic ";
    private static final AtomicLong EXPIRY = new AtomicLong(0);
    private static final AtomicLong TOKEN_EXPIRY_TOLERANCE_IN_SEC = new AtomicLong(5);
    private static boolean readExpiryToleranceFromConfig = false;

    @Override
    public void run(String... args) throws Exception {
        getAccessToken(appConfig, restTemplate);
    }

    private static boolean isTokenExpired() {
        return ((EXPIRY.get() - new Date().getTime() / 1000) - 1 < TOKEN_EXPIRY_TOLERANCE_IN_SEC.get());
    }

    public static void getAccessToken(final AppConfig appConfig, final RestTemplate restTemplate) {

    	TokenSuccessResponse generateAccessTokenResponse = null;
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
                        generateAccessTokenResponse = oauthApi.createToken(CLIENT_CREDENTIALS, null);  
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
        log.info("access token [{}], expiry [{}]", generateAccessTokenResponse, EXPIRY.get());
        appConfig.getAccessTokenStore().put(appConfig.getClientID(), accessToken);
    }

    private static void applicationErrorHandler(Exception ex) {
        log.warn("failed to complete request", ex);
    }
}

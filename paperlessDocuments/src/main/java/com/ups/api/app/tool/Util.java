package com.ups.api.app.tool;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.openapitools.oauth.client.ApiClient;
import org.openapitools.oauth.client.api.OAuthApi;
import org.openapitools.oauth.client.model.GenerateTokenSuccessResponse;
import org.openapitools.paperlessDocuments.client.model.PAPERLESSDOCUMENTRequestWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ups.api.app.AppConfig;
import com.ups.api.app.PaperlessDocuments;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Util {
	private static final String CLIENT_CREDENTIALS = "client_credentials";
	private static final String BASIC_AUTH = "Basic ";
	private static final AtomicLong EXPIRY = new AtomicLong(0);
	private static final AtomicLong TOKEN_EXPIRY_TOLERANCE_IN_SEC = new AtomicLong(5);
	private static boolean readExpiryToleranceFromConfig = false;

	private static boolean isTokenExpired() {
		return( (EXPIRY.get() - new Date().getTime()/1000) - 1 < TOKEN_EXPIRY_TOLERANCE_IN_SEC.get());
	}
	
	public static String getAccessToken(final AppConfig appConfig, final RestTemplate restTemplate) {	
		if(!readExpiryToleranceFromConfig) {
			TOKEN_EXPIRY_TOLERANCE_IN_SEC.set(appConfig.getTokenExipryToleranceInSec());
			readExpiryToleranceFromConfig = true;
		}
		String accessToken = appConfig.getAccessTokenStore().get(appConfig.getClientID());
		if(null == accessToken || isTokenExpired()) {
			synchronized(Util.class) {
				if(null == accessToken || isTokenExpired()) {
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
						EXPIRY.set(new Date().getTime()/1000 + Long.parseLong(generateAccessTokenResponse.getExpiresIn()) - 2);
					} catch (Exception ex) {
						throw new IllegalStateException(ex);
					}
				}
			}
		}
		log.info("access token [{}], expiry [{}]", accessToken, EXPIRY.get());
		appConfig.getAccessTokenStore().put(appConfig.getClientID(), accessToken);
		return accessToken;
	}
	
	public static <T> T createRequestFromJsonFile(final String filePath,
			final Class<T> requestClass,AppConfig appConfig,CreateRequestEnricher enricher) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			T request = mapper.readValue(PaperlessDocuments.class.getClassLoader().getResourceAsStream(filePath), requestClass);
			if(null!=enricher&& requestClass.equals(PAPERLESSDOCUMENTRequestWrapper.class)){
				enricher.enrich(appConfig, request);
			}
			return request;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IllegalStateException("failed to constrcut object from [" + filePath + ']', ex);
		}
	}
	private Util() {
	}	
}

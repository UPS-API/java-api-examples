package com.ups.api.app;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@Configuration
@Data
public class AppConfig {
	
	public static final int SCENARIO_PROPERTIES_JSON_FILE_NAME = 0;
	public static final int SCENARIO_PROPERTIES_CLASS_NAME = 1;

	@Value("${api.oauth.partner.client.id}")
	private String clientID;
	
	@Value("${api.oauth.partner.secret}")
	private String secret;
	
	@Value("${api.oauth.base.url}")
	private String oauthBaseUrl;

	// store access token obtaining by client_credential grant_type.
	private Map<String,String> accessTokenStore = new ConcurrentHashMap<>();
	
	@Value("${api.addressValidation.base.url:#{null}}")
	private String addressValidationBaseUrl;
	
	@Value("${api.addressValidation.version:v1}")
	private String addressValidationVersion;

	@Value("${api.addressValidation.reqOption:1}")
	private Integer addressValidationReqOption;
	
	@Value("${api.addressValidation.transaction.source:testing}")
	private String transactionSrc;
	
	@Value("#{${api.addressValidation.scenario.properties}}")
	private Map<String,List<String>> scenarioProperties;

	@Value("${api.oauth.access.token.expiry.tolerance:5}")
	private long tokenExipryToleranceInSec;


	public static final String ADDRESS_VALIDATION_SUCCESS_SCENARIO = "AddressValidationSuccess";

	public static final String UNCLASSIFIED_ADDRESS_VALIDATION_SCENARIO = "UnClassified";

	public static final String COMMERCIAL_ADDRESS_VALIDATION_SCENARIO = "Commercial";

	public static final String RESIDENTIAL_ADDRESS_VALIDATION_SCENARIO = "Residential";
	@Bean 
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		final SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		return builder.requestFactory(() -> factory).build();
	}
}

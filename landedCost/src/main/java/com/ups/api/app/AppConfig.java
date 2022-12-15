package com.ups.api.app;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static Logger log = LoggerFactory.getLogger(AppConfig.class);

	public static final int SCENARIO_PROPERTIES_JSON_FILE_NAME = 0;
	public static final int SCENARIO_PROPERTIES_CLASS_NAME = 1;

	public static final int SCENARIO_PORPERTY_REQUEST_OPTION_PARAMETER = 2;
	public static final int SCENARIO_PORPERTY_ADDITIONAL_INFO_PARAMETER = 3;

	public static final String LandedCostSuccess = "LandedCostQueryRequestSuccess";

	@Value("${api.oauth.partner.client.id}")
	private String clientID;

	@Value("${api.oauth.partner.secret}")
	private String secret;

	@Value("${api.oauth.base.url}")
	private String oauthBaseUrl;

	@Value("${api.oauth.partner.accessToken:#{null}}")
	private String previousObtainedToken;

	// transient token populated from previousObtainedToken or
	// obtained from client_credential grant_type.
	private Map<String, String> accessTokenStore = new ConcurrentHashMap<>();

	@Value("${api.landed.cost.base.url:#{null}}")
	private String landedCostBaseUrl;

	@Value("${api.landed.cost.version:v1}")
	private String landedCostVersion;

	@Value("${api.landed.cost.transaction.source:testing}")
	private String transactionSrc;

	@Value("#{${api.landed.cost.scenario.properties}}")
	private Map<String, List<String>> scenarioProperties;

	@Value("${api.oauth.access.token.expiry.tolerance:5}")
	private long tokenExipryToleranceInSec;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		final SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		return builder.requestFactory(() -> factory).build();
	}
}

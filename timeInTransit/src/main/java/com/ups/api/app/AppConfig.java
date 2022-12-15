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

import lombok.Getter;

@Configuration
@Getter
public class AppConfig {	
	public static final int SCENARIO_PROPERTIES_JSON_FILE_NAME = 0;
	public static final int SCENARIO_PROPERTIES_CLASS_NAME = 1;
	
	public static final String TNT_INTERNATIONAL_SUCCESS_SCENARIO = "TNTInternationalSuccess";
	public static final String TNT_DOMESTIC_SUCCESS_SCENARIO = "TNTDomesticSuccess";
	public static final String TNT_INVALID_SHIP_DATE_SCENARIO = "InvalidShipDate";
	
	@Value("${api.oauth.partner.client.id}")
	private String clientID;
	
	@Value("${api.oauth.partner.secret}")
	private String secret;
	
	@Value("${api.oauth.base.url}")
	private String oauthBaseUrl;
	 
	// store access token obtaining by client_credential grant_type.
	private Map<String,String> accessTokenStore = new ConcurrentHashMap<>();
	
	@Value("${api.tnt.base.url:#{null}}")
	private String tntBaseUrl;
	
	@Value("${api.tnt.version:v1}")
	private String tntVersion;
	
	@Value("${api.tnt.transaction.source:testing}")
	private String transactionSrc;
	
	@Value("${api.oauth.access.token.expiry.tolerance:5}")
	private long tokenExipryToleranceInSec;
	
	@Value("#{${api.tnt.scenario.properties}}")
	private Map<String,List<String>> scenarioProperties;
	
	@Value("#{${api.tnt.scenario.tnt.success.day.from.today:10}}")
	private int numberOfDayFromToday;
	
	@Bean 
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		final SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		return builder.requestFactory(() -> factory).build();
	}
}

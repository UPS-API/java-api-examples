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
	public static final int SCENARIO_PORPERTY_REQUEST_OPTION_PARAMETER = 2;
	public static final int SCENARIO_PORPERTY_ADDITIONAL_INFO_PARAMETER = 3;
	
	public static final String SIMPLE_RATE_SCENARIO = "SimpleRate";
	public static final String TNT_RATE_SCENARIO = "TNTRate";
	
	public static final String REQUEST_OPTION_RATE = "Rate";
	public static final String REQUEST_OPTION_SHOP = "Shop";
	
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
	private Map<String,String> accessTokenStore = new ConcurrentHashMap<>();
	
	@Value("${api.rate.base.url:#{null}}")
	private String rateBaseUrl;
	
	@Value("${api.rate.version:v1}")
	private String rateVersion;
	
	@Value("${api.rate.transaction.source:testing}")
	private String transactionSrc;
	
	@Value("${api.oauth.ccess.token.expiry.tolerance:5}")
    private long tokenExipryToleranceInSec;

	@Value("#{${api.rate.scenario.properties}}")
	private Map<String,List<String>> scenarioProperties;
	
	@Value("#{${api.rate.scenario.tnt.rate.day.from.today:10}}")
	private int numberOfDayFromToday;
	
	@Bean 
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		final SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		return builder.requestFactory(() -> factory).build();
	}
}

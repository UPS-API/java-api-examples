package com.ups.api.app;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@Data
public class AppConfig {
    private static Logger log = LoggerFactory.getLogger(AppConfig.class);

    public static final int SCENARIO_PROPERTIES_JSON_FILE_NAME = 0;
    public static final int SCENARIO_PROPERTIES_CLASS_NAME = 1;

    public static final int SCENARIO_PORPERTY_REQUEST_OPTION_PARAMETER = 2;
    public static final int SCENARIO_PORPERTY_ADDITIONAL_INFO_PARAMETER = 3;

    public static final String PICKUP_CREATION_REQUEST_SUCCESS = "PickupCreationRequestSuccess";
    public static final String POST_PICKUP_TYPE = "rating";
    //you can change based on requirement both,oncall or smart
    public static final String GET_PICKUP_TYPE = "both";//oncall, smart

    public static final String CANCEL_BY = "prn";


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

    @Value("${api.pickup.base.url:#{null}}")
    private String pickupBaseUrl;

    @Value("${api.pickup.version:v1}")
    private String pickupVersion;

    @Value("${api.pickup.transaction.source:testing}")
    private String transactionSrc;

    @Value("${api.pickup.accountNumber}")
    private String accountNumber;

    @Value("${api.pickup.countrycode}")
    private String countryCode;

    @Value("#{${api.pickup.creation.scenario.properties}}")
    private Map<String, List<String>> scenarioPickupCreationProperties;

    @Value("#{${api.pickup.service.center.facility.scenario.properties}}")
    private Map<String, List<String>> scenarioPickupGetServiceCenterFacilitiesProperties;

    @Value("#{${api.pickup.rate.scenario.properties}}")
    private Map<String, List<String>> scenarioPickupRateProperties;

    @Value("${api.oauth.access.token.expiry.tolerance:5}")
    private long tokenExipryToleranceInSec;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        final SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        return builder.requestFactory(() -> factory).build();
    }
}

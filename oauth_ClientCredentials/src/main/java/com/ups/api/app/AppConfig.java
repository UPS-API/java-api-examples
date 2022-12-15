package com.ups.api.app;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@Getter
public class AppConfig {

    private static Logger log = LoggerFactory.getLogger(AppConfig.class);
    public static final int SCENARIO_PROPERTIES_JSON_FILE_NAME = 0;
    public static final int SCENARIO_PROPERTIES_CLASS_NAME = 1;


    @Value("${api.oauth.partner.client.id}")
    private String clientID;

    @Value("${api.oauth.partner.secret}")
    private String secret;

    @Value("${api.oauth.base.url}")
    private String oauthBaseUrl;

    @Value("${api.oauth.access.token.expiry.tolerance:5}")
    private long tokenExipryToleranceInSec;

    // store access token obtaining by client_credential grant_type.
    private Map<String, String> accessTokenStore = new ConcurrentHashMap<>();


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        final SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        return builder.requestFactory(() -> factory).build();
    }

}

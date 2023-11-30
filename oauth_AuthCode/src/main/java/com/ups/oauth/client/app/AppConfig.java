package com.ups.oauth.client.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;

@Configuration
@Getter
public class AppConfig {

	    @Value("${token.api.url}")
		private String tokenUrl;
	   
		@Value("${token.api.client}")
		private String clientId;
	   
		@Value("${token.api.secret}")
		private String secretId;

		@Value("${api.valid.client.url}")
		private String validateClientUrl;

		@Value("${refresh.api.url}")
		private String refreshUrl;

		@Value("${redirect.url}")
	    private String redirectUrl;
		
		@Value("${api.response_type}")
		private String code;
		
		@Value("${api.type}")
		private String type;

		@Value("${api.scope}")
		private String scope;
		
		@Value("${api.state}")
		private String state;
		
		@Value("${api.base.url}")
		private String upsurl;
		
		@Value("${api.valid.client.url}")
		private String authorizeUrl;
		
		
/*
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		final SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		return builder.requestFactory(() -> factory).build();
	}
*/
}

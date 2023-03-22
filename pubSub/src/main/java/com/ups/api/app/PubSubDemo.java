package com.ups.api.app;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.openapitools.pubsub.client.ApiClient;
import org.openapitools.pubsub.client.api.PubSubApi;
import org.openapitools.pubsub.client.model.PubSubResponseWrapper;
import org.openapitools.pubsub.client.model.PubSubTrackingRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ups.api.app.tool.CreateRequestEnricher;
import com.ups.api.app.tool.Util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class PubSubDemo implements CommandLineRunner {
	private static final String SCENARIO_NAME_LOG_FORMAT = "PubSub Response for scenario: {}";
	private static final String DEFAULT_ACCEPT_PARAMETER = "application/json";
	
	private final RestTemplate restTemplate;
	private final AppConfig appConfig;
	private static final ThreadLocal<PubSubApi> api = new ThreadLocal<>();

	@Override
	public void run(String... args) throws Exception {
		// Each iteration will create an instance of PubSubTrackingRequest from a pre-determined json file verses
		// creating a PubSubTrackingRequest object and calling a setter for particular attribute in an application environment.
		for(Map.Entry<String, List<String>> entry : appConfig.getScenarioProperties().entrySet()) {
			try {
				PubSubTrackingRequest pubSubTrackingRequest = Util.createRequestFromJsonFile(entry.getKey(),
																						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
																						PubSubTrackingRequest.class,
																						appConfig,
																						Arrays.asList(new CreateRequestEnricher() {}));
				// create a 32 character unique id.
				final String transId = UUID.randomUUID().toString().replace("-", "");
				
				Optional<String> acceptParameter = getAcceptParameter(entry);
				
				// Get a tracking response for a list of tracking number.
				PubSubResponseWrapper pubSubResponseWrapper = sendRequest(pubSubTrackingRequest, transId, acceptParameter);
				
				processResult(entry.getKey(), pubSubResponseWrapper);
			} catch(HttpClientErrorException httpClientException) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
			} catch(Exception ex) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				applicationErrorHandler(ex);
			} finally {
				cleanup();
			}
			log.info("\n");
		}
	}

	public PubSubResponseWrapper sendRequest(final PubSubTrackingRequest pubSubTrackingRequest, final String transId, final Optional<String> acceptOption) {
		log.info("transId: {}", transId);
		final String accessToken = Util.getAccessToken(appConfig, restTemplate);
        PubSubApi pubSubApi = api.get();
        if(null == pubSubApi) {
        	pubSubApi = new PubSubApi(new ApiClient(restTemplate));
        	pubSubApi.getApiClient().setBasePath(appConfig.getBaseUrl());
                api.set(pubSubApi);
        }

        pubSubApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		return pubSubApi.trackVersionSubscriptionPackagePost(appConfig.getVersion(),
										transId,
										appConfig.getTransactionSrc(),
										acceptOption.orElse(DEFAULT_ACCEPT_PARAMETER),
										pubSubTrackingRequest);
	}
	
	private Optional<String> getAcceptParameter(final Map.Entry<String, List<String>> entry) {
		Optional<String> optionParameter = Optional.empty();
		if(entry.getValue().size() > AppConfig.SCENARIO_PORPERTY_ACCEPT_PARAMETER) {
			final String optionParameterString = entry.getValue().get(AppConfig.SCENARIO_PORPERTY_ACCEPT_PARAMETER);
			if(null != optionParameterString && !optionParameterString.isEmpty()) {
				optionParameter = Optional.of(entry.getValue().get(AppConfig.SCENARIO_PORPERTY_ACCEPT_PARAMETER));
			}
		}
		return optionParameter;
	}
	
	private void cleanup() {
        PubSubApi pubSubApi = api.get();
        if(null != pubSubApi) {
                api.remove();
        }
	}
	
	void processResult(final String scenarioName, final PubSubResponseWrapper pubSubResponseWrapper) {
		ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		
		log.info(SCENARIO_NAME_LOG_FORMAT, scenarioName);
		try {
			log.info("response json:\n{}", objectMapper.writeValueAsString(pubSubResponseWrapper));
		}catch(Exception ex) {
			log.info("response: {}", pubSubResponseWrapper.toString());
		}
	}
	
	private void applicationErrorHandler(Exception ex) {
		log.warn("failed to complete request", ex);
	}
}

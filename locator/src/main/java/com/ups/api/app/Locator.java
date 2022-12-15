package com.ups.api.app;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.openapitools.locator.client.ApiClient;
import org.openapitools.locator.client.api.LocatorApi;
import org.openapitools.locator.client.model.LOCATORRequestWrapper;
import org.openapitools.locator.client.model.LOCATORResponseWrapper;
import org.openapitools.locator.client.model.LocatorRequest;
import org.openapitools.locator.client.model.LocatorResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ups.api.app.tool.Util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class Locator implements CommandLineRunner {
	
	private static final String SCENARIO_NAME_LOG_FORMAT = "Locator Response for scenario: {}";
	
	RestTemplate restTemplate;
	AppConfig appConfig;

	private static final ThreadLocal<LocatorApi> api = new ThreadLocal<>();

	@Override
	public void run(String... args) throws Exception {
		// run through different Locator request
		for (Map.Entry<String, List<String>> entry : this.appConfig.getScenarioProperties().entrySet()) {
			try{
			// Create LocatorRequest from a pre-determined json file
			LocatorRequest locatorRequest = Util.createRequestFromJsonFile(
					entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
					LocatorRequest.class,
					this.appConfig);

			// create a 32 character unique id.
			final String transId = UUID.randomUUID().toString().replace("-", "");
			LOCATORRequestWrapper locatorRequestWrapper = new LOCATORRequestWrapper();
			locatorRequestWrapper.setLocatorRequest(locatorRequest);
			// Get a Locator information
			LOCATORResponseWrapper locatorResponseWrapper=this.sendRequest(locatorRequestWrapper, transId);

			processResult(entry.getKey(), locatorResponseWrapper.getLocatorResponse());
			} catch(HttpClientErrorException httpClientException) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
			} catch(Exception ex) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				this.applicationErrorHandler(ex);
			} finally {
				this.cleanup();
			}
			log.info("\n");
		}	
	}


	public LOCATORResponseWrapper sendRequest(final LOCATORRequestWrapper locatorRequestWrapper, final String transId) {
		log.info("transId: {}", transId);
		final String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
        LocatorApi locatorApi = api.get();
        if(null == locatorApi) {
			locatorApi = new LocatorApi(new ApiClient(this.restTemplate));
			locatorApi.getApiClient().setBasePath(this.appConfig.getLocatorBaseUrl());
                api.set(locatorApi);
        }

        locatorApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		return locatorApi.locator(this.appConfig.getLocatorVersion(), this.appConfig.getReqOption(),
		locatorRequestWrapper,
		transId,
		this.appConfig.getTransactionSrc(),
		"en_US");
	}
	
	private void cleanup() {
        LocatorApi locatorApi = api.get();
        if(null != locatorApi) {
                api.remove();
        }
	}

	/**
	 * @param scenarioName
	 * @param locatorResponse
	 */
	public static void processResult(final String scenarioName, final LocatorResponse locatorResponse) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			log.info("response json: [{}]", mapper.writeValueAsString(locatorResponse));
		}catch(Exception ex) {
			log.info("response: {}", locatorResponse.toString());
		}	
		log.info(SCENARIO_NAME_LOG_FORMAT, scenarioName);

	}

	private void applicationErrorHandler(Exception ex) {
		log.warn("failed to complete request", ex);
	}
}

package com.ups.api.app;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.openapitools.preNotification.client.ApiClient;
import org.openapitools.preNotification.client.api.PreNotificationApi;
import org.openapitools.preNotification.client.model.PRENOTIFICATIONRequestWrapper;
import org.openapitools.preNotification.client.model.PRENOTIFICATIONResponseWrapper;
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
public class PreNotification implements CommandLineRunner {

	RestTemplate restTemplate;

	AppConfig appConfig;

	private static final ThreadLocal<PreNotificationApi> api = new ThreadLocal<>();
	private static final String SCENARIO_NAME_LOG_FORMAT = "Pre Notification Response for scenario: {}";
	@Override
	public void run(String... args) throws Exception {
		// run through different PRENOTIFICATIONWrapper request
		for (Map.Entry<String, List<String>> entry : this.appConfig.getScenarioProperties().entrySet()) {
			try {
				// Create Pre Notification Request from a pre-determined json file
				PRENOTIFICATIONRequestWrapper preNotificationRequestWrapper = Util.createRequestFromJsonFile(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
						PRENOTIFICATIONRequestWrapper.class);
				// Get Pre Notification status
				PRENOTIFICATIONResponseWrapper preNotificationResponseWrapper = this.sendRequest(preNotificationRequestWrapper);

				processResult(entry.getKey(), preNotificationResponseWrapper.getPreNotificationResponse());
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

	public PRENOTIFICATIONResponseWrapper sendRequest(final PRENOTIFICATIONRequestWrapper preNotificationRequestWrapper) {
		final String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
		// create a 32 character unique id.
		final String transId = UUID.randomUUID().toString().replace("-", "");
        PreNotificationApi preNotificationApi = api.get();
        if(null == preNotificationApi) {
			preNotificationApi = new PreNotificationApi(new ApiClient(this.restTemplate));
			preNotificationApi.getApiClient().setBasePath(this.appConfig.getPreNotificationBaseUrl());
            api.set(preNotificationApi);
        }

        preNotificationApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		return preNotificationApi
		.preNotification(this.appConfig.getPreNotificationVersion(), preNotificationRequestWrapper, transId, this.appConfig.getTransactionSrc());
	}
	
	private void cleanup() {
        PreNotificationApi preNotificationApi = api.get();
        if(null != preNotificationApi) {
                api.remove();
        }
	}

	/**
	 * @param scenarioName
	 * @param response
	 */
	public static void processResult(final String scenarioName, final Object response) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			// convert user object to json string and return it
			log.info("Scenario name: {}, response[{}]", scenarioName, mapper.writeValueAsString(response));
		} catch (Exception e) {
			log.warn("Unable to process result {}", e.getMessage());
		}
	}

	private void applicationErrorHandler(Exception ex) {
		log.warn("failed to complete request: {}", ex.getMessage());
	}
}

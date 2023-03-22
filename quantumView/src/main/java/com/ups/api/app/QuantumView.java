package com.ups.api.app;

import java.util.List;
import java.util.Map;

import org.openapitools.quantumView.client.ApiClient;
import org.openapitools.quantumView.client.api.QuantumViewApi;
import org.openapitools.quantumView.client.model.QUANTUMVIEWRequestWrapper;
import org.openapitools.quantumView.client.model.QUANTUMVIEWResponseWrapper;
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
public class QuantumView implements CommandLineRunner {

	RestTemplate restTemplate;

	AppConfig appConfig;

	private static final ThreadLocal<QuantumViewApi> api = new ThreadLocal<>();
	private static final String SCENARIO_NAME_LOG_FORMAT = "Quantum View Response for scenario: {}";
	@Override
	public void run(String... args) throws Exception {
		// run through different QUANTUMVIEWRequestWrapper request
		for (Map.Entry<String, List<String>> entry : this.appConfig.getScenarioProperties().entrySet()) {
			try {
				// Create Quantum View Request from a pre-determined json file
				QUANTUMVIEWRequestWrapper quantumViewRequestWrapper = Util.createRequestFromJsonFile(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
						QUANTUMVIEWRequestWrapper.class);
				// Get Quantum View response
				QUANTUMVIEWResponseWrapper quantumViewResponseWrapper = this.sendRequest(quantumViewRequestWrapper);

				processResult(entry.getKey(), quantumViewResponseWrapper.getQuantumViewResponse());
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

	public QUANTUMVIEWResponseWrapper sendRequest(final QUANTUMVIEWRequestWrapper quantumViewRequestWrapper) {
		final String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
        QuantumViewApi quantumViewApi = api.get();
        if(null == quantumViewApi) {
			quantumViewApi = new QuantumViewApi(new ApiClient(this.restTemplate));
			quantumViewApi.getApiClient().setBasePath(this.appConfig.getQuantumViewBaseUrl());
            api.set(quantumViewApi);
        }

        quantumViewApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		return quantumViewApi.quantumView(this.appConfig.getQuantumViewVersion(), quantumViewRequestWrapper);
	}
	
	private void cleanup() {
		QuantumViewApi quantumViewApi = api.get();
        if(null != quantumViewApi) {
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

package com.ups.api.app;

import java.util.List;
import java.util.Map;

import org.openapitools.addressValidation.client.ApiClient;
import org.openapitools.addressValidation.client.api.AddressValidationApi;
import org.openapitools.addressValidation.client.model.XAVRequestWrapper;
import org.openapitools.addressValidation.client.model.XAVResponseWrapper;
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
public class AddressValidation implements CommandLineRunner {

	RestTemplate restTemplate;

	AppConfig appConfig;

	private static final ThreadLocal<AddressValidationApi> api = new ThreadLocal<>();
	private static final String SCENARIO_NAME_LOG_FORMAT = "Address validation Response for scenario: {}";
	@Override
	public void run(String... args) throws Exception {
		// run through different XAVRequestWrapper request
		for (Map.Entry<String, List<String>> entry : this.appConfig.getScenarioProperties().entrySet()) {
			try {
				// Create XAV Request from a pre-determined json file
				XAVRequestWrapper xavRequestWrapper = Util.createRequestFromJsonFile(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
						XAVRequestWrapper.class);
				// Get Address Validation result
				XAVResponseWrapper xavResponseWrapper = this.sendRequest(xavRequestWrapper);

				processResult(entry.getKey(), xavResponseWrapper.getXaVResponse());
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

	public XAVResponseWrapper sendRequest(final XAVRequestWrapper xavRequestWrapper) {
		final String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
        AddressValidationApi addressValidationApi = api.get();
        if(null == addressValidationApi) {
			addressValidationApi = new AddressValidationApi(new ApiClient(this.restTemplate));
			addressValidationApi.getApiClient().setBasePath(this.appConfig.getAddressValidationBaseUrl());
            api.set(addressValidationApi);
        }

        addressValidationApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		return addressValidationApi
		.addressValidation(this.appConfig.getAddressValidationReqOption(), this.appConfig.getAddressValidationVersion(),
				xavRequestWrapper,null,null);
	}
	
	private void cleanup() {
        AddressValidationApi addressValidationApi = api.get();
        if(null != addressValidationApi) {
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

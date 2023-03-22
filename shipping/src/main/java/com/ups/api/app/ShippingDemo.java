package com.ups.api.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ups.api.app.tool.ShipApi;
import com.ups.api.app.tool.Util;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.shipping.client.ApiClient;
import org.openapitools.shipping.client.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j

public class ShippingDemo implements CommandLineRunner {

	RestTemplate restTemplate;
	AppConfig appConfig;
	private String trackingNumber = null;
	private String shipmentIdentificationNumber = null;
	private static final String SCENARIO_NAME_LOG_FORMAT = "Shipping Response for scenario: {}";
	private static final ThreadLocal<ShipApi> api = new ThreadLocal<>();

	public ShippingDemo(RestTemplate restTemplate, AppConfig appConfig) {
		this.restTemplate = restTemplate;
		this.appConfig = appConfig;
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			// Get shipping response
			getShippingResponse();
			// get label recovery responce
			getLabelRecoveryResponse();
			// get void shipment responce
			getVoidShipmentResponse();
		} catch (Exception ex) {
			applicationErrorHandler(ex);
		}
	}

	/**
	 * getShippingResponse method used for process shipping request and getting
	 * shipping responce
	 */
	private void getShippingResponse() {

		for (Map.Entry<String, List<String>> entry : appConfig.getScenarioProperties().entrySet()) {

			try {
				SHIPRequestWrapper shipmentRequest = Util.createRequestFromJsonFileShipping(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME), SHIPRequestWrapper.class,
						appConfig);
				final String transId = UUID.randomUUID().toString().replaceAll("-", "");

				final ShipApi shipApi = getShipApi(restTemplate, appConfig);

				SHIPResponseWrapper shipResponseWrapper = Util.jsonResultPreprocess(
						shipApi.shipment(appConfig.getShippingVersion(), shipmentRequest, transId,
								appConfig.getTransactionSrc(), null),
						Util.getJsonToObjectConversionMap(), SHIPResponseWrapper.class);
				ShipmentResponse shipmentResponse = shipResponseWrapper.getShipmentResponse();
				if (trackingNumber == null) {
					if (shipmentResponse.getShipmentResults().getPackageResults().get(0).getTrackingNumber() != null) {
						trackingNumber = shipmentResponse.getShipmentResults().getPackageResults().get(0)
								.getTrackingNumber();
						shipmentIdentificationNumber = shipmentResponse.getShipmentResults()
								.getShipmentIdentificationNumber();
					}
				}
				processAllResponse(entry.getKey(), shipmentResponse);
			} catch (HttpClientErrorException httpClientException) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
			} catch (Exception ex) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				applicationErrorHandler(ex);
			} finally {
				cleanup();
			}
			log.info("\n");
		}
	}

	/**
	 * getLabelRecoveryResponse method used for process label recovery request and
	 * getting response
	 */
	private void getLabelRecoveryResponse() {

		for (Map.Entry<String, List<String>> entry : appConfig.getLabelRecoveryScenarioProperties().entrySet()) {
			try {
				LABELRECOVERYRequestWrapper labelRecoveryRequest = Util.createRequestFromJsonFile(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
						LABELRECOVERYRequestWrapper.class, appConfig);

				final String transId = UUID.randomUUID().toString().replaceAll("-", "");

				final ShipApi shipApi = getShipApi(restTemplate, appConfig);
				LABELRECOVERYResponseWrapper labelrecoveryResponseWrapper = shipApi.labelRecovery(
						appConfig.getShippingVersion(), labelRecoveryRequest, transId, appConfig.getTransactionSrc());

				processAllResponse(entry.getKey(), labelrecoveryResponseWrapper.getLabelRecoveryResponse());
			} catch (HttpClientErrorException httpClientException) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
			} catch (Exception ex) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				applicationErrorHandler(ex);
			} finally {
				cleanup();
			}
			log.info("\n");
		}
	}

	/**
	 * getVoidShipmentResponse used for deleting based on tracking number
	 */
	public void getVoidShipmentResponse() {

		try {
			final ShipApi shipApi = getShipApi(restTemplate, appConfig);
			final String transId = UUID.randomUUID().toString().replace("-", "");
			VOIDSHIPMENTResponseWrapper voidshipmentResponseWrapper = shipApi.voidShipment(
					appConfig.getShippingVersion(), shipmentIdentificationNumber, transId,
					appConfig.getTransactionSrc(), trackingNumber);
			processAllResponse("VoidShipmentResponseSucess", voidshipmentResponseWrapper.getVoidShipmentResponse());
		} catch (HttpClientErrorException httpClientException) {
			log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
			log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
		} catch (Exception ex) {
			log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
			applicationErrorHandler(ex);
		} finally {
			cleanup();
		}
		log.info("\n");
	}

	/**
	 * initialize ship api and return shipApi
	 *
	 * @param restTemplate
	 * @param appConfig
	 * @return
	 */
	public ShipApi getShipApi(final RestTemplate restTemplate, final AppConfig appConfig) {

		final String accessToken = Util.getAccessToken(appConfig, restTemplate);
		ShipApi shipApi = api.get();
		if (null == shipApi) {
			shipApi = new ShipApi(new ApiClient(restTemplate));
			shipApi.getApiClient().setBasePath(appConfig.getShippingBaseUrl());
			api.set(shipApi);
		}
		shipApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		return shipApi;
	}

	public static void processAllResponse(final String scenarioName, final Object object) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			log.info("Scenario name: {}, response[{}]", scenarioName, mapper.writeValueAsString(object));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cleanup() {
		ShipApi shipApi = api.get();
		if (null != shipApi) {
			api.remove();
		}
	}

	private void applicationErrorHandler(Exception ex) {
		log.warn("failed to complete request", ex);
	}
}

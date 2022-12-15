package com.ups.api.app;



import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.openapitools.addressValidation.client.ApiClient;
import org.openapitools.addressValidation.client.api.AddressValidationApi;
import org.openapitools.addressValidation.client.model.XAVRequestWrapper;
import org.openapitools.addressValidation.client.model.XAVResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ups.api.AddressValidationApplication;
import com.ups.api.app.AddressValidation;
import com.ups.api.app.AppConfig;
import com.ups.api.app.tool.Util;


@SpringBootTest(classes = AddressValidationApplication.class)
public class AddressValidationAppTest {
	@Autowired
	AppConfig appConfig;
	
	@Autowired
	RestTemplate restTemplate;

	private String SUCCESS_CODE="1";

	private String SUCCESS_DESC="Success";

	@Test
    void testMain() {
		assertDoesNotThrow(() -> {
	        AddressValidationApplication.main(new String[]{
	                "--spring.main.web-environment=false"
	        });
		});
    }
	@Test
	public void allJsonFileExist() throws ClassNotFoundException {
		for(Map.Entry<String, List<String>> entry : this.appConfig.getScenarioProperties().entrySet()) {
			Object request =  Util.createRequestFromJsonFile(
                entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
                XAVRequestWrapper.class);
			assertNotNull(request); 
			assertTrue(request instanceof XAVRequestWrapper);
		}
	}

	@Test
	 void testJsonFileCreateThrowsIllegalStateException() {
    Throwable exception = assertThrows(Exception.class, () -> Util.createRequestFromJsonFile(null,AddressValidation.class));
    assertSame(IllegalStateException.class, exception.getClass());
	}
	
	@Test
	public void scenarioSyntax() throws ClassNotFoundException {
		Map<String, List<String>> mapToRequestInfo = this.appConfig.getScenarioProperties();
		for(Map.Entry<String, List<String>> entry : mapToRequestInfo.entrySet()) {
			final String scenarioName = entry.getKey();
			final String jsonFileName = entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
			final String className = entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_CLASS_NAME);
			assertNotNull(scenarioName);
			assertNotNull(jsonFileName);
			assertNotNull(className);
			
			Class<?> classType = Class.forName(className);
			assertTrue(classType instanceof Class);
		}
	}
	
	@Test
	public void getAccessToken() {
		String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
		assertNotNull(accessToken);
	}
	
	@Test
	public void doAddressValidation() throws JsonProcessingException {
		String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
		AddressValidationApi addressValidationApi = new AddressValidationApi(new ApiClient(this.restTemplate));
		addressValidationApi.getApiClient().setBasePath(this.appConfig.getAddressValidationBaseUrl());
		addressValidationApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        final String addressValidationSuccessJsonFileName = this.appConfig.getScenarioProperties().
        get(AppConfig.ADDRESS_VALIDATION_SUCCESS_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create XAV Request from a pre-determined json file
		XAVRequestWrapper xavRequestWrapper = Util.createRequestFromJsonFile(
			addressValidationSuccessJsonFileName,
			XAVRequestWrapper.class);

    // Get a Address Validation result
	XAVResponseWrapper xavResponseWrapper = addressValidationApi
	.addressValidation(this.appConfig.getAddressValidationReqOption(), this.appConfig.getAddressValidationVersion(),
			xavRequestWrapper,null,null);


		assertNotNull(xavResponseWrapper);
		assertNotNull(xavResponseWrapper.getXaVResponse());
		assertNotNull(xavResponseWrapper.getXaVResponse().getResponse());
		assertEquals(xavResponseWrapper.getXaVResponse().getResponse().getResponseStatus().getCode(),this.SUCCESS_CODE);
		assertEquals(xavResponseWrapper.getXaVResponse().getResponse().getResponseStatus().getDescription(),this.SUCCESS_DESC);
	}

	@Test
	public void testUnClassifiedAddressValidation() throws JsonProcessingException {
		String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
		AddressValidationApi addressValidationApi = new AddressValidationApi(new ApiClient(this.restTemplate));
		addressValidationApi.getApiClient().setBasePath(this.appConfig.getAddressValidationBaseUrl());
		addressValidationApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        final String unClassifiedAddressValidationJsonFileName = this.appConfig.getScenarioProperties().
        get(AppConfig.UNCLASSIFIED_ADDRESS_VALIDATION_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create XAV Request from a pre-determined json file
		XAVRequestWrapper xavRequestWrapper = Util.createRequestFromJsonFile(
			unClassifiedAddressValidationJsonFileName,
			XAVRequestWrapper.class);

    // Get a Address Validation result
	XAVResponseWrapper xavResponseWrapper = addressValidationApi
	.addressValidation(this.appConfig.getAddressValidationReqOption(), this.appConfig.getAddressValidationVersion(),
			xavRequestWrapper,null,null);


		assertNotNull(xavResponseWrapper);
		assertNotNull(xavResponseWrapper.getXaVResponse());
		assertNotNull(xavResponseWrapper.getXaVResponse().getResponse());
		assertEquals(xavResponseWrapper.getXaVResponse().getResponse().getResponseStatus().getCode(),this.SUCCESS_CODE);
		assertEquals(xavResponseWrapper.getXaVResponse().getResponse().getResponseStatus().getDescription(),this.SUCCESS_DESC);
		assertNotNull(xavResponseWrapper.getXaVResponse().getAddressClassification());
		assertEquals(xavResponseWrapper.getXaVResponse().getAddressClassification().getCode(),"0");
		assertEquals(xavResponseWrapper.getXaVResponse().getAddressClassification().getDescription(),"Unknown");
	}
	@Test
	public void testCommercialAddressValidation() throws JsonProcessingException {
		String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
		AddressValidationApi addressValidationApi = new AddressValidationApi(new ApiClient(this.restTemplate));
		addressValidationApi.getApiClient().setBasePath(this.appConfig.getAddressValidationBaseUrl());
		addressValidationApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        final String commercialAddressValidationJsonFileName = this.appConfig.getScenarioProperties().
        get(AppConfig.COMMERCIAL_ADDRESS_VALIDATION_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create XAV Request from a pre-determined json file
		XAVRequestWrapper xavRequestWrapper = Util.createRequestFromJsonFile(
			commercialAddressValidationJsonFileName,
			XAVRequestWrapper.class);

    // Get a Address Validation result
	XAVResponseWrapper xavResponseWrapper = addressValidationApi
	.addressValidation(this.appConfig.getAddressValidationReqOption(), this.appConfig.getAddressValidationVersion(),
			xavRequestWrapper,null,null);


		assertNotNull(xavResponseWrapper);
		assertNotNull(xavResponseWrapper.getXaVResponse());
		assertNotNull(xavResponseWrapper.getXaVResponse().getResponse());
		assertEquals(xavResponseWrapper.getXaVResponse().getResponse().getResponseStatus().getCode(),this.SUCCESS_CODE);
		assertEquals(xavResponseWrapper.getXaVResponse().getResponse().getResponseStatus().getDescription(),this.SUCCESS_DESC);
		assertNotNull(xavResponseWrapper.getXaVResponse().getAddressClassification());
		assertEquals(xavResponseWrapper.getXaVResponse().getAddressClassification().getCode(),"1");
		assertEquals(xavResponseWrapper.getXaVResponse().getAddressClassification().getDescription(),"Commercial");
	}
	@Test
	public void testResidentialAddressValidation() throws JsonProcessingException {
		String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
		AddressValidationApi addressValidationApi = new AddressValidationApi(new ApiClient(this.restTemplate));
		addressValidationApi.getApiClient().setBasePath(this.appConfig.getAddressValidationBaseUrl());
		addressValidationApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        final String residentialAddressValidationJsonFileName = this.appConfig.getScenarioProperties().
        get(AppConfig.RESIDENTIAL_ADDRESS_VALIDATION_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create XAV Request from a pre-determined json file
		XAVRequestWrapper xavRequestWrapper = Util.createRequestFromJsonFile(
			residentialAddressValidationJsonFileName,
			XAVRequestWrapper.class);

    // Get a Address Validation result
	XAVResponseWrapper xavResponseWrapper = addressValidationApi
	.addressValidation(this.appConfig.getAddressValidationReqOption(), this.appConfig.getAddressValidationVersion(),
			xavRequestWrapper,null,null);


		assertNotNull(xavResponseWrapper);
		assertNotNull(xavResponseWrapper.getXaVResponse());
		assertNotNull(xavResponseWrapper.getXaVResponse().getResponse());
		assertEquals(xavResponseWrapper.getXaVResponse().getResponse().getResponseStatus().getCode(),this.SUCCESS_CODE);
		assertEquals(xavResponseWrapper.getXaVResponse().getResponse().getResponseStatus().getDescription(),this.SUCCESS_DESC);
		assertNotNull(xavResponseWrapper.getXaVResponse().getAddressClassification());
		assertEquals(xavResponseWrapper.getXaVResponse().getAddressClassification().getCode(),"2");
		assertEquals(xavResponseWrapper.getXaVResponse().getAddressClassification().getDescription(),"Residential");
	}
}

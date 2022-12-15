package com.ups.api.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.openapitools.rate.client.model.RATERequestWrapper;
import org.openapitools.rate.client.model.RATEResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ups.api.RateApplication;
import com.ups.api.app.AppConfig;
import com.ups.api.app.RateDemo;
import com.ups.api.app.tool.CreateRequestEnricher;
import com.ups.api.app.tool.RateApi;
import com.ups.api.app.tool.Util;

@SpringBootTest(classes = RateApplication.class)
class RateApplicationTests {
	@Autowired
	AppConfig appConfig;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Test
    void testMain() {
		assertDoesNotThrow(() -> {
	        RateApplication.main(new String[]{
	                "--spring.main.web-environment=false",
	                "--spring.autoconfigure.exclude=blahblahblah"
	        });
		});
    }
	
	@Test
	void allJsonFileExist() throws ClassNotFoundException {
		for(Map.Entry<String, List<String>> entry : appConfig.getScenarioProperties().entrySet()) {
			Class<?> classType = Class.forName(entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_CLASS_NAME));
		
			Object request = Util.createRequestFromJsonFile(entry.getKey(),
															entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
															classType,
															appConfig,
															Collections.emptyList());
			assertNotNull(request);
			assertTrue(request instanceof RATERequestWrapper);
			assertNotNull(((RATERequestWrapper)request).getRateRequest());
		}
	}
	
	@Test
	void notExistJsonFile() throws ClassNotFoundException {	
		assertThrows(IllegalStateException.class, () -> {
			Util.createRequestFromJsonFile("Non-existing Json file",
												"unknownFile",
												RATERequestWrapper.class,
												null,
												null);
		});
	}    	

	@Test
	void scenarioSyntax() throws ClassNotFoundException {
		Map<String, List<String>> mapToRequestInfo = appConfig.getScenarioProperties();
		for(Map.Entry<String, List<String>> entry : mapToRequestInfo.entrySet()) {
			final String scenarioName = entry.getKey();
			final String jsonFileName = entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
			final String className = entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_CLASS_NAME);

			assertNotNull(scenarioName);
			assertNotNull(jsonFileName);
			assertNotNull(className);
			
			if(entry.getValue().size() > AppConfig.SCENARIO_PORPERTY_REQUEST_OPTION_PARAMETER) {
				assertNotNull(entry.getValue().get(AppConfig.SCENARIO_PORPERTY_REQUEST_OPTION_PARAMETER));
			}
			
			if(entry.getValue().size() > AppConfig.SCENARIO_PORPERTY_ADDITIONAL_INFO_PARAMETER) {
				assertNotNull(entry.getValue().get(AppConfig.SCENARIO_PORPERTY_ADDITIONAL_INFO_PARAMETER));
			}
			
			Class<?> classType = Class.forName(className);
			assertTrue(classType instanceof Class);
		}
	}
	
	@Test
	void getAccessToken() {
		String accessToken = Util.getAccessToken(appConfig, restTemplate);
		assertNotNull(accessToken);
	}
	
	@Test
	void getRateResponse() throws JsonMappingException, JsonProcessingException {
		RateDemo rateDemo = new RateDemo(restTemplate, appConfig);
		final List<String> simpleRateScenarioParameters = appConfig.getScenarioProperties().
																		get(AppConfig.SIMPLE_RATE_SCENARIO);
		final String simpleRateJsonFileName = simpleRateScenarioParameters.
															get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
			
		RATERequestWrapper rateRequestWrapper = Util.createRequestFromJsonFile(AppConfig.SIMPLE_RATE_SCENARIO,
																								simpleRateJsonFileName,
																								RATERequestWrapper.class,
																								appConfig,
																								Arrays.asList(new CreateRequestEnricher() {}));
		// create a 32 character unique id.
		final String transId = UUID.randomUUID().toString().replaceAll("-", "");
		
		final String requestOption = simpleRateScenarioParameters.get(AppConfig.SCENARIO_PORPERTY_REQUEST_OPTION_PARAMETER);
		String additionalInfo = null;
		if(simpleRateScenarioParameters.size() > AppConfig.SCENARIO_PORPERTY_ADDITIONAL_INFO_PARAMETER) {
			additionalInfo = simpleRateScenarioParameters.get(AppConfig.SCENARIO_PORPERTY_ADDITIONAL_INFO_PARAMETER);
		}
		
		final RATEResponseWrapper rateResponseWrapper = rateDemo.sendRequest(rateRequestWrapper,
																						transId,
																						requestOption,
																						additionalInfo);
		assertNotNull(rateRequestWrapper);
		assertNotNull(rateResponseWrapper);
		assertNotNull(rateRequestWrapper.getRateRequest());
		assertNotNull(rateResponseWrapper.getRateResponse());
		assertEquals("failed to get a successful response from server.", "1", rateResponseWrapper.getRateResponse().getResponse().getResponseStatus().getCode());
	}
	
	@Test
	void dayRollForward() {
		Calendar start = new GregorianCalendar();
		Calendar cal = new GregorianCalendar();
		
		Util.dayRoll(cal, 1);
		
		assertTrue(cal.after(start));
	}
	
	@Test
	void dayRollBackward() {
		Calendar start = new GregorianCalendar();
		Calendar cal = new GregorianCalendar();
		
		Util.dayRoll(cal, -1);
		
		assertTrue(cal.before(start));
	}
	
	@Test
	void restTemplateInjection() {
		assertNotNull(restTemplate);
	}
}

package com.ups.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ups.api.app.LandedCostDemo;
import org.junit.jupiter.api.Test;

import org.openapitools.landed.cost.client.api.LandedCostApi;
import org.openapitools.landed.cost.client.model.LANDEDCOSTRequestWrapper;
import org.openapitools.landed.cost.client.model.LANDEDCOSTResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ups.api.app.AppConfig;
import com.ups.api.app.tool.Util;

@SpringBootTest(classes = LandedCostApplication.class)
class LandedCostApplicationTests {
	@Autowired
	AppConfig appConfig;

	@Autowired
	RestTemplate restTemplate;

	@Test
	void testMain() {
		assertDoesNotThrow(() -> {
			LandedCostApplication.main(new String[]{
					"--spring.main.web-environment=false",
					"--spring.autoconfigure.exclude=blahblahblah"
			});
		});
	}

	@Test
	void allJsonFileExist() throws ClassNotFoundException {
		for(Map.Entry<String, List<String>> entry : appConfig.getScenarioProperties().entrySet()) {
			Class<?> classType = Class.forName(entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_CLASS_NAME));

			Object request = Util.createRequestFromJsonFile(
					entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
					LANDEDCOSTRequestWrapper.class,
					appConfig);

			assertNotNull(request);
			assertTrue(request instanceof LANDEDCOSTRequestWrapper);
			assertNotNull(((LANDEDCOSTRequestWrapper)request).getLandedCostRequest());
		}
	}

	@Test
	void notExistJsonFile() throws ClassNotFoundException {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			Util.createRequestFromJsonFile("Non-existing Json file",
					LANDEDCOSTRequestWrapper.class,
					null
					);
		});
	}

	@Test
	 void scenarioSyntax() throws ClassNotFoundException {
		Map<String, List<String>> mapToRequestInfo = appConfig.getScenarioProperties();
		for(Map.Entry<String, List<String>> entry : mapToRequestInfo.entrySet()) {
			final String scenarioName = entry.getKey();
			final String jsonFileName = entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
			final String className = entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_CLASS_NAME);
			assertNotNull(null != scenarioName);
			assertNotNull(null != jsonFileName);
			assertNotNull(null != className);

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
	 void getLANDEDCOSTResponseWrapper() throws JsonProcessingException {
		//String accessToken = Util.getAccessToken(appConfig, restTemplate);

		//final LandedCostApi landedCostApi = LandedCostDemo.initializeLandedCostApi(restTemplate, appConfig.getLandedCostBaseUrl(), accessToken);
		LandedCostDemo  landedCostDemo = new LandedCostDemo(restTemplate, appConfig);

		final String freightShipJsonFileName = appConfig.getScenarioProperties().
				get(AppConfig.LandedCostSuccess).
				get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);

		LANDEDCOSTRequestWrapper landedcostRequestWrapper = Util.createRequestFromJsonFile(
				freightShipJsonFileName,
				LANDEDCOSTRequestWrapper.class,
				appConfig);
		final String transId = UUID.randomUUID().toString().replaceAll("-", "");

		//LANDEDCOSTResponseWrapper landedcostResponseWrapper = landedCostDemo.sendRequest(landedcostRequestWrapper, transId);
		//ShipmentResponse shipmentResponse = shipResponseWrapper.getShipmentResponse();
		//assertNotNull( landedcostResponseWrapper);
		//LandedCostDemo.processResultLandedCostResponse(freightShipJsonFileName, landedcostResponseWrapper.getLandedCostResponse());
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

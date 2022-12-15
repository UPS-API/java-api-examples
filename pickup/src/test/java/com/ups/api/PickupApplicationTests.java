package com.ups.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ups.api.app.AppConfig;
import com.ups.api.app.PickupDemo;
import com.ups.api.app.tool.Util;
import org.junit.jupiter.api.Test;
import org.openapitools.pickup.client.api.PickupApi;
import org.openapitools.pickup.client.model.PICKUPCreationRequestWrapper;
import org.openapitools.pickup.client.model.PICKUPCreationResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = PickupApplication.class)
class PickupApplicationTests {
	@Autowired
	AppConfig appConfig;

	@Autowired
	RestTemplate restTemplate;



	@Test
	void testMain() {
		assertDoesNotThrow(() -> {
			PickupApplication.main(new String[]{
					"--spring.main.web-environment=false",
					"--spring.autoconfigure.exclude=blahblahblah"
			});
		});
	}

	@Test
	void allJsonFileExist() throws ClassNotFoundException {
		for(Map.Entry<String, List<String>> entry : appConfig.getScenarioPickupCreationProperties().entrySet()) {
			Class<?> classType = Class.forName(entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_CLASS_NAME));

			Object request = Util.createRequestFromJsonFile(
					entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
					PICKUPCreationRequestWrapper.class,
					appConfig);

			assertNotNull(request);
			assertTrue(request instanceof PICKUPCreationRequestWrapper);
			assertNotNull(((PICKUPCreationRequestWrapper)request).getPickupCreationRequest());
		}
	}

	@Test
	void notExistJsonFile() throws ClassNotFoundException {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			Util.createRequestFromJsonFile("Non-existing Json file",
					PICKUPCreationRequestWrapper.class,
					null
					);
		});
	}

	@Test
	 void scenarioSyntax() throws ClassNotFoundException {
		Map<String, List<String>> mapToRequestInfo = appConfig.getScenarioPickupCreationProperties();
		for(Map.Entry<String, List<String>> entry : mapToRequestInfo.entrySet()) {
			final String scenarioName = entry.getKey();
			final String jsonFileName = entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
			final String className = entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_CLASS_NAME);
			assertNotNull(scenarioName);
			assertNotNull(jsonFileName);
			assertNotNull( className);

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
	 void getPickupResponse() throws JsonProcessingException {
		String accessToken = Util.getAccessToken(appConfig, restTemplate);

		final PickupApi pickupApi = PickupDemo.initializePickupApi(restTemplate, appConfig);


		final String pickupCrationJsonFileName = appConfig.getScenarioPickupCreationProperties().
				get(AppConfig.PICKUP_CREATION_REQUEST_SUCCESS).
				get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);


		PICKUPCreationRequestWrapper pickupCreationRequestWrapper
				= Util.createRequestFromJsonFile(
				pickupCrationJsonFileName, PICKUPCreationRequestWrapper.class,
				appConfig);
		final String transId = UUID.randomUUID().toString().replaceAll("-", "");

		PICKUPCreationResponseWrapper pickupCreationResponseWrapper =
				pickupApi.pickupCreation(appConfig.getPickupVersion(),
						pickupCreationRequestWrapper,transId, appConfig.getTransactionSrc());
		String prn =
			prn = pickupCreationResponseWrapper.getPickupCreationResponse().getPRN();
		PickupDemo.processAllResponse(pickupCrationJsonFileName, pickupCreationResponseWrapper.getPickupCreationResponse());
		assertNotNull( pickupCreationResponseWrapper);

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

package com.ups.api.app;

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
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.openapitools.pubsub.client.model.PubSubResponseWrapper;
import org.openapitools.pubsub.client.model.PubSubTrackingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.ups.api.PubSubApplication;
import com.ups.api.app.tool.CreateRequestEnricher;
import com.ups.api.app.tool.Util;

@SpringBootTest(classes = PubSubApplication.class)
class PubSubApplicationTests {
	@Autowired
	AppConfig appConfig;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Test
    void testMain() {
		assertDoesNotThrow(() -> {
	        PubSubApplication.main(new String[]{
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
			assertTrue(request instanceof PubSubTrackingRequest);
			assertNotNull(((PubSubTrackingRequest)request).getShipperAccountNumber());
		}
	}
	
	@Test
	void notExistJsonFile() throws ClassNotFoundException {	
		assertThrows(IllegalStateException.class, () -> {
			Util.createRequestFromJsonFile("Non-existing Json file",
					"unknownFile",
					PubSubTrackingRequest.class,
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
	void getPubSubResponse() {
		PubSubDemo tntDemo = new PubSubDemo(restTemplate, appConfig);
			
		final String successJsonFileName = appConfig.getScenarioProperties().
															get(AppConfig.PUB_SUB_SUCCESS_SCENARIO).
															get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
			
		PubSubTrackingRequest pubSubTrackingRequest = Util.createRequestFromJsonFile(AppConfig.PUB_SUB_SUCCESS_SCENARIO,
																								successJsonFileName,
																								PubSubTrackingRequest.class,
																								appConfig,
																								Arrays.asList(new CreateRequestEnricher() {}));

		// create a 32 character unique id.
		final String transId = UUID.randomUUID().toString().replaceAll("-", "");
			
		// Expect a proper pubSub response.
		PubSubResponseWrapper pubSubResponseWrapper = tntDemo.sendRequest(pubSubTrackingRequest, transId, Optional.empty());
		
		assertNotNull(pubSubResponseWrapper);
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
	
	@Test
	void processResponseHandler() {
		assertDoesNotThrow(() -> {
			PubSubDemo pubSubDemo = new PubSubDemo(restTemplate, appConfig);
			pubSubDemo.processResult("testing", new PubSubResponseWrapper());
		});
	}
}

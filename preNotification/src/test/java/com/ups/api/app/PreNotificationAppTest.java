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
import org.openapitools.preNotification.client.model.PRENOTIFICATIONRequestWrapper;
import org.openapitools.preNotification.client.model.PRENOTIFICATIONResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ups.api.PreNotificationApplication;
import com.ups.api.app.tool.Util;

@SpringBootTest(classes = PreNotificationApplication.class)
public class PreNotificationAppTest {
	@Autowired
	AppConfig appConfig;
	
	@Autowired
	RestTemplate restTemplate;

	private static final String SUCCESS_STATUS_CODE="1";

	private static final String SUCCESS_STATUS_DESCRIPTION="Success";
	
	@Test
    void testMain() {
		assertDoesNotThrow(() -> {
	        PreNotificationApplication.main(new String[]{
	                "--spring.main.web-environment=false"
	        });
		});
    }
	
	@Test
	void allJsonFileExist() throws ClassNotFoundException {
		for(Map.Entry<String, List<String>> entry : this.appConfig.getScenarioProperties().entrySet()) {		
			Object request =  Util.createRequestFromJsonFile(
                entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
                PRENOTIFICATIONRequestWrapper.class);
			assertNotNull(request); 
			assertTrue(request instanceof PRENOTIFICATIONRequestWrapper);
		}
	}
	@Test
	 void testJsonFileCreateThrowsIllegalStateException() {
    Throwable exception = assertThrows(Exception.class, () -> Util.createRequestFromJsonFile(null,PRENOTIFICATIONRequestWrapper.class));
    assertSame(IllegalStateException.class, exception.getClass());
	}
	@Test
	void scenarioSyntax() throws ClassNotFoundException {
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
	void getAccessToken() {
		String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
		assertNotNull(accessToken);
	}
	@Test
	void sendPrenotification() throws JsonProcessingException {
		PreNotification preNotification=new PreNotification(this.restTemplate, this.appConfig);
        final String locatorSuccessJsonFileName = this.appConfig.getScenarioProperties().
        get(AppConfig.PRENOTIFICATION_SUCCESS_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create Pre Notification from a pre-determined json file;
        PRENOTIFICATIONRequestWrapper preNotificationRequestWrapper = Util.createRequestFromJsonFile(
            locatorSuccessJsonFileName,
            PRENOTIFICATIONRequestWrapper.class);
    // Get Pre Notification status
	PRENOTIFICATIONResponseWrapper preNotificationResponseWrapper = preNotification.sendRequest(preNotificationRequestWrapper);
		assertNotNull(preNotificationResponseWrapper);
		assertNotNull(preNotificationResponseWrapper.getPreNotificationResponse());
		assertNotNull(preNotificationResponseWrapper.getPreNotificationResponse().getResponse());
		assertNotNull(preNotificationResponseWrapper.getPreNotificationResponse().getResponse().getResponseStatus());
		assertEquals(SUCCESS_STATUS_CODE,preNotificationResponseWrapper.getPreNotificationResponse().getResponse().getResponseStatus().getCode());
		assertEquals(SUCCESS_STATUS_DESCRIPTION,preNotificationResponseWrapper.getPreNotificationResponse().getResponse().getResponseStatus().getDescription());
	}
}

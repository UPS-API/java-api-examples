package com.ups.api.app;



import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.openapitools.locator.client.model.LOCATORRequestWrapper;
import org.openapitools.locator.client.model.LOCATORResponseWrapper;
import org.openapitools.locator.client.model.LocatorRequest;
import org.slf4j.event.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ups.api.LocatorApplication;
import com.ups.api.app.AppConfig;
import com.ups.api.app.Locator;
import com.ups.api.app.tool.Util;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes = LocatorApplication.class)
@Slf4j
public class LocatorAppTest {
	@Autowired
	AppConfig appConfig;
	
	@Autowired
	RestTemplate restTemplate;

	private static final String SUCCESS_STATUS_CODE="1";

	private static final String SUCCESS_STATUS_DESCRIPTION="Success";
	
	@Test
    void testMain() {
		assertDoesNotThrow(() -> {
	        LocatorApplication.main(new String[]{
	                "--spring.main.web-environment=false"
	        });
		});
    }
	
	@Test
	void allJsonFileExist() throws ClassNotFoundException {
		for(Map.Entry<String, List<String>> entry : this.appConfig.getScenarioProperties().entrySet()) {		
			Object request =  Util.createRequestFromJsonFile(
                entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
                LocatorRequest.class,
                this.appConfig);
			assertNotNull(request); 
			assertTrue(request instanceof LocatorRequest);
		}
	}
	@Test
	 void testJsonFileCreateThrowsIllegalStateException() {
    Throwable exception = assertThrows(Exception.class, () -> Util.createRequestFromJsonFile(null,LocatorRequest.class,
	this.appConfig));
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
	void getLocatorResponse() throws JsonProcessingException {
		Locator locator=new Locator(this.restTemplate, this.appConfig);
        final String locatorSuccessJsonFileName = this.appConfig.getScenarioProperties().
        get(AppConfig.LOCATOR_SUCCESS_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create LocatorRequest from a pre-determined json file;
        LocatorRequest locatorRequest = Util.createRequestFromJsonFile(
            locatorSuccessJsonFileName,
            LocatorRequest.class,
            this.appConfig);

    // create a 32 character unique id.
    final String transId = UUID.randomUUID().toString().replaceAll("-", "");
    LOCATORRequestWrapper locatorRequestWrapper = new LOCATORRequestWrapper();
    locatorRequestWrapper.setLocatorRequest(locatorRequest);
    // Get a Locator information
    LOCATORResponseWrapper locatorResponseWrapper = locator.sendRequest(locatorRequestWrapper, transId);

		assertNotNull(locatorResponseWrapper);
		assertNotNull(locatorResponseWrapper.getLocatorResponse());
		assertNotNull(locatorResponseWrapper.getLocatorResponse().getSearchResults());
		assertEquals(SUCCESS_STATUS_CODE,locatorResponseWrapper.getLocatorResponse().getResponse().getResponseStatusCode());
		assertEquals(SUCCESS_STATUS_DESCRIPTION,locatorResponseWrapper.getLocatorResponse().getResponse().getResponseStatusDescription());
		ObjectMapper mapper = new ObjectMapper();
		log.info("locator response: {}",mapper.writeValueAsString(locatorResponseWrapper.getLocatorResponse().getResponse()));
	}
}

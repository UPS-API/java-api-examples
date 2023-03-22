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
import org.openapitools.quantumView.client.model.QUANTUMVIEWRequestWrapper;
import org.openapitools.quantumView.client.model.QUANTUMVIEWResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ups.api.QuantumViewApplication;
import com.ups.api.app.tool.Util;

@SpringBootTest(classes = QuantumViewApplication.class)
public class QuantumViewAppTest {
	@Autowired
	AppConfig appConfig;
	
	@Autowired
	RestTemplate restTemplate;

	private static final String SUCCESS_STATUS_CODE="1";

	private static final String SUCCESS_STATUS_DESCRIPTION="Success";
	
	@Test
    void testMain() {
		assertDoesNotThrow(() -> {
	        QuantumViewApplication.main(new String[]{
	                "--spring.main.web-environment=false"
	        });
		});
    }
	
	@Test
	void allJsonFileExist() throws ClassNotFoundException {
		for(Map.Entry<String, List<String>> entry : this.appConfig.getScenarioProperties().entrySet()) {		
			Object request =  Util.createRequestFromJsonFile(
                entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
                QUANTUMVIEWRequestWrapper.class);
			assertNotNull(request); 
			assertTrue(request instanceof QUANTUMVIEWRequestWrapper);
		}
	}
	@Test
	 void testJsonFileCreateThrowsIllegalStateException() {
    Throwable exception = assertThrows(Exception.class, () -> Util.createRequestFromJsonFile(null,QUANTUMVIEWRequestWrapper.class));
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
	void getQVResponseByFileName() throws JsonProcessingException {
		QuantumView quantumView=new QuantumView(this.restTemplate, this.appConfig);
        final String qyByNameSuccessJsonFileName = this.appConfig.getScenarioProperties().
        get(AppConfig.QUANTUM_VIEW_REQUEST_BY_NAME_SUCCESS_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create Quantum View Request from a pre-determined json file
		QUANTUMVIEWRequestWrapper quantumViewRequestWrapper = Util.createRequestFromJsonFile(
			qyByNameSuccessJsonFileName,
			QUANTUMVIEWRequestWrapper.class);
		// Get Quantum View response
		QUANTUMVIEWResponseWrapper quantumViewResponseWrapper = quantumView.sendRequest(quantumViewRequestWrapper);
		assertNotNull(quantumViewResponseWrapper);
		assertNotNull(quantumViewResponseWrapper.getQuantumViewResponse());
		assertNotNull(quantumViewResponseWrapper.getQuantumViewResponse().getResponse());
		assertEquals(SUCCESS_STATUS_CODE,quantumViewResponseWrapper.getQuantumViewResponse().getResponse().getResponseStatusCode());
		assertEquals(SUCCESS_STATUS_DESCRIPTION,quantumViewResponseWrapper.getQuantumViewResponse().getResponse().getResponseStatusDescription());
	}
	@Test
	void getQVResponseByDateRange() throws JsonProcessingException {
		QuantumView quantumView=new QuantumView(this.restTemplate, this.appConfig);
        final String qyByDateSuccessJsonFileName = this.appConfig.getScenarioProperties().
        get(AppConfig.QUANTUM_VIEW_REQUEST_BY_DATE_RANGE_SUCCESS_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create Quantum View Request from a pre-determined json file
		QUANTUMVIEWRequestWrapper quantumViewRequestWrapper = Util.createRequestFromJsonFile(
			qyByDateSuccessJsonFileName,
			QUANTUMVIEWRequestWrapper.class);
		// Get Quantum View response
		QUANTUMVIEWResponseWrapper quantumViewResponseWrapper = quantumView.sendRequest(quantumViewRequestWrapper);
		assertNotNull(quantumViewResponseWrapper);
		assertNotNull(quantumViewResponseWrapper.getQuantumViewResponse());
		assertNotNull(quantumViewResponseWrapper.getQuantumViewResponse().getResponse());
		assertEquals(SUCCESS_STATUS_CODE,quantumViewResponseWrapper.getQuantumViewResponse().getResponse().getResponseStatusCode());
		assertEquals(SUCCESS_STATUS_DESCRIPTION,quantumViewResponseWrapper.getQuantumViewResponse().getResponse().getResponseStatusDescription());
	}
}

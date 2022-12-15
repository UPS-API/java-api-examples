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
import org.openapitools.dangerousGoods.client.model.AcceptanceAuditPreCheckRequest;
import org.openapitools.dangerousGoods.client.model.ChemicalReferenceDataRequest;
import org.openapitools.dangerousGoods.client.model.DANGEROUSGOODSUTILITYAPCRequestWrapper;
import org.openapitools.dangerousGoods.client.model.DANGEROUSGOODSUTILITYAPCResponseWrapper;
import org.openapitools.dangerousGoods.client.model.DANGEROUSGOODSUTILITYRequestWrapper;
import org.openapitools.dangerousGoods.client.model.DANGEROUSGOODSUTILITYResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ups.api.DangerousGoodsApplication;
import com.ups.api.app.AppConfig;
import com.ups.api.app.DangerousGoods;
import com.ups.api.app.tool.Util;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes = DangerousGoodsApplication.class)
@Slf4j
public class DangerousGoodsAppTest {
	@Autowired
	AppConfig appConfig;
	
	@Autowired
	RestTemplate restTemplate;

	private String SUCCESS_CODE="1";

	private String SUCCESS_STATUS="Success";

	@Test
    void testMain() {
		assertDoesNotThrow(() -> {
	        DangerousGoodsApplication.main(new String[]{
	                "--spring.main.web-environment=false"
	        });
		});
    }
	
	@Test
	public void allJsonFileExist() throws ClassNotFoundException {
		for(Map.Entry<String, List<String>> entry : this.appConfig.getChemicalRefScenarioProperties().entrySet()) {
			Object request =  Util.createRequestFromJsonFile(
                entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
                ChemicalReferenceDataRequest.class);
				assertNotNull(request);
			assertTrue(request instanceof ChemicalReferenceDataRequest);
		}
		for(Map.Entry<String, List<String>> entry : this.appConfig.getPreCheckScenarioProperties().entrySet()) {
			Object request =  Util.createRequestFromJsonFile(
                entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
                AcceptanceAuditPreCheckRequest.class);
			assertNotNull(request);
			assertTrue(request instanceof AcceptanceAuditPreCheckRequest);
		}
	}

	@Test
	public void scenarioSyntax() throws ClassNotFoundException {
		Map<String, List<String>> mapToRequestInfo = this.appConfig.getChemicalRefScenarioProperties();
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
	 void testJsonFileCreateThrowsIllegalStateException() {
    Throwable exception = assertThrows(Exception.class, () -> Util.createRequestFromJsonFile(null,ChemicalReferenceDataRequest.class));
    assertSame(IllegalStateException.class, exception.getClass());
	}
	@Test
	public void getChemicalReferenceData() throws JsonProcessingException {
		DangerousGoods dangerousGoods=new DangerousGoods(this.restTemplate, this.appConfig);
        final String chemicalRefSuccessJsonFileName = this.appConfig.getChemicalRefScenarioProperties().
        get(AppConfig.CHEMICAL_REFER_SUCCESS_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create ChemicalReferenceDataRequest from a pre-determined json file;
		ChemicalReferenceDataRequest chemicalReferenceDataRequest = Util.createRequestFromJsonFile(
			chemicalRefSuccessJsonFileName,
			ChemicalReferenceDataRequest.class);
			DANGEROUSGOODSUTILITYRequestWrapper dangerousRequestWrapper = new DANGEROUSGOODSUTILITYRequestWrapper();
				dangerousRequestWrapper.setChemicalReferenceDataRequest(chemicalReferenceDataRequest);
		// Get a Chemical Reference data
		DANGEROUSGOODSUTILITYResponseWrapper dangerousGoodsResponseWrapper = (DANGEROUSGOODSUTILITYResponseWrapper)dangerousGoods.sendRequest(dangerousRequestWrapper);
		assertNotNull(dangerousGoodsResponseWrapper);
		assertNotNull(dangerousGoodsResponseWrapper.getChemicalReferenceDataResponse());
		assertNotNull(dangerousGoodsResponseWrapper.getChemicalReferenceDataResponse().getResponse());
		assertEquals(dangerousGoodsResponseWrapper.getChemicalReferenceDataResponse().getResponse().getResponseStatus().getCode(),this.SUCCESS_CODE);
		assertEquals(dangerousGoodsResponseWrapper.getChemicalReferenceDataResponse().getResponse().getResponseStatus().getDescription(),this.SUCCESS_STATUS);
		ObjectMapper mapper = new ObjectMapper();
		log.info("Chemical Reference Data response: {}",mapper.writeValueAsString(dangerousGoodsResponseWrapper));
	}

	@Test
	public void acceptanceauditprecheck() throws JsonProcessingException {
		DangerousGoods dangerousGoods=new DangerousGoods(this.restTemplate, this.appConfig);
        final String preCheckSuccessJsonFileName = this.appConfig.getPreCheckScenarioProperties().
        get(AppConfig.PRE_CHECK_SUCCESS_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create AcceptanceAuditPreCheckRequest from a pre-determined json file;
		AcceptanceAuditPreCheckRequest acceptanceAuditPreCheckRequest = Util.createRequestFromJsonFile(
				preCheckSuccessJsonFileName,
				AcceptanceAuditPreCheckRequest.class);
		DANGEROUSGOODSUTILITYAPCRequestWrapper dangerousAPCRequestWrapper=new DANGEROUSGOODSUTILITYAPCRequestWrapper();
		dangerousAPCRequestWrapper.setAcceptanceAuditPreCheckRequest(acceptanceAuditPreCheckRequest);
		// Get a Pre check status
				DANGEROUSGOODSUTILITYAPCResponseWrapper dangerousGoodsAPCResponseWrapper = (DANGEROUSGOODSUTILITYAPCResponseWrapper)dangerousGoods.sendRequest(dangerousAPCRequestWrapper);
		assertNotNull(dangerousGoodsAPCResponseWrapper);
		assertNotNull(dangerousGoodsAPCResponseWrapper.getAcceptanceAuditPreCheckResponse());
		assertNotNull(dangerousGoodsAPCResponseWrapper.getAcceptanceAuditPreCheckResponse().getResponse());
		assertEquals(dangerousGoodsAPCResponseWrapper.getAcceptanceAuditPreCheckResponse().getResponse().getResponseStatus().getCode(),this.SUCCESS_CODE);
		assertEquals(dangerousGoodsAPCResponseWrapper.getAcceptanceAuditPreCheckResponse().getResponse().getResponseStatus().getDescription(),this.SUCCESS_STATUS);
		ObjectMapper mapper = new ObjectMapper();
		log.info("Acceptance Audit Pre Check response: {}",mapper.writeValueAsString(dangerousGoodsAPCResponseWrapper));
	}
}

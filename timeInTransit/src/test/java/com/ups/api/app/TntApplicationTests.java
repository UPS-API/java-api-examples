package com.ups.api.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
import org.openapitools.tnt.client.model.TimeInTransitRequest;
import org.openapitools.tnt.client.model.TimeInTransitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.ups.api.TntApplication;
import com.ups.api.app.tool.CreateRequestEnricher;
import com.ups.api.app.tool.Util;

@SpringBootTest(classes = TntApplication.class)
class TntApplicationTests {
	@Autowired
	AppConfig appConfig;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Test
    void testMain() {
		assertDoesNotThrow(() -> {
	        TntApplication.main(new String[]{
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
			assertTrue(request instanceof TimeInTransitRequest);
			assertEquals("2022-10-07", ((TimeInTransitRequest)request).getShipDate());
		}
	}
	
	@Test
	void notExistJsonFile() throws ClassNotFoundException {	
		assertThrows(IllegalStateException.class, () -> {
			Util.createRequestFromJsonFile("Non-existing Json file",
					"unknownFile",
					TimeInTransitRequest.class,
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
	void getTNTResponse() {
		TNTDemo tntDemo = new TNTDemo(restTemplate, appConfig);
			
		final String tntSuccessJsonFileName = appConfig.getScenarioProperties().
															get(AppConfig.TNT_INTERNATIONAL_SUCCESS_SCENARIO).
															get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
			
		TimeInTransitRequest timeInTransitRequest = Util.createRequestFromJsonFile(AppConfig.TNT_INTERNATIONAL_SUCCESS_SCENARIO,
																								tntSuccessJsonFileName,
																								TimeInTransitRequest.class,
																								appConfig,
																								Arrays.asList(new CreateRequestEnricher() {}));

		// create a 32 character unique id.
		final String transId = UUID.randomUUID().toString().replaceAll("-", "");
			
		// Expect a proper time in transit information for a shipment.
		TimeInTransitResponse timeInTransitResponse = tntDemo.sendRequest(timeInTransitRequest, transId);
		
		assertNotNull(timeInTransitResponse);
		assertNull(timeInTransitResponse.getValidationList());
		assertNotNull(timeInTransitResponse.getEmsResponse());
		assertNotNull(timeInTransitResponse.getEmsResponse().getServices());
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
	void testDutyType() {
		String dutyTypes[][] = {{null, ""},
								{"01", "Dutiable"},
								{"02", "Non Dutiable"},
								{"03", "Low Value"},
								{"09", "Low Value"},
								{"04", "Courier Remission"},
								{"05", "Gift"},
								{"06", "Military"},
								{"07", "Exception"},
								{"08", "Line Release"},
								{"99", "unknown"}};
		
		Arrays.stream(dutyTypes).forEach(dutyType-> {
			final String dutyTypeNumeric = dutyType[0];
			final String dutyTypeString = dutyType[1];
			assertEquals(dutyTypeString, TNTDemo.dutyTypeToString(dutyTypeNumeric));
		});
	}
	
	@Test
	void testBillType() {
		String billTypes[][] = {{null, ""},	
								{"02", "Document"},
								{"03", "Non-Document"},		
								{"04", "WWEF"},
								{"07", "Pallet"},
								{"99", "unknown"}};

		Arrays.stream(billTypes).forEach(billType -> {
			final String billTypeNumeric = billType[0];
			final String billTypeString = billType[1];
			assertEquals(billTypeString, TNTDemo.billTypeToString(billTypeNumeric));
		});
	}
}

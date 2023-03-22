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

import com.ups.api.app.AppConfig;
import com.ups.api.app.ShippingDemo;
import com.ups.api.app.tool.ShipApi;
import com.ups.api.app.tool.Util;
import org.junit.jupiter.api.Test;

import org.openapitools.shipping.client.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest(classes = ShippingApplication.class)
class ShippingApplicationTests {
	@Autowired
    AppConfig appConfig;

	@Autowired
	RestTemplate restTemplate;



	@Test
	void testMain() {
		assertDoesNotThrow(() -> {
			ShippingApplication.main(new String[]{
					"--spring.main.web-environment=false",
					"--spring.autoconfigure.exclude=blahblahblah"
			});
		});
	}

	@Test
	void allJsonFileExist() throws ClassNotFoundException {
		for(Map.Entry<String, List<String>> entry : appConfig.getScenarioProperties().entrySet()) {
			Class<?> classType = Class.forName(entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_CLASS_NAME));

			Object request = Util.createRequestFromJsonFileShipping(
					entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
					SHIPRequestWrapper.class,
					appConfig);
			assertNotNull(request);
			assertTrue(request instanceof SHIPRequestWrapper);
			assertNotNull(((SHIPRequestWrapper)request).getShipmentRequest());
		}
	}

	@Test
	void notExistJsonFile() throws ClassNotFoundException {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			Util.createRequestFromJsonFileShipping("Non-existing Json file",
					SHIPRequestWrapper.class,
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
	 void getShippingResponse() throws JsonProcessingException {
		ShippingDemo shipping = new ShippingDemo(restTemplate,appConfig);
		final ShipApi shipApi = shipping.getShipApi(restTemplate, appConfig);



		final String shippingSuccessJsonFileName = appConfig.getScenarioProperties().
				get(AppConfig.SHIPPING_SUCCESS).
				get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);

		SHIPRequestWrapper shipRequestWrapper = Util.createRequestFromJsonFileShipping(
				shippingSuccessJsonFileName,
				SHIPRequestWrapper.class,
				appConfig);
		final String transId = UUID.randomUUID().toString().replaceAll("-", "");

		SHIPResponseWrapper shipResponseWrapper = Util.jsonResultPreprocess(shipApi.shipment(appConfig.getShippingVersion(), shipRequestWrapper,
				transId,
				appConfig.getTransactionSrc(),
				null),Util.getJsonToObjectConversionMap(),SHIPResponseWrapper.class);
		ShipmentResponse shipmentResponse = shipResponseWrapper.getShipmentResponse();
		assertNotNull( shipResponseWrapper);
		shipping.processAllResponse(shippingSuccessJsonFileName, shipmentResponse);

		String trackingNumber = shipmentResponse.getShipmentResults().getPackageResults().get(0).getTrackingNumber();
        String shipmentIdentificationNumber = shipmentResponse.getShipmentResults().getShipmentIdentificationNumber();

		VOIDSHIPMENTResponseWrapper voidshipmentResponseWrapper =  shipApi.voidShipment(appConfig.getShippingVersion(),
				shipmentIdentificationNumber,
				transId,
				appConfig.getTransactionSrc(),
				trackingNumber);

		assertNotNull(voidshipmentResponseWrapper);
		shipping.processAllResponse(AppConfig.LABEL_RECOVERY_SUCCESS, voidshipmentResponseWrapper.getVoidShipmentResponse());



	}

	@Test
	void getLabelRecoveryResponseSuccess() throws JsonProcessingException {

		ShippingDemo shipping = new ShippingDemo(restTemplate,appConfig);
		final ShipApi shipApi = shipping.getShipApi(restTemplate, appConfig);
		final String shippingSuccessJsonFileName = appConfig.getLabelRecoveryScenarioProperties().
				get(AppConfig.LABEL_RECOVERY_SUCCESS).
				get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);

		LABELRECOVERYRequestWrapper labelRecoveryRequest = Util.createRequestFromJsonFile(
				shippingSuccessJsonFileName,
				LABELRECOVERYRequestWrapper.class,
				appConfig);

		final String transId = UUID.randomUUID().toString().replaceAll("-", "");

		LABELRECOVERYResponseWrapper labelrecoveryResponseWrapper = shipApi.labelRecovery(appConfig.getShippingVersion(),
				labelRecoveryRequest,
				transId,
				appConfig.getTransactionSrc()
		);

		assertNotNull(labelrecoveryResponseWrapper);
		shipping.processAllResponse(shippingSuccessJsonFileName, labelrecoveryResponseWrapper.getLabelRecoveryResponse());
	}

	/*@Test
	public void getVoidShipmentResponse() throws JsonProcessingException {
		String accessToken = Util.getAccessToken(appConfig, restTemplate);


	}*/

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

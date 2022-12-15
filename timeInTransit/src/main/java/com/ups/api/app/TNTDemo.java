package com.ups.api.app;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.openapitools.tnt.client.ApiClient;
import org.openapitools.tnt.client.api.TntApi;
import org.openapitools.tnt.client.model.EmsResponse;
import org.openapitools.tnt.client.model.Services;
import org.openapitools.tnt.client.model.TimeInTransitRequest;
import org.openapitools.tnt.client.model.TimeInTransitResponse;
import org.openapitools.tnt.client.model.ValidationList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ups.api.app.tool.CreateRequestEnricher;
import com.ups.api.app.tool.Util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class TNTDemo implements CommandLineRunner {
	private static final String SCENARIO_NAME_LOG_FORMAT = "TNT Response for scenario: {}";
	
	private final RestTemplate restTemplate;
	private final AppConfig appConfig;
	private static final ThreadLocal<TntApi> api = new ThreadLocal<>();

	@Override
	public void run(String... args) throws Exception {
		// Each iteration will create an instance of TimeInTransitRequest from a pre-determined json file verses
		// creating a TimeInTransitRequest object and calling a setter for particular attribute in an application environment.
		//
		// Run through different TNT request, ie. domestic request, missing origin country request, invalid shipDate.
		for(Map.Entry<String, List<String>> entry : appConfig.getScenarioProperties().entrySet()) {
			try {
				TimeInTransitRequest timeInTransitRequest = Util.createRequestFromJsonFile(entry.getKey(),
																						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
																						TimeInTransitRequest.class,
																						appConfig,
																						Arrays.asList(new CreateRequestEnricher() {}));
				// create a 32 character unique id.
				final String transId = UUID.randomUUID().toString().replace("-", "");
				
				// Get a time in transit information for a particular shipment.
				TimeInTransitResponse timeInTransitResponse = sendRequest(timeInTransitRequest, transId);
				
				processResult(entry.getKey(), timeInTransitResponse);
			} catch(HttpClientErrorException httpClientException) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
			} catch(Exception ex) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				applicationErrorHandler(ex);
			} finally {
				cleanup();
			}
			log.info("\n");
		}
	}

	public TimeInTransitResponse sendRequest(final TimeInTransitRequest timeInTransitRequest, final String transId) {
		log.info("transId: {}", transId);
		final String accessToken = Util.getAccessToken(appConfig, restTemplate);
        TntApi tntApi = api.get();
        if(null == tntApi) {
                tntApi = new TntApi(new ApiClient(restTemplate));
                tntApi.getApiClient().setBasePath(appConfig.getTntBaseUrl());
                api.set(tntApi);
        }

        tntApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		return tntApi.timeInTransit(appConfig.getTntVersion(),
										transId,
										appConfig.getTransactionSrc(),
										timeInTransitRequest);
	}
	
	private void cleanup() {
        TntApi tntApi = api.get();
        if(null != tntApi) {
                api.remove();
        }
	}
	
	private void processResult(final String scenarioName, final TimeInTransitResponse timeInTransitResponse) {
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			log.info("response json: [{}]", objectMapper.writeValueAsString(timeInTransitResponse));
		}catch(Exception ex) {
			log.info("response: {}", timeInTransitResponse.toString());
		}
		
		log.info(SCENARIO_NAME_LOG_FORMAT, scenarioName);
		
		printValidationInfo(timeInTransitResponse.getValidationList());
		printEmsResponseInfo(timeInTransitResponse.getEmsResponse());
	}
	
	private void printValidationInfo(final ValidationList validationList) {
		if(null == validationList) {	
			return;
		}
			
		log.info("\tValidation Info:");
		log.info("\t\torigin ambiguous: {}", validationList.getOriginAmbiguous());
		log.info("\t\tdestination ambiguous: {}", validationList.getDestinationAmbiguous());
		
		if(null != validationList.getInvalidFieldList() && null != validationList.getInvalidFieldListCodes()) {
			Iterator<String> fieldItr = validationList.getInvalidFieldList().iterator();
			Iterator<String> codeItr = validationList.getInvalidFieldListCodes().iterator();
			
			while(fieldItr.hasNext()) {
				if(codeItr.hasNext()) {
					log.info("\t\tinvalid field name={}, error code={}", fieldItr.next(), codeItr.next());
				} else {
					log.info("\t\tinvalid field name={}", fieldItr.next());
				}
			}
		}
	}
	
	private void printEmsResponseInfo(final EmsResponse emsResponse) {
		if(null == emsResponse) {
			return;
		}
		
		// print some EMS response info.
		log.info("\tEMS Response:");
		log.info("\t\tshipDate: {}", emsResponse.getShipDate());
		log.info("\t\tshipTime: {}", emsResponse.getShipTime());
		log.info("\t\tbillType: {}", billTypeToString(emsResponse.getBillType()));
		
		if(emsResponse.getDutyType() != null) {
			log.info("\t\tdutyType: {}", dutyTypeToString(emsResponse.getDutyType()));
		}
		log.info("\t\tgaranteeSuspended: {}", emsResponse.getGuaranteeSuspended());
		
		List<Services> services = emsResponse.getServices();
		log.info("\t\tnumber of service avaliable={}", services.size());
		
		services.forEach(service->{
			log.info("\t\t\tdescription: {}", service.getServiceLevelDescription());
			log.info("\t\t\tdeliveryDate: {}", service.getDeliveryDate());
			log.info("\t\t\ttotalTransitDays: {}", service.getTotalTransitDays());
			if(null != service.getPoddate()) {
				log.info("\t\t\tpoddate: {}", service.getPoddate());
			}
			log.info("\t\t\tguaranteeIndicator: {}", service.getGuaranteeIndicator().equals("1")?"Guarantee":"Not Guarantee");
		});
	}
	
	static String billTypeToString(final String billTypeCode) {
		if(null == billTypeCode) {
			return "";
		}
		switch(billTypeCode) {
		case "02":
			return "Document";
		case "03":
			return "Non-Document";
		case "04":
			return "WWEF";
		case "07":
			return "Pallet";
		default:
			return "unknown";
		}
	}
	
	static String dutyTypeToString(final String dutyTypeCode) {
		if(null == dutyTypeCode) {
			return "";
		}
		switch(dutyTypeCode) {
		case "01":
			return "Dutiable";
		case "02":
			return "Non Dutiable";
		case "03":
		case "09":
			return "Low Value";
		case "04":
			return "Courier Remission";
		case "05":
			return "Gift";
		case "06":
			return "Military";
		case "07":
			return "Exception";
		case "08":
			return "Line Release";
		default:
			return "unknown";
		}
	}
	
	private void applicationErrorHandler(Exception ex) {
		log.warn("failed to complete request", ex);
	}
}

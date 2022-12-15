package com.ups.api.app;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.openapitools.dangerousGoods.client.ApiClient;
import org.openapitools.dangerousGoods.client.api.AcceptanceAuditPrecheckApi;
import org.openapitools.dangerousGoods.client.api.ChemicalReferenceDataApi;
import org.openapitools.dangerousGoods.client.model.AcceptanceAuditPreCheckRequest;
import org.openapitools.dangerousGoods.client.model.ChemicalReferenceDataRequest;
import org.openapitools.dangerousGoods.client.model.DANGEROUSGOODSUTILITYAPCRequestWrapper;
import org.openapitools.dangerousGoods.client.model.DANGEROUSGOODSUTILITYAPCResponseWrapper;
import org.openapitools.dangerousGoods.client.model.DANGEROUSGOODSUTILITYRequestWrapper;
import org.openapitools.dangerousGoods.client.model.DANGEROUSGOODSUTILITYResponseWrapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ups.api.app.tool.Util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class DangerousGoods implements CommandLineRunner {

	private static final String SCENARIO_NAME_LOG_FORMAT = "Response for scenario: {}";

	RestTemplate restTemplate;

	AppConfig appConfig;

	private static final ThreadLocal<ChemicalReferenceDataApi> chemicalApi = new ThreadLocal<>();

	private static final ThreadLocal<AcceptanceAuditPrecheckApi> preCheckApi = new ThreadLocal<>();

	@Override
	public void run(String... args) throws Exception {
		try {
			// Get ChemicalReferenceData response
			this.getChemicalReferenceData();
			// Get Acceptance Audit Pre Check Status
			this.acceptanceauditprecheck();

		} catch (Exception ex) {
			this.applicationErrorHandler(ex);
		}
	}

	private void getChemicalReferenceData() {

		// run through different ChemicalReferenceData request
		for (Map.Entry<String, List<String>> entry : this.appConfig.getChemicalRefScenarioProperties().entrySet()) {
			try {
				// Create Chemical Reference Data Request from a pre-determined json file
				ChemicalReferenceDataRequest chemicalReferenceDataRequest = Util.createRequestFromJsonFile(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
						ChemicalReferenceDataRequest.class);
				DANGEROUSGOODSUTILITYRequestWrapper dangerousRequestWrapper = new DANGEROUSGOODSUTILITYRequestWrapper();
				dangerousRequestWrapper.setChemicalReferenceDataRequest(chemicalReferenceDataRequest);
				// Get a Chemical Reference data
				DANGEROUSGOODSUTILITYResponseWrapper dangerousGoodsResponseWrapper = (DANGEROUSGOODSUTILITYResponseWrapper)this.sendRequest(dangerousRequestWrapper);
				processResult(entry.getKey(), dangerousGoodsResponseWrapper.getChemicalReferenceDataResponse());
			} catch(HttpClientErrorException httpClientException) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
			} catch(Exception ex) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				this.applicationErrorHandler(ex);
			} finally {
				this.cleanUpChemicalApi();
			}
			log.info("\n");
		}
	}

	private void acceptanceauditprecheck() {

		// run through different AcceptanceAuditPreCheck request
		for (Map.Entry<String, List<String>> entry : this.appConfig.getPreCheckScenarioProperties().entrySet()) {
			try {
				// Create AcceptanceAuditPreCheckRequest from a pre-determined json file
				AcceptanceAuditPreCheckRequest acceptanceAuditPreCheckRequest = Util.createRequestFromJsonFile(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
						AcceptanceAuditPreCheckRequest.class);
				DANGEROUSGOODSUTILITYAPCRequestWrapper dangerousAPCRequestWrapper = new DANGEROUSGOODSUTILITYAPCRequestWrapper();
				dangerousAPCRequestWrapper.setAcceptanceAuditPreCheckRequest(acceptanceAuditPreCheckRequest);
				// Get a Pre check status
				DANGEROUSGOODSUTILITYAPCResponseWrapper dangerousGoodsAPCResponseWrapper = (DANGEROUSGOODSUTILITYAPCResponseWrapper)this.sendRequest(dangerousAPCRequestWrapper);
				processResult(entry.getKey(), dangerousGoodsAPCResponseWrapper.getAcceptanceAuditPreCheckResponse());
			} catch(HttpClientErrorException httpClientException) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
			} catch(Exception ex) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				this.applicationErrorHandler(ex);
			} finally {
				this.cleanUpPreCheckApi();
			}
			log.info("\n");
		}

	}
	public Object sendRequest(final Object object) {
		// create a 32 character unique id.
		String randomId = UUID.randomUUID().toString();
		final String transId = randomId.replace("-", "");
		log.info("transId: {}", transId);
		final String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
		if(object instanceof DANGEROUSGOODSUTILITYRequestWrapper){
			ChemicalReferenceDataApi chemicalReferenceDataApi = chemicalApi.get();
			if(null == chemicalReferenceDataApi) {
				chemicalReferenceDataApi = new ChemicalReferenceDataApi(new ApiClient(this.restTemplate));
				chemicalReferenceDataApi.getApiClient().setBasePath(this.appConfig.getDangerousGoodsBaseUrl());
				chemicalApi.set(chemicalReferenceDataApi);
			}
	
			chemicalReferenceDataApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
			return chemicalReferenceDataApi
			.chemicalReferenceData(transId, this.appConfig.getTransactionSrc(),
					this.appConfig.getDangerousGoodsVersion(), (DANGEROUSGOODSUTILITYRequestWrapper)object);
		}else if(object instanceof DANGEROUSGOODSUTILITYAPCRequestWrapper){
			AcceptanceAuditPrecheckApi acceptanceAuditPreCheck = preCheckApi.get();
			if(null == acceptanceAuditPreCheck) {
				acceptanceAuditPreCheck = new AcceptanceAuditPrecheckApi(new ApiClient(this.restTemplate));
				acceptanceAuditPreCheck.getApiClient().setBasePath(this.appConfig.getDangerousGoodsBaseUrl());
				preCheckApi.set(acceptanceAuditPreCheck);
			}
	
			acceptanceAuditPreCheck.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
			return acceptanceAuditPreCheck
			.acceptanceAuditPreCheck(transId, this.appConfig.getTransactionSrc(),
					this.appConfig.getDangerousGoodsVersion(), (DANGEROUSGOODSUTILITYAPCRequestWrapper)object);
		}

		return null;
      
	}
	
	private void cleanUpChemicalApi() {
        ChemicalReferenceDataApi chemicalReferenceDataApi = chemicalApi.get();
        if(null != chemicalReferenceDataApi) {
			chemicalApi.remove();
        }
	}

	private void cleanUpPreCheckApi() {
        AcceptanceAuditPrecheckApi acceptanceAuditPrecheckApi = preCheckApi.get();
        if(null != acceptanceAuditPrecheckApi) {
			preCheckApi.remove();
        }
	}

	/**
	 * @param scenarioName
	 * @param response
	 */
	public static void processResult(final String scenarioName, final Object response) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			// convert user object to json string and return it
			log.info("Scenario name: {}, response[{}]", scenarioName, mapper.writeValueAsString(response));
		} catch (Exception e) {
			log.warn("Unable to process result {}", e.getMessage());
		}
	}

	private void applicationErrorHandler(Exception ex) {
		log.warn("failed to complete request: {}", ex.getMessage());
	}
}

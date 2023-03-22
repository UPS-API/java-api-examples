package com.ups.api.app;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.openapitools.paperlessDocuments.client.ApiClient;
import org.openapitools.paperlessDocuments.client.api.DeleteDocumentsApi;
import org.openapitools.paperlessDocuments.client.api.UploadDocumentsApi;
import org.openapitools.paperlessDocuments.client.api.UploadImageApi;
import org.openapitools.paperlessDocuments.client.model.PAPERLESSDOCUMENTDeleteResponseWrapper;
import org.openapitools.paperlessDocuments.client.model.PAPERLESSDOCUMENTRequestWrapper;
import org.openapitools.paperlessDocuments.client.model.PAPERLESSDOCUMENTResponseWrapper;
import org.openapitools.paperlessDocuments.client.model.PAPERLESSDOCUMENTUploadRequestWrapper;
import org.openapitools.paperlessDocuments.client.model.PAPERLESSDOCUMENTUploadResponseWrapper;
import org.openapitools.paperlessDocuments.client.model.UploadResponse;
import org.openapitools.paperlessDocuments.client.model.UploadResponseFormsHistoryDocumentID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ups.api.app.tool.CreateRequestEnricher;
import com.ups.api.app.tool.Util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class PaperlessDocuments implements CommandLineRunner {

	private static final String SCENARIO_NAME_LOG_FORMAT = "Response for scenario: {}";

	private static final String HTTP_EXCEPTION_LOG_FORMAT = "Http exception - ";

	RestTemplate restTemplate;

	AppConfig appConfig;

	private static final ThreadLocal<UploadImageApi> uploadImageApi = new ThreadLocal<>();

	private static final ThreadLocal<UploadDocumentsApi> uploadDocumentsApi = new ThreadLocal<>();

	private static final ThreadLocal<DeleteDocumentsApi> deleteDocumentsApi = new ThreadLocal<>();

	private static final String BEARER = "Bearer ";

	@Override
	public void run(String... args) throws Exception {
		try {
			// Get Upload documents response
			this.uploadDocuments();
			// Get Push Image to repository response
			this.pushImageToRepo();
			// Get Delete documents status
			this.deleteDocuments();

		} catch (Exception ex) {
			this.applicationErrorHandler(ex);
		}
	}

	private void uploadDocuments() {

		// run through different Paperless Documents Upload request
		for (Map.Entry<String, List<String>> entry : this.appConfig.getUploadDocumentScenarioProperties().entrySet()) {
			try {
				// Create Paperless Documents Upload Request from a pre-determined json file
				PAPERLESSDOCUMENTUploadRequestWrapper paperlessUploadRequestWrapper = Util.createRequestFromJsonFile(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
						PAPERLESSDOCUMENTUploadRequestWrapper.class,this.appConfig,null);
				// Get Upload documents status
				PAPERLESSDOCUMENTUploadResponseWrapper paperlessUploadResponseWrapper = (PAPERLESSDOCUMENTUploadResponseWrapper)this.sendRequest(paperlessUploadRequestWrapper);
				UploadResponse uploadResponse=paperlessUploadResponseWrapper.getUploadResponse();
				UploadResponseFormsHistoryDocumentID formsHistoryDocumentID=uploadResponse.getFormsHistoryDocumentID();
				processResult(entry.getKey(), uploadResponse);
				if(null!=paperlessUploadResponseWrapper&&null!=uploadResponse){
					String documentID=null;
					if(formsHistoryDocumentID.getDocumentID() instanceof List){
						documentID=((List<String>)formsHistoryDocumentID.getDocumentID()).get(0);
					}else{
						documentID=(String)formsHistoryDocumentID.getDocumentID();
					}
					this.appConfig.setDocumentId(documentID);
				}
			} catch(HttpClientErrorException httpClientException) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				log.warn(HTTP_EXCEPTION_LOG_FORMAT + httpClientException.getStatusCode(), httpClientException);
			} catch(Exception ex) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				this.applicationErrorHandler(ex);
			} finally {
				this.cleanUpUploadDocumentApi();
			}
			log.info("\n");
		}
	}

	private void pushImageToRepo() {

		// run through different Paperless Documents request
		for (Map.Entry<String, List<String>> entry : this.appConfig.getUploadImageScenarioProperties().entrySet()) {
			try {
				// Create Paperless Documents Request from a pre-determined json file
				PAPERLESSDOCUMENTRequestWrapper paperlessRequestWrapper = Util.createRequestFromJsonFile(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
						PAPERLESSDOCUMENTRequestWrapper.class,this.appConfig,new CreateRequestEnricher() {});
				// Get Upload Image status
				PAPERLESSDOCUMENTResponseWrapper paperlessResponseWrapper = (PAPERLESSDOCUMENTResponseWrapper)this.sendRequest(paperlessRequestWrapper);
				processResult(entry.getKey(), paperlessResponseWrapper.getPushToImageRepositoryResponse());
			} catch(HttpClientErrorException httpClientException) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				log.warn(HTTP_EXCEPTION_LOG_FORMAT + httpClientException.getStatusCode(), httpClientException);
			} catch(Exception ex) {
				log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
				this.applicationErrorHandler(ex);
			} finally {
				this.cleanUpUploadImageApi();
			}
			log.info("\n");
		}
	}

	private void deleteDocuments() {	
			try {
				// Prepare Delete Document api access.
				DeleteDocumentsApi deleteApi = deleteDocumentsApi.get();
				if(null == deleteApi) {
					deleteApi = new DeleteDocumentsApi(new ApiClient(this.restTemplate));
					deleteApi.getApiClient().setBasePath(this.appConfig.getPaperlessDocumentsBaseUrl());
					deleteDocumentsApi.set(deleteApi);
				}
				final String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
				deleteApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, BEARER + accessToken);	
				// create a 32 character unique id.
				String randomId = UUID.randomUUID().toString();
				final String transId = randomId.replace("-", "");
				// Delete document status
				PAPERLESSDOCUMENTDeleteResponseWrapper paperlessDeleteResponseWrapper = deleteApi
						.delete(this.appConfig.getPaperlessDocumentsVersion(), this.appConfig.getShipperNumber(),
						this.appConfig.getDocumentId(),transId,this.appConfig.getTransactionSrc());

				processResult("Delete document", paperlessDeleteResponseWrapper.getDeleteResponse());
			} catch(HttpClientErrorException httpClientException) {
				log.warn(HTTP_EXCEPTION_LOG_FORMAT + httpClientException.getStatusCode(), httpClientException);
			} catch(Exception ex) {
				this.applicationErrorHandler(ex);
			} finally {
				this.cleanUpDeleteApi();
			}

	}
	public Object sendRequest(final Object object) {
		// create a 32 character unique id.
		String randomId = UUID.randomUUID().toString();
		final String transId = randomId.replace("-", "");
		log.info("transId: {}", transId);
		final String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
		if(object instanceof PAPERLESSDOCUMENTUploadRequestWrapper){
			UploadDocumentsApi uploadApi = uploadDocumentsApi.get();
			if(null == uploadApi) {
				uploadApi = new UploadDocumentsApi(new ApiClient(this.restTemplate));
				uploadApi.getApiClient().setBasePath(this.appConfig.getPaperlessDocumentsBaseUrl());
				uploadDocumentsApi.set(uploadApi);
			}
	
			uploadApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, BEARER + accessToken);
			return uploadApi
			.upload(this.appConfig.getPaperlessDocumentsVersion(), this.appConfig.getShipperNumber(),
			(PAPERLESSDOCUMENTUploadRequestWrapper)object,transId,this.appConfig.getTransactionSrc());
		}else if(object instanceof PAPERLESSDOCUMENTRequestWrapper){
			UploadImageApi pushImageApi = uploadImageApi.get();
			if(null == pushImageApi) {
				pushImageApi = new UploadImageApi(new ApiClient(this.restTemplate));
				pushImageApi.getApiClient().setBasePath(this.appConfig.getPaperlessDocumentsBaseUrl());
				uploadImageApi.set(pushImageApi);
			}	
			pushImageApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, BEARER + accessToken);
			return pushImageApi
			.pushToImageRepository(this.appConfig.getPaperlessDocumentsVersion(), this.appConfig.getShipperNumber(),
			(PAPERLESSDOCUMENTRequestWrapper)object,transId,this.appConfig.getTransactionSrc());
		}

		return null;
      
	}
	
	private void cleanUpUploadDocumentApi() {
        UploadDocumentsApi uploadApi = uploadDocumentsApi.get();
        if(null != uploadApi) {
			uploadDocumentsApi.remove();
        }
	}

	private void cleanUpUploadImageApi() {
        UploadImageApi pushImageApi = uploadImageApi.get();
        if(null != pushImageApi) {
			uploadImageApi.remove();
        }
	}

	private void cleanUpDeleteApi() {
        DeleteDocumentsApi deleteApi = deleteDocumentsApi.get();
        if(null != deleteApi) {
			deleteDocumentsApi.remove();
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

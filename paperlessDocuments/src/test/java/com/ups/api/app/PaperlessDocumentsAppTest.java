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
import org.openapitools.paperlessDocuments.client.ApiClient;
import org.openapitools.paperlessDocuments.client.api.DeleteDocumentsApi;
import org.openapitools.paperlessDocuments.client.model.PAPERLESSDOCUMENTDeleteResponseWrapper;
import org.openapitools.paperlessDocuments.client.model.PAPERLESSDOCUMENTRequestWrapper;
import org.openapitools.paperlessDocuments.client.model.PAPERLESSDOCUMENTResponseWrapper;
import org.openapitools.paperlessDocuments.client.model.PAPERLESSDOCUMENTUploadRequestWrapper;
import org.openapitools.paperlessDocuments.client.model.PAPERLESSDOCUMENTUploadResponseWrapper;
import org.openapitools.paperlessDocuments.client.model.UploadResponse;
import org.openapitools.paperlessDocuments.client.model.UploadResponseFormsHistoryDocumentID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ups.api.PaperlessDocumentsApplication;
import com.ups.api.app.tool.CreateRequestEnricher;
import com.ups.api.app.tool.Util;

@SpringBootTest(classes = PaperlessDocumentsApplication.class)
public class PaperlessDocumentsAppTest {
	@Autowired
	AppConfig appConfig;
	
	@Autowired
	RestTemplate restTemplate;

	private String SUCCESS_CODE="1";

	private String SUCCESS_STATUS="Success";
	private final String BEARER = "Bearer ";

	@Test
    void testMain() {
		assertDoesNotThrow(() -> {
	        PaperlessDocumentsApplication.main(new String[]{
	                "--spring.main.web-environment=false"
	        });
		});
    }
	
	@Test
	public void allJsonFileExist() throws ClassNotFoundException {
		for(Map.Entry<String, List<String>> entry : this.appConfig.getUploadDocumentScenarioProperties().entrySet()) {
			Object request =  Util.createRequestFromJsonFile(
                entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
                PAPERLESSDOCUMENTUploadRequestWrapper.class,this.appConfig,null);
				assertNotNull(request);
			assertTrue(request instanceof PAPERLESSDOCUMENTUploadRequestWrapper);
		}
		for(Map.Entry<String, List<String>> entry : this.appConfig.getUploadImageScenarioProperties().entrySet()) {
			Object request =  Util.createRequestFromJsonFile(
                entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
                PAPERLESSDOCUMENTRequestWrapper.class,this.appConfig,null);
			assertNotNull(request);
			assertTrue(request instanceof PAPERLESSDOCUMENTRequestWrapper);
		}
	}

	@Test
	public void scenarioSyntax() throws ClassNotFoundException {
		Map<String, List<String>> mapToRequestInfo = this.appConfig.getUploadDocumentScenarioProperties();
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
    Throwable exception = assertThrows(Exception.class, () -> Util.createRequestFromJsonFile(null,PAPERLESSDOCUMENTRequestWrapper.class,this.appConfig,null));
    assertSame(IllegalStateException.class, exception.getClass());
	}
	@Test
	public void uploadDocuments() throws JsonProcessingException {
		PaperlessDocuments paperlessDocuments=new PaperlessDocuments(this.restTemplate, this.appConfig);
        final String uploadDocumentsJsonFileName = this.appConfig.getUploadDocumentScenarioProperties().
        get(AppConfig.UPLOAD_DOCUMENTS_SUCCESS_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create Paperless Documents Upload Request from a pre-determined json file
		PAPERLESSDOCUMENTUploadRequestWrapper paperlessUploadRequestWrapper = Util.createRequestFromJsonFile(
			uploadDocumentsJsonFileName,
			PAPERLESSDOCUMENTUploadRequestWrapper.class,this.appConfig,null);
		// Get Upload documents status
		PAPERLESSDOCUMENTUploadResponseWrapper paperlessUploadResponseWrapper = (PAPERLESSDOCUMENTUploadResponseWrapper)paperlessDocuments.sendRequest(paperlessUploadRequestWrapper);
		assertNotNull(paperlessUploadResponseWrapper);
		assertNotNull(paperlessUploadResponseWrapper.getUploadResponse());
		assertNotNull(paperlessUploadResponseWrapper.getUploadResponse().getResponse());
		assertEquals(paperlessUploadResponseWrapper.getUploadResponse().getResponse().getResponseStatus().getCode(),this.SUCCESS_CODE);
		assertEquals(paperlessUploadResponseWrapper.getUploadResponse().getResponse().getResponseStatus().getDescription(),this.SUCCESS_STATUS);
	}

	@Test
	public void pushImageToRepo() throws JsonProcessingException {
		PaperlessDocuments paperlessDocuments=new PaperlessDocuments(this.restTemplate, this.appConfig);
        final String uploadDocumentsJsonFileName = this.appConfig.getUploadDocumentScenarioProperties().
        get(AppConfig.UPLOAD_DOCUMENTS_SUCCESS_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create Paperless Documents Upload Request from a pre-determined json file
		PAPERLESSDOCUMENTUploadRequestWrapper paperlessUploadRequestWrapper = Util.createRequestFromJsonFile(
			uploadDocumentsJsonFileName,
			PAPERLESSDOCUMENTUploadRequestWrapper.class,this.appConfig,null);
		// Get Upload documents status
		PAPERLESSDOCUMENTUploadResponseWrapper paperlessUploadResponseWrapper = (PAPERLESSDOCUMENTUploadResponseWrapper)paperlessDocuments.sendRequest(paperlessUploadRequestWrapper);
		UploadResponse uploadResponse=paperlessUploadResponseWrapper.getUploadResponse();
		UploadResponseFormsHistoryDocumentID formsHistoryDocumentID=uploadResponse.getFormsHistoryDocumentID();
		if(null!=paperlessUploadResponseWrapper&&null!=uploadResponse){
			String documentID=null;
			if(formsHistoryDocumentID.getDocumentID() instanceof List){
				documentID=((List<String>)formsHistoryDocumentID.getDocumentID()).get(0);
			}else{
				documentID=(String)formsHistoryDocumentID.getDocumentID();
			}
			this.appConfig.setDocumentId(documentID);
		}
        final String uploadImageSuccessJsonFileName = this.appConfig.getUploadImageScenarioProperties().
        get(AppConfig.UPLOAD_IMAGE_SUCCESS_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create Paperless Documents Request from a pre-determined json file
		PAPERLESSDOCUMENTRequestWrapper paperlessRequestWrapper = Util.createRequestFromJsonFile(
			uploadImageSuccessJsonFileName,
			PAPERLESSDOCUMENTRequestWrapper.class,this.appConfig,new CreateRequestEnricher() {});
		// Get Upload documents status
		PAPERLESSDOCUMENTResponseWrapper paperlessResponseWrapper = (PAPERLESSDOCUMENTResponseWrapper)paperlessDocuments.sendRequest(paperlessRequestWrapper);
		assertNotNull(paperlessResponseWrapper);
		assertNotNull(paperlessResponseWrapper.getPushToImageRepositoryResponse());
		assertNotNull(paperlessResponseWrapper.getPushToImageRepositoryResponse().getResponse());
		assertEquals(paperlessResponseWrapper.getPushToImageRepositoryResponse().getResponse().getResponseStatus().getCode(),this.SUCCESS_CODE);
		assertEquals(paperlessResponseWrapper.getPushToImageRepositoryResponse().getResponse().getResponseStatus().getDescription(),this.SUCCESS_STATUS);
	}
	@Test
	public void deleteDocuments() throws JsonProcessingException {
		PaperlessDocuments paperlessDocuments=new PaperlessDocuments(this.restTemplate, this.appConfig);
        final String uploadDocumentsJsonFileName = this.appConfig.getUploadDocumentScenarioProperties().
        get(AppConfig.UPLOAD_DOCUMENTS_SUCCESS_SCENARIO).
        get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME);
		// Create Paperless Documents Upload Request from a pre-determined json file
		PAPERLESSDOCUMENTUploadRequestWrapper paperlessUploadRequestWrapper = Util.createRequestFromJsonFile(
			uploadDocumentsJsonFileName,
			PAPERLESSDOCUMENTUploadRequestWrapper.class,this.appConfig,null);
		// Get Upload documents status
		PAPERLESSDOCUMENTUploadResponseWrapper paperlessUploadResponseWrapper = (PAPERLESSDOCUMENTUploadResponseWrapper)paperlessDocuments.sendRequest(paperlessUploadRequestWrapper);
		UploadResponse uploadResponse=paperlessUploadResponseWrapper.getUploadResponse();
		UploadResponseFormsHistoryDocumentID formsHistoryDocumentID=uploadResponse.getFormsHistoryDocumentID();
		if(null!=paperlessUploadResponseWrapper&&null!=uploadResponse){
			String documentID=null;
			if(formsHistoryDocumentID.getDocumentID() instanceof List){
				documentID=((List<String>)formsHistoryDocumentID.getDocumentID()).get(0);
			}else{
				documentID=(String)formsHistoryDocumentID.getDocumentID();
			}
			this.appConfig.setDocumentId(documentID);
		}
		DeleteDocumentsApi deleteApi = new DeleteDocumentsApi(new ApiClient(this.restTemplate));
		deleteApi.getApiClient().setBasePath(this.appConfig.getPaperlessDocumentsBaseUrl());
		final String accessToken = Util.getAccessToken(this.appConfig, this.restTemplate);
		deleteApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, this.BEARER + accessToken);
		// create a 32 character unique id.
		String randomId = UUID.randomUUID().toString();
		final String transId = randomId.replace("-", "");
		// Delete document status
		PAPERLESSDOCUMENTDeleteResponseWrapper paperlessDeleteResponseWrapper = deleteApi
				.delete(this.appConfig.getPaperlessDocumentsVersion(), this.appConfig.getShipperNumber(),
				this.appConfig.getDocumentId(),transId,this.appConfig.getTransactionSrc());
		assertNotNull(paperlessDeleteResponseWrapper);
		assertNotNull(paperlessDeleteResponseWrapper.getDeleteResponse());
		assertNotNull(paperlessDeleteResponseWrapper.getDeleteResponse().getResponse());
		assertEquals(paperlessDeleteResponseWrapper.getDeleteResponse().getResponse().getResponseStatus().getCode(),this.SUCCESS_CODE);
		assertEquals(paperlessDeleteResponseWrapper.getDeleteResponse().getResponse().getResponseStatus().getDescription(),this.SUCCESS_STATUS);
	}
}

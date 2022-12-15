package com.ups.api.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ups.api.app.tool.Util;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.pickup.client.ApiClient;
import org.openapitools.pickup.client.api.PickupApi;
import org.openapitools.pickup.client.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j

public class PickupDemo implements CommandLineRunner {

    RestTemplate restTemplate;
    AppConfig appConfig;

    private static final ThreadLocal<PickupApi> api = new ThreadLocal<>();
    private static final String SCENARIO_NAME_LOG_FORMAT = "Shipping Response for scenario: {}";
    private String prn = null;


    public PickupDemo(RestTemplate restTemplate, AppConfig appConfig) {
        this.restTemplate = restTemplate;
        this.appConfig = appConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        try {

            //processing all endpoint api call and printing their response
            postPickupCreationAndGetResponce();
            postPickupGetServiceCenterFacilities();
            postPickupRate();
            getPickupPendingStatusResponse();
            pickupCancel();
            pickupGetPoliticalDivision1List();

        } catch (Exception ex) {
            applicationErrorHandler(ex);
        }
    }

    /**
     * getLandedCostResponse method used for process LandedCost request and getting
     * Landed Cost Response
     */
    private void postPickupCreationAndGetResponce() {
        for (Map.Entry<String, List<String>> entry : appConfig.getScenarioPickupCreationProperties().entrySet()) {
            try {
                PICKUPCreationRequestWrapper pickupCreationRequestWrapper
                        = Util.createRequestFromJsonFile(
                        entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME), PICKUPCreationRequestWrapper.class,
                        appConfig);

                final String transId = UUID.randomUUID().toString().replace("-", "");
                final PickupApi pickupApi = initializePickupApi(restTemplate, appConfig);
                PICKUPCreationResponseWrapper pickupCreationResponseWrapper =
                        pickupApi.pickupCreation(appConfig.getPickupVersion(),
                                pickupCreationRequestWrapper, transId, appConfig.getTransactionSrc());
                if (prn == null) {
                    prn = pickupCreationResponseWrapper.getPickupCreationResponse().getPRN();
                }
                processAllResponse(entry.getKey(), pickupCreationResponseWrapper.getPickupCreationResponse());
            } catch (HttpClientErrorException httpClientException) {
                log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
                log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
            } catch (Exception ex) {
                log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
                applicationErrorHandler(ex);
            } finally {
                cleanup();
            }
            log.info("\n");
        }

    }

    /**
     * pickup Get Service Center Facilities
     */
    private void postPickupGetServiceCenterFacilities() {

        for (Map.Entry<String, List<String>> entry : appConfig.getScenarioPickupGetServiceCenterFacilitiesProperties().entrySet()) {
            try {
                PICKUPServCenterRequestWrapper pickupServCenterRequestWrapper
                        = Util.createRequestFromJsonFile(
                        entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME), PICKUPServCenterRequestWrapper.class,
                        appConfig);

                final String transId = UUID.randomUUID().toString().replace("-", "");
                final PickupApi pickupApi = initializePickupApi(restTemplate, appConfig);
                PICKUPServCenterResponseWrapper pickupServCenterResponseWrapper =
                        pickupApi.pickupGetServiceCenterFacilities(appConfig.getPickupVersion(),
                                pickupServCenterRequestWrapper, transId, appConfig.getTransactionSrc());

                processAllResponse(entry.getKey(), pickupServCenterResponseWrapper.getPickupGetServiceCenterFacilitiesResponse());
            } catch (HttpClientErrorException httpClientException) {
                log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
                log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
            } catch (Exception ex) {
                log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
                applicationErrorHandler(ex);
            } finally {
                cleanup();
            }
            log.info("\n");
        }
    }


    /**
     * Pickup Rate
     */
    private void postPickupRate() {

        for (Map.Entry<String, List<String>> entry : appConfig.getScenarioPickupRateProperties().entrySet()) {
            try {
                PICKUPRequestWrapper pickupRequestWrapper
                        = Util.createRequestFromJsonFile(
                        entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME), PICKUPRequestWrapper.class,
                        appConfig);

                final String transId = UUID.randomUUID().toString().replace("-", "");
                final PickupApi pickupApi = initializePickupApi(restTemplate, appConfig);
                PICKUPResponseWrapper pickupResponseWrapper =
                        pickupApi.pickupRate(appConfig.getPickupVersion(),
                                appConfig.POST_PICKUP_TYPE,
                                pickupRequestWrapper,
                                transId, appConfig.getTransactionSrc());
                processAllResponse(entry.getKey(), pickupResponseWrapper.getPickupRateResponse());
            } catch (HttpClientErrorException httpClientException) {
                log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
                log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
            } catch (Exception ex) {
                log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
                applicationErrorHandler(ex);
            } finally {
                cleanup();
            }
            log.info("\n");
        }
    }

    /**
     * Pickup Pending Status
     */
    public void getPickupPendingStatusResponse() {

        try {
            final PickupApi pickupApi = initializePickupApi(restTemplate, appConfig);
            final String transId = UUID.randomUUID().toString().replace("-", "");
            PICKUPPendingResponseWrapper pickupPendingResponseWrapper =
                    pickupApi.pickupPendingStatus(appConfig.getAccountNumber(),
                            appConfig.getPickupVersion(),
                            appConfig.GET_PICKUP_TYPE, transId, appConfig.getTransactionSrc());
            processAllResponse("PickupPendingStatusResponseSuccess",
                    pickupPendingResponseWrapper.getPickupPendingStatusResponse());
        } catch (HttpClientErrorException httpClientException) {
            log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
            log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
        } catch (Exception ex) {
            log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
            applicationErrorHandler(ex);
        } finally {
            cleanup();
        }
        log.info("\n");

    }

    /**
     * Pickup Cancel
     */
    public void pickupCancel() {

        try {
            final PickupApi pickupApi = initializePickupApi(restTemplate, appConfig);
            final String transId = UUID.randomUUID().toString().replace("-", "");
            PICKUPCancelResponseWrapper pickupCancelResponseWrapper =
                    pickupApi.pickupCancel(appConfig.CANCEL_BY,
                            appConfig.getPickupVersion(),
                            transId, appConfig.getTransactionSrc(), prn);
            processAllResponse("PickupCancelResponseSuccess",
                    pickupCancelResponseWrapper.getPickupCancelResponse());
        } catch (HttpClientErrorException httpClientException) {
            log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
            log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
        } catch (Exception ex) {
            log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
            applicationErrorHandler(ex);
        } finally {
            cleanup();
        }
        log.info("\n");

    }

    /**
     * Pickup Get Political Division1 List
     */
    public void pickupGetPoliticalDivision1List() {

        try {
            final PickupApi pickupApi = initializePickupApi(restTemplate, appConfig);
            final String transId = UUID.randomUUID().toString().replace("-", "");
            PICKUPPolDivResponseWrapper pickupGetPoliticalDivision1List =
                    pickupApi.pickupGetPoliticalDivision1List(transId, appConfig.getTransactionSrc(),
                            appConfig.getPickupVersion(),
                            appConfig.getCountryCode());
            processAllResponse("PickupGetPoliticalDivision1ListResponseSuccess",
                    pickupGetPoliticalDivision1List.getPickupGetPoliticalDivision1ListResponse());
        } catch (HttpClientErrorException httpClientException) {
            log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
            log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
        } catch (Exception ex) {
            log.warn(SCENARIO_NAME_LOG_FORMAT, "VoidShipmentResponseSucess");
            applicationErrorHandler(ex);
        } finally {
            cleanup();
        }
        log.info("\n");

    }

    /**
     * printing all object Response to json
     *
     * @param scenarioName
     * @param object
     */
    public static void processAllResponse(final String scenarioName, final Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            log.info("Scenario name: {}, response[{}]", scenarioName, mapper.writeValueAsString(object));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * initialize Pickup Api
     *
     * @param restTemplate
     * @param appConfig
     * @return
     */
    public static PickupApi initializePickupApi(final RestTemplate restTemplate, AppConfig appConfig) {

        final String accessToken = Util.getAccessToken(appConfig, restTemplate);
        PickupApi pickupApi = api.get();
        if (null == pickupApi) {
            pickupApi = new PickupApi(new ApiClient(restTemplate));
            pickupApi.getApiClient().setBasePath(appConfig.getPickupBaseUrl());
            api.set(pickupApi);
        }
        pickupApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        return pickupApi;
    }

    private void cleanup() {
        PickupApi shipApi = api.get();
        if (null != shipApi) {
            api.remove();
        }
    }

    private void applicationErrorHandler(Exception ex) {
        log.warn("failed to complete request", ex);
    }
}

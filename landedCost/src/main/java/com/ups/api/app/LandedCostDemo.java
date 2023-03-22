package com.ups.api.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ups.api.app.tool.Util;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.landed.cost.client.ApiClient;
import org.openapitools.landed.cost.client.api.LandedCostApi;
import org.openapitools.landed.cost.client.model.LandedCostRequest;
import org.openapitools.landed.cost.client.model.LandedCostResponse;
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

public class LandedCostDemo implements CommandLineRunner {

    private static final ThreadLocal<LandedCostApi> api = new ThreadLocal<>();
    private static final String SCENARIO_NAME_LOG_FORMAT = "Landed Cost Response for scenario: {}";
    RestTemplate restTemplate;
    AppConfig appConfig;

    public LandedCostDemo(RestTemplate restTemplate, AppConfig appConfig) {
        this.restTemplate = restTemplate;
        this.appConfig = appConfig;
    }

    /**
     * printing landed Cost Response
     *
     * @param scenarioName
     * @param landedCostResponse
     */
    public static void processResultLandedCostResponse(final String scenarioName, final LandedCostResponse landedCostResponse) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            log.info("Scenario name: {}, response[{}]", scenarioName, mapper.writeValueAsString(landedCostResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(String... args) throws Exception {

        // Each iteration will create an instance of LANDEDCOSTRequestWrapper from a pre-determined json file verses
        // creating a LANDEDCOSTRequestWrapper object and calling a setter for particular attribute in an application environment.
        for (Map.Entry<String, List<String>> entry : appConfig.getScenarioProperties().entrySet()) {
            try {

                LandedCostRequest landedCostRequest = Util.createRequestFromJsonFile(
                        entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME), LandedCostRequest.class,
                        appConfig);
                // create a 32 character unique id.
                final String transId = UUID.randomUUID().toString().replace("-", "");

                // Get a landed cost information.
                LandedCostResponse landedCostResponse = sendRequest(landedCostRequest, transId);

                processResultLandedCostResponse(entry.getKey(), landedCostResponse);
            } catch (HttpClientErrorException httpClientException) {
                log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
                log.warn("Http exception - " + httpClientException.getStatusCode(), httpClientException);
            } catch (Exception ex) {
                log.warn(SCENARIO_NAME_LOG_FORMAT, entry.getKey());
                applicationErrorHandler(ex);
            } finally {
                cleanup();
            }
            log.info("\n");
        }

    }

    public LandedCostResponse sendRequest(final LandedCostRequest landedCostRequest, final String transId) {
        log.info("transId: {}", transId);
        final String accessToken = Util.getAccessToken(appConfig, restTemplate);
        LandedCostApi landedCostApi = api.get();
        if (null == landedCostApi) {
            landedCostApi = new LandedCostApi(new ApiClient(restTemplate));
            landedCostApi.getApiClient().setBasePath(appConfig.getLandedCostBaseUrl());
            api.set(landedCostApi);
        }
        landedCostApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        return landedCostApi.landedCost(transId,
                appConfig.getTransactionSrc(),
                appConfig.getLandedCostVersion(),
                landedCostRequest, null);
    }

    private void cleanup() {
        LandedCostApi landedCostApi = api.get();
        if (null != landedCostApi) {
            api.remove();
        }
    }

    private void applicationErrorHandler(Exception ex) {
        log.warn("failed to complete request", ex);
    }
}

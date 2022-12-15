package com.ups.api.app.tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openapitools.rate.client.ApiClient;
import org.openapitools.rate.client.model.RATERequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

public class RateApi {
    private ApiClient apiClient;

    public RateApi() {
        this(new ApiClient());
    }

    @Autowired
    public RateApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * The Rating API is used when rating or shopping a shipment.
     * 
     * <p><b>200</b> - successful operation
     * <p><b>401</b> - Unauthorized Request
     * @param version Indicates Rate API to display the new release features in  Rate API response based on Rate release. See the New  section for the latest Rate release. Supported values: v1,  v1601, v1607, v1701, 1801. Length 5 (required)
     * @param requestoption Valid Values:  Rate &#x3D; The server rates (The default Request option is  Rate if a Request Option is not provided).  Shop &#x3D; The server validates the shipment, and returns  rates for all UPS products from the ShipFrom to the  ShipTo addresses.  Rate is the only valid request option for Ground Freight  Pricing requests. . Length 10 (required)
     * @param raTERequestWrapper Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. (required)
     * @param transId An identifier unique to the request. Length 32 (optional)
     * @param transactionSrc An identifier of the client/source application that is making the request.Length 512 (optional, default to testing)
     * @param additionalinfo Valid Values:  timeintransit &#x3D; The server rates with transit time  information combined with requestoption in URL. Rate is the only valid request option for Ground Freight  Pricing requests. Length 15 (optional)
     * @return RATEResponseWrapper
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String rate(String version, String requestoption, RATERequestWrapper raTERequestWrapper, String transId, String transactionSrc, String additionalinfo) throws RestClientException {
        return rateWithHttpInfo(version, requestoption, raTERequestWrapper, transId, transactionSrc, additionalinfo).getBody();
    }

    /**
     * The Rating API is used when rating or shopping a shipment.
     * 
     * <p><b>200</b> - successful operation
     * <p><b>401</b> - Unauthorized Request
     * @param version Indicates Rate API to display the new release features in  Rate API response based on Rate release. See the New  section for the latest Rate release. Supported values: v1,  v1601, v1607, v1701, 1801. Length 5 (required)
     * @param requestoption Valid Values:  Rate &#x3D; The server rates (The default Request option is  Rate if a Request Option is not provided).  Shop &#x3D; The server validates the shipment, and returns  rates for all UPS products from the ShipFrom to the  ShipTo addresses.  Rate is the only valid request option for Ground Freight  Pricing requests. . Length 10 (required)
     * @param raTERequestWrapper Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. (required)
     * @param transId An identifier unique to the request. Length 32 (optional)
     * @param transactionSrc An identifier of the client/source application that is making the request.Length 512 (optional, default to testing)
     * @param additionalinfo Valid Values:  timeintransit &#x3D; The server rates with transit time  information combined with requestoption in URL. Rate is the only valid request option for Ground Freight  Pricing requests. Length 15 (optional)
     * @return ResponseEntity&lt;RATEResponseWrapper&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> rateWithHttpInfo(String version, String requestoption, RATERequestWrapper raTERequestWrapper, String transId, String transactionSrc, String additionalinfo) throws RestClientException {
        Object localVarPostBody = raTERequestWrapper;
        
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling rate");
        }
        
        // verify the required parameter 'requestoption' is set
        if (requestoption == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestoption' when calling rate");
        }
        
        // verify the required parameter 'raTERequestWrapper' is set
        if (raTERequestWrapper == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'raTERequestWrapper' when calling rate");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("version", version);
        uriVariables.put("requestoption", requestoption);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "additionalinfo", additionalinfo));

        if (transId != null) {
        localVarHeaderParams.add("transId", apiClient.parameterToString(transId));
        }
        if (transactionSrc != null) {
        	localVarHeaderParams.add("transactionSrc", apiClient.parameterToString(transactionSrc));
        }
        
        final String[] localVarAccepts = { 
            "application/json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "oauth2" };

        ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI("/rating/{version}/{requestoption}", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}

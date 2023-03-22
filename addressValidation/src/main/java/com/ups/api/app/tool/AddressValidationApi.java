package com.ups.api.app.tool;


import org.openapitools.addressValidation.client.ApiClient;

import org.openapitools.addressValidation.client.model.XAVRequestWrapper;
import org.openapitools.addressValidation.client.model.XAVResponseWrapper;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


public class AddressValidationApi {
    private ApiClient apiClient;

    public AddressValidationApi() {
        this(new ApiClient());
    }

    @Autowired
    public AddressValidationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return this.apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * The Address Validation Street Level API can be used to check addresses against the United States Postal Service database of valid addresses in the U.S. and Puerto Rico.
     * 
     * <p><b>200</b> - successful operation
     * @param requestoption Identifies the type of request. Valid  values:  1 - Address Validation 2 - Address Classification  3 - Address Validation and Address  Classification. (required)
     * @param version Identifies the version of the API. Valid  values:  v1 (required)
     * @param xaVRequestWrapper Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. (required)
     * @param regionalrequestindicator Valid values: True or False.  If True, either the region element or any  combination of Political Division 1,  Political Division 2, PostcodePrimaryLow  and the PostcodeExtendedLow fields will  be recognized for validation in addition to  the urbanization element. If False or no  indicator, street level address validation  is provided (optional)
     * @param maximumcandidatelistsize Valid values: 0 – 50 The maximum number of Candidates to  return for this request. If not provided,  the default size of 15 is returned. (optional)
     * @return XAVResponseWrapper
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String addressValidation(Integer requestoption, String version, XAVRequestWrapper xaVRequestWrapper, String regionalrequestindicator, Integer maximumcandidatelistsize) throws RestClientException {
        return this.addressValidationWithHttpInfo(requestoption, version, xaVRequestWrapper, regionalrequestindicator, maximumcandidatelistsize).getBody();
    }

    /**
     * The Address Validation Street Level API can be used to check addresses against the United States Postal Service database of valid addresses in the U.S. and Puerto Rico.
     * 
     * <p><b>200</b> - successful operation
     * @param requestoption Identifies the type of request. Valid  values:  1 - Address Validation 2 - Address Classification  3 - Address Validation and Address  Classification. (required)
     * @param version Identifies the version of the API. Valid  values:  v1 (required)
     * @param xaVRequestWrapper Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. (required)
     * @param regionalrequestindicator Valid values: True or False.  If True, either the region element or any  combination of Political Division 1,  Political Division 2, PostcodePrimaryLow  and the PostcodeExtendedLow fields will  be recognized for validation in addition to  the urbanization element. If False or no  indicator, street level address validation  is provided (optional)
     * @param maximumcandidatelistsize Valid values: 0 – 50 The maximum number of Candidates to  return for this request. If not provided,  the default size of 15 is returned. (optional)
     * @return ResponseEntity&lt;XAVResponseWrapper&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> addressValidationWithHttpInfo(Integer requestoption, String version, XAVRequestWrapper xaVRequestWrapper, String regionalrequestindicator, Integer maximumcandidatelistsize) throws RestClientException {
        Object localVarPostBody = xaVRequestWrapper;
        
        // verify the required parameter 'requestoption' is set
        if (requestoption == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestoption' when calling addressValidation");
        }
        
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling addressValidation");
        }
        
        // verify the required parameter 'xaVRequestWrapper' is set
        if (xaVRequestWrapper == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'xaVRequestWrapper' when calling addressValidation");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("requestoption", requestoption);
        uriVariables.put("version", version);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(this.apiClient.parameterToMultiValueMap(null, "regionalrequestindicator", regionalrequestindicator));
        localVarQueryParams.putAll(this.apiClient.parameterToMultiValueMap(null, "maximumcandidatelistsize", maximumcandidatelistsize));

        final String[] localVarAccepts = { 
            "application/json", "application/xml"
         };
        final List<MediaType> localVarAccept = this.apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = this.apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "oauth2" };

        ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {};
        return this.apiClient.invokeAPI("/addressvalidation/{version}/{requestoption}", HttpMethod.POST, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}

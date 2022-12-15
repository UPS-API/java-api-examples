package com.ups.api.app.tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openapitools.shipping.client.ApiClient;
import org.openapitools.shipping.client.model.LABELRECOVERYRequestWrapper;
import org.openapitools.shipping.client.model.LABELRECOVERYResponseWrapper;
import org.openapitools.shipping.client.model.SHIPRequestWrapper;
import org.openapitools.shipping.client.model.VOIDSHIPMENTResponseWrapper;
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

public class ShipApi {
	private ApiClient apiClient;

	public ShipApi() {
		this(new ApiClient());
	}

	@Autowired
	public ShipApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * The Label Shipping API allows us to retrieve forward and return labels. Label
	 * Recovery
	 * <p>
	 * <b>200</b> - successful operation
	 * <p>
	 * <b>401</b> - Unauthorized Request
	 * 
	 * @param version                     When UPS introduces new elements in the
	 *                                    response that are not associated with new
	 *                                    request elements, Subversion is used. This
	 *                                    ensures backward compatibility. v1
	 *                                    original features of the application. No
	 *                                    support for CODTurn-inPage,
	 *                                    HighValueReport or InternationalForms
	 *                                    features returned in the response v1701
	 *                                    includes support for CODTurn-inPage
	 *                                    features returned in the response. V1903
	 *                                    Length 5 (required)
	 * @param laBELRECOVERYRequestWrapper Generate sample code for popular API
	 *                                    requests by selecting an example below. To
	 *                                    view a full sample request and response,
	 *                                    first click \&quot;Authorize\&quot; and
	 *                                    enter your application credentials, then
	 *                                    populate the required parameters above and
	 *                                    click \&quot;Try it out\&quot;. (required)
	 * @param transId                     An identifier unique to the request.
	 *                                    Length 32 (optional)
	 * @param transactionSrc              An identifier of the client/source
	 *                                    application that is making the
	 *                                    request.Length 512 (optional, default to
	 *                                    testing)
	 * @return LABELRECOVERYResponseWrapper
	 * @throws RestClientException if an error occurs while attempting to invoke the
	 *                             API
	 */
	public LABELRECOVERYResponseWrapper labelRecovery(String version,
			LABELRECOVERYRequestWrapper laBELRECOVERYRequestWrapper, String transId, String transactionSrc)
			throws RestClientException {
		return labelRecoveryWithHttpInfo(version, laBELRECOVERYRequestWrapper, transId, transactionSrc).getBody();
	}

	/**
	 * The Label Shipping API allows us to retrieve forward and return labels. Label
	 * Recovery
	 * <p>
	 * <b>200</b> - successful operation
	 * <p>
	 * <b>401</b> - Unauthorized Request
	 * 
	 * @param version                     When UPS introduces new elements in the
	 *                                    response that are not associated with new
	 *                                    request elements, Subversion is used. This
	 *                                    ensures backward compatibility. v1
	 *                                    original features of the application. No
	 *                                    support for CODTurn-inPage,
	 *                                    HighValueReport or InternationalForms
	 *                                    features returned in the response v1701
	 *                                    includes support for CODTurn-inPage
	 *                                    features returned in the response. V1903
	 *                                    Length 5 (required)
	 * @param laBELRECOVERYRequestWrapper Generate sample code for popular API
	 *                                    requests by selecting an example below. To
	 *                                    view a full sample request and response,
	 *                                    first click \&quot;Authorize\&quot; and
	 *                                    enter your application credentials, then
	 *                                    populate the required parameters above and
	 *                                    click \&quot;Try it out\&quot;. (required)
	 * @param transId                     An identifier unique to the request.
	 *                                    Length 32 (optional)
	 * @param transactionSrc              An identifier of the client/source
	 *                                    application that is making the
	 *                                    request.Length 512 (optional, default to
	 *                                    testing)
	 * @return ResponseEntity&lt;LABELRECOVERYResponseWrapper&gt;
	 * @throws RestClientException if an error occurs while attempting to invoke the
	 *                             API
	 */
	public ResponseEntity<LABELRECOVERYResponseWrapper> labelRecoveryWithHttpInfo(String version,
			LABELRECOVERYRequestWrapper laBELRECOVERYRequestWrapper, String transId, String transactionSrc)
			throws RestClientException {
		Object localVarPostBody = laBELRECOVERYRequestWrapper;

		// verify the required parameter 'version' is set
		if (version == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'version' when calling labelRecovery");
		}

		// verify the required parameter 'laBELRECOVERYRequestWrapper' is set
		if (laBELRECOVERYRequestWrapper == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'laBELRECOVERYRequestWrapper' when calling labelRecovery");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("version", version);

		final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders localVarHeaderParams = new HttpHeaders();
		final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
		final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

		if (transId != null)
			localVarHeaderParams.add("transId", apiClient.parameterToString(transId));
		if (transactionSrc != null)
			localVarHeaderParams.add("transactionSrc", apiClient.parameterToString(transactionSrc));

		final String[] localVarAccepts = { "application/json" };
		final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		final String[] localVarContentTypes = { "application/json" };
		final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "oauth2" };

		ParameterizedTypeReference<LABELRECOVERYResponseWrapper> localReturnType = new ParameterizedTypeReference<LABELRECOVERYResponseWrapper>() {
		};
		return apiClient.invokeAPI("/labels/{version}/recovery", HttpMethod.POST, uriVariables, localVarQueryParams,
				localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept,
				localVarContentType, localVarAuthNames, localReturnType);
	}

	/**
	 * The Shipping API makes UPS shipping services available to client applications
	 * that communicate with UPS using the Internet Shipping
	 * <p>
	 * <b>200</b> - successful operation
	 * <p>
	 * <b>401</b> - Unauthorized Request
	 * 
	 * @param version                     Indicates Ship API to display the new
	 *                                    release features in Rate API response
	 *                                    based on Ship release. See the New section
	 *                                    for the latest Ship release. Supported
	 *                                    values: v1, v1601, v1607, v1701, 1801 .
	 *                                    Length 5 (required)
	 * @param shIPRequestWrapper          Generate sample code for popular API
	 *                                    requests by selecting an example below. To
	 *                                    view a full sample request and response,
	 *                                    first click \&quot;Authorize\&quot; and
	 *                                    enter your application credentials, then
	 *                                    populate the required parameters above and
	 *                                    click \&quot;Try it out\&quot;. (required)
	 * @param transId                     An identifier unique to the request.
	 *                                    Length 32 (optional)
	 * @param transactionSrc              An identifier of the client/source
	 *                                    application that is making the
	 *                                    request.Length 512 (optional, default to
	 *                                    testing)
	 * @param additionaladdressvalidation Valid Values: city &#x3D; validation will
	 *                                    include city.Length 15 (optional)
	 * @return SHIPResponseWrapper
	 * @throws RestClientException if an error occurs while attempting to invoke the
	 *                             API
	 */
	public String shipment(String version, SHIPRequestWrapper shIPRequestWrapper, String transId, String transactionSrc,
			String additionaladdressvalidation) throws RestClientException {
		return shipmentWithHttpInfo(version, shIPRequestWrapper, transId, transactionSrc, additionaladdressvalidation)
				.getBody();
	}

	/**
	 * The Shipping API makes UPS shipping services available to client applications
	 * that communicate with UPS using the Internet Shipping
	 * <p>
	 * <b>200</b> - successful operation
	 * <p>
	 * <b>401</b> - Unauthorized Request
	 * 
	 * @param version                     Indicates Ship API to display the new
	 *                                    release features in Rate API response
	 *                                    based on Ship release. See the New section
	 *                                    for the latest Ship release. Supported
	 *                                    values: v1, v1601, v1607, v1701, 1801 .
	 *                                    Length 5 (required)
	 * @param shIPRequestWrapper          Generate sample code for popular API
	 *                                    requests by selecting an example below. To
	 *                                    view a full sample request and response,
	 *                                    first click \&quot;Authorize\&quot; and
	 *                                    enter your application credentials, then
	 *                                    populate the required parameters above and
	 *                                    click \&quot;Try it out\&quot;. (required)
	 * @param transId                     An identifier unique to the request.
	 *                                    Length 32 (optional)
	 * @param transactionSrc              An identifier of the client/source
	 *                                    application that is making the
	 *                                    request.Length 512 (optional, default to
	 *                                    testing)
	 * @param additionaladdressvalidation Valid Values: city &#x3D; validation will
	 *                                    include city.Length 15 (optional)
	 * @return ResponseEntity&lt;SHIPResponseWrapper&gt;
	 * @throws RestClientException if an error occurs while attempting to invoke the
	 *                             API
	 */
	public ResponseEntity<String> shipmentWithHttpInfo(String version, SHIPRequestWrapper shIPRequestWrapper,
			String transId, String transactionSrc, String additionaladdressvalidation) throws RestClientException {
		Object localVarPostBody = shIPRequestWrapper;

		// verify the required parameter 'version' is set
		if (version == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'version' when calling shipment");
		}

		// verify the required parameter 'shIPRequestWrapper' is set
		if (shIPRequestWrapper == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'shIPRequestWrapper' when calling shipment");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("version", version);

		final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders localVarHeaderParams = new HttpHeaders();
		final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
		final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

		localVarQueryParams.putAll(
				apiClient.parameterToMultiValueMap(null, "additionaladdressvalidation", additionaladdressvalidation));

		if (transId != null)
			localVarHeaderParams.add("transId", apiClient.parameterToString(transId));
		if (transactionSrc != null)
			localVarHeaderParams.add("transactionSrc", apiClient.parameterToString(transactionSrc));

		final String[] localVarAccepts = { "application/json" };
		final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		final String[] localVarContentTypes = { "application/json" };
		final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "oauth2" };

		ParameterizedTypeReference<String> localReturnType = new ParameterizedTypeReference<String>() {
		};
		return apiClient.invokeAPI("/shipments/{version}/ship", HttpMethod.POST, uriVariables, localVarQueryParams,
				localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept,
				localVarContentType, localVarAuthNames, localReturnType);
	}

	/**
	 * The Void Shipping API is used to cancel the previously scheduled shipment
	 * Void Shipment
	 * <p>
	 * <b>200</b> - successful operation
	 * <p>
	 * <b>401</b> - Unauthorized Request
	 * 
	 * @param version                      API Version (required)
	 * @param shipmentidentificationnumber The shipment&#39;s identification number
	 *                                     Alpha-numeric. Must pass 1Z rules. Must
	 *                                     be upper case. Length 18 (required)
	 * @param transId                      An identifier unique to the request.
	 *                                     Length 32 (optional)
	 * @param transactionSrc               An identifier of the client/source
	 *                                     application that is making the
	 *                                     request.Length 512 (optional, default to
	 *                                     testing)
	 * @param trackingnumber               The package&#39;s tracking number. You
	 *                                     may have up to 20 different tracking
	 *                                     numbers listed. If more than one tracking
	 *                                     number, pass this value as:
	 *                                     trackingnumber&#x3D;
	 *                                     [\&quot;1ZISUS010330563105\&quot;,\&quot;1ZISUS01033056310
	 *                                     8\&quot;] with a coma separating each
	 *                                     number. Alpha-numeric. Must pass 1Z
	 *                                     rules. Must be upper case. Length 18
	 *                                     (optional)
	 * @return VOIDSHIPMENTResponseWrapper
	 * @throws RestClientException if an error occurs while attempting to invoke the
	 *                             API
	 */
	public VOIDSHIPMENTResponseWrapper voidShipment(String version, String shipmentidentificationnumber, String transId,
			String transactionSrc, String trackingnumber) throws RestClientException {
		return voidShipmentWithHttpInfo(version, shipmentidentificationnumber, transId, transactionSrc, trackingnumber)
				.getBody();
	}

	/**
	 * The Void Shipping API is used to cancel the previously scheduled shipment
	 * Void Shipment
	 * <p>
	 * <b>200</b> - successful operation
	 * <p>
	 * <b>401</b> - Unauthorized Request
	 * 
	 * @param version                      API Version (required)
	 * @param shipmentidentificationnumber The shipment&#39;s identification number
	 *                                     Alpha-numeric. Must pass 1Z rules. Must
	 *                                     be upper case. Length 18 (required)
	 * @param transId                      An identifier unique to the request.
	 *                                     Length 32 (optional)
	 * @param transactionSrc               An identifier of the client/source
	 *                                     application that is making the
	 *                                     request.Length 512 (optional, default to
	 *                                     testing)
	 * @param trackingnumber               The package&#39;s tracking number. You
	 *                                     may have up to 20 different tracking
	 *                                     numbers listed. If more than one tracking
	 *                                     number, pass this value as:
	 *                                     trackingnumber&#x3D;
	 *                                     [\&quot;1ZISUS010330563105\&quot;,\&quot;1ZISUS01033056310
	 *                                     8\&quot;] with a coma separating each
	 *                                     number. Alpha-numeric. Must pass 1Z
	 *                                     rules. Must be upper case. Length 18
	 *                                     (optional)
	 * @return ResponseEntity&lt;VOIDSHIPMENTResponseWrapper&gt;
	 * @throws RestClientException if an error occurs while attempting to invoke the
	 *                             API
	 */
	public ResponseEntity<VOIDSHIPMENTResponseWrapper> voidShipmentWithHttpInfo(String version,
			String shipmentidentificationnumber, String transId, String transactionSrc, String trackingnumber)
			throws RestClientException {
		Object localVarPostBody = null;

		// verify the required parameter 'version' is set
		if (version == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'version' when calling voidShipment");
		}

		// verify the required parameter 'shipmentidentificationnumber' is set
		if (shipmentidentificationnumber == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
					"Missing the required parameter 'shipmentidentificationnumber' when calling voidShipment");
		}

		// create path and map variables
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("version", version);
		uriVariables.put("shipmentidentificationnumber", shipmentidentificationnumber);

		final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
		final HttpHeaders localVarHeaderParams = new HttpHeaders();
		final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
		final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

		localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "trackingnumber", trackingnumber));

		if (transId != null)
			localVarHeaderParams.add("transId", apiClient.parameterToString(transId));
		if (transactionSrc != null)
			localVarHeaderParams.add("transactionSrc", apiClient.parameterToString(transactionSrc));

		final String[] localVarAccepts = { "application/json" };
		final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		final String[] localVarContentTypes = {};
		final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "oauth2" };

		ParameterizedTypeReference<VOIDSHIPMENTResponseWrapper> localReturnType = new ParameterizedTypeReference<VOIDSHIPMENTResponseWrapper>() {
		};
		return apiClient.invokeAPI("/shipments/{version}/void/cancel/{shipmentidentificationnumber}", HttpMethod.DELETE,
				uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
	}
}

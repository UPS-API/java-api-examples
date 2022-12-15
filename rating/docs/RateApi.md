# RateApi

All URIs are relative to *https://wwwcie.ups.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**rate**](RateApi.md#rate) | **POST** /rating/{version}/{requestoption} | The Rating API is used when rating or shopping a shipment. |



## rate

> RATEResponseWrapper rate(version, requestoption, raTERequestWrapper, transId, transactionSrc, additionalinfo)

The Rating API is used when rating or shopping a shipment.

### Example

```java
// Import classes:
import org.openapitools.rate.client.ApiClient;
import org.openapitools.rate.client.ApiException;
import org.openapitools.rate.client.Configuration;
import org.openapitools.rate.client.auth.*;
import org.openapitools.rate.client.models.*;
import org.openapitools.rate.client.api.RateApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com/api");
        
        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        RateApi apiInstance = new RateApi(defaultClient);
        String version = "v1"; // String | Indicates Rate API to display the new release features in  Rate API response based on Rate release. See the New  section for the latest Rate release. Supported values: v1,  v1601, v1607, v1701, 1801. Length 5
        String requestoption = "requestoption_example"; // String | Valid Values:  Rate = The server rates (The default Request option is  Rate if a Request Option is not provided).  Shop = The server validates the shipment, and returns  rates for all UPS products from the ShipFrom to the  ShipTo addresses.  Rate is the only valid request option for Ground Freight  Pricing requests. . Length 10
        RATERequestWrapper raTERequestWrapper = new RATERequestWrapper(); // RATERequestWrapper | Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \"Authorize\" and enter your application credentials, then populate the required parameters above and click \"Try it out\".
        String transId = "transId_example"; // String | An identifier unique to the request. Length 32
        String transactionSrc = "testing"; // String | An identifier of the client/source application that is making the request.Length 512
        String additionalinfo = "additionalinfo_example"; // String | Valid Values:  timeintransit = The server rates with transit time  information combined with requestoption in URL. Rate is the only valid request option for Ground Freight  Pricing requests. Length 15
        try {
            RATEResponseWrapper result = apiInstance.rate(version, requestoption, raTERequestWrapper, transId, transactionSrc, additionalinfo);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RateApi#rate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **version** | **String**| Indicates Rate API to display the new release features in  Rate API response based on Rate release. See the New  section for the latest Rate release. Supported values: v1,  v1601, v1607, v1701, 1801. Length 5 | [default to v1] |
| **requestoption** | **String**| Valid Values:  Rate &#x3D; The server rates (The default Request option is  Rate if a Request Option is not provided).  Shop &#x3D; The server validates the shipment, and returns  rates for all UPS products from the ShipFrom to the  ShipTo addresses.  Rate is the only valid request option for Ground Freight  Pricing requests. . Length 10 | |
| **raTERequestWrapper** | [**RATERequestWrapper**](RATERequestWrapper.md)| Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. | |
| **transId** | **String**| An identifier unique to the request. Length 32 | [optional] |
| **transactionSrc** | **String**| An identifier of the client/source application that is making the request.Length 512 | [optional] [default to testing] |
| **additionalinfo** | **String**| Valid Values:  timeintransit &#x3D; The server rates with transit time  information combined with requestoption in URL. Rate is the only valid request option for Ground Freight  Pricing requests. Length 15 | [optional] |

### Return type

[**RATEResponseWrapper**](RATEResponseWrapper.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **401** | Unauthorized Request |  -  |


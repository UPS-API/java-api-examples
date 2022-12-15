# TntApi

All URIs are relative to *https://wwwcie.ups.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**timeInTransit**](TntApi.md#timeInTransit) | **POST** /shipments/{version}/transittimes | Get Time and Transit Response |



## timeInTransit

> TimeInTransitResponse timeInTransit(version, transId, transactionSrc, timeInTransitRequest)

Get Time and Transit Response

### Example

```java
// Import classes:
import org.openapitools.tnt.client.ApiClient;
import org.openapitools.tnt.client.ApiException;
import org.openapitools.tnt.client.Configuration;
import org.openapitools.tnt.client.auth.*;
import org.openapitools.tnt.client.models.*;
import org.openapitools.tnt.client.api.TntApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com/api");
        
        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        TntApi apiInstance = new TntApi(defaultClient);
        String version = "v1"; // String | API Version
        String transId = "transId_example"; // String | An identifier unique to the request.  Length 32
        String transactionSrc = "testing"; // String | Identifies the clients/source application that is calling.  Length 512
        TimeInTransitRequest timeInTransitRequest = new TimeInTransitRequest(); // TimeInTransitRequest | Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \"Authorize\" and enter your application credentials, then populate the required parameters above and click \"Try it out\".
        try {
            TimeInTransitResponse result = apiInstance.timeInTransit(version, transId, transactionSrc, timeInTransitRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TntApi#timeInTransit");
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
| **version** | **String**| API Version | [default to v1] |
| **transId** | **String**| An identifier unique to the request.  Length 32 | |
| **transactionSrc** | **String**| Identifies the clients/source application that is calling.  Length 512 | [default to testing] |
| **timeInTransitRequest** | [**TimeInTransitRequest**](TimeInTransitRequest.md)| Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. | |

### Return type

[**TimeInTransitResponse**](TimeInTransitResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | invalid request |  -  |
| **401** | Unauthorized Request |  -  |


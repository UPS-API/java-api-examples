# PubSubApi

All URIs are relative to *https://wwwcie.ups.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**trackVersionSubscriptionPackagePost**](PubSubApi.md#trackVersionSubscriptionPackagePost) | **POST** /track/{version}/subscription/package |  |



## trackVersionSubscriptionPackagePost

> PubSubResponseWrapper trackVersionSubscriptionPackagePost(version, transID, transactionSrc, accept, pubSubTrackingRequest)



### Example

```java
// Import classes:
import org.openapitools.pubsub.client.ApiClient;
import org.openapitools.pubsub.client.ApiException;
import org.openapitools.pubsub.client.Configuration;
import org.openapitools.pubsub.client.auth.*;
import org.openapitools.pubsub.client.models.*;
import org.openapitools.pubsub.client.api.PubSubApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com/api");
        
        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        PubSubApi apiInstance = new PubSubApi(defaultClient);
        String version = "v1"; // String | API Version, e.g. v1
        String transID = "transID_example"; // String | An identifier unique to the request.
        String transactionSrc = "testing"; // String | Identifies the client/source application that is calling.
        String accept = "application/json"; // String | Value: application/json
        PubSubTrackingRequest pubSubTrackingRequest = new PubSubTrackingRequest(); // PubSubTrackingRequest | Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \"Authorize\" and enter your application credentials, then populate the required parameters above and click \"Try it out\".
        try {
            PubSubResponseWrapper result = apiInstance.trackVersionSubscriptionPackagePost(version, transID, transactionSrc, accept, pubSubTrackingRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PubSubApi#trackVersionSubscriptionPackagePost");
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
| **version** | **String**| API Version, e.g. v1 | [default to v1] |
| **transID** | **String**| An identifier unique to the request. | |
| **transactionSrc** | **String**| Identifies the client/source application that is calling. | [default to testing] |
| **accept** | **String**| Value: application/json | [default to application/json] |
| **pubSubTrackingRequest** | [**PubSubTrackingRequest**](PubSubTrackingRequest.md)| Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. | |

### Return type

[**PubSubResponseWrapper**](PubSubResponseWrapper.md)

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


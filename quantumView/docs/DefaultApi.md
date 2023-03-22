# DefaultApi

All URIs are relative to *https://wwwcie.ups.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**validateClient**](DefaultApi.md#validateClient) | **GET** /security/v1/oauth/validate-client |  |



## validateClient

> ValidateSuccessResponse validateClient(clientId, redirectUri)



Validate Client

### Example

```java
// Import classes:
import org.openapitools.oauth.client.ApiClient;
import org.openapitools.oauth.client.ApiException;
import org.openapitools.oauth.client.Configuration;
import org.openapitools.oauth.client.models.*;
import org.openapitools.oauth.client.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        String clientId = "clientId_example"; // String | Client id for the requesting application.
        String redirectUri = "redirectUri_example"; // String | Callback URL for the requesting application.
        try {
            ValidateSuccessResponse result = apiInstance.validateClient(clientId, redirectUri);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#validateClient");
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
| **clientId** | **String**| Client id for the requesting application. | |
| **redirectUri** | **String**| Callback URL for the requesting application. | |

### Return type

[**ValidateSuccessResponse**](ValidateSuccessResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | Invalid Request |  -  |
| **401** | Unauthorized |  -  |


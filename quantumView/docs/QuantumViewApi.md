# QuantumViewApi

All URIs are relative to *https://wwwcie.ups.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**quantumView**](QuantumViewApi.md#quantumView) | **POST** /quantumview/{version}/events | Get Quantum View Response |



## quantumView

> QUANTUMVIEWResponseWrapper quantumView(version, quANTUMVIEWRequestWrapper)

Get Quantum View Response

### Example

```java
// Import classes:
import org.openapitools.quantumView.client.ApiClient;
import org.openapitools.quantumView.client.ApiException;
import org.openapitools.quantumView.client.Configuration;
import org.openapitools.quantumView.client.auth.*;
import org.openapitools.quantumView.client.models.*;
import org.openapitools.quantumView.client.api.QuantumViewApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com/api");
        
        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        QuantumViewApi apiInstance = new QuantumViewApi(defaultClient);
        String version = "v1"; // String | Version of API
        QUANTUMVIEWRequestWrapper quANTUMVIEWRequestWrapper = new QUANTUMVIEWRequestWrapper(); // QUANTUMVIEWRequestWrapper | Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \"Authorize\" and enter your application credentials, then populate the required parameters above and click \"Try it out\".
        try {
            QUANTUMVIEWResponseWrapper result = apiInstance.quantumView(version, quANTUMVIEWRequestWrapper);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling QuantumViewApi#quantumView");
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
| **version** | **String**| Version of API | [default to v1] |
| **quANTUMVIEWRequestWrapper** | [**QUANTUMVIEWRequestWrapper**](QUANTUMVIEWRequestWrapper.md)| Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. | |

### Return type

[**QUANTUMVIEWResponseWrapper**](QUANTUMVIEWResponseWrapper.md)

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


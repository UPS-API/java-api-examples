# OAuthApi

All URIs are relative to *https://wwwcie.ups.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**generateToken**](OAuthApi.md#generateToken) | **POST** /security/v1/oauth/token |  |



## generateToken

> GenerateTokenSuccessResponse generateToken(grantType, code, redirectUri, xMerchantId)



Generate Token

### Example

```java
// Import classes:
import org.openapitools.oauth.client.ApiClient;
import org.openapitools.oauth.client.ApiException;
import org.openapitools.oauth.client.Configuration;
import org.openapitools.oauth.client.auth.*;
import org.openapitools.oauth.client.models.*;
import org.openapitools.oauth.client.api.OAuthApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        OAuthApi apiInstance = new OAuthApi(defaultClient);
        String grantType = "authorization_code"; // String | Valid values: authorization_code
        String code = "code_example"; // String | Authorization code from the UPS login system.
        String redirectUri = "redirectUri_example"; // String | Callback URL for the requesting application.
        String xMerchantId = "xMerchantId_example"; // String | Client merchant ID
        try {
            GenerateTokenSuccessResponse result = apiInstance.generateToken(grantType, code, redirectUri, xMerchantId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OAuthApi#generateToken");
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
| **grantType** | **String**| Valid values: authorization_code | [default to authorization_code] |
| **code** | **String**| Authorization code from the UPS login system. | |
| **redirectUri** | **String**| Callback URL for the requesting application. | |
| **xMerchantId** | **String**| Client merchant ID | [optional] |

### Return type

[**GenerateTokenSuccessResponse**](GenerateTokenSuccessResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | Invalid Request |  -  |
| **401** | Unauthorized Request |  -  |
| **403** | Blocked Merchant |  -  |
| **429** | Quota Limit Exceeded |  -  |


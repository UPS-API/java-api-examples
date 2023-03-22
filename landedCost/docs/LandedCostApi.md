# LandedCostApi

All URIs are relative to *https://wwwcie.ups.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**landedCost**](LandedCostApi.md#landedCost) | **POST** /landedcost/{version}/quotes | Landed Cost provides an all-inclusive cost estimate of international shipments. |



## landedCost

> LandedCostResponse landedCost(transId, transactionSrc, version, landedCostRequest, accountNumber)

Landed Cost provides an all-inclusive cost estimate of international shipments.

### Example

```java
// Import classes:
import org.openapitools.landed.cost.client.ApiClient;
import org.openapitools.landed.cost.client.ApiException;
import org.openapitools.landed.cost.client.Configuration;
import org.openapitools.landed.cost.client.auth.*;
import org.openapitools.landed.cost.client.models.*;
import org.openapitools.landed.cost.client.api.LandedCostApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com/api");
        
        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        LandedCostApi apiInstance = new LandedCostApi(defaultClient);
        String transId = "transId_example"; // String | An identifier unique to the request. Length 32
        String transactionSrc = "testing"; // String | An identifier of the client/source application that is making the request.Length 512
        String version = "v1"; // String | Version of API
        LandedCostRequest landedCostRequest = new LandedCostRequest(); // LandedCostRequest | Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \"Authorize\" and enter your application credentials, then populate the required parameters above and click \"Try it out\".
        String accountNumber = "accountNumber_example"; // String | 
        try {
            LandedCostResponse result = apiInstance.landedCost(transId, transactionSrc, version, landedCostRequest, accountNumber);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling LandedCostApi#landedCost");
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
| **transId** | **String**| An identifier unique to the request. Length 32 | |
| **transactionSrc** | **String**| An identifier of the client/source application that is making the request.Length 512 | [default to testing] |
| **version** | **String**| Version of API | [default to v1] |
| **landedCostRequest** | [**LandedCostRequest**](LandedCostRequest.md)| Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. | |
| **accountNumber** | **String**|  | [optional] |

### Return type

[**LandedCostResponse**](LandedCostResponse.md)

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


# SingleTrackApiControllerApi

All URIs are relative to *https://wwwcie.ups.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getSingleTrackResponseUsingGET**](SingleTrackApiControllerApi.md#getSingleTrackResponseUsingGET) | **GET** /track/v1/details/{inquiryNumber} | gets single track API details |



## getSingleTrackResponseUsingGET

> TrackApiResponse getSingleTrackResponseUsingGET(inquiryNumber, transId, transactionSrc, locale, returnSignature)

gets single track API details

### Example

```java
// Import classes:
import org.openapitools.track.client.ApiClient;
import org.openapitools.track.client.ApiException;
import org.openapitools.track.client.Configuration;
import org.openapitools.track.client.auth.*;
import org.openapitools.track.client.models.*;
import org.openapitools.track.client.api.SingleTrackApiControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com/api");
        
        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        SingleTrackApiControllerApi apiInstance = new SingleTrackApiControllerApi(defaultClient);
        String inquiryNumber = "inquiryNumber_example"; // String | Inquiry Number
        String transId = "transId_example"; // String | transId
        String transactionSrc = "testing"; // String | transactionSrc
        String locale = "en_US"; // String | locale
        String returnSignature = "false"; // String | returnSignature
        try {
            TrackApiResponse result = apiInstance.getSingleTrackResponseUsingGET(inquiryNumber, transId, transactionSrc, locale, returnSignature);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SingleTrackApiControllerApi#getSingleTrackResponseUsingGET");
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
| **inquiryNumber** | **String**| Inquiry Number | |
| **transId** | **String**| transId | |
| **transactionSrc** | **String**| transactionSrc | [default to testing] |
| **locale** | **String**| locale | [optional] [default to en_US] |
| **returnSignature** | **String**| returnSignature | [optional] [default to false] |

### Return type

[**TrackApiResponse**](TrackApiResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tracking Information found |  -  |
| **207** | Tracking Information not found for all inquiry numbers |  -  |
| **400** | Invalid request |  -  |
| **404** | Tracking number information not found |  -  |
| **500** | Internal server error |  -  |
| **503** | Resource is not available |  -  |


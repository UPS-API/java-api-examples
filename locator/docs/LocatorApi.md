# LocatorApi

All URIs are relative to *https://wwwcie.ups.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**locator**](LocatorApi.md#locator) | **POST** /locations/{version}/search/availabilities/{reqOption} | Get Locator Response |



## locator

> LOCATORResponseWrapper locator(version, reqOption, loCATORRequestWrapper, transId, transactionSrc, locale)

Get Locator Response

### Example

```java
// Import classes:
import org.openapitools.locator.client.ApiClient;
import org.openapitools.locator.client.ApiException;
import org.openapitools.locator.client.Configuration;
import org.openapitools.locator.client.auth.*;
import org.openapitools.locator.client.models.*;
import org.openapitools.locator.client.api.LocatorApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com/api");
        
        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        LocatorApi apiInstance = new LocatorApi(defaultClient);
        String version = "v1"; // String | Version of API
        String reqOption = "reqOption_example"; // String | Indicates the type of request. Valid values: 1-Locations (Drop Locations and Will call locations) 8-All available Additional Services 16-All available Program Types 24-All available Additional Services and Program types 32-All available Retail Locations 40-All available Retail Locations and Additional Services  48-All available Retail Locations and Program Types  56-All available Retail Locations, Additional Services and Program Types  64-Search for UPS Access Point Locations.  
        LOCATORRequestWrapper loCATORRequestWrapper = new LOCATORRequestWrapper(); // LOCATORRequestWrapper | Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \"Authorize\" and enter your application credentials, then populate the required parameters above and click \"Try it out\".
        String transId = "transId_example"; // String | An identifier unique to the request. Length 32
        String transactionSrc = "testing"; // String | An identifier of the client/source application that is making the request.Length 512
        String locale = "en_US"; // String | Locale of request
        try {
            LOCATORResponseWrapper result = apiInstance.locator(version, reqOption, loCATORRequestWrapper, transId, transactionSrc, locale);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling LocatorApi#locator");
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
| **reqOption** | **String**| Indicates the type of request. Valid values: 1-Locations (Drop Locations and Will call locations) 8-All available Additional Services 16-All available Program Types 24-All available Additional Services and Program types 32-All available Retail Locations 40-All available Retail Locations and Additional Services  48-All available Retail Locations and Program Types  56-All available Retail Locations, Additional Services and Program Types  64-Search for UPS Access Point Locations.   | |
| **loCATORRequestWrapper** | [**LOCATORRequestWrapper**](LOCATORRequestWrapper.md)| Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. | |
| **transId** | **String**| An identifier unique to the request. Length 32 | [optional] |
| **transactionSrc** | **String**| An identifier of the client/source application that is making the request.Length 512 | [optional] [default to testing] |
| **locale** | **String**| Locale of request | [optional] [default to en_US] |

### Return type

[**LOCATORResponseWrapper**](LOCATORResponseWrapper.md)

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


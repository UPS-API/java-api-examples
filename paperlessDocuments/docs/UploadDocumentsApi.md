# UploadDocumentsApi

All URIs are relative to *https://wwwcie.ups.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**upload**](UploadDocumentsApi.md#upload) | **POST** /paperlessdocuments/{version}/upload | The Paperless Document API web service allows the users to upload,delete and push to image repository their own customized trade documents for customs clearance to Forms History.  |



## upload

> PAPERLESSDOCUMENTUploadResponseWrapper upload(version, shipperNumber, paPERLESSDOCUMENTUploadRequestWrapper, transId, transactionSrc)

The Paperless Document API web service allows the users to upload,delete and push to image repository their own customized trade documents for customs clearance to Forms History. 

### Example

```java
// Import classes:
import org.openapitools.paperlessDocuments.client.ApiClient;
import org.openapitools.paperlessDocuments.client.ApiException;
import org.openapitools.paperlessDocuments.client.Configuration;
import org.openapitools.paperlessDocuments.client.auth.*;
import org.openapitools.paperlessDocuments.client.models.*;
import org.openapitools.paperlessDocuments.client.api.UploadDocumentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com/api");
        
        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        UploadDocumentsApi apiInstance = new UploadDocumentsApi(defaultClient);
        String version = "v1"; // String | Version of API
        String shipperNumber = "shipperNumber_example"; // String | Shipper Number
        PAPERLESSDOCUMENTUploadRequestWrapper paPERLESSDOCUMENTUploadRequestWrapper = new PAPERLESSDOCUMENTUploadRequestWrapper(); // PAPERLESSDOCUMENTUploadRequestWrapper | Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \"Authorize\" and enter your application credentials, then populate the required parameters above and click \"Try it out\".
        String transId = "transId_example"; // String | An identifier unique to the request. Length 32
        String transactionSrc = "testing"; // String | An identifier of the client/source application that is making the request.Length 512
        try {
            PAPERLESSDOCUMENTUploadResponseWrapper result = apiInstance.upload(version, shipperNumber, paPERLESSDOCUMENTUploadRequestWrapper, transId, transactionSrc);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling UploadDocumentsApi#upload");
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
| **shipperNumber** | **String**| Shipper Number | |
| **paPERLESSDOCUMENTUploadRequestWrapper** | [**PAPERLESSDOCUMENTUploadRequestWrapper**](PAPERLESSDOCUMENTUploadRequestWrapper.md)| Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. | |
| **transId** | **String**| An identifier unique to the request. Length 32 | [optional] |
| **transactionSrc** | **String**| An identifier of the client/source application that is making the request.Length 512 | [optional] [default to testing] |

### Return type

[**PAPERLESSDOCUMENTUploadResponseWrapper**](PAPERLESSDOCUMENTUploadResponseWrapper.md)

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


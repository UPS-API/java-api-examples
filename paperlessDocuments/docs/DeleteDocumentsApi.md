# DeleteDocumentsApi

All URIs are relative to *https://wwwcie.ups.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**delete**](DeleteDocumentsApi.md#delete) | **DELETE** /paperlessdocuments/{version}/DocumentId/ShipperNumber | The Paperless Document API web service allows the users to upload their own customized trade documents for customs clearance to Forms History.  |



## delete

> PAPERLESSDOCUMENTDeleteResponseWrapper delete(version, shipperNumber, documentId, transId, transactionSrc)

The Paperless Document API web service allows the users to upload their own customized trade documents for customs clearance to Forms History. 

### Example

```java
// Import classes:
import org.openapitools.paperlessDocuments.client.ApiClient;
import org.openapitools.paperlessDocuments.client.ApiException;
import org.openapitools.paperlessDocuments.client.Configuration;
import org.openapitools.paperlessDocuments.client.auth.*;
import org.openapitools.paperlessDocuments.client.models.*;
import org.openapitools.paperlessDocuments.client.api.DeleteDocumentsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com/api");
        
        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        DeleteDocumentsApi apiInstance = new DeleteDocumentsApi(defaultClient);
        String version = "v1"; // String | Version of API
        String shipperNumber = "shipperNumber_example"; // String | Your Shipper Number
        String documentId = "documentId_example"; // String | DocumentId representing uploaded document to Forms History.  Only one DocumentID will be accepted for delete request.
        String transId = "transId_example"; // String | An identifier unique to the request. Length 32
        String transactionSrc = "testing"; // String | An identifier of the client/source application that is making the request.Length 512
        try {
            PAPERLESSDOCUMENTDeleteResponseWrapper result = apiInstance.delete(version, shipperNumber, documentId, transId, transactionSrc);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DeleteDocumentsApi#delete");
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
| **shipperNumber** | **String**| Your Shipper Number | |
| **documentId** | **String**| DocumentId representing uploaded document to Forms History.  Only one DocumentID will be accepted for delete request. | |
| **transId** | **String**| An identifier unique to the request. Length 32 | [optional] |
| **transactionSrc** | **String**| An identifier of the client/source application that is making the request.Length 512 | [optional] [default to testing] |

### Return type

[**PAPERLESSDOCUMENTDeleteResponseWrapper**](PAPERLESSDOCUMENTDeleteResponseWrapper.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **401** | Unauthorized Request |  -  |


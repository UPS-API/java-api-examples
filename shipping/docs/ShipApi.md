# ShipApi

All URIs are relative to *https://wwwcie.ups.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**labelRecovery**](ShipApi.md#labelRecovery) | **POST** /labels/{version}/recovery | The Label Shipping API allows us to retrieve forward and return labels. |
| [**shipment**](ShipApi.md#shipment) | **POST** /shipments/{version}/ship | The Shipping API makes UPS shipping services available to client applications that communicate with UPS  using the Internet |
| [**voidShipment**](ShipApi.md#voidShipment) | **DELETE** /shipments/{version}/void/cancel/{shipmentidentificationnumber} | The Void Shipping API is used to cancel the previously scheduled shipment |



## labelRecovery

> LABELRECOVERYResponseWrapper labelRecovery(version, laBELRECOVERYRequestWrapper, transId, transactionSrc)

The Label Shipping API allows us to retrieve forward and return labels.

Label Recovery

### Example

```java
// Import classes:
import org.openapitools.shipping.client.ApiClient;
import org.openapitools.shipping.client.ApiException;
import org.openapitools.shipping.client.Configuration;
import org.openapitools.shipping.client.auth.*;
import org.openapitools.shipping.client.models.*;
import org.openapitools.shipping.client.api.ShipApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com/api");
        
        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        ShipApi apiInstance = new ShipApi(defaultClient);
        String version = "v1"; // String | When UPS introduces new elements in the  response that are not associated with new  request elements, Subversion is used. This  ensures backward compatibility.  v1  original features of the application. No  support for CODTurn-inPage, HighValueReport  or InternationalForms features returned in the  response v1701  includes support for CODTurn-inPage  features returned in the response. V1903  Length 5
        LABELRECOVERYRequestWrapper laBELRECOVERYRequestWrapper = new LABELRECOVERYRequestWrapper(); // LABELRECOVERYRequestWrapper | Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \"Authorize\" and enter your application credentials, then populate the required parameters above and click \"Try it out\".
        String transId = "transId_example"; // String | An identifier unique to the request. Length 32
        String transactionSrc = "testing"; // String | An identifier of the client/source application that is making the request.Length 512
        try {
            LABELRECOVERYResponseWrapper result = apiInstance.labelRecovery(version, laBELRECOVERYRequestWrapper, transId, transactionSrc);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ShipApi#labelRecovery");
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
| **version** | **String**| When UPS introduces new elements in the  response that are not associated with new  request elements, Subversion is used. This  ensures backward compatibility.  v1  original features of the application. No  support for CODTurn-inPage, HighValueReport  or InternationalForms features returned in the  response v1701  includes support for CODTurn-inPage  features returned in the response. V1903  Length 5 | [default to v1] |
| **laBELRECOVERYRequestWrapper** | [**LABELRECOVERYRequestWrapper**](LABELRECOVERYRequestWrapper.md)| Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. | |
| **transId** | **String**| An identifier unique to the request. Length 32 | [optional] |
| **transactionSrc** | **String**| An identifier of the client/source application that is making the request.Length 512 | [optional] [default to testing] |

### Return type

[**LABELRECOVERYResponseWrapper**](LABELRECOVERYResponseWrapper.md)

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


## shipment

> SHIPResponseWrapper shipment(version, shIPRequestWrapper, transId, transactionSrc, additionaladdressvalidation)

The Shipping API makes UPS shipping services available to client applications that communicate with UPS  using the Internet

Shipping

### Example

```java
// Import classes:
import org.openapitools.shipping.client.ApiClient;
import org.openapitools.shipping.client.ApiException;
import org.openapitools.shipping.client.Configuration;
import org.openapitools.shipping.client.auth.*;
import org.openapitools.shipping.client.models.*;
import org.openapitools.shipping.client.api.ShipApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com/api");
        
        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        ShipApi apiInstance = new ShipApi(defaultClient);
        String version = "v1"; // String | Indicates Ship API to display the new release features in  Rate API response based on Ship release. See the New  section for the latest Ship release. Supported values: v1,  v1601, v1607, v1701, 1801 . Length 5
        SHIPRequestWrapper shIPRequestWrapper = new SHIPRequestWrapper(); // SHIPRequestWrapper | Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \"Authorize\" and enter your application credentials, then populate the required parameters above and click \"Try it out\".
        String transId = "transId_example"; // String | An identifier unique to the request. Length 32
        String transactionSrc = "testing"; // String | An identifier of the client/source application that is making the request.Length 512
        String additionaladdressvalidation = "additionaladdressvalidation_example"; // String | Valid Values:  city = validation will include city.Length 15
        try {
            SHIPResponseWrapper result = apiInstance.shipment(version, shIPRequestWrapper, transId, transactionSrc, additionaladdressvalidation);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ShipApi#shipment");
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
| **version** | **String**| Indicates Ship API to display the new release features in  Rate API response based on Ship release. See the New  section for the latest Ship release. Supported values: v1,  v1601, v1607, v1701, 1801 . Length 5 | [default to v1] |
| **shIPRequestWrapper** | [**SHIPRequestWrapper**](SHIPRequestWrapper.md)| Generate sample code for popular API requests by selecting an example below. To view a full sample request and response, first click \&quot;Authorize\&quot; and enter your application credentials, then populate the required parameters above and click \&quot;Try it out\&quot;. | |
| **transId** | **String**| An identifier unique to the request. Length 32 | [optional] |
| **transactionSrc** | **String**| An identifier of the client/source application that is making the request.Length 512 | [optional] [default to testing] |
| **additionaladdressvalidation** | **String**| Valid Values:  city &#x3D; validation will include city.Length 15 | [optional] |

### Return type

[**SHIPResponseWrapper**](SHIPResponseWrapper.md)

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


## voidShipment

> VOIDSHIPMENTResponseWrapper voidShipment(version, shipmentidentificationnumber, transId, transactionSrc, trackingnumber)

The Void Shipping API is used to cancel the previously scheduled shipment

Void Shipment

### Example

```java
// Import classes:
import org.openapitools.shipping.client.ApiClient;
import org.openapitools.shipping.client.ApiException;
import org.openapitools.shipping.client.Configuration;
import org.openapitools.shipping.client.auth.*;
import org.openapitools.shipping.client.models.*;
import org.openapitools.shipping.client.api.ShipApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://wwwcie.ups.com/api");
        
        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        ShipApi apiInstance = new ShipApi(defaultClient);
        String version = "v1"; // String | API Version
        String shipmentidentificationnumber = "shipmentidentificationnumber_example"; // String | The shipment's identification number  Alpha-numeric. Must pass 1Z rules. Must be  upper case. Length 18
        String transId = "transId_example"; // String | An identifier unique to the request. Length 32
        String transactionSrc = "testing"; // String | An identifier of the client/source application that is making the request.Length 512
        String trackingnumber = "trackingnumber_example"; // String | The package's tracking number. You may have  up to 20 different tracking numbers listed. If more than one tracking number, pass this  value as: trackingnumber=  [\"1ZISUS010330563105\",\"1ZISUS01033056310 8\"] with a coma separating each number. Alpha-numeric. Must pass 1Z rules. Must be  upper case. Length 18
        try {
            VOIDSHIPMENTResponseWrapper result = apiInstance.voidShipment(version, shipmentidentificationnumber, transId, transactionSrc, trackingnumber);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ShipApi#voidShipment");
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
| **shipmentidentificationnumber** | **String**| The shipment&#39;s identification number  Alpha-numeric. Must pass 1Z rules. Must be  upper case. Length 18 | |
| **transId** | **String**| An identifier unique to the request. Length 32 | [optional] |
| **transactionSrc** | **String**| An identifier of the client/source application that is making the request.Length 512 | [optional] [default to testing] |
| **trackingnumber** | **String**| The package&#39;s tracking number. You may have  up to 20 different tracking numbers listed. If more than one tracking number, pass this  value as: trackingnumber&#x3D;  [\&quot;1ZISUS010330563105\&quot;,\&quot;1ZISUS01033056310 8\&quot;] with a coma separating each number. Alpha-numeric. Must pass 1Z rules. Must be  upper case. Length 18 | [optional] |

### Return type

[**VOIDSHIPMENTResponseWrapper**](VOIDSHIPMENTResponseWrapper.md)

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


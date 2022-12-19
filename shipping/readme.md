# Shipping 
## Introduction
The Shipping Package RESTful API gives your applications many ways to manage the shipment of packages to their
destination. UPS offers a range of delivery time frames from same day to standard ground transportation. Shipments
may be within the United States or international, and they may range from documents to large packages.
UPS also supports many valued added services for shipments, including collect on delivery (COD), declared value,
delivery confirmation, and automatic notification of delivery status.

## Getting Started
### Prerequisites
- You will need to have Maven and the Java Development Kit installed.

### Download
- You can either download a local copy or clone the repository:

```sh
git clone https://github.com/UPS-API/java-api-examples.git
```

### Insert Your Information
- Update your OAuth Client information in <project home>/src/main/resources/application.properties file. These values can be found in the UPS Developer Portal under Apps and your specific application's information.

|Property Name |
| :------: |
|```api.oauth.partner.client.id```|
|```api.oauth.partner.secret```|

- Update your client information in any tags marked with "< >" within the <project home>/src/main/resources/ json files. For this API there are the following fields:

|                          Property Name                         |
|:-------------------------------------------------------------------:| 
|                       ```<Shipper Number> ```                       |
|              ```        <your email address>       ```              |
|        ```           <your From EMail Address>          ```         |
|          ```           <your Account Number>          ```           |
| ```           <your UndeliverableEMailAddress address>          ``` |
|         ```           <youre Tracking Number>          ```          |
|         ```           < PreDeparture ITN Number>         ```        |
|         ```          <Tax Identification Number>         ```        |
|         ```          <Invoice Number>        ```                    |
|         ```          <Purchase Order Number>         ```            |
|         ```          <Entry Number>         ```                     |


### Build and run

- Build the project using Maven
```sh
cd <project home>
mvn clean package
```

- Run the project that is generated in the <project home>/target directory.
```sh
java -jar shipping-x.x.x.jar
```
- Check the console for the application's REST response.


## Code Walk Through
There are 3 notable class in this tutorial, namely com.ups.api.app.AppConfig and 
com.ups.api.app.ShippingDemo.  The AppConfig class is a configuration class leveraging 
Spring injection to incorporate the property value from 
src/main/resources/application.properties file.  The ShippingDemo is to illustrate how 
to use the Shipping api.


> Get an access token via OAuth client_credentials grant type.

```java
 // Prepare shipping api access.
final String accessToken = Util.getAccessToken(appConfig, restTemplate);
        ShipApi shipApi = api.get();
        if (null == shipApi) {
        shipApi = new ShipApi(new ApiClient(restTemplate));
        shipApi.getApiClient().setBasePath(appConfig.getShippingBaseUrl());
        api.set(shipApi);
        }
        shipApi.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
```
> initializeShipApi function is to create a ship api object with the base url and 
populated the HTTP Authorization header with the access token.
	
##Shipping code				
```java
//this code for shipmentReques
	 SHIPRequestWrapper shipmentRequest = Util.createRequestFromJsonFile(
             entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME), SHIPRequestWrapper.class,
        appConfig);
final String transId = UUID.randomUUID().toString().replaceAll("-", "");

final ShipApi shipApi = getShipApi(restTemplate, appConfig);

        SHIPResponseWrapper shipResponseWrapper = Util.jsonResultPreprocess(
        shipApi.shipment(appConfig.getShippingVersion(), shipmentRequest, transId,
        appConfig.getTransactionSrc(), null),
        Util.getJsonToObjectConversionMap(), SHIPResponseWrapper.class);
        ShipmentResponse shipmentResponse = shipResponseWrapper.getShipmentResponse();
        if (trackingNumber == null) {
        trackingNumber = shipmentResponse.getShipmentResults().getPackageResults().getTrackingNumber();
        shipmentIdentificationNumber = shipmentResponse.getShipmentResults()
        .getShipmentIdentificationNumber();
        }
```
> It reconstructs a SHIPRequestWrapper object from a json file.  In a typical 
application, a SHIPRequestWrapper object would be created via a default constructor 
and calling setter to populate the attribute instead.
> A SHIPResponseWrapper will be returned from backend server for a particular shipment
specified in the SHIPResponseWrapper object.  The SHIPResponseWrapper would have a
validation error if there is any as well as emsResponse, which includes a list of
available UPS service and service detail, to a successful request.

##Label Recovery
```java
 LABELRECOVERYRequestWrapper labelRecoveryRequest = Util.createRequestFromJsonFile(
        entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
        LABELRECOVERYRequestWrapper.class, appConfig);

final String transId = UUID.randomUUID().toString().replaceAll("-", "");

final ShipApi shipApi = getShipApi(restTemplate, appConfig);
        LABELRECOVERYResponseWrapper labelrecoveryResponseWrapper = shipApi.labelRecovery(
        appConfig.getShippingVersion(), labelRecoveryRequest, transId, appConfig.getTransactionSrc());
        appConfig.getTransactionSrc(), trackingNumber);
```
> It reconstructs a LABELRECOVERYRequestWrapper object from a json file.  In a typical
application, a LABELRECOVERYRequestWrapper object would be created via a default constructor
and calling setter to populate the attribute instead.
> A LABELRECOVERYResponseWrapper will be returned from backend server for a particular shipment
specified in the LABELRECOVERYResponseWrapper object.  The LABELRECOVERYResponseWrapper would have a
validation error if there is any as well as LABELRECOVERYResponseWrapper, which includes a list of
available UPS service and service detail, to a successful request.


##Label Recovery
```java
 final ShipApi shipApi = getShipApi(restTemplate, appConfig);
final String transId = UUID.randomUUID().toString().replace("-", "");
        VOIDSHIPMENTResponseWrapper voidshipmentResponseWrapper = shipApi.voidShipment(
        appConfig.getShippingVersion(), shipmentIdentificationNumber, transId,
        appConfig.getTransactionSrc(), trackingNumber);
```

> A VOIDSHIPMENTResponseWrapper will be returned from backend server for a particular shipment
specified in the VOIDSHIPMENTResponseWrapper object.  The LABELRECOVERYResponseWrapper would have a
validation error if there is any as well as VOIDSHIPMENTResponseWrapper, which includes a list of
available UPS service and service detail, to a successful request.

### Data Schema
- [Request Schema SHIPRequestWrapper](docs/SHIPRequestWrapper.md)

- [Response Schema SHIPResponseWrapper](docs/SHIPResponseWrapper.md)

- [Request Schema LABELRECOVERYRequestWrapper](docs/LABELRECOVERYRequestWrapper.md)

- [Response Schema LABELRECOVERYResponseWrapper](docs/LABELRECOVERYResponseWrapper.md)

- [Response Schema VOIDSHIPMENTResponseWrapper](docs/VOIDSHIPMENTResponseWrapper.md)


## Sample Request
### Negotiated Rates
- The Shipping Package RESTful API provides access to Published Rates and Negotiated Rates. A negotiated rate is
  established by contract between the customer and UPS.

[Sample Request Negotiated Rates](src/main/resources/ShippingRequestwithNegotiatedRates.json)

[Sample Response Negotiated Rates](src/main/resources/Response/ShippingRequestwithNegotiatedRatesResponse.json)



### Shipping Request with International Forms

[Shipping Request with International Forms](src/main/resources/ShippingRequestwithInternationalForms.json)

[Sample Response International Forms](src/main/resources/Response/ShippingRequestwithInternationalFormsResponse.json)

### Shipping Dry Ice or Lithium Batteries

[Shipping Request Shipping Dry Ice or Lithium Batteries](src/main/resources/ShippingDryIceOrLithiumBatteries.json)

[Sample Response Shipping Dry Ice or Lithium Batteries](src/main/resources/Response/ShippingDryIceOrLithiumBatteriesResponse.json)

###  Shipping Hazmat Goods Request

Customers must computer generate the UPS Hazardous Materials Shipping Paper or Shipper's Declaration. There is
no validation for a hazardous materials shipment request

[Shipping Request Shipping Hazmat Goods Request](src/main/resources/ShippingHazmatGoods.json)

[Sample Response Shipping Hazmat Goods](src/main/resources/Response/ShippingHazmatGoodsResponse.json)

###  Billing Third Party

[Shipping Request Billing Third Party](src/main/resources/ShippingBillingThirdParty.json)

[Sample Response Billing Third Party](src/main/resources/Response/ShippingBillingThirdPartyResponse.json)

###  Multi-Piece Shipping

[Shipping Request Multi-Piece Shipping](src/main/resources/ShippingMultiPieceShipping.json)

[Sample Response Multi-Piece Shipping](src/main/resources/Response/ShippingMultiPieceShippingResponse.json)
###  Ship to a UPS Access Point

[Shipping Request Ship to a UPS Access Point](src/main/resources/ShipToAUPSAccessPoint.json)

[Sample Response Ship to a UPS Access Point](src/main/resources/Response/ShipToAUPSAccessPointResponse.json)

###  Proactive Response Shipping

[Shipping Request Proactive Response Shipping](src/main/resources/ShippingProactiveResponse.json)

[Sample Response Proactive Response Shipping](src/main/resources/Response/ShippingProactiveResponse.json)

###  World Wide Economy Shipping
UPS Worldwide Economy (WWE) allows shippers to manifest low weight, low value goods destined for international
consignees. Shippers can either consolidate their WWE shipments into a larger “Master Carton” for shipping to an in
country UPS Export Facility; or they can provide their own transportation of the WWE shipments to the UPS Export
Facility.
WWE shipments that have been consolidated into a Master Carton are linked via a MasterCartonID, which provides
enhanced tracking capability between the WWE shipments contained within and the Master Carton itself.

[Shipping Request WorldWide Economy Shipping](src/main/resources/WorldWideEconomyShipping.json)

[Sample Response WorldWide Economy Shipping](src/main/resources/Response/WorldWideEconomyShippingResponse.json)
## Label Recovery Request
[Shipping Request Label Recovery](src/main/resources/LabelRecoveryRequest.json)

[Sample Response Label Recovery](src/main/resources/Response/LabelRecoveryResponse.json)

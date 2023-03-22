# Landed Cost
## Introduction
The Landed Cost Quoting API allows customers to get In this document, you will find guidance and instructions for integrating the Landed Cost Quoting and Parts RESTful
API into your application, service, or system.

## Getting Started
### Prerequisites
- You will need to have Maven and the Java Development Kit installed.

### Download
- You can either download a local copy or clone the repository:

```sh
git clone <https://github.com/ups/api-examples>
```

### Insert Your Information
- Update your OAuth Client information in <project home>/src/main/resources/application.properties file. These values can be found in the UPS Developer Portal under Apps and your specific application's information.

|Property Name |
| :------: |
|```api.oauth.partner.client.id```|
|```api.oauth.partner.secret```|


### Build and run

- Build the project using Maven
```sh
cd <project home>
mvn clean package
```

- Run the project that is generated in the <project home>/target directory.
```sh
java -jar landed-x.x.x.jar
```
- Check the console for the application's REST response.


## Code Walk Through
There are 2 notable class in this tutorial, namely com.ups.api.app.AppConfig and 
com.ups.api.app.LandedCostDemo.  The AppConfig class is a configuration class leveraging 
Spring injection to incorporate the property value from 
src/main/resources/application.properties file.  The LandedCostDemo is to illustrate how 
to use the Landed cost api.

```java
    LandedCostRequest landedCostRequest = Util.createRequestFromJsonFile(
        entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME), LandedCostRequest.class,
        appConfig);
```
> Each iteration will create an instance of LandedCostRequest from a pre-determined json file 
> .Creating object via default constructor and injecting properties followed by
a set of setter to populate the necessary attribute.


```java
 LandedCostResponse landedCostResponse = sendRequest(landedCostRequest, transId);
```
> The sendRequest function creates a Landed Cost Api object and set the access token expiry tolerance if it haven't created one yet as well as populating with a valid access token and processing request and getting response for landed cost. 

### Data Schema
- [Request Schema LandedCostRequest](docs/LandedCostRequest.md)

- [Response Schema LandedCostResponse](docs/LandedCostResponse.md)

### Sample Request/Response
### Landed Cost request
- Landed Cost provides an all-inclusive cost estimate of international shipments.

```json
{
  "currencyCode": "GBP",
  "transID": "325467165",
  "allowPartialLandedCostResult": false,
  "alversion": 0,
  "shipment": {
    "id": "ShipmentID83",
    "importCountryCode": "GB",
    "importProvince": "",
    "shipDate": "",
    "exportCountryCode": "US",
    "incoterms": "",
    "shipmentItems": [
      {
        "commodityId": "1",
        "grossWeightUnit": "",
        "priceEach": "125",
        "hsCode": "400932",
        "quantity": 24,
        "UOM": "Each",
        "originCountryCode": "GB",
        "commodityCurrencyCode": "GBP",
        "description": ""
      },
      {
        "commodityId": "4",
        "grossWeightUnit": "",
        "priceEach": "0.5",
        "hsCode": "",
        "quantity": 900,
        "UOM": "Each",
        "originCountryCode": "GB",
        "commodityCurrencyCode": "GBP",
        "description": "Cord 5mm {PK50 Yellow/Red"
      }
    ],
    "transModes": "",
    "shipmentType": "Sale"
  }
}
```


### Landed Cost Response 

```json
{
  "shipment": {
    "currencyCode": "GBP",
    "id": "ShipmentID83",
    "brokerageFeeItems": [
      {
        "chargeName": "Disbursement Fee",
        "chargeAmount": 19.05
      },
      {
        "chargeName": "Entry Preparation Fee",
        "chargeAmount": 5.6
      }
    ],
    "totalBrokerageFees": 24.65,
    "totalDuties": 60,
    "totalCommodityLevelTaxesAndFees": 0,
    "totalShipmentLevelTaxesAndFees": 0,
    "totalVAT": 702,
    "totalDutyandTax": 762,
    "grandTotal": 786.65,
    "importCountryCode": "GB",
    "shipmentItems": [
      {
        "commodityId": "1",
        "commodityDuty": 60,
        "totalCommodityTaxesAndFees": 0,
        "commodityVAT": 612,
        "totalCommodityDutyandTax": 672,
        "commodityCurrencyCode": "GBP",
        "isCalculable": true,
        "hsCode": "4009320090"
      },
      {
        "commodityId": "4",
        "commodityDuty": 0,
        "totalCommodityTaxesAndFees": 0,
        "commodityVAT": 90,
        "totalCommodityDutyandTax": 90,
        "commodityCurrencyCode": "GBP",
        "isCalculable": true,
        "hsCode": "8546901000"
      }
    ]
  },
  "alversion": 0,
  "dpversion": null,
  "transID": "325467165",
  "error": null,
  "perfStats": {
    "absLayerTime": "169",
    "fulfillTime": "Mon Feb 06 8:00:02.979 -05:00 2023",
    "receiptTime": "Mon Feb 06 8:00:02.809 -05:00 2023"
  }
}
```
# Time in Transit
## Introduction
  Time in Transit, TNT, is an api for obtaining number of days in transit, pickup, delivery times, and an indication of whether or not UPS can guarantee the delivery time for a shipment information including origin, destination, and desired service. It expects a TimeInTransitRequest json object in a request body and returns a TimeInTransitResponse in a response body.  The TimeInTransitResponse would include a validationList in a case of invalid shipping information.

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

### Build and run

- Build the project using Maven
```sh
cd <project home>
mvn clean package
```

- Run the project that is generated in the <project home>/target directory.
```sh
java -jar timeInTransit-x.x.x.jar 
```
- Check the console for the application's REST response.


## Code Walk Through
There are 2 notable classes in this tutorial, namely com.ups.api.app.AppConfig and com.ups.api.app.TNTDemo.  The AppConfig class is a configuration class leveraging Spring injection to incorporate the property value from src/main/resources/application.properties file.  The TNTDemo is to illustrate how to use the TNT api.

					
```java
	TimeInTransitRequest timeInTransitRequest = Util.createRequestFromJsonFile(entry.getKey(),
								entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
								TimeInTransitRequest.class,
								appConfig,
								Arrays.asList(new CreateRequestEnricher() {}));
```
> It reconstructs a TimeInTransitRequest object from a json file which includes 
origin/destination address and other required information.  In a typical application, 
a TimeInTransitRequest object would be created via a default constructor followed by 
a set of setter to populate the necessary attribute.


```java
	// Get a time in transit information for a particular shipment.
	TimeInTransitResponse timeInTransitResponse = sendRequest(timeInTransitRequest, transId);
```
> The sendRequest function creates a TNT api object and set the access token expiry tolerance if it haven't created one yet as well as populating with a valid access token.  A TimeInTransitResponse will be returned from a backend server for a particular shipment specified in the TimeInTransitRequest object.  The TimeInTransitResponse would have a validation error if there is any as well as emsResponse, which includes a list of available UPS service and service detail, to a successful request.


### Data Schema 
- [Request Schema TimeInTransitRequest](docs/TimeInTransitRequest.md)

- [Response Schema TimeInTransitResponse](docs/TimeInTransitResponse.md)

### Sample Request/Response
- An international TimeInTransitRequest request for a shipment of "Non Document" 
package from Germany to United States
```json
{
  "originCountryCode": "DE",
  "originStateProvince": "",
  "originCityName": "",
  "originTownName": "",
  "originPostalCode": "10703",
  "destinationCountryCode": "US",
  "destinationStateProvince": "NH",
  "destinationCityName": "MANCHESTER",
  "destinationTownName": "",
  "destinationPostalCode": "03104",
  "weight": "10.5",
  "weightUnitOfMeasure": "LBS",
  "shipmentContentsValue": "10.5",
  "shipmentContentsCurrencyCode": "USD",
  "billType": "03",
  "shipDate": "2022-10-07",
  "shipTime": "",
  "residentialIndicator": "",
  "numberOfPackages": "1"
}
```


- An domestic TimeInTransitRequest request
```json
{
  "originCountryCode": "US",
  "originPostalCode": "11023",
  "destinationCountryCode": "US",
  "destinationTownName": "",
  "destinationPostalCode": "03104",
  "weight": "10.5",
  "weightUnitOfMeasure": "LBS",
  "shipDate": "2022-10-07",
  "shipTime": "",
  "residentialIndicator": "",
  "numberOfPackages": "1"
}
```

- A successful TimeInTransitResponse response
```json
{
  "validationList": null,
  "destinationPickList": null,
  "originPickList": null,
  "emsResponse": {
    "shipDate": "2022-10-14",
    "shipTime": "13:0:36",
    "serviceLevel": "A",
    "billType": "02",
    "dutyType": null,
    "residentialIndicator": "02",
    "destinationCountryName": "UNITED STATES",
    "destinationCountryCode": "US",
    "destinationPostalCode": "03104",
    "destinationPostalCodeLow": "03104",
    "destinationPostalCodeHigh": "03104",
    "destinationStateProvince": "NH",
    "destinationCityName": "MANCHESTER",
    "originCountryName": "UNITED STATES",
    "originCountryCode": "US",
    "originPostalCode": "11023",
    "originPostalCodeLow": "11023",
    "originPostalCodeHigh": "11023",
    "originStateProvince": "NY",
    "originCityName": "GREAT NECK",
    "weight": "10.5",
    "weightUnitOfMeasure": "LBS",
    "shipmentContentsValue": "10.5",
    "shipmentContentsCurrencyCode": "USD",
    "guaranteeSuspended": false,
    "numberOfServices": 9,
    "services": [
      {
        "serviceLevel": "1DMS",
        "serviceLevelDescription": "UPS Next Day Air® Early",
        "shipDate": "2022-10-14",
        "deliveryDate": "2022-10-15",
        "commitTime": "09:00:00",
        "deliveryTime": "09:00:00",
        "deliveryDayOfWeek": "SAT",
        "nextDayPickupIndicator": "0",
        "saturdayPickupIndicator": "0",
        "saturdayDeliveryDate": null,
        "saturdayDeliveryTime": null,
        "serviceRemarksText": null,
        "guaranteeIndicator": "0",
        "totalTransitDays": 0,
        "businessTransitDays": 1,
        "restDaysCount": 0,
        "holidayCount": 0,
        "delayCount": 0,
        "pickupDate": "2022-10-14",
        "pickupTime": "19:00:00",
        "cstccutoffTime": "17:00:00",
        "poddate": null,
        "poddays": 0
      },
     ...
    }
  }
}
```

- A TimeInTransitResponse response with invalid shipDate
```json
{
  "validationList": {
    "invalidFieldList": [
      "ShipDate"
    ],
    "invalidFieldListCodes": [
      "1085"
    ],
    "destinationAmbiguous": false,
    "originAmbiguous": false
  },
  "destinationPickList": null,
  "originPickList": null,
  "emsResponse": null
}
```
### Glossary

|Term|Definition|
| :------: | :------: |
|billType | can be non-document, document, WWEF, Pallet.|
|transId| is a 32 character long unique identifier which is being used internally troubleshooting issue.|
|transactionSrc|is a maximum 512 character long string to identify an application sending a request; however, it is optional for partner application (suggested to use your company).|
|WWDT|World Wide Delivery Time is one of UPS api.|
|WWEF|World Wide Express Flight is a division of UPS for shipping.|
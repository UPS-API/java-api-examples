# PreNotification
## Introduction
The Pre-Notification API allows customer applications to inform UPS operations of Dangerous Goods shipments as they are processed and will enter the UPS transportation network prior to an upload of manifest information at the end of the day.

## Getting Started
### Prerequisites
- You will need to have Maven and the Java Development Kit installed.

### Download
- You can either download a local copy or clone the repository:

```sh
git clone <https://github.com/UPS-API/java-api-examples>
```

### Insert Your Information
- Update your OAuth Client information in <project home>/src/main/resources/application.properties file. These values can be found in the UPS Developer Portal under Apps and your specific application's information.

|Property Name |
| :------: |
|```api.oauth.partner.client.id```|
|```api.oauth.partner.secret```|

- Update your client information in any tags marked with "< >" within the <project home>/src/main/resources/ json files. For this API there are the following fields:

|Property Name |
| :------: |
|```<Shipper Number>```|
|```<Tracking Number>```|
|```<Shipment Identification Number>```|
|```<ID Number>```|
|```<Regulation Set>```|

### Build and run

- Build the project using Maven
```sh
cd <project home>
mvn clean package
```

- Run the project that is generated in the <project home>/target directory.
```sh
java -jar preNotification-x.x.x.jar    
```
- check console output for application result


## Code Walk Through
There are 2 notable class in this tutorial, namely com.ups.api.app.AppConfig and 
com.ups.api.app.PreNotification.  The AppConfig class is a configuration class leveraging 
Spring injection to incorporate the property value from 
src/main/resources/application.properties file.  The PreNotification class is to illustrate how to use the preNotification api.

```java
 String accessToken = Util.getAccessToken(appConfig, restTemplate);
```
> Get an access token via OAuth client_credentials grant type.


## preNotification
					
```java
	// Create Pre Notification Request from a pre-determined json file
	PRENOTIFICATIONRequestWrapper preNotificationRequestWrapper = Util.createRequestFromJsonFile(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
						PRENOTIFICATIONRequestWrapper.class);						
```
> It reconstructs a PreNotification Request Wrapper object from a json file.  In a typical 
application, a PRENOTIFICATIONRequestWrapper object would be created via a default constructor 
and calling setter to populate the attribute instead.

```java
	// Get Pre Notification status
	PRENOTIFICATIONResponseWrapper preNotificationResponseWrapper = this.sendRequest(preNotificationRequestWrapper);					
```
> The sendRequest function creates a PreNotification api object and set the access token expiry tolerance if it haven't created one yet as well as populating with a valid access token. A Wrapper with PreNotification response  will be returned from backend server providing the notification status with transaction identifier. 

### Data Schema 
 - [Request Schema PRENOTIFICATIONRequestWrapper](docs/PRENOTIFICATIONRequestWrapper.md)
 - [Response Schema PRENOTIFICATIONResponseWrapper](docs/PRENOTIFICATIONResponseWrapper.md)


### Sample Request
```json
{
  "PreNotificationRequest": {
    "Request": {
      "TransactionReference": {
        "CustomerContext": "",
        "TransactionIdentifier": ""
      }
    },
    "Shipment": {
      "ShipperNumber": "<Shipper Number>",
      "ShipmentIdentificationNumber": "<Shipment Identification Number>",//holds the trackingNumber of the shipment
      "ShipFromAddress": {
        "AddressLine": "123 Main St",
        "City": "Atlanta",
        "StateProvinceCode": "GA",
        "PostalCode": "30030",
        "CountryCode": "GA"
      },
      "ShipToAddress": {
        "AddressLine": "123 Main St",
        "City": "Atlanta",
        "StateProvinceCode": "GA",
        "PostalCode": "30030",
        "CountryCode": "GA"
      },
      "PickupDate": "20171101",
      "Service": {
        "Code": "GND",
        "Description": "Ground"
      },
      "RegulationSet": "<Regulation Set>",
      "Package": {
        "TrackingNumber": "<Tracking Number>",
        "PackageWeight": {
          "UnitOfMeasurement": {
            "Code": "KGS",
            "Description": "Kilo"
          },
          "Weight": "12"
        },
        "TransportationMode": "GND",
        "VoidIndicator": "",
        "PackagePoints": "12",
        "ChemicalRecord": {
          "ReportableQuantity": "1",
          "ClassDivisionNumber": "I",
          "SubRiskClass": "1234",
          "IDNumber": "<ID Number>",
          "PackagingGroupType": "0",
          "Quantity": "1",
          "UOM": "LBS",
          "PackagingInstructionCode": "TEST",
          "EmergencyPhone": "",
          "EmergencyContact": "",
          "ProperShippingName": "TEST SHIPPING",
          "TechnicalName": "",
          "AdditionalDescription": "",
          "PackagingType": "",
          "HazardLabelRequired": "LABEL",
          "PackagingTypeQuantity": "1",
          "CommodityRegulatedLevelCode": "LR",
          "TransportCategory": "0",
          "TunnelRestrictionCode": "1",
          "QValue": "0.1",
          "OverPackedIndicator": "",
          "AllPackedInOneIndicator": ""
        }
      }
    }
  }
}
```
### Sample Response

```json
{
    "PreNotificationResponse": {
        "Response": {
            "ResponseStatus": {
                "Code": "1",
                "Description": "Success"
            },
            "TransactionReference": {
                "CustomerContext": "",
                "TransactionIdentifier": "trhel8vm1dmbzGMMg40nck"
            }
        }
    }
}
 ```

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

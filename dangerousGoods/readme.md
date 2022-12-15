# DangerousGoods
## Introduction
  The Dangerous Goods API provides the ability to determine what Dangerous Goods (also known as Hazardous Materials) can be carried by UPS.
  There are two APIs which provides the functionality to get  reference data and audit pre check status: Chemical Reference Data API and Acceptance Audit Precheck API.

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

|Property Name |
| :------: |
|```<ID Number>```|
|```<Shipping Name>```|
|```<Shipper Number>```|
|```<Regulation Set>```|
|```<Proper Shipping Name>```|
|```<Hazardous Materials Description>```|
|```<List of Shipping Names>```|

### Build and run

- Build the project using Maven
```sh
cd <project home>
mvn clean package
```

- Run the project that is generated in the <project home>/target directory.
```sh
java -jar dangerousGoods-x.x.x.jar    
```
- check console output for application result


## Code Walk Through
There are 2 notable class in this tutorial, namely com.ups.api.app.AppConfig and 
com.ups.api.app.DangerousGoods.  The AppConfig class is a configuration class leveraging 
Spring injection to incorporate the property value from 
src/main/resources/application.properties file.  The DangerousGoods class is to illustrat how to use the ChemicalReferenceData and AcceptanceAuditPreCheck api.

```java
 String accessToken = Util.getAccessToken(appConfig, restTemplate);
```
> Get an access token via OAuth client_credentials grant type.


## chemicalReferenceData
					
```java
	// Create Chemical Reference Data Request from a pre-determined json file
	ChemicalReferenceDataRequest chemicalReferenceDataRequest = Util.createRequestFromJsonFile(
		entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),ChemicalReferenceDataRequest.class);
    DANGEROUSGOODSUTILITYRequestWrapper dangerousRequestWrapper = new DANGEROUSGOODSUTILITYRequestWrapper();
				dangerousRequestWrapper.setChemicalReferenceDataRequest(chemicalReferenceDataRequest);
```
> It reconstructs a ChemicalReferenceDataRequest object from a json file.  In a typical 
application, a ChemicalReferenceDataRequest object would be created via a default constructor 
and calling setter to populate the attribute instead.

```java
	// Get a Chemical Reference data
	DANGEROUSGOODSUTILITYResponseWrapper dangerousGoodsResponseWrapper = (DANGEROUSGOODSUTILITYResponseWrapper)sendRequest(dangerousRequestWrapper);
```
> The sendRequest function creates a ChemicalReferenceData api object and set the access token expiry tolerance if it haven't created one yet as well as populating with a valid access token. A Wrapper with ChemicalReferenceData response  will be returned from backend server providing the Chemical details,Quantity limit and other regulation details. 
### Data Schema 
 - [Request Schema DANGEROUSGOODSUTILITYRequestWrapper](docs/DANGEROUSGOODSUTILITYRequestWrapper.md)
 - [Response Schema DANGEROUSGOODSUTILITYResponseWrapper](docs/DANGEROUSGOODSUTILITYResponseWrapper.md)


### Sample Request
```json
{
  "ChemicalReferenceDataRequest": {
    "IDNumber": "<ID Number>",
    "ProperShippingName": "<Shipping Name>",
    "ShipperNumber": "<Shipper Number>"
  }
}
```
### Sample Response

```json
{
     "ChemicalReferenceDataResponse": {
         "Response": {
             "ResponseStatus": {
                 "Code": "1",
                 "Description": "Success"
             }
         },
         "ChemicalData": [
             {
                 "ChemicalDetail": {
                     "RegulationSet": "<Regulation Set>",
                     "IDNumber": "<ID Number>",
                     "HazardousMaterialsDescription": "<Hazardous Materials Description>",
                     "ClassDivisionNumber": "3",
                     "PackagingGroupType": "II",
                     "TechnicalNameRequiredIndicator": "N",
                     "AdditionalShippingInformationRequiredIndicator": "N"
                 },
                 "ProperShippingNameDetail": {
                     "ProperShippingName": [
                        "<List of Shipping Names>"
                     ]
                 },
                 "PackageQuantityLimitDetail": [
                     {
                         "PackageQuantityLimitTypeCode": "LTD QTY",
                         "Quantity": "1.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "150"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "PAX",
                         "Quantity": "5.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "202"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "CAO",
                         "Quantity": "30.0000",
                         "UOM": "L"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT LTD",
                         "Quantity": "1.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "150"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT PAX",
                         "Quantity": "5.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "202"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT CAO",
                         "Quantity": "60.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "202"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "GND",
                         "Quantity": "32.0000",
                         "UOM": "KG"
                     }
                 ]
             },
             {
                 "ChemicalDetail": {
                    "RegulationSet": "<Regulation Set>",
                    "IDNumber": "<ID Number>",
                    "HazardousMaterialsDescription": "<Hazardous Materials Description>",
                     "ClassDivisionNumber": "3",
                     "PackagingGroupType": "II",
                     "TechnicalNameRequiredIndicator": "N",
                     "AdditionalShippingInformationRequiredIndicator": "N"
                 },
                 "ProperShippingNameDetail": {
                     "ProperShippingName": [
                        "<List of Shipping Names>"
                     ]
                 },
                 "PackageQuantityLimitDetail": [
                     {
                         "PackageQuantityLimitTypeCode": "LTD QTY",
                         "Quantity": "1.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "Y341"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "PAX",
                         "Quantity": "5.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "353"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "CAO",
                         "Quantity": "30.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "364"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT LTD",
                         "Quantity": "1.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "Y341"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT PAX",
                         "Quantity": "5.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "353"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT CAO",
                         "Quantity": "60.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "364"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "GND",
                         "Quantity": "0.0000"
                     }
                 ]
             },
             {
                 "ChemicalDetail": {
                    "RegulationSet": "<Regulation Set>",
                     "IDNumber": "<ID Number>",
                     "HazardousMaterialsDescription": "<Hazardous Materials Description>",
                     "ClassDivisionNumber": "3",
                     "PackagingGroupType": "II",
                     "TechnicalNameRequiredIndicator": "N",
                     "AdditionalShippingInformationRequiredIndicator": "N"
                 },
                 "ProperShippingNameDetail": {
                     "ProperShippingName": [
                        "<List of Shipping Names>"
                     ]
                 },
                 "PackageQuantityLimitDetail": [
                     {
                         "PackageQuantityLimitTypeCode": "LTD QTY",
                         "Quantity": "1.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "Y341"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "PAX",
                         "Quantity": "5.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "353"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "CAO",
                         "Quantity": "60.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "364"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT LTD",
                         "Quantity": "1.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "Y341"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT PAX",
                         "Quantity": "5.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "353"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT CAO",
                         "Quantity": "60.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "364"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "GND",
                         "Quantity": "99999.0000",
                         "UOM": "L"
                     }
                 ]
             },
             {
                 "ChemicalDetail": {
                    "RegulationSet": "<Regulation Set>",
                    "IDNumber": "<ID Number>",
                    "HazardousMaterialsDescription": "<Hazardous Materials Description>",
                     "ClassDivisionNumber": "3",
                     "PackagingGroupType": "II",
                     "TechnicalNameRequiredIndicator": "N",
                     "AdditionalShippingInformationRequiredIndicator": "N"
                 },
                 "ProperShippingNameDetail": {
                     "ProperShippingName": [
                        "<List of Shipping Names>"
                     ]
                 },
                 "PackageQuantityLimitDetail": [
                     {
                         "PackageQuantityLimitTypeCode": "LTD QTY",
                         "Quantity": "0.0000"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "PAX",
                         "Quantity": "0.0000"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "CAO",
                         "Quantity": "0.0000"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT LTD",
                         "Quantity": "0.0000"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT PAX",
                         "Quantity": "0.0000"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT CAO",
                         "Quantity": "0.0000"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "GND",
                         "Quantity": "30.0000",
                         "UOM": "KG G",
                         "PackagingInstructionCode": "P001"
                     }
                 ]
             },
             {
                 "ChemicalDetail": {
                    "RegulationSet": "<Regulation Set>",
                    "IDNumber": "<ID Number>",
                    "HazardousMaterialsDescription": "<Hazardous Materials Description>",
                     "ClassDivisionNumber": "3",
                     "PackagingGroupType": "II",
                     "TechnicalNameRequiredIndicator": "N",
                     "AdditionalShippingInformationRequiredIndicator": "N"
                 },
                 "ProperShippingNameDetail": {
                     "ProperShippingName": [
                        "<List of Shipping Names>"
                     ]
                 },
                 "PackageQuantityLimitDetail": [
                     {
                         "PackageQuantityLimitTypeCode": "LTD QTY",
                         "Quantity": "1.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "Y341"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "PAX",
                         "Quantity": "5.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "353"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "CAO",
                         "Quantity": "30.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "364"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT LTD",
                         "Quantity": "1.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "Y341"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT PAX",
                         "Quantity": "5.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "353"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT CAO",
                         "Quantity": "60.0000",
                         "UOM": "L",
                         "PackagingInstructionCode": "364"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "GND",
                         "Quantity": "0.0000"
                     }
                 ]
             },
             {
                 "ChemicalDetail": {
                    "RegulationSet": "<Regulation Set>",
                    "IDNumber": "<ID Number>",
                    "HazardousMaterialsDescription": "<Hazardous Materials Description>",
                     "ClassDivisionNumber": "3",
                     "PackagingGroupType": "II",
                     "TechnicalNameRequiredIndicator": "N",
                     "AdditionalShippingInformationRequiredIndicator": "N"
                 },
                 "ProperShippingNameDetail": {
                     "ProperShippingName": [
                        "<List of Shipping Names>"
                     ]
                 },
                 "PackageQuantityLimitDetail": [
                     {
                         "PackageQuantityLimitTypeCode": "LTD QTY",
                         "Quantity": "0.0000"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "PAX",
                         "Quantity": "0.0000"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "CAO",
                         "Quantity": "0.0000"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT LTD",
                         "Quantity": "0.0000"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT PAX",
                         "Quantity": "0.0000"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "COMAT CAO",
                         "Quantity": "0.0000"
                     },
                     {
                         "PackageQuantityLimitTypeCode": "GND",
                         "Quantity": "30.0000",
                         "UOM": "L"
                     }
                 ]
             }
         ]
     }
 }
 ```

## acceptanceAuditPreCheck
					
```java
	AcceptanceAuditPreCheckRequest acceptanceAuditPreCheckRequest = Util.createRequestFromJsonFile(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
						AcceptanceAuditPreCheckRequest.class,
						appConfig);
     DANGEROUSGOODSUTILITYAPCRequestWrapper dangerousAPCRequestWrapper = new DANGEROUSGOODSUTILITYAPCRequestWrapper();
				dangerousAPCRequestWrapper.setAcceptanceAuditPreCheckRequest(acceptanceAuditPreCheckRequest);                   
```
> It reconstructs a AcceptanceAuditPreCheckRequest object from a json file.  In a typical 
application, a AcceptanceAuditPreCheckRequest object would be created via a default constructor 
and calling setter to populate the attribute instead.

```java
	// Get a Pre check status
	DANGEROUSGOODSUTILITYAPCResponseWrapper dangerousGoodsAPCResponseWrapper = (DANGEROUSGOODSUTILITYAPCResponseWrapper)sendRequest(dangerousAPCRequestWrapper);
```
> The sendRequest function creates a AcceptanceAuditPrecheck api object and set the access token expiry tolerance if it haven't created one yet as well as populating with a valid access token. A Wrapper with AcceptanceAuditPreCheck response  will be returned from backend server providing the Transaction identifier,Service cdoe and package results. 
### Data Schema 
 - [Request Schema DANGEROUSGOODSUTILITYAPCRequestWrapper](docs/DANGEROUSGOODSUTILITYAPCRequestWrapper.md)
 - [Response Schema DANGEROUSGOODSUTILITYAPCResponseWrapper](docs/DANGEROUSGOODSUTILITYAPCResponseWrapper.md)

### Sample Request
```json
{
     "AcceptanceAuditPreCheckRequest": {
       "Request": {
         "RequestOption": "Request",
         "TransactionReference": {
           "CustomerContext": "",
           "TransactionIdentifier": "TransactionIdentifier"
         }
       },
       "OriginRecordTransactionTimestamp": "",
       "Shipment": {
         "ShipperNumber": "<Shipper Number>",
         "ShipFromAddress": {
           "AddressLine": "123 Main st",
           "City": "Atlanta",
           "StateProvinceCode": "GA",
           "PostalCode": "7603",
           "CountryCode": "US"
         },
         "ShipToAddress": {
          "AddressLine": "125 Main st",
           "City": "Atlanta",
           "StateProvinceCode": "GA",
           "PostalCode": "1831",
           "CountryCode": "BE"
         },
         "Service": {
           "Code": "01",
           "Description": "GROUND "
         },
         "RegulationSet": "<Reulation Set>",
         "Package": {
           "PackageIdentifier": "12",
           "PackageWeight": {
             "Weight": "12",
             "UnitOfMeasurement": {
               "Code": "KGS",
               "Description": "KILOS"
             }
           },
           "QValue": "0",
           "OverPackedIndicator": "I",
           "TransportationMode": "PAX",
           "EmergencyContact": "SELF",
           "ChemicalRecord": {
             "ChemicalRecordIdentifier": "12",
             "ReportableQuantity": "RQ",
             "ClassDivisionNumber": "3",
             "SubRiskClass": "            ",
             "IDNumber": "<ID Number>",
             "PackagingGroupType": "III",
             "Quantity": "10",
             "UOM": "KGS",
             "PackagingInstructionCode": "Y344",
             "ProperShippingName": "<Proper Shipping Name>",
             "TechnicalName": "            ",
             "AdditionalDescription": "N",
             "PackagingType": "<Packaging Type>",
             "HazardLabelRequired": "LABEL IT",
             "PackagingTypeQuantity": "22",
             "CommodityRegulatedLevelCode": "LQ",
             "TransportCategory": "3",
             "TunnelRestrictionCode": "1"
           }
         }
       }
     }
   }
```
### Sample Response

```json
{
  "AcceptanceAuditPreCheckResponse": {
      "Response": {
          "ResponseStatus": {
              "Code": "1",
              "Description": "Success"
          },
          "TransactionReference": {
              "CustomerContext": "",
              "TransactionIdentifier": "123456789"
          }
      },
      "ShipperNumber": "<Shipper Number>",
      "Service": {
          "Code": "001"
      },
      "RegulationSet": "<Regulation Set>",
      "PackageResults": {
          "PackageIdentifier": "12",
          "AccessibleIndicator": "N",
          "EuropeBUIndicator": "N",
          "ChemicalRecordResults": {
              "ChemicalRecordIdentifier": "12",
              "ADRUnits": "0.0"
          }
      }
  }
}
```

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

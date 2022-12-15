# Landed Cost
## Introduction
The Landed Cost API allows customers to get estimated duties, taxes, and brokerage fees for your cross border shipments at any point in your business process.

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
    LANDEDCOSTRequestWrapper landedcostRequestWrapper = Util.createRequestFromJsonFile(
        entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME), LANDEDCOSTRequestWrapper.class,
        appConfig);
```
> Each iteration will create an instance of LANDEDCOSTRequestWrapper from a pre-determined json file 
> .Creating object via default constructor and injecting properties followed by
a set of setter to populate the necessary attribute.


```java
LANDEDCOSTResponseWrapper landedcostResponseWrapper = sendRequest(landedcostRequestWrapper, transId);
```
> The sendRequest function creates a Landed Cost Api object and set the access token expiry tolerance if it haven't created one yet as well as populating with a valid access token and processing request and getting response for landed cost. 

### Data Schema
- [Request Schema LANDEDCOSTRequestWrapper](docs/LANDEDCOSTRequestWrapper.md)

- [Response Schema LANDEDCOSTResponseWrapper.md](docs/LANDEDCOSTResponseWrapper.md)

### Sample Request/Response
### EstimatedRequest request
- Landed Cost provides an all-inclusive cost estimate of international shipments.

```json
{
  "LandedCostRequest" : {
    "Request" : {
      "RequestAction" : "LandedCost"
    },
    "EstimateRequest" : {
      "Shipment" : {
        "Product" : {
          "TariffCode" : "4901990000",
          "Question" : { }
        },
        "Question" : {
          "Name" : "Name"
        }
      },
      "TransactionDigest" : "rO0ABXNyABtjb20udXBzLnhvbHQudGEubGMuTENSZXN1bHQOqA+6xY5G9QIAFkQAB2ZyZWlnaHREAAlpbnN1cmFuY2VJAAlpdGVyYXRpb25JAAtudW1TaGlwUXVlc0QADnNoaXBtZW50VGF4RmVlTAAGVXNlcklkdAASTGphdmEvbGFuZy9TdHJpbmc7TAALYWNjdENvdW50cnlxAH4AAUwAC2NvbW1vZGl0aWVzdAAVTGphdmEvdXRpbC9BcnJheUxpc3Q7TAAIY3VycmVuY3lxAH4AAUwAC2Rlc3RDb3VudHJ5cQB+AAFMAAxkZXN0UHJvdmluY2VxAH4AAUwACmZyZWlnaHRDdXJxAH4AAUwADGluc3VyYW5jZUN1cnEAfgABTAAEbW9kZXEAfgABTAANb3JpZ2luQ291bnRyeXEAfgABTAAOb3JpZ2luUHJvdmluY2VxAH4AAUwABnJlZklkMXEAfgABTAAGcmVmSWQycQB+AAFMAAZyZWZJZDNxAH4AAUwAD3NoaXBtZW50QW5zd2Vyc3EAfgACTAARc2hpcG1lbnRRdWVzdGlvbnNxAH4AAkwAB3Vwc0FjY3RxAH4AAXhwQCQAAAAAAABAJAAAAAAAAAAAAAAAAAACAAAAAAAAAAB0AAdYT0xUUUExcHNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABc3IAHmNvbS51cHMueG9sdC50YS5sYy5MQ0NvbW1vZGl0eRD2kswQ94DGAgARRAADVkFURAAGZHV0aWVzSQAHbnVtUXVlc0kACHF1YW50aXR5RAAIc3ViVG90YWxEAAZ0YXhGZWVEAAl1bml0UHJpY2VEAAZ3ZWlnaHRMAAdhbnN3ZXJzcQB+AAJMAAdjb3VudHJ5cQB+AAFMAANjdXJxAH4AAUwAC3Byb2R1Y3REZXNjcQB+AAFMAApwcm9kdXROYW1lcQB+AAFMAAlxdWVzdGlvbnNxAH4AAkwACnRhcmlmZkNvZGVxAH4AAUwADXRhcmlmZlN1YkNvZGVxAH4AAUwACndlaWdodFVuaXRxAH4AAXhwQCRBvaURnOAAAAAAAAAAAAAAAAAAAAAFQEMwQYk3S8cAAAAAAAAAAEAWAAAAAAAAQAAAAAAAAABwdAACVVN0AANVU0R0AABxAH4AC3B0AAo0OTAxOTkwMDAwcQB+AAt0AAJrZ3h0AANFVVJ0AAJCRXB0AANFVVJ0AANFVVJ0AAIwMXQAAlVTcHQAEVBfMTE0MmVfTENfMjVfRUVLcHBwc3EAfgAFAAAAAncEAAAAAnNyACNjb20udXBzLnhvbHQudGEubGMuTENRdWVzdGlvbkFuc3dlcuWKlkUBkQ98AgAHSQAJaXRlcmF0aW9uSQAEdHlwZUwABmFuc3dlcnEAfgABTAAEbmFtZXEAfgABTAAKb3B0aW9uVGV4dHEAfgABTAAHb3B0aW9uc3QAFkxqYXZhL3V0aWwvUHJvcGVydGllcztMAAR0ZXh0cQB+AAF4cAAAAAAAAAADcHQAB0xWU19NT1Nwc3IAFGphdmEudXRpbC5Qcm9wZXJ0aWVzORLQenA2PpgCAAFMAAhkZWZhdWx0c3EAfgAXeHIAE2phdmEudXRpbC5IYXNodGFibGUTuw8lIUrkuAMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAIdwgAAAALAAAACHQAA0FJUnQAA0FJUnQAA1NFQXQAA1NFQXQABFBBUkx0AAtQT1NUIFBBUkNFTHQABExBTkR0AARMQU5EdAAEU1BFRHQAClNQRUVEIFBPU1R0AARJTlRQdAARSU5URVJORVQgUFVSQ0hBU0V0AARQT1NUdAAEUE9TVHQABENPVVJ0AAdDT1VSSUVSeHB0ABVXaGF0IGlzIHRoZSBNT1MgdHlwZT9zcQB+ABYAAAAAAAAAA3B0ABFMVlNfU0hJUE1FTlRfVFlQRXBzcQB+ABo/QAAAAAAACHcIAAAACwAAAAR0AARHSUZUdAAdR2lmdCBBcnRpY2xlcyAvIEdpZnQgUGFja2FnZXN0AARQRVJTdAARUGVyc29uYWwgQXJ0aWNsZXN0AARDT01NdAAeQXJ0aWNsZXMgd2l0aCBjb21tZXJjaWFsIHZhbHVldAAEU01QTHQAB1NhbXBsZXN4cHQAGldoYXQgaXMgdGhlIFNoaXBtZW50IHR5cGU/eHA1VMDGG4wTMCfjzyOk4hk2"
    }
  }
}
```


### EstimatedRequest Response 

```json
{
  "LandedCostResponse": {
    "Response": "",
    "EstimateResponse": {
      "TransactionInfo": {
        "Date": "11/15/2022",
        "Time": "07:48 ET",
        "TransactionCharge": {
          "MonetaryValue": "0.00",
          "CurrencyCode": ""
        }
      },
      "ShipmentEstimate": {
        "CurrencyCode": "EUR",
        "ShipmentCharges": {
          "TaxesAndFees": "0.00",
          "AdditionalInsuranceCost": "10.00",
          "TransportationCost": "10.00",
          "SubTotal": "20.00"
        },
        "ProductsCharges": {
          "Product": {
            "TariffCode": "4901990000",
            "Charges": {
              "Duties": "0.00",
              "TaxesAndFees": "0.00",
              "VAT": "10.1284",
              "CostOfGoods": "28.2486",
              "SubTotal": "38.377"
            }
          },
          "ProductsSubTotal": "38.377"
        },
        "TotalLandedCost": "58.377"
      }
    }
  }
}
```

### QueryRequest Request 
```json

{
  "LandedCostRequest": {
    "Request" : {
      "RequestAction" : "LandedCost"
    },
    "QueryRequest": {
      "Shipment": {
        "OriginCountryCode": "US",
        "OriginStateProvinceCode": "",
        "DestinationCountryCode": "BE",
        "DestinationStateProvinceCode": "",
        "TransportationMode": "1",
        "FreightCharges": {
          "MonetaryValue": "10",
          "CurrencyCode": "EUR"
        },
        "AdditionalInsurance": {
          "MonetaryValue": "10",
          "CurrencyCode": "EUR"
        },
        "Product": {
          "TariffInfo": {
            "TariffCode": "4901990000"
          },
          "ProductCountryCodeOfOrigin": "US",
          "Quantity": {
            "Value": "5"
          },
          "Weight": {
            "Value": "2",
            "UnitOfMeasure": {
              "UnitCode": "kg",
              "UnitDescription": ""
            }
          },
          "UnitPrice": {
            "MonetaryValue": "5.5",
            "CurrencyCode": "USD"
          }
        },
        "ResultCurrencyCode": "EUR"
      },
      "TransactionReferenceID": "P_1142e_LC_25_EEK"
    }
  }
}
```

### QueryRequest Response 

```json
{
  "LandedCostResponse": {
    "Response": "",
    "QueryResponse": {
      "Shipment": {
        "Product": {
          "TariffCode": "4901990000"
        },
        "Question": [
          {
            "Name": "LVS_MOS",
            "Text": "What is the MOS type?",
            "Type": "3",
            "Options": {
              "Option": [
                {
                  "Key": "AIR",
                  "Value": "AIR"
                },
                {
                  "Key": "AIR",
                  "Value": "AIR"
                },
                {
                  "Key": "COUR",
                  "Value": "COURIER"
                },
                {
                  "Key": "INTP",
                  "Value": "INTERNET PURCHASE"
                },
                {
                  "Key": "LAND",
                  "Value": "LAND"
                },
                {
                  "Key": "LAND",
                  "Value": "LAND"
                },
                {
                  "Key": "LAND",
                  "Value": "LAND"
                },
                {
                  "Key": "LAND",
                  "Value": "LAND"
                },
                {
                  "Key": "PARL",
                  "Value": "POST PARCEL"
                },
                {
                  "Key": "POST",
                  "Value": "POST"
                },
                {
                  "Key": "SEA",
                  "Value": "SEA"
                },
                {
                  "Key": "SEA",
                  "Value": "SEA"
                },
                {
                  "Key": "SPED",
                  "Value": "SPEED POST"
                }
              ]
            }
          },
          {
            "Name": "LVS_SHIPMENT_TYPE",
            "Text": "What is the Shipment type?",
            "Type": "3",
            "Options": {
              "Option": [
                {
                  "Key": "COMM",
                  "Value": "Articles with commercial value"
                },
                {
                  "Key": "GIFT",
                  "Value": "Gift Articles / Gift Packages"
                },
                {
                  "Key": "PERS",
                  "Value": "Personal Articles"
                },
                {
                  "Key": "SMPL",
                  "Value": "Samples"
                }
              ]
            }
          }
        ]
      },
      "TransactionDigest": "rO0ABXNyABtjb20udXBzLnhvbHQudGEubGMuTENSZXN1bHQOqA+6xY5G9QIAFkQAB2ZyZWlnaHREAAlpbnN1cmFuY2VJAAlpdGVyYXRpb25JAAtudW1TaGlwUXVlc0QADnNoaXBtZW50VGF4RmVlTAAGVXNlcklkdAASTGphdmEvbGFuZy9TdHJpbmc7TAALYWNjdENvdW50cnlxAH4AAUwAC2NvbW1vZGl0aWVzdAAVTGphdmEvdXRpbC9BcnJheUxpc3Q7TAAIY3VycmVuY3lxAH4AAUwAC2Rlc3RDb3VudHJ5cQB+AAFMAAxkZXN0UHJvdmluY2VxAH4AAUwACmZyZWlnaHRDdXJxAH4AAUwADGluc3VyYW5jZUN1cnEAfgABTAAEbW9kZXEAfgABTAANb3JpZ2luQ291bnRyeXEAfgABTAAOb3JpZ2luUHJvdmluY2VxAH4AAUwABnJlZklkMXEAfgABTAAGcmVmSWQycQB+AAFMAAZyZWZJZDNxAH4AAUwAD3NoaXBtZW50QW5zd2Vyc3EAfgACTAARc2hpcG1lbnRRdWVzdGlvbnNxAH4AAkwAB3Vwc0FjY3RxAH4AAXhwQCQAAAAAAABAJAAAAAAAAAAAAAAAAAACAAAAAAAAAAB0AAdYT0xUUUExcHNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABc3IAHmNvbS51cHMueG9sdC50YS5sYy5MQ0NvbW1vZGl0eRD2kswQ94DGAgARRAADVkFURAAGZHV0aWVzSQAHbnVtUXVlc0kACHF1YW50aXR5RAAIc3ViVG90YWxEAAZ0YXhGZWVEAAl1bml0UHJpY2VEAAZ3ZWlnaHRMAAdhbnN3ZXJzcQB+AAJMAAdjb3VudHJ5cQB+AAFMAANjdXJxAH4AAUwAC3Byb2R1Y3REZXNjcQB+AAFMAApwcm9kdXROYW1lcQB+AAFMAAlxdWVzdGlvbnNxAH4AAkwACnRhcmlmZkNvZGVxAH4AAUwADXRhcmlmZlN1YkNvZGVxAH4AAUwACndlaWdodFVuaXRxAH4AAXhwQCRBvaURnOAAAAAAAAAAAAAAAAAAAAAFQEMwQYk3S8cAAAAAAAAAAEAWAAAAAAAAQAAAAAAAAABwdAACVVN0AANVU0R0AABxAH4AC3B0AAo0OTAxOTkwMDAwcQB+AAt0AAJrZ3h0AANFVVJ0AAJCRXB0AANFVVJ0AANFVVJ0AAIwMXQAAlVTcHQAEVBfMTE0MmVfTENfMjVfRUVLcHBwc3EAfgAFAAAAAncEAAAAAnNyACNjb20udXBzLnhvbHQudGEubGMuTENRdWVzdGlvbkFuc3dlcuWKlkUBkQ98AgAHSQAJaXRlcmF0aW9uSQAEdHlwZUwABmFuc3dlcnEAfgABTAAEbmFtZXEAfgABTAAKb3B0aW9uVGV4dHEAfgABTAAHb3B0aW9uc3QAFkxqYXZhL3V0aWwvUHJvcGVydGllcztMAAR0ZXh0cQB+AAF4cAAAAAAAAAADcHQAB0xWU19NT1Nwc3IAFGphdmEudXRpbC5Qcm9wZXJ0aWVzORLQenA2PpgCAAFMAAhkZWZhdWx0c3EAfgAXeHIAE2phdmEudXRpbC5IYXNodGFibGUTuw8lIUrkuAMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAIdwgAAAALAAAACHQAA0FJUnQAA0FJUnQAA1NFQXQAA1NFQXQABFBBUkx0AAtQT1NUIFBBUkNFTHQABExBTkR0AARMQU5EdAAEU1BFRHQAClNQRUVEIFBPU1R0AARJTlRQdAARSU5URVJORVQgUFVSQ0hBU0V0AARQT1NUdAAEUE9TVHQABENPVVJ0AAdDT1VSSUVSeHB0ABVXaGF0IGlzIHRoZSBNT1MgdHlwZT9zcQB+ABYAAAAAAAAAA3B0ABFMVlNfU0hJUE1FTlRfVFlQRXBzcQB+ABo/QAAAAAAACHcIAAAACwAAAAR0AARHSUZUdAAdR2lmdCBBcnRpY2xlcyAvIEdpZnQgUGFja2FnZXN0AARQRVJTdAARUGVyc29uYWwgQXJ0aWNsZXN0AARDT01NdAAeQXJ0aWNsZXMgd2l0aCBjb21tZXJjaWFsIHZhbHVldAAEU01QTHQAB1NhbXBsZXN4cHQAGldoYXQgaXMgdGhlIFNoaXBtZW50IHR5cGU/eHA1VMDGG4wTMCfjzyOk4hk2"
    }
  }
}
```
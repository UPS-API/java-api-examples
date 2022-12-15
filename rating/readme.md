# Rate
## Introduction

The Rating API allows applications to look up and compare rates for UPS services:

The Rating API gives client applications the ability to:

- Find the rate for a specific UPS service for a specific package or shipment
- Compare available rates and services for a specific package or shipment
- Request negotiated rates for a specific package or shipment
>Note: Customers must be authorized and activated for negotiated rates. 
The API provides the negotiated rates that apply to the selected service. For more 
information on negotiated rates, including authorization to receive them, please check 
with your UPS account representative.


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
|```<your shipper number>```|

### Build and run

- Build the project using Maven
```sh
cd <project home>
mvn clean package
```

- Run the project that is generated in the <project home>/target directory.
```sh
java -jar rating-x.x.x.jar
```
- Check the console for the application's REST response.


## Code Walk Through
There are 2 notable classes in this tutorial, namely com.ups.api.app.AppConfig 
and com.ups.api.app.RateDemo.  The AppConfig class is a configuration class leveraging 
Spring injection to incorporate the property value from src/main/resources/application.properties 
file.  The RateDemo is to illustrate how to use the Rate api.


					
```java
    RATERequestWrapper rateRequestWrapper = Util.createRequestFromJsonFile(entry.getKey(),
														entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
														RATERequestWrapper.class,
														appConfig,
														Arrays.asList(new CreateRequestEnricher() {}));
```
> It reconstructs a RATERequestWrapper object from a json file which includes 
origin/destination address and other required information.  In a typical application, 
a RATERequestWrapper object would be created via a default constructor followed by 
a set of setter to populate the necessary attribute.

```java
	// Get a rate information for a particular shipment.
	final RATEResponseWrapper rateResponseWrapper = sendRequest(rateRequestWrapper, transId, requestOption, additionalInfo);
```
> The sendRequest function creates a Rate api object and set the access token expiry tolerance if it haven't created one yet as well as populating with a valid access token.  A RATEResponseWrapper object will be returned from a backend server for a particular 
shipment specified in the RATERequestWrapper object.  The RATEResponseWrapper 
has ResponseStatus and Alert object including the status and alert in respective section. The detail rate information will be in the RatedShipment object.


### Data Schema 
- [Request Schema RATERequestWrapper](docs/RATERequestWrapper.md)

- [Response Schema RATEResponseWrapper](docs/RATEResponseWrapper.md)

### Sample Request/Response
- Simple Rate request
```json
{
    "RateRequest": {
      "Request": {
        "RequestOption": "Rate",
        "SubVersion": "2108",
        "TransactionReference": {
          "CustomerContext": "CustomerContext"
        }
      },
      "Shipment": {
        "Shipper": {
          "Name": "ShipperName",
          "ShipperNumber": <your shipper number>,
          "Address": {
            "AddressLine": "123 main street",
            "City": "TIMONIUM",
            "StateProvinceCode": "MD",
            "PostalCode": "21093",
            "CountryCode": "US"
          }
        },
        "ShipTo": {
          "Name": "ShipToName",
          "Address": {
            "AddressLine": "ShipToAddressLine",
            "City": "Alpharetta",
            "StateProvinceCode": "GA",
            "PostalCode": "30005",
            "CountryCode": "US"
          }
        },
        "ShipFrom": {
          "Name": "ShipFromName",
          "Address": {
            "AddressLine": "ShipFromAddressLine",
            "City": "TIMONIUM",
            "StateProvinceCode": "MD",
            "PostalCode": "21093",
            "CountryCode": "US"
          }
        },
        "PaymentDetails": {
          "ShipmentCharge": {
            "Type": "01",
            "BillShipper": {
              "AccountNumber": <your shipper number>
            }
          }
        },
        "Service": {
          "Code": "03",
          "Description": "Ground"
        },
        "NumOfPieces": "1",
        "Package": {
          "PackagingType": {
            "Code": "02",
            "Description": "Packaging"
          },
          "Dimensions": {
            "UnitOfMeasurement": {
              "Code": "IN",
              "Description": "Inches"
            },
            "Length": "5",
            "Width": "5",
            "Height": "5"
          },
          "PackageWeight": {
            "UnitOfMeasurement": {
              "Code": "LBS",
              "Description": "Pounds"
            },
            "Weight": "1"
          },
          "SimpleRate" : {
            "Code" : "XS"
          }
        }
      }
    }
}
```
> The above sample rate request contains a mocked field, <your shipper number>, which is supposed to be specified per your information.

- An international Rate request 
```json
{
  "RateRequest" : {
    "Request" : {
      "RequestOption" : "Rate",
      "SubVersion" : "1901",
      "TransactionReference" : {
        "CustomerContext" : "Verify success returned when international shipment is created with payment option as Bill Shipper with account number"
      }
    },
    "PickupType" : {
      "Code" : "01",
      "Description" : "pickup"
    },
    "CustomerClassification" : {
      "Code" : "1607",
      "Description" : "CustomerClassification"
    },
    "Shipment" : {
      "OriginRecordTransactionTimestamp" : "2016-07-14T12:01:33.999",
      "Shipper" : {
        "Name" : "Shipper_Name",
        "ShipperNumber" : <your shipper number>,
        "Address" : {
          "AddressLine" : "123 main street",
          "City" : "Alpharetta",
          "StateProvinceCode" : "GA",
          "PostalCode" : "30005",
          "CountryCode" : "US"
        }
      },
      "ShipTo" : {
        "Name" : "ShipToName",
        "Address" : {
          "AddressLine" : "ShipToAddress",
          "City" : "STARZACH",
          "StateProvinceCode" : "GA",
          "PostalCode" : "72181",
          "CountryCode" : "DE"
        }
      },
      "ShipFrom" : {
        "Name" : "ShipFromName",
        "Address" : {
          "AddressLine" : "ShipFromAddressLine",
          "City" : "Alpharetta",
          "StateProvinceCode" : "GA",
          "PostalCode" : "30005",
          "CountryCode" : "US"
        }
      },
      "PaymentDetails" : {
        "ShipmentCharge" : {
          "Type" : "01",
          "BillShipper" : {
            "AccountNumber" : <your shipper number>
          }
        }
      },
      "Service" : {
        "Code" : "96",
        "Description" : "UPS Worldwide Express Freight"
      },
      "NumOfPieces" : "10",
      "Package" : {
        "PackagingType" : {
          "Code" : "30",
          "Description" : "Pallet"
        },
        "Dimensions" : {
          "UnitOfMeasurement" : {
            "Code" : "IN",
            "Description" : "Inches"
          },
          "Length" : "5",
          "Width" : "5",
          "Height" : "5"
        },
        "PackageWeight" : {
          "UnitOfMeasurement" : {
            "Code" : "LBS",
            "Description" : "LBS"
          },
          "Weight" : "10"
        },
        "PackageServiceOptions" : { },
        "OversizeIndicator" : "",
        "MinimumBillableWeightIndicator" : ""
      },
      "ShipmentServiceOptions" : { }
    }
  }
}
```
> The above sample international rate request contains a mocked field, <your shipper number>, which is supposed to be specified per your information.


- A TNT Rate request
```json
{
    "RateRequest": {
      "Request": {
        "RequestOption": "Rate",
        "SubVersion": "2108",
        "TransactionReference": {
          "CustomerContext": "CustomerContext"
        }
      },
      "Shipment": {
          "Shipper": {
            "Name": "ShipperName",
            "ShipperNumber": <your shipper number>,
            "Address": {
              "AddressLine": "ShipperAddressLine",
              "City": "TIMONIUM",
              "StateProvinceCode": "MD",
              "PostalCode": "21093",
              "CountryCode": "US"
            }
          },
          "ShipTo": {
            "Name": "ShipToName",
            "Address": {
              "AddressLine": "ShipToAddressLine",
              "City": "Alpharetta",
              "StateProvinceCode": "GA",
              "PostalCode": "30005",
              "CountryCode": "US"
            }
          },
          "ShipFrom": {
            "Name": "ShipFromName",
            "Address": {
              "AddressLine": "ShipFromAddressLine",
              "City": "TIMONIUM",
              "StateProvinceCode": "MD",
              "PostalCode": "21093",
              "CountryCode": "US"
            }
          },
          "PaymentDetails": {
            "ShipmentCharge": {
              "Type": "01",
              "BillShipper": {
                "AccountNumber": <your shipper number>
              }
            }
          },
          "Service": {
            "Code": "03",
            "Description": "Ground"
          },
          "NumOfPieces": "1",
          "Package": {
            "PackagingType": {
              "Code": "02",
              "Description": "Packaging"
            },
            "Dimensions": {
              "UnitOfMeasurement": {
                "Code": "IN",
                "Description": "Inches"
              },
              "Length": "5",
              "Width": "5",
              "Height": "5"
            },
            "PackageWeight": {
              "UnitOfMeasurement": {
                "Code": "LBS",
                "Description": "Pounds"
              },
              "Weight": "1"
            }
          },
          "DeliveryTimeInformation": {
            "PackageBillType": "03",
            "Pickup": {
              "Date": "20230101",
              "Time": "1000"
            }
          }
        }
      }
    }
}
```
> The above sample TNT rate request contains a mocked field, <your shipper number>, which is supposed to be specified per your information.

- A successful Simple Rate response
```json
{
  "RateResponse": {
    "Response": {
      "ResponseStatus": {
        "Code": "1",
        "Description": "Success"
      },
      "Alert": [
        {
          "Code": "110971",
          "Description": "Your invoice may vary from the displayed reference rates"
        }
      ],
      "TransactionReference": {
        "CustomerContext": "testing",
        "TransactionIdentifier": "ciewssoasc2b9N16KDjmjl"
      }
    },
    "RatedShipment": {
      "Service": {
        "Code": "03",
        "Description": ""
      },
      "RatedShipmentAlert": {
        "Code": "110971",
        "Description": "Your invoice may vary from the displayed reference rates"
      },
      "BillingWeight": {
        "UnitOfMeasurement": {
          "Code": "LBS",
          "Description": "Pounds"
        },
        "Weight": "0.0"
      },
      "TransportationCharges": {
        "CurrencyCode": "USD",
        "MonetaryValue": "9.45"
      },
      "BaseServiceCharge": {
        "CurrencyCode": "USD",
        "MonetaryValue": "0.00"
      },
      "ServiceOptionsCharges": {
        "CurrencyCode": "USD",
        "MonetaryValue": "0.00"
      },
      "TotalCharges": {
        "CurrencyCode": "USD",
        "MonetaryValue": "9.45"
      },
      "RatedPackage": {
        "TransportationCharges": {
          "CurrencyCode": "USD",
          "MonetaryValue": "9.45"
        },
        "BaseServiceCharge": {
          "CurrencyCode": "USD",
          "MonetaryValue": "9.45"
        },
        "ServiceOptionsCharges": {
          "CurrencyCode": "USD",
          "MonetaryValue": "0.00"
        },
        "ItemizedCharges": {
          "Code": "553",
          "CurrencyCode": "USD",
          "MonetaryValue": "0.00"
        },
        "TotalCharges": {
          "CurrencyCode": "USD",
          "MonetaryValue": "9.45"
        },
        "Weight": "0.7",
        "BillingWeight": {
          "UnitOfMeasurement": {
            "Code": "LBS",
            "Description": "Pounds"
          },
          "Weight": "0.0"
        },
        "SimpleRate": {
          "Code": "XS"
        }
      }
    }
  }
}
```

- An invalid BillShipper.AccountNumber
```json
{
  "response": {
    "errors": [
      {
        "code": "111580",
        "message": "Missing or Invalid account number for Payment Details."
      }
    ]
  }
}
```
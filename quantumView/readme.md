# QuantumView
## Introduction
The Quantum View® API accesses UPS Quantum View's comprehensive suite of services that give you details about your UPS shipments and the ability to access your Quantum View Data information.

With this API, your application can automatically retrieve Quantum View events and integrate those events into processes of other information system.

**Quantum View API components include:**

- *Quantum View Subscriptions:* Enables application's to retrieve specific Quantum View events. Set up subscriptions for outbound shipments, inbound shipments, and shipments using alternate billing such as freight collect, third party, and consignee-billed.
- *Bookmarks:* Allows for minimal application impact network resources for accounts with a high volume of UPS activity. If Quantum View information that satisfies your request returns multiple files and exceeds the 150 KB limit, UPS returns part of the information and appends a special Bookmark element to the response.
- *File Names:* Enables your application to directly request a specific file when it knows the name of the Quantum View file.
- *Date / Time Range:* Enables you to request Quantum View events that occurred during a specific range of dates and/or times.

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
|```<Lead Shipment Tracking Number>```|
|```<Shipment Identification Number>```|
|```<ID Number>```|
|```<Subscriber ID>```|
|```<File Name>```|
|```<Event Name>```|
|```<Event Number>```|

### Build and run

- Build the project using Maven
```sh
cd <project home>
mvn clean package
```

- Run the project that is generated in the <project home>/target directory.
```sh
java -jar quantumView-x.x.x.jar    
```
- check console output for application result


## Code Walk Through
There are 2 notable class in this tutorial, namely com.ups.api.app.AppConfig and 
com.ups.api.app.QuantumView.  The AppConfig class is a configuration class leveraging 
Spring injection to incorporate the property value from 
src/main/resources/application.properties file.  The QuantumView class is to illustrate how to use the QuantumView api.

```java
 String accessToken = Util.getAccessToken(appConfig, restTemplate);
```
> Get an access token via OAuth client_credentials grant type.


## QuantumView
					
```java
	// Create Quantum View Request from a pre-determined json file
				QUANTUMVIEWRequestWrapper quantumViewRequestWrapper = Util.createRequestFromJsonFile(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
						QUANTUMVIEWRequestWrapper.class);					
```
> It reconstructs a Quantum View Request Wrapper object from a json file.  In a typical 
application, a QUANTUMVIEWRequestWrapper object would be created via a default constructor 
and calling setter to populate the attribute instead.

```java
	// Get Quantum View response
				QUANTUMVIEWResponseWrapper quantumViewResponseWrapper = this.sendRequest(quantumViewRequestWrapper);				
```
> The sendRequest function creates a QuantumView api object and set the access token expiry tolerance if it haven't created one yet as well as populating with a valid access token. A Wrapper with QuantumView response  will be returned from backend server providing the quantum view subscription details. 

### Data Schema 
 - [Request Schema QUANTUMVIEWRequestWrapper](docs/QUANTUMVIEWRequestWrapper.md)
 - [Response Schema QUANTUMVIEWResponseWrapper](docs/QUANTUMVIEWResponseWrapper.md)


### Sample Request
```json
{
    "QuantumViewRequest": {
        "Request": {
            "TransactionReference": {
                "CustomerContext":  "Verify Quantum view response based on the file name"
            },
            "RequestAction": "QVEvents"
        },
        "SubscriptionRequest": {
            "FileName": "123456789",
            "Name": "subscriber"
        }
    }
  }
```
### Sample Response

```json
{
    "QuantumViewResponse": {
        "Response": {
            "TransactionReference": {
                "CustomerContext": "Check for Quantum view response based on the file name"
            },
            "ResponseStatusCode": "1",
            "ResponseStatusDescription": "Success"
        },
        "QuantumViewEvents": {
            "SubscriberID": "<Subscriber ID>",
            "SubscriptionEvents": {
                "Name": "<Event Name>",
                "Number": "<Event Number>",
                "SubscriptionStatus": {
                    "Code": "A",
                    "Description": "Active"
                },
                "SubscriptionFile": {
                    "FileName": "<File Name>",
                    "StatusType": {
                        "Code": "R",
                        "Description": "Read"
                    },
                    "Manifest": [
                        {
                            "Shipper": {
                                "Name": "SHIPFROMNAME",
                                "ShipperNumber": "<Shipper Number>",
                                "Address": {
                                    "AddressLine1": "SHIPFROMADDRESS",
                                    "City": "BURLINGTON",
                                    "StateProvinceCode": "ON",
                                    "PostalCode": "L7L0C2",
                                    "CountryCode": "CA"
                                }
                            },
                            "ShipTo": {
                                "AttentionName": "SHIPTONAME",
                                "PhoneNumber": "12345678901234",
                                "Address": {
                                    "ConsigneeName": "SHIPTONAME",
                                    "AddressLine1": "SHIPTOADDRESS",
                                    "City": "BURLINGTON",
                                    "StateProvinceCode": "ON",
                                    "PostalCode": "L7L0C2",
                                    "CountryCode": "CA"
                                }
                            },
                            "Service": {
                                "Code": "011"
                            },
                            "PickupDate": "20221215",
                            "DocumentsOnly": "3",
                            "Package": {
                                "Activity": {
                                    "Date": "20221215",
                                    "Time": "131900"
                                },
                                "Description": "Return",
                                "Dimensions": {
                                    "Length": "00001000",
                                    "Width": "00001000",
                                    "Height": "00001000"
                                },
                                "DimensionalWeight": {
                                    "UnitOfMeasurement": {
                                        "Code": "LBS"
                                    },
                                    "Weight": "0000072"
                                },
                                "PackageWeight": {
                                    "Weight": "+0000.1"
                                },
                                "TrackingNumber": "<Tracking Number>",
                                "PackageServiceOptions": {
                                    "COD": ""
                                }
                            },
                            "ShipmentServiceOptions": {
                                "CallTagARS": {
                                    "Code": "6"
                                }
                            },
                            "ShipmentChargeType": "P/P",
                            "BillToAccount": {
                                "Option": "01",
                                "Number": "166222"
                            },
                            "LeadShipmentTrackingNumber": "<Lead Shipment Tracking Number>",
                            "PackageCount": "000001"
                        },
                        {
                            "Shipper": {
                                "Name": "SHIPFROMNAME",
                                "ShipperNumber": "<Shipper Number>",
                                "Address": {
                                    "AddressLine1": "SHIPFROMADDRESS",
                                    "City": "BURLINGTON",
                                    "StateProvinceCode": "ON",
                                    "PostalCode": "L7L0C2",
                                    "CountryCode": "CA"
                                }
                            },
                            "ShipTo": {
                                "AttentionName": "SHIPTONAME",
                                "PhoneNumber": "12345678901234",
                                "Address": {
                                    "ConsigneeName": "SHIPTONAME",
                                    "AddressLine1": "SHIPTOADDRESS",
                                    "City": "BURLINGTON",
                                    "StateProvinceCode": "ON",
                                    "PostalCode": "L7L0C2",
                                    "CountryCode": "CA"
                                }
                            },
                            "Service": {
                                "Code": "011"
                            },
                            "PickupDate": "20221215",
                            "DocumentsOnly": "3",
                            "Package": {
                                "Activity": {
                                    "Date": "20221215",
                                    "Time": "131800"
                                },
                                "Description": "Return",
                                "Dimensions": {
                                    "Length": "00001000",
                                    "Width": "00001000",
                                    "Height": "00001000"
                                },
                                "DimensionalWeight": {
                                    "UnitOfMeasurement": {
                                        "Code": "LBS"
                                    },
                                    "Weight": "0000072"
                                },
                                "PackageWeight": {
                                    "Weight": "+0000.1"
                                },
                                "TrackingNumber": "<Tracking Number>",
                                "PackageServiceOptions": {
                                    "COD": ""
                                }
                            },
                            "ShipmentServiceOptions": {
                                "CallTagARS": {
                                    "Code": "6"
                                }
                            },
                            "ShipmentChargeType": "P/P",
                            "BillToAccount": {
                                "Option": "01",
                                "Number": "166222"
                            },
                            "LeadShipmentTrackingNumber": "<Lead Shipment Tracking Number>",
                            "PackageCount": "000001"
                        },
                        {
                            "Shipper": {
                                "Name": "SHIPFROMNAME",
                                "ShipperNumber": "<Shipper Number>",
                                "Address": {
                                    "AddressLine1": "SHIPFROMADDRESS",
                                    "City": "BURLINGTON",
                                    "StateProvinceCode": "ON",
                                    "PostalCode": "L7L0C2",
                                    "CountryCode": "CA"
                                }
                            },
                            "ShipTo": {
                                "AttentionName": "SHIPTONAME",
                                "PhoneNumber": "12345678901234",
                                "Address": {
                                    "ConsigneeName": "SHIPTONAME",
                                    "AddressLine1": "SHIPTOADDRESS",
                                    "City": "BURLINGTON",
                                    "StateProvinceCode": "ON",
                                    "PostalCode": "L7L0C2",
                                    "CountryCode": "CA"
                                }
                            },
                            "Service": {
                                "Code": "011"
                            },
                            "PickupDate": "20221215",
                            "DocumentsOnly": "3",
                            "Package": {
                                "Activity": {
                                    "Date": "20221215",
                                    "Time": "131100"
                                },
                                "Description": "Return",
                                "Dimensions": {
                                    "Length": "00001000",
                                    "Width": "00001000",
                                    "Height": "00001000"
                                },
                                "DimensionalWeight": {
                                    "UnitOfMeasurement": {
                                        "Code": "LBS"
                                    },
                                    "Weight": "0000072"
                                },
                                "PackageWeight": {
                                    "Weight": "+0000.1"
                                },
                                "TrackingNumber": "<Tracking Number>",
                                "PackageServiceOptions": {
                                    "COD": ""
                                }
                            },
                            "ShipmentServiceOptions": {
                                "CallTagARS": {
                                    "Code": "6"
                                }
                            },
                            "ShipmentChargeType": "P/P",
                            "BillToAccount": {
                                "Option": "01",
                                "Number": "166222"
                            },
                            "LeadShipmentTrackingNumber": "<Lead Shipment Tracking Number>",
                            "PackageCount": "000001"
                        },
                        {
                            "Shipper": {
                                "Name": "SHIPFROMNAME",
                                "ShipperNumber": "<Shipper Number>",
                                "Address": {
                                    "AddressLine1": "SHIPFROMADDRESS",
                                    "City": "BURLINGTON",
                                    "StateProvinceCode": "ON",
                                    "PostalCode": "L7L0C2",
                                    "CountryCode": "CA"
                                }
                            },
                            "ShipTo": {
                                "AttentionName": "SHIPTONAME",
                                "PhoneNumber": "12345678901234",
                                "Address": {
                                    "ConsigneeName": "SHIPTONAME",
                                    "AddressLine1": "SHIPTOADDRESS",
                                    "City": "BURLINGTON",
                                    "StateProvinceCode": "ON",
                                    "PostalCode": "L7L0C2",
                                    "CountryCode": "CA"
                                }
                            },
                            "Service": {
                                "Code": "011"
                            },
                            "PickupDate": "20221215",
                            "DocumentsOnly": "3",
                            "Package": {
                                "Activity": {
                                    "Date": "20221215",
                                    "Time": "131000"
                                },
                                "Description": "Return",
                                "Dimensions": {
                                    "Length": "00001000",
                                    "Width": "00001000",
                                    "Height": "00001000"
                                },
                                "DimensionalWeight": {
                                    "UnitOfMeasurement": {
                                        "Code": "LBS"
                                    },
                                    "Weight": "0000072"
                                },
                                "PackageWeight": {
                                    "Weight": "+0000.1"
                                },
                                "TrackingNumber": "<Tracking Number>",
                                "PackageServiceOptions": {
                                    "COD": ""
                                }
                            },
                            "ShipmentServiceOptions": {
                                "CallTagARS": {
                                    "Code": "6"
                                }
                            },
                            "ShipmentChargeType": "P/P",
                            "BillToAccount": {
                                "Option": "01",
                                "Number": "166222"
                            },
                            "LeadShipmentTrackingNumber": "<Lead Shipment Tracking Number>",
                            "PackageCount": "000001"
                        }
                    ]
                }
            }
        }
    }
}
 ```

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

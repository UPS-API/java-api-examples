# Locator
## Introduction
  Locator, is an api provides function to search for UPS shipping locations based on type and available services. It expects a LocatorRequest json object in the request body 
  and returns a LocatorRepsonse in the response body or errorResponse in case of 
  error senario.
  With the Locator API you'll be able to find retail locations such as:
  - UPS Access PointTM
  - The UPS Store®
  - UPS Customer Centers
  - UPS Express
  - UPS Alliance Location
  - Authorized Shipping Outlet (ASO)
  - UPS Authorized Service Providers   
Note: The location types will vary from country to country offering the tool.

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
java -jar locator-x.x.x.jar
```
- Check the console for the application's REST response.


## Code Walk Through
There are 2 notable class in this tutorial, namely com.ups.api.app.AppConfig and 
com.ups.api.app.Locator.  The AppConfig class is a configuration class leveraging 
Spring injection to incorporate the property value from 
src/main/resources/application.properties file.  The Locator class is to illustrat how 
to use the Locator api.

```java
 String accessToken = Util.getAccessToken(appConfig, restTemplate);
```
> Get an access token via OAuth client_credentials grant type.

					
```java
	// Create LocatorRequest from a pre-determined json file;
			LocatorRequest locatorRequest = Util.createRequestFromJsonFile(
					entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
					LocatorRequest.class,
					appConfig);
```
> It reconstructs a LocatorRequest object from a json file.  In a typical 
application, a LocatorRequest object would be created via a default constructor 
and calling setter to populate the attribute instead.

```java
	// Get a UPS shipping locations based on type and available services by providing respective Request options
	LOCATORResponseWrapper locatorResponseWrapper=sendRequest(locatorRequestWrapper, transId);
```
> The sendRequest function creates a Locator api object and set the access token expiry tolerance if it haven't created one yet as well as populating with a valid access token. A Locator response  will be returned from backend server  based on the req option and address information sent as part of Locator request.  


### Data Schema 
 - [Request Schema LocatorRequest](docs/LocatorRequest.md)
 - [Response Schema LOCATORResponseWrapper](docs/LOCATORResponseWrapper.md)

### Sample Request
```json
{
        "Request": {
            "TransactionReference": {
                "CustomerContext": ""
            },
            "RequestAction": "Locator",
            "RequestOption": "56"
        },
        "OriginAddress": {
            "AddressKeyFormat": {
                "AddressLine": "123 Main St",
                "PoliticalDivision2": "Atlanta",
                "PoliticalDivision1": "PE",
                "PostcodePrimaryLow": "30005",
                "PostcodeExtendedLow": "30005",
                "CountryCode": "US"
            },
            "MaximumListSize": "10"
        },
        "Translate": {
            "LanguageCode": "ENG",
            "Locale": "en_US"
        },
        "UnitOfMeasurement": {
            "Code": "MI"
        },
        "LocationSearchCriteria": {
            "SearchOption": [
                {
                    "OptionType": {
                        "Code": "01"
                    },
                    "OptionCode": {
                        "Code": "001"
                    },
                    "Relation": {
                        "Code": "01"
                    }
                },
                {
                    "OptionType": {
                        "Code": "01"
                    },
                    "OptionCode": [
                        {
                            "Code": "001"
                        },
                        {
                            "Code": "001"
                        }
                    ],
                    "Relation": {
                        "Code": "01"
                    }
                }
            ],
            "MaximumListSize": "10",
            "SearchRadius": "75",
            "ServiceSearch": {
                "Time": "1030",
                "ServiceCode": {
                    "Code": "01"
                }
            }
        },
        "SortCriteria": {
            "SortType": "01"
        }
}
```
### Sample Response
```json
{
    "LocatorResponse": {
        "Response": {
            "TransactionReference": "",
            "ResponseStatusCode": "1",
            "ResponseStatusDescription": "Success"
        },
        "SearchResults": {
            "DropLocation": [
                {
                    "LocationID": "5367",
                    "IVR": {
                        "PhraseID": "22591"
                    },
                    "Geocode": {
                        "Latitude": "33.76067733",
                        "Longitude": "-84.5407409"
                    },
                    "AddressKeyFormat": {
                        "ConsigneeName": "CC - ATLANTA",
                        "AddressLine": "270 MARVIN MILLER DR",
                        "PoliticalDivision2": "ATLANTA",
                        "PoliticalDivision1": "GA",
                        "PostcodePrimaryLow": "30336",
                        "PostcodeExtendedLow": "1814",
                        "CountryCode": "US"
                    },
                    "PhoneNumber": "8007425877",
                    "LocationAttribute": {
                        "OptionType": {
                            "Code": "01",
                            "Description": "Location"
                        },
                        "OptionCode": {
                            "Code": "001",
                            "Description": "UPS Customer Center"
                        }
                    },
                    "Distance": {
                        "Value": "20.5",
                        "UnitOfMeasurement": {
                            "Code": "MI",
                            "Description": "MILES"
                        }
                    },
                    "SpecialInstructions": "",
                    "LatestGroundDropOffTime": "Mon: 8:45am; Tue-Fri: 8:45pm; Sat, Sun: No Pickup",
                    "LatestAirDropOffTime": "Mon-Fri: 7:00pm; Sat, Sun: No Pickup",
                    "AdditionalChargeIndicator": "",
                    "StandardHoursOfOperation": "Mon-Fri: 9:00am-8:00pm; Sat: 9:00am-5:00pm; Sun: Closed",
                    "WillCallHoursOfOperation": "Mon: 0900-2000;Tues: 0900-2000;Wed: 0900-2000;Th:  0900-2000;Fri:  0900-2000;Sat: 0900-1700;",
                    "OperatingHours": {
                        "StandardHours": [
                            {
                                "HoursType": "11",
                                "DayOfWeek": [
                                    {
                                        "Day": "1",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "2",
                                        "OpenHours": "900",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "3",
                                        "OpenHours": "900",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "4",
                                        "OpenHours": "900",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "5",
                                        "OpenHours": "900",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "6",
                                        "OpenHours": "900",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "7",
                                        "OpenHours": "900",
                                        "CloseHours": "1700"
                                    }
                                ]
                            },
                            {
                                "HoursType": "12",
                                "DayOfWeek": [
                                    {
                                        "Day": "1",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "2",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "3",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "4",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "5",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "6",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "7",
                                        "ClosedIndicator": ""
                                    }
                                ]
                            },
                            {
                                "HoursType": "13",
                                "DayOfWeek": [
                                    {
                                        "Day": "1",
                                        "OpenHours": "930"
                                    },
                                    {
                                        "Day": "2",
                                        "OpenHours": "930"
                                    },
                                    {
                                        "Day": "3",
                                        "OpenHours": "930"
                                    },
                                    {
                                        "Day": "4",
                                        "OpenHours": "930"
                                    },
                                    {
                                        "Day": "5",
                                        "OpenHours": "930"
                                    },
                                    {
                                        "Day": "6",
                                        "OpenHours": "930"
                                    },
                                    {
                                        "Day": "7",
                                        "OpenHours": "930"
                                    }
                                ]
                            },
                            {
                                "HoursType": "10",
                                "DayOfWeek": [
                                    {
                                        "Day": "1",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "2",
                                        "OpenHours": "900",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "3",
                                        "OpenHours": "900",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "4",
                                        "OpenHours": "900",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "5",
                                        "OpenHours": "900",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "6",
                                        "OpenHours": "900",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "7",
                                        "OpenHours": "900",
                                        "CloseHours": "1700"
                                    }
                                ]
                            }
                        ]
                    },
                    "Comments": "A government issued photo ID is required when shipping or picking up a package at a UPS Customer Center.",
                    "SLIC": "3031",
                    "ServiceOfferingList": {
                        "ServiceOffering": [
                            {
                                "Code": "001",
                                "Description": "Direct To Retail"
                            },
                            {
                                "Code": "002",
                                "Description": "Not In One ADL"
                            },
                            {
                                "Code": "004",
                                "Description": "Retail to Retail"
                            },
                            {
                                "Code": "007",
                                "Description": "PUDO"
                            },
                            {
                                "Code": "008",
                                "Description": "Early Pickup Delivery Time"
                            },
                            {
                                "Code": "010",
                                "Description": "DCO DCR intercept accepted"
                            },
                            {
                                "Code": "013",
                                "Description": "Accepts Restricted Articles"
                            }
                        ]
                    },
                    "DisplayPhoneNumberIndicator": "1",
                    "AccessPointInformation": {
                        "PublicAccessPointID": "U32921710",
                        "BusinessClassificationList": {
                            "BusinessClassification": {
                                "Code": "021",
                                "Description": "OTHER"
                            }
                        },
                        "AccessPointStatus": {
                            "Code": "01",
                            "Description": "ACTIVE"
                        }
                    },
                    "LocationImage": {
                        "SecureURL": "https://www.webservices.ups.com/locator-services/images?imageID=98DDC788-5038-4135-82E8-9D74E8B4254F.jpg"
                    },
                    "LocationNewIndicator": "N",
                    "WillCallLocationIndicator": "N"
                },
                {
                    "LocationID": "5392",
                    "IVR": {
                        "PhraseID": "22778"
                    },
                    "Geocode": {
                        "Latitude": "33.89439010",
                        "Longitude": "-84.2380523"
                    },
                    "AddressKeyFormat": {
                        "ConsigneeName": "UPS CC DORAVILLE",
                        "AddressLine": "3772 PLEASANTDALE RD&#xD;120",
                        "PoliticalDivision2": "DORAVILLE",
                        "PoliticalDivision1": "GA",
                        "PostcodePrimaryLow": "30340",
                        "PostcodeExtendedLow": "4270",
                        "CountryCode": "US"
                    },
                    "PhoneNumber": "8007425877",
                    "LocationAttribute": {
                        "OptionType": {
                            "Code": "01",
                            "Description": "Location"
                        },
                        "OptionCode": {
                            "Code": "001",
                            "Description": "UPS Customer Center"
                        }
                    },
                    "Distance": {
                        "Value": "36.5",
                        "UnitOfMeasurement": {
                            "Code": "MI",
                            "Description": "MILES"
                        }
                    },
                    "SpecialInstructions": "",
                    "LatestGroundDropOffTime": "Mon-Fri: 7:45pm; Sat: 12:45pm; Sun: No Pickup",
                    "LatestAirDropOffTime": "Mon-Fri: 7:45pm; Sat: 12:45pm; Sun: No Pickup",
                    "AdditionalChargeIndicator": "",
                    "StandardHoursOfOperation": "Mon-Fri: 8:00am-8:00pm; Sat: 10:00am-4:00pm; Sun: Closed",
                    "WillCallHoursOfOperation": "Mon: 0800-2000;Tues: 0800-2000;Wed: 0800-2000;Th:  0800-2000;Fri:  0800-2000;Sat: 1000-1600;",
                    "OperatingHours": {
                        "StandardHours": [
                            {
                                "HoursType": "11",
                                "DayOfWeek": [
                                    {
                                        "Day": "1",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "2",
                                        "OpenHours": "800",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "3",
                                        "OpenHours": "800",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "4",
                                        "OpenHours": "800",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "5",
                                        "OpenHours": "800",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "6",
                                        "OpenHours": "800",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "7",
                                        "OpenHours": "1000",
                                        "CloseHours": "1600"
                                    }
                                ]
                            },
                            {
                                "HoursType": "12",
                                "DayOfWeek": [
                                    {
                                        "Day": "1",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "2",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "3",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "4",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "5",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "6",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "7",
                                        "ClosedIndicator": ""
                                    }
                                ]
                            },
                            {
                                "HoursType": "13",
                                "DayOfWeek": [
                                    {
                                        "Day": "1",
                                        "OpenHours": "830"
                                    },
                                    {
                                        "Day": "2",
                                        "OpenHours": "830"
                                    },
                                    {
                                        "Day": "3",
                                        "OpenHours": "830"
                                    },
                                    {
                                        "Day": "4",
                                        "OpenHours": "830"
                                    },
                                    {
                                        "Day": "5",
                                        "OpenHours": "830"
                                    },
                                    {
                                        "Day": "6",
                                        "OpenHours": "830"
                                    },
                                    {
                                        "Day": "7",
                                        "OpenHours": "830"
                                    }
                                ]
                            },
                            {
                                "HoursType": "10",
                                "DayOfWeek": [
                                    {
                                        "Day": "1",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "2",
                                        "OpenHours": "800",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "3",
                                        "OpenHours": "800",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "4",
                                        "OpenHours": "800",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "5",
                                        "OpenHours": "800",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "6",
                                        "OpenHours": "800",
                                        "CloseHours": "2000"
                                    },
                                    {
                                        "Day": "7",
                                        "OpenHours": "1000",
                                        "CloseHours": "1600"
                                    }
                                ]
                            }
                        ]
                    },
                    "Comments": "A government issued photo ID is required when shipping or picking up a package at a UPS Customer Center.",
                    "SLIC": "3027",
                    "ServiceOfferingList": {
                        "ServiceOffering": [
                            {
                                "Code": "001",
                                "Description": "Direct To Retail"
                            },
                            {
                                "Code": "002",
                                "Description": "Not In One ADL"
                            },
                            {
                                "Code": "004",
                                "Description": "Retail to Retail"
                            },
                            {
                                "Code": "007",
                                "Description": "PUDO"
                            },
                            {
                                "Code": "008",
                                "Description": "Early Pickup Delivery Time"
                            },
                            {
                                "Code": "010",
                                "Description": "DCO DCR intercept accepted"
                            },
                            {
                                "Code": "013",
                                "Description": "Accepts Restricted Articles"
                            }
                        ]
                    },
                    "DisplayPhoneNumberIndicator": "1",
                    "AccessPointInformation": {
                        "PublicAccessPointID": "U48396045",
                        "ImageURL": "https://rms.ups.com/rms/image?id=1B905C20-7C97-4ED2-9CFA-66E66F3DCF75",
                        "BusinessClassificationList": {
                            "BusinessClassification": {
                                "Code": "021",
                                "Description": "OTHER"
                            }
                        },
                        "AccessPointStatus": {
                            "Code": "01",
                            "Description": "ACTIVE"
                        }
                    },
                    "LocationImage": {
                        "SecureURL": "https://www.webservices.ups.com/locator-services/images?imageID=EB448D39-E707-47B6-8426-4A249D030C11.jpg"
                    },
                    "LocationNewIndicator": "N",
                    "WillCallLocationIndicator": "N"
                },
                {
                    "LocationID": "5375",
                    "IVR": {
                        "PhraseID": "22722"
                    },
                    "Geocode": {
                        "Latitude": "33.94309997",
                        "Longitude": "-83.4811553"
                    },
                    "AddressKeyFormat": {
                        "ConsigneeName": "CUSTOMER CENTER BOGART",
                        "AddressLine": "215 CONWAY DR",
                        "PoliticalDivision2": "BOGART",
                        "PoliticalDivision1": "GA",
                        "PostcodePrimaryLow": "30622",
                        "PostcodeExtendedLow": "1789",
                        "CountryCode": "US"
                    },
                    "PhoneNumber": "8007425877",
                    "LocationAttribute": {
                        "OptionType": {
                            "Code": "01",
                            "Description": "Location"
                        },
                        "OptionCode": {
                            "Code": "001",
                            "Description": "UPS Customer Center"
                        }
                    },
                    "Distance": {
                        "Value": "73",
                        "UnitOfMeasurement": {
                            "Code": "MI",
                            "Description": "MILES"
                        }
                    },
                    "SpecialInstructions": "",
                    "LatestGroundDropOffTime": "Mon-Fri: 6:45pm; Sat, Sun: No Pickup",
                    "LatestAirDropOffTime": "Mon-Fri: 6:45pm; Sat, Sun: No Pickup",
                    "AdditionalChargeIndicator": "",
                    "StandardHoursOfOperation": "Mon-Fri: 8:00am-10:00am, 4:30pm-7:30pm; Sat, Sun: Closed",
                    "WillCallHoursOfOperation": "Mon: 0800-1000;1630-1930;Tues: 0800-1000;1630-1930;Wed: 0800-1000;1630-1930;Th:  0800-1000;1630-1930;Fri:  0800-1000;1630-1930;",
                    "OperatingHours": {
                        "StandardHours": [
                            {
                                "HoursType": "11",
                                "DayOfWeek": [
                                    {
                                        "Day": "1",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "2",
                                        "OpenHours": [
                                            "800",
                                            "1630"
                                        ],
                                        "CloseHours": [
                                            "1000",
                                            "1930"
                                        ]
                                    },
                                    {
                                        "Day": "3",
                                        "OpenHours": [
                                            "800",
                                            "1630"
                                        ],
                                        "CloseHours": [
                                            "1000",
                                            "1930"
                                        ]
                                    },
                                    {
                                        "Day": "4",
                                        "OpenHours": [
                                            "800",
                                            "1630"
                                        ],
                                        "CloseHours": [
                                            "1000",
                                            "1930"
                                        ]
                                    },
                                    {
                                        "Day": "5",
                                        "OpenHours": [
                                            "800",
                                            "1630"
                                        ],
                                        "CloseHours": [
                                            "1000",
                                            "1930"
                                        ]
                                    },
                                    {
                                        "Day": "6",
                                        "OpenHours": [
                                            "800",
                                            "1630"
                                        ],
                                        "CloseHours": [
                                            "1000",
                                            "1930"
                                        ]
                                    },
                                    {
                                        "Day": "7",
                                        "ClosedIndicator": ""
                                    }
                                ]
                            },
                            {
                                "HoursType": "12",
                                "DayOfWeek": [
                                    {
                                        "Day": "1",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "2",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "3",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "4",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "5",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "6",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "7",
                                        "ClosedIndicator": ""
                                    }
                                ]
                            },
                            {
                                "HoursType": "13",
                                "DayOfWeek": [
                                    {
                                        "Day": "1",
                                        "OpenHours": "1845"
                                    },
                                    {
                                        "Day": "2",
                                        "OpenHours": "1845"
                                    },
                                    {
                                        "Day": "3",
                                        "OpenHours": "1845"
                                    },
                                    {
                                        "Day": "4",
                                        "OpenHours": "1845"
                                    },
                                    {
                                        "Day": "5",
                                        "OpenHours": "1845"
                                    },
                                    {
                                        "Day": "6",
                                        "OpenHours": "1845"
                                    },
                                    {
                                        "Day": "7",
                                        "OpenHours": "1845"
                                    }
                                ]
                            },
                            {
                                "HoursType": "10",
                                "DayOfWeek": [
                                    {
                                        "Day": "1",
                                        "ClosedIndicator": ""
                                    },
                                    {
                                        "Day": "2",
                                        "OpenHours": [
                                            "800",
                                            "1630"
                                        ],
                                        "CloseHours": [
                                            "1000",
                                            "1930"
                                        ]
                                    },
                                    {
                                        "Day": "3",
                                        "OpenHours": [
                                            "800",
                                            "1630"
                                        ],
                                        "CloseHours": [
                                            "1000",
                                            "1930"
                                        ]
                                    },
                                    {
                                        "Day": "4",
                                        "OpenHours": [
                                            "800",
                                            "1630"
                                        ],
                                        "CloseHours": [
                                            "1000",
                                            "1930"
                                        ]
                                    },
                                    {
                                        "Day": "5",
                                        "OpenHours": [
                                            "800",
                                            "1630"
                                        ],
                                        "CloseHours": [
                                            "1000",
                                            "1930"
                                        ]
                                    },
                                    {
                                        "Day": "6",
                                        "OpenHours": [
                                            "800",
                                            "1630"
                                        ],
                                        "CloseHours": [
                                            "1000",
                                            "1930"
                                        ]
                                    },
                                    {
                                        "Day": "7",
                                        "ClosedIndicator": ""
                                    }
                                ]
                            }
                        ]
                    },
                    "Comments": "A government issued photo ID is required when shipping or picking up a package at a UPS Customer Center.",
                    "SLIC": "3060",
                    "ServiceOfferingList": {
                        "ServiceOffering": [
                            {
                                "Code": "001",
                                "Description": "Direct To Retail"
                            },
                            {
                                "Code": "002",
                                "Description": "Not In One ADL"
                            },
                            {
                                "Code": "004",
                                "Description": "Retail to Retail"
                            },
                            {
                                "Code": "007",
                                "Description": "PUDO"
                            },
                            {
                                "Code": "008",
                                "Description": "Early Pickup Delivery Time"
                            },
                            {
                                "Code": "010",
                                "Description": "DCO DCR intercept accepted"
                            },
                            {
                                "Code": "013",
                                "Description": "Accepts Restricted Articles"
                            }
                        ]
                    },
                    "DisplayPhoneNumberIndicator": "1",
                    "AccessPointInformation": {
                        "PublicAccessPointID": "U98248521",
                        "BusinessClassificationList": {
                            "BusinessClassification": {
                                "Code": "021",
                                "Description": "OTHER"
                            }
                        },
                        "AccessPointStatus": {
                            "Code": "01",
                            "Description": "ACTIVE"
                        }
                    },
                    "LocationImage": {
                        "SecureURL": "https://www.webservices.ups.com/locator-services/images?imageID=62C9267A-B477-47D1-8B06-D1C81D6F4399.jpg"
                    },
                    "LocationNewIndicator": "N",
                    "WillCallLocationIndicator": "N"
                }
            ]
        }
    }
}
```
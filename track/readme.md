# Track
## Introduction
  Track, is an api provides function to track status of a shipment, delivery , time, and the latest transit scan. It's a GET call which expects a inquiryNumber and returns a TrackResponse in the response body or errorResponse in case of error senario.
## Tracking API components include:

- **Package or Shipment Tracking**:Enables applications to provide tracking information based on a tracking number, shipment identification number, or reference number for packages, shipments or Mail Innovations pieces. A shipment may be a single transaction with multiple packages, or it may be a single freight shipment.
- **Tracking Numbers**: Enables applications to track, locate, and verify arrival of packages and shipments.
- **Shipment Identification Numbers**: Enables applications to use shipment identification numbers to identify and track every shipment as it moves through the UPS system.
- **Reference Numbers**: Allows for flexibility. Applications can track any UPS package or shipment by a convenient, user determined reference number. Applications can assign a reference number to:
an individual package
all packages in a shipment
an air or ocean freight shipment
- **PRO Numbers and Air Waybill Numbers**: Enables applications to use PRO or Air Waybill numbers to identify and trace a freight shipment as it moves through the UPS system. A successful query by PRO or Air Waybill number returns all commodities within a shipment.
- **Candidate Bookmarks**: Enables applications to distinguish between like references. In cases where more than one shipment matches a reference number, UPS returns identifying information about each shipment, and it marks each shipment with a unique candidate bookmark.

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
java -jar track-x.x.x.jar
```
- Check the console for the application's REST response.


## Code Walk Through
There are 2 notable class in this tutorial, namely com.ups.api.app.AppConfig and 
com.ups.api.app.Track.  The AppConfig class is a configuration class leveraging 
Spring injection to incorporate the property value from 
src/main/resources/application.properties file.  The Track class is to illustrat how 
to use the Tracking api.

```java
 String accessToken = Util.getAccessToken(appConfig, restTemplate);
```
> Get an access token via OAuth client_credentials grant type.

					
```java
	// create a 32 character unique id.
		final String transId = UUID.randomUUID().toString().replaceAll("-", "");
```
> It creates a 32 character randam Id will be used as transactionId a required parameter to get the tracking response.

```java
	// Get a Tracking information for the respective inquiryNumber sent as part of the GET call. 
	// Get Tracking information
			final TrackApiResponse trackApiResponse = sendRequest(appConfig.getInquiryNumber(), transId,
					appConfig.getTransactionSrc(),
					"en_US",
					"false");
```
>The sendRequest function creates a Track api object and set the access token expiry tolerance if it haven't created one yet as well as populating with a valid access token. A Tracking API response  will be returned from backend server  based on the inquiry number sent as part of the GET call.  


### Data Schema 
 - [Request Schema TrackApiResponse](docs/TrackApiResponse.md)


### Sample Request

https://wwwcie.ups.com/api/track/v1/details/{inquiryNumber}

### Sample Response
```json
{
    "trackResponse": {
        "shipment": [
            {
                "inquiryNumber": "<Inquiry Number>",
                "package": [
                    {
                        "trackingNumber": "<Tracking Number>",
                        "deliveryDate": [
                            {
                                "type": "DEL",
                                "date": "20220126"
                            }
                        ],
                        "deliveryTime": {
                            "type": "DEL",
                            "endTime": "163000"
                        },
                        "activity": [
                            {
                                "location": {
                                    "address": {
                                        "city": "PARAMUS",
                                        "stateProvince": "NJ",
                                        "countryCode": "US",
                                        "country": "US"
                                    },
                                    "slic": "0761"
                                },
                                "status": {
                                    "type": "D",
                                    "description": "DELIVERED ",
                                    "code": "F4",
                                    "statusCode": "011"
                                },
                                "date": "20220126",
                                "time": "163000"
                            },
                            {
                                "location": {
                                    "address": {
                                        "countryCode": "US",
                                        "country": "US"
                                    }
                                },
                                "status": {
                                    "type": "M",
                                    "description": "Shipper created a label, UPS has not received the package yet. ",
                                    "code": "MP",
                                    "statusCode": "003"
                                },
                                "date": "20220126",
                                "time": "151641"
                            }
                        ],
                        "packageCount": 1
                    }
                ]
            }
        ]
    }
}
```
## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.
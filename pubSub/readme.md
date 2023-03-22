# PubSub Tracking Api
## Introduction
  The PubSub tracking API is used by high-volume cusomters and third parties while decreasing overall load on the Track API.  A request holds up to 100 tracking number which has a 34 character limit.

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
|```<Tracking Number A>```|
|```<Tracking Number B>```|
|```<Your Message Receiver URL>```|
|```<Your Message Endpoint Access Token>```|

### Build and run

- Build the project using Maven
```sh
cd <project home>
mvn clean package
```

- Run the project that is generated in the <project home>/target directory.
```sh
java -jar pubsub-x.x.x.jar
```
- Check the console for the application's REST response.


## Code Walk Through
There are 2 notable classes in this tutorial, namely com.ups.api.app.AppConfig and com.ups.api.app.PubSubDemo.  The AppConfig class is a configuration class leveraging Spring injection to incorporate the property value from src/main/resources/application.properties file.  The PubSubDemo is to illustrate how to use the PubSub api.

					
```java
	PubSubTrackingRequest pubSubTrackingRequest = Util.createRequestFromJsonFile(entry.getKey(),
											entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
											PubSubTrackingRequest.class,
											appConfig,
											Arrays.asList(new CreateRequestEnricher() {}));
```
> It reconstructs a PubSubTrackingRequest object from a json file which includes 
shipper account number and a tracking number list.  In a typical application, 
a PubSubTrackingRequest object would be created via a default constructor followed by 
a set of setter to populate the necessary attribute.


```java
	// Get a tracking response for a list of tracking number.
	PubSubResponseWrapper pubSubResponseWrapper = sendRequest(pubSubTrackingRequest, transId, acceptParameter);
```
> The sendRequest function creates a PubSub api object and set the access token expiry tolerance if it haven't created one yet as well as populating with a valid access token.  A PubSubResponseWrapper will be returned from a backend server for a list of tracking number specified in the PubSubTrackingRequest object.  The PubSubResponseWrapper contains a list of valid tracking number and a list of invalid number if exists.


### Data Schema 
- [Request Schema PubSubTrackingRequest](docs/PubSubTrackingRequest.md)

- [Response Schema PubSubResponseWrapper](docs/PubSubResponseWrapper.md)

### Sample Request/Response
- PubSub request
```json
{
  "countryCode": "US",
  "locale": "en_US",
  "shipperAccountNumber": "",
  "trackingNumberList": [
    "<Tracking Number A>",
    "<Tracking Number B>"
  ],
  "scanPreference": [],
  "destination": {
    "url": "<Your Message Receiver URL>",
    "credential": "<Your Message Endpoint Access Token>",
    "credentialType": "Bearer"
  }
}
```


- Successful PubSub Response
```json
{
  "validTrackingNumbers": [
    "<Tracking Number A>",
    "<Tracking Number B>"
  ],
  "invalidTrackingNumbers": []
}
```
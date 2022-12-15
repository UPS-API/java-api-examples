# AddressValidation
## Introduction
 The Address Validation Street Level API can be used to check addresses against the United States Postal Service database of valid addresses in the U.S. and Puerto Rico.

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
java -jar addressValidation-x.x.x.jar 
```
- Check the console for the application's REST response.


## Code Walk Through
There are 2 notable class in this tutorial, namely com.ups.api.app.AppConfig and 
com.ups.api.app.AddressValidation.  The AppConfig class is a configuration class leveraging 
Spring injection to incorporate the property value from 
src/main/resources/application.properties file.  The AddressValidation class is to illustrate how to use the AddressValidation api.

```java
 String accessToken = Util.getAccessToken(appConfig, restTemplate);
```
> Get an access token via OAuth client_credentials grant type.


## Address Validation					
```java
	// Create XAV Request from a pre-determined json file
	XAVRequestWrapper xavRequestWrapper = Util.createRequestFromJsonFile(
						entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME),
						XAVRequestWrapper.class);			
```
> It reconstructs a XAVRequestWrapper object from a json file.  In a typical 
application, a XAVRequestWrapper object would be created via a default constructor 
and calling setter to populate the attribute instead.

```java
	// Get Address Validation result
	XAVResponseWrapper xavResponseWrapper = sendRequest(xavRequestWrapper);
```
>  The sendRequest function creates a AddressValidation api object and set the access token expiry tolerance if it haven't created one yet as well as populating with a valid access token.A Wrapper with XAV response  will be returned from backend server providing the address validation status, classification of address and validated address.

### Data Schema 
 - [Request Schema XAVRequestWrapper](docs/XAVRequestWrapper.md)
 - [Response Schema XAVResponseWrapper](docs/XAVResponseWrapper.md)


### Sample Request
```json
{
    "XAVRequest": {
        "Request": {
            "RequestOption": "3",
            "TransactionReference": {
                "CustomerContext": "Verify XAV Request returns Success Response when Request Option as Address Classification with Validation Source as USPS for US Commercial in AddressKey",
                "TransactionIdentifier": ""
            }
        },
        "AddressValidationSource": "3",
        "MaximumCandidateListSize": "15",
        "AddressKeyFormat": {
            "ConsigneeName": "",
            "AttentionName": "",
            "AddressLine": "123 Main St",
            "PoliticalDivision2": "Atlanta",
            "PoliticalDivision1": "GA",
            "PostcodePrimaryLow": "95677",
            "PostcodeExtendedLow": "3536",
            "Region": "",
            "Urbanization": "",
            "CountryCode": "US"
        }
    }
}
```
### Sample Response
```json
{
    "XAVResponse": {
        "Response": {
            "ResponseStatus": {
                "Code": "1",
                "Description": "Success"
            },
            "TransactionReference": {
                "CustomerContext": "Verify XAV Request returns Success Response when Request Option as Address Classification with Validation Source as USPS for US Commercial in AddressKey",
                "TransactionIdentifier": "123456789"
            }
        },
        "ValidAddressIndicator": "",
        "AddressClassification": {
            "Code": "1",
            "Description": "Commercial"
        },
        "Candidate": {
            "AddressClassification": {
                "Code": "1",
                "Description": "Commercial"
            },
            "AddressKeyFormat": {
                "AddressLine": "123 Main St",
                "PoliticalDivision2": "Atlanta",
                "PoliticalDivision1": "GA",
                "PostcodePrimaryLow": "95677",
                "PostcodeExtendedLow": "3334",
                "Region": "Atlanta GA 95677-3334",
                "CountryCode": "US"
            }
        }
    }
}
```
## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.
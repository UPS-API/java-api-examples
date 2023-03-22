# Pickup API
## Introduction
Using the Pickup API, applications can schedule pickups, manage previously scheduled pickups, or cancel previously scheduled pickups.

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
|:-------------------------------------------------------------:| 
|                    ```<Shipper Number> ```                    |
|           ```        <your email address>       ```           |
|     ```           <your From EMail Address>          ```      |
|       ```           <your Account Number>          ```        |
| ```           <your Confirmation Email Address>          ```  |
| ```           <your Undeliverable Email Address>          ``` |
| ```           <PRN>          ``` |


### Build and run

- Build the project using Maven
```sh
cd <project home>
mvn clean package
```

- Run the project that is generated in the <project home>/target directory.
```sh
java -jar pickup-x.x.x.jar
```
- Check the console for the application's REST response.


## Code Walk Through
There are 2 notable class in this tutorial, namely com.ups.api.app.AppConfig and 
com.ups.api.app.PickupDemo.  The AppConfig class is a configuration class leveraging 
Spring injection to incorporate the property value from 
src/main/resources/application.properties file.  The TnTDemo is to illustrate how 
to use the Landed cost api.


```java
 final PickupApi pickupApi = initializePickupApi(restTemplate, appConfig);

```
> initializePickupApi function is to create a pickup api object with the base url and 
populated the HTTP Authorization header with the access token.
	
## Pickup Creation	

| Method |                      Endpoint                       |
|:------:|:---------------------------------------------------:|
|  POST  | https://wwwcie.ups.com/api/pickupcreation/v1/pickup |

```java
	 PICKUPCreationRequestWrapper pickupCreationRequestWrapper
             = Util.createRequestFromJsonFile(
             entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME), PICKUPCreationRequestWrapper.class,
        appConfig);

final String transId = UUID.randomUUID().toString().replaceAll("-", "");

        PICKUPCreationResponseWrapper pickupCreationResponseWrapper =
        pickupApi.pickupCreation(appConfig.getPickupVersion(),
        pickupCreationRequestWrapper,transId, appConfig.getTransactionSrc());
        if (prn == null){
        prn = pickupCreationResponseWrapper.getPickupCreationResponse().getPRN();
        }
        processAllResponse(entry.getKey(), pickupCreationResponseWrapper.getPickupCreationResponse());
```
> It reconstructs a PICKUPCreationRequestWrapper object from a json file.  In a typical 
application, a PICKUPCreationRequestWrapper object would be created via a default constructor 
and calling setter to populate the attribute instead. processing Api call and printing in console as response

> A PICKUPCreationResponseWrapper will be returned from backend server for a particular pickup 
specified in the PICKUPCreationResponseWrapper object.  The PICKUPCreationResponseWrapper would have a
validation error if there is any as well as pickupCreationRequestWrapper, which includes a list of
available UPS service and service detail, to a successful request.



### Data Schema
- [Request Schema PICKUPCreationRequestWrapper](docs/PICKUPCancelRequestWrapper.md)

- [Response Schema PICKUPCreationResponseWrapper](docs/PICKUPCreationResponseWrapper.md)

### Sample Request for pickup creation

```json
{
  "PickupCreationRequest": {
    "Request": {
      "TransactionReference": {
        "CustomerContext": "d9 Different Client-- shipper account payment method -"
      }
    },
    "RatePickupIndicator": "N",
    "Shipper": {
      "Account": {
        "AccountNumber": "<your Account Number>",
        "AccountCountryCode": "US"
      }
    },
    "PickupDateInfo": {
      "CloseTime": "1400",
      "ReadyTime": "0500",
      "PickupDate": "20221130"
    },
    "PickupAddress": {
      "CompanyName": "Pickup Proxy",
      "ContactName": "Pickup Manager",
      "AddressLine": "Pickup Address",
      "Room": "R01",
      "Floor": "2",
      "City": "Allendale",
      "StateProvince": "NJ",
      "Urbanization": "",
      "PostalCode": "07401",
      "CountryCode": "US",
      "ResidentialIndicator": "Y",
      "PickupPoint": "Lobby",
      "Phone": {
        "Number": "123456789",
        "Extension": "1234"
      }
    },
    "AlternateAddressIndicator": "Y",
    "PickupPiece": [
      {
        "ServiceCode": "001",
        "Quantity": "27",
        "DestinationCountryCode": "US",
        "ContainerCode": "01"
      },
      {
        "ServiceCode": "012",
        "Quantity": "4",
        "DestinationCountryCode": "US",
        "ContainerCode": "01"
      }
    ],
    "TotalWeight": {
      "Weight": "5.5",
      "UnitOfMeasurement": "LBS"
    },
    "OverweightIndicator": "N",
    "PaymentMethod": "01",
    "SpecialInstruction": "Jias Test ",
    "ReferenceNumber": "CreatePickupRefJia",
    "Notification": {
      "ConfirmationEmailAddress": "<your Confirmation Email Address> ",
      "UndeliverableEmailAddress": "<your Undeliverable Email Address>"
    }
  }
}
```


### Pickup creation Response 

```json
{
  "PickupCreationResponse": {
    "Response": {
      "ResponseStatus": {
        "Code": "1",
        "Description": "Success"
      },
      "TransactionReference": {
        "CustomerContext": "d9 Different Client-- shipper account payment method -"
      }
    },
    "PRN": "<PRN>",
    "RateStatus": {
      "Code": "04",
      "Description": "Rate not requested"
    }
  }
}
```
## Pickup Get Service Center Facilities


| Method |                      Endpoint                       |
|:------:|:---------------------------------------------------:|
|  POST  | https://wwwcie.ups.com/api/pickup/v1/servicecenterlocations |

```java
	  PICKUPServCenterRequestWrapper pickupServCenterRequestWrapper
        = Util.createRequestFromJsonFile(
        entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME), PICKUPServCenterRequestWrapper.class,
        appConfig);

final String transId = UUID.randomUUID().toString().replace("-", "");
final PickupApi pickupApi = initializePickupApi(restTemplate, appConfig);
        PICKUPServCenterResponseWrapper pickupServCenterResponseWrapper =
        pickupApi.pickupGetServiceCenterFacilities(appConfig.getPickupVersion(),
        pickupServCenterRequestWrapper, transId, appConfig.getTransactionSrc());

```
> It reconstructs a PICKUPServCenterRequestWrapper object from a json file.  In a typical
application, a PICKUPServCenterRequestWrapper object would be created via a default constructor
and calling setter to populate the attribute instead. processing Api call and printing in console as response

> A PICKUPServCenterResponseWrapper will be returned from backend server for a particular pickup
specified in the PICKUPServCenterResponseWrapper object.  The PICKUPServCenterResponseWrapper would have a
validation error if there is any as well as PICKUPServCenterResponseWrapper, which includes a list of
available UPS service and service detail, to a successful request.

### Data Schema
- [Request Schema PICKUPServCenterRequestWrapper](docs/PICKUPServCenterRequestWrapper.md)

- [Response Schema PICKUPServCenterResponseWrapper](docs/PICKUPServCenterResponseWrapper.md)

### Sample Request for Pickup Get Service Center Facilities
```json
{
  "PickupGetServiceCenterFacilitiesRequest" : {
    "Request" : {
      "TransactionReference" : {
        "CustomerContext" : "Verify success response is returned with UPS location informatiom when GetServiceLocation request is submitted"
      }
    },
    "PickupPiece" : {
      "ServiceCode" : "096",
      "ContainerCode" : "03"
    },
    "OriginAddress" : {
      "StreetAddress" : "Test address Line",
      "City" : "BERLIN",
      "StateProvince" : "NY",
      "PostalCode" : "10011",
      "CountryCode" : "DE",
      "OriginSearchCriteria" : {
        "SearchRadius" : "1",
        "DistanceUnitOfMeasure" : "MI",
        "MaximumLocation" : "10"
      }
    },
    "DestinationAddress" : {
      "City" : "Ontario",
      "StateProvince" : "ON",
      "PostalCode" : "A1A1A1",
      "CountryCode" : "CA"
    },
    "Locale" : "en_US"
  }
}

```

### Sample Response for Pickup Get Service Center Facilities

```json
{
  "PickupGetServiceCenterFacilitiesResponse": {
    "Response": {
      "ResponseStatus": {
        "Code": "1",
        "Description": "Success"
      },
      "TransactionReference": {
        "CustomerContext": "Verify success response is returned with UPS location informatiom when GetServiceLocation request is submitted"
      }
    },
    "ServiceCenterLocation": {
      "DropOffFacilities": [
        {
          "Name": "Name",
          "Address": {
            "AddressLine": "AddressLine,",
            "City": "HAMBURG",
            "PostalCode": "22335",
            "CountryCode": "DE"
          },
          "SLIC": "0004",
          "Type": "PKG",
          "Timezone": "Europe/Berlin",
          "Phone": "123456789",
          "FacilityTime": {
            "DayOfWeek": [
              {
                "Day": "Monday",
                "OpenHours": "0900",
                "CloseHours": "1800",
                "PrepTime": "60",
                "LastDrop": "1600"
              },
              {
                "Day": "Tuesday",
                "OpenHours": "0900",
                "CloseHours": "1800",
                "PrepTime": "60",
                "LastDrop": "1600"
              },
              {
                "Day": "Wednesday",
                "OpenHours": "0900",
                "CloseHours": "1800",
                "PrepTime": "60",
                "LastDrop": "1600"
              },
              {
                "Day": "Thursday",
                "OpenHours": "0900",
                "CloseHours": "1800",
                "PrepTime": "60",
                "LastDrop": "1600"
              },
              {
                "Day": "Friday",
                "OpenHours": "0900",
                "CloseHours": "1800",
                "PrepTime": "60",
                "LastDrop": "1600"
              }
            ]
          }
        },
        {
          "Name": "Name",
          "Address": {
            "AddressLine": "AddressLine",
            "City": "UMKIRCH",
            "PostalCode": "79224",
            "CountryCode": "DE"
          },
          "SLIC": "7931",
          "Type": "PKG",
          "Timezone": "Europe/Berlin",
          "Phone": "123456789",
          "FacilityTime": {
            "DayOfWeek": [
              {
                "Day": "Sunday",
                "OpenHours": "0800",
                "CloseHours": "2000",
                "PrepTime": "60",
                "LastDrop": "1615"
              },
              {
                "Day": "Monday",
                "OpenHours": "0800",
                "CloseHours": "2000",
                "PrepTime": "60",
                "LastDrop": "1615"
              },
              {
                "Day": "Tuesday",
                "OpenHours": "0800",
                "CloseHours": "2000",
                "PrepTime": "60",
                "LastDrop": "1615"
              },
              {
                "Day": "Wednesday",
                "OpenHours": "0800",
                "CloseHours": "2000",
                "PrepTime": "60",
                "LastDrop": "1615"
              },
              {
                "Day": "Thursday",
                "OpenHours": "0800",
                "CloseHours": "2000",
                "PrepTime": "60",
                "LastDrop": "1615"
              },
              {
                "Day": "Friday",
                "OpenHours": "0800",
                "CloseHours": "2000",
                "PrepTime": "60",
                "LastDrop": "1615"
              }
            ]
          }
        },
        {
          "Name": "Name",
          "Address": {
            "AddressLine": "AddressLine",
            "City": "KIRCHHEIM",
            "PostalCode": "85551",
            "CountryCode": "DE"
          },
          "SLIC": "8071",
          "Type": "PKG",
          "Timezone": "Europe/Berlin",
          "Phone": "123456789",
          "FacilityTime": {
            "DayOfWeek": [
              {
                "Day": "Sunday",
                "OpenHours": "0800",
                "CloseHours": "2000",
                "PrepTime": "60",
                "LastDrop": "1730"
              },
              {
                "Day": "Monday",
                "OpenHours": "0800",
                "CloseHours": "2000",
                "PrepTime": "60",
                "LastDrop": "1730"
              },
              {
                "Day": "Tuesday",
                "OpenHours": "0800",
                "CloseHours": "2000",
                "PrepTime": "60",
                "LastDrop": "1730"
              },
              {
                "Day": "Wednesday",
                "OpenHours": "0800",
                "CloseHours": "2000",
                "PrepTime": "60",
                "LastDrop": "1730"
              },
              {
                "Day": "Thursday",
                "OpenHours": "0800",
                "CloseHours": "2000",
                "PrepTime": "60",
                "LastDrop": "1730"
              },
              {
                "Day": "Friday",
                "OpenHours": "0800",
                "CloseHours": "2000",
                "PrepTime": "60",
                "LastDrop": "1730"
              }
            ]
          }
        }
      ],
      "PickupFacilities": {
        "Name": "Name",
        "Address": {
          "AddressLine": "AddressLine",
          "City": "DARTMOUTH",
          "StateProvince": "NS",
          "PostalCode": "B3B1J8",
          "CountryCode": "CA"
        },
        "SLIC": "9985",
        "Type": "FRT",
        "Timezone": "Atlantic Standard Time",
        "Phone": "123456789",
        "FacilityTime": {
          "DayOfWeek": [
            {
              "Day": "Monday",
              "OpenHours": "0700",
              "CloseHours": "1800",
              "PrepTime": "90",
              "LastDrop": "1630"
            },
            {
              "Day": "Tuesday",
              "OpenHours": "0700",
              "CloseHours": "1800",
              "PrepTime": "90",
              "LastDrop": "1630"
            },
            {
              "Day": "Wednesday",
              "OpenHours": "0700",
              "CloseHours": "1800",
              "PrepTime": "90",
              "LastDrop": "1630"
            },
            {
              "Day": "Thursday",
              "OpenHours": "0700",
              "CloseHours": "1800",
              "PrepTime": "90",
              "LastDrop": "1630"
            },
            {
              "Day": "Friday",
              "OpenHours": "0700",
              "CloseHours": "1800",
              "PrepTime": "90",
              "LastDrop": "1630"
            }
          ]
        }
      }
    }
  }
}
```

## Pickup rate


| Method |                      Endpoint                       |
|:------:|:---------------------------------------------------:|
|  POST  | https://wwwcie.ups.com/api/shipments/v1/pickup/rating |

```java
	  PICKUPRequestWrapper pickupRequestWrapper
        = Util.createRequestFromJsonFile(
        entry.getValue().get(AppConfig.SCENARIO_PROPERTIES_JSON_FILE_NAME), PICKUPRequestWrapper.class,
        appConfig);

final String transId = UUID.randomUUID().toString().replace("-", "");
final PickupApi pickupApi = initializePickupApi(restTemplate, appConfig);
        PICKUPResponseWrapper pickupResponseWrapper =
        pickupApi.pickupRate(appConfig.getPickupVersion(),
        appConfig.POST_PICKUP_TYPE,
        pickupRequestWrapper,
        transId, appConfig.getTransactionSrc());
```
> It reconstructs a PICKUPRequestWrapper object from a json file.  In a typical
application, a PICKUPRequestWrapper object would be created via a default constructor
and calling setter to populate the attribute instead. processing Api call and printing in console as response

> A PICKUPResponseWrapper will be returned from backend server for a particular pickup
specified in the PICKUPResponseWrapper object.  The PICKUPResponseWrapper would have a
validation error if there is any as well as PICKUPResponseWrapper, which includes a list of
available UPS service and service detail, to a successful request.

### Data Schema
- [Request Schema PICKUPRequestWrapper](docs/PICKUPRequestWrapper.md)

- [Response Schema PICKUPResponseWrapper](docs/PICKUPResponseWrapper.md)

### Sample Request for pickup Rate
```json
{
  "PickupRateRequest" : {
    "Request" : {
      "RequestOption" : "01",
      "SubVersion" : "1701",
      "TransactionReference" : {
        "CustomerContext" : "Verify Success response is returned with  Published charge  and warning 9500717 code for rate request with NBS user."
      }
    },
    "PickupAddress" : {
      "AddressLine" : "Pickup Address",
      "City" : "Louisville",
      "StateProvince" : "GA",
      "PostalCode" : "30076",
      "CountryCode" : "US",
      "ResidentialIndicator" : "Y"
    },
    "AlternateAddressIndicator" : "Y",
    "ServiceDateOption" : "02",
    "PickupDateInfo" : {
      "CloseTime" : "1700",
      "ReadyTime" : "0900",
      "PickupDate" : "20220524"
    },
    "TaxInformationIndicator" : "Y",
    "UserLevelDiscountIndicator" : "Y"
  }
}
```


### Sample response for Pickup rate 

```json
{
  "PickupRateResponse": {
    "Response": {
      "ResponseStatus": {
        "Code": "1",
        "Description": "Success"
      },
      "Alert": {
        "Code": "9500717",
        "Description": "User level promotion discount not valid for the pickup."
      },
      "TransactionReference": {
        "CustomerContext": "Verify Success response is returned with  Published charge  and warning 9500717 code for rate request with NBS user.",
        "TransactionIdentifier": "trhel8vm1ct3yvpD4KY8Bl"
      }
    },
    "RateResult": {
      "Disclaimer": {
        "Code": "05",
        "Description": "Rate excludes VAT. Rate includes a fuel surcharge, but excludes taxes, duties and other charges that may apply to the shipment."
      },
      "RateType": "FD",
      "CurrencyCode": "USD",
      "ChargeDetail": [
        {
          "ChargeCode": "B",
          "ChargeDescription": "BASE CHARGE",
          "ChargeAmount": "7.00",
          "TaxAmount": "0.00"
        },
        {
          "ChargeCode": "S",
          "ChargeDescription": "REMOTE AREA SURCHARGE",
          "ChargeAmount": "0.00",
          "TaxAmount": "0.00"
        },
        {
          "ChargeCode": "S",
          "ChargeDescription": "RESIDENTIAL SURCHARGE",
          "ChargeAmount": "4.85",
          "TaxAmount": "0.00"
        },
        {
          "ChargeCode": "S",
          "ChargeDescription": "FUEL SURCHARGE",
          "ChargeAmount": "2.04",
          "TaxAmount": "0.00"
        }
      ],
      "TotalTax": "0.00",
      "GrandTotalOfAllCharge": "13.89",
      "PreTaxTotalCharge": "13.89"
    }
  }
}
```

## Pickup Pending Status 

| Method |                      Endpoint                       |
|:------:|:---------------------------------------------------:|
|  GET   | https://wwwcie.ups.com/api/shipments/v1/pickup/both |


```java
	  final PickupApi pickupApi = initializePickupApi(restTemplate, appConfig);
final String transId = UUID.randomUUID().toString().replace("-", "");
        PICKUPPendingResponseWrapper pickupPendingResponseWrapper =
        pickupApi.pickupPendingStatus(appConfig.getAccountNumber(),
        appConfig.getPickupVersion(),
        appConfig.GET_PICKUP_TYPE, transId, appConfig.getTransactionSrc());
```
>   processing request by passing account number and pickup type
### Data Schema

- [Response Schema PICKUPPendingResponseWrapper](docs/PICKUPPendingResponseWrapper.md)

### Sample Response for Pickup Pending Status
```json
{
  "PickupPendingStatusResponse": {
    "Response": {
      "ResponseStatus": {
        "Code": "1",
        "Description": "Success"
      }
    },
    "PendingStatus": {
      "PickupType": "02",
      "ServiceDate": "20221128",
      "PRN": "<PRN>",
      "GWNStatusCode": "003",
      "PickupStatusMessage": "Order successfully completed"
    }
  }
}
```

## Pickup Cancel

| Method |                      Endpoint                       |
|:------:|:---------------------------------------------------:|
| DELETE | https://wwwcie.ups.com/api/shipments/v1/pickup/prn |


```java
	   final PickupApi pickupApi = initializePickupApi(restTemplate, appConfig);
final String transId = UUID.randomUUID().toString().replace("-", "");
        PICKUPCancelResponseWrapper pickupCancelResponseWrapper =
        pickupApi.pickupCancel(appConfig.CANCEL_BY,
        appConfig.getPickupVersion(),
        transId, appConfig.getTransactionSrc(), prn);
        processAllResponse("PickupCancelResponseSuccess",
        pickupCancelResponseWrapper.getPickupCancelResponse());
```
>   processing request by passing prn number and pickup type would be prn
### Data Schema

- [Response Schema PICKUPCancelResponseWrapper](docs/PICKUPCancelResponseWrapper.md)

### Sample Response for Pickup Cancel
```json
{
  "PickupCancelResponse": {
    "Response": {
      "ResponseStatus": {
        "Code": "1",
        "Description": "Success"
      },
      "TransactionReference": {
        "CustomerContext": "ValsRequest",
        "TransactionIdentifier": "trhel8vm1cy3kzflqJfk4B"
      }
    },
    "PickupType": "01"
  }
}
```

## Pickup Get Political Division List

| Method |                      Endpoint                       |
|:------:|:---------------------------------------------------:|
|  GET   |https://wwwcie.ups.com/api/pickup/v1/countries/US|


```java
	  final PickupApi pickupApi = initializePickupApi(restTemplate, appConfig);
final String transId = UUID.randomUUID().toString().replace("-", "");
        PICKUPPolDivResponseWrapper pickupGetPoliticalDivision1List =
        pickupApi.pickupGetPoliticalDivision1List(transId, appConfig.getTransactionSrc(),
        appConfig.getPickupVersion(),
        appConfig.getCountryCode());
```
>   processing request by passing  country code

### Data Schema

- [Response Schema PICKUPPolDivResponseWrapper](docs/PICKUPPolDivResponseWrapper.md)

### Sample Response for Pickup Get Political Division List
```json
{
  "PickupGetPoliticalDivision1ListResponse": {
    "Response": {
      "ResponseStatus": {
        "Code": "1",
        "Description": "Success"
      }
    },
    "PoliticalDivision1": [
      "AK",
      "AL",
      "AR",
      "AZ",
      "CA",
      "CO",
      "CT",
      "DC",
      "DE",
      "FL",
      "GA",
      "HI",
      "IA",
      "ID",
      "IL",
      "IN",
      "KS",
      "KY",
      "LA",
      "MA",
      "MD",
      "ME",
      "MI",
      "MN",
      "MO",
      "MS",
      "MT",
      "NC",
      "ND",
      "NE",
      "NH",
      "NJ",
      "NM",
      "NV",
      "NY",
      "OH",
      "OK",
      "OR",
      "PA",
      "PR",
      "RI",
      "SC",
      "SD",
      "TN",
      "TX",
      "UT",
      "VA",
      "VT",
      "WA",
      "WI",
      "WV",
      "WY"
    ]
  }
}
```
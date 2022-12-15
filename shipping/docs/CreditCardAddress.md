

# CreditCardAddress

Container to hold the Credit card Billing Address.  It is required to provide billing address if credit card information is provided and when the ShipFrom country or territory is the US, PR, and CA.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addressLine** | **String** | SoldTo location�s street address.  Applies to NAFTA CO. |  |
|**city** | **String** | SoldTo location�s city. |  |
|**stateProvinceCode** | **String** | SoldTo location�s state or province code.  Required for certain countries or territories. |  [optional] |
|**postalCode** | **String** | SoldTo location�s postal code. |  [optional] |
|**countryCode** | **String** | SoldTo location�s country or territory code. |  |




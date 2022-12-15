

# ShipToAddress

Address Container.  N/A

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addressLine** | **String** | The UPS Access Point&#39;s street address, including name and number (when applicable).  Length is not validated. |  |
|**city** | **String** | UPS Access Point city. |  [optional] |
|**stateProvinceCode** | **String** | UPS Access Point State or Province code. |  [optional] |
|**postalCode** | **String** | Postal Code for UPS accounts billing address.  Postal Code  may be present when the FRS Payment Information type &#x3D; 02 and type &#x3D; 03. |  [optional] |
|**countryCode** | **String** | Country or Territory code for the  UPS accounts &amp; billing address.  Country or Territory Code is required when the FRS Payment Information type &#x3D; 02 and type&#x3D; 03. |  |
|**residentialAddressIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored.This field is a flag to indicate if the Alternate Delivery location is a residential location.  True if ResidentialAddressIndicator tag exists.  For future use. |  [optional] |




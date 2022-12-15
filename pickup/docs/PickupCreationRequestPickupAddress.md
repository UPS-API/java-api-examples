

# PickupCreationRequestPickupAddress

The container of pickup address.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**companyName** | **String** | Company name |  |
|**contactName** | **String** | Name of contact person |  |
|**addressLine** | **String** | Detailed street address. For Jan. 2010 release, only one AddressLine is allowed |  |
|**room** | **String** | Room number |  [optional] |
|**floor** | **String** | Floor number |  [optional] |
|**city** | **String** | City or equivalent |  |
|**stateProvince** | **String** | State or province for postal countries; county for Ireland (IE) and district code for Hong Kong (HK) |  [optional] |
|**urbanization** | **String** | Barrio for Mexico (MX) Urbanization for Puerto Rico (PR) Shire for United Kingdom (UK) |  [optional] |
|**postalCode** | **String** | Postal code or equivalent for postal countries |  [optional] |
|**countryCode** | **String** | The pickup country or territory code as defined by ISO-3166.  Refer to Country or Territory Codes in the Appendix for valid values. |  |
|**residentialIndicator** | **String** | Indicates if the pickup address is commercial or residential.  Valid values: Y &#x3D; Residential address N &#x3D; Non-residential (Commercial) address (default) |  |
|**pickupPoint** | **String** | The specific spot to pickup at the address. |  [optional] |
|**phone** | [**PickupAddressPhone**](PickupAddressPhone.md) |  |  |




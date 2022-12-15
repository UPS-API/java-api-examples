

# FreightOptionsDestinationAddress

Destination Address Container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**city** | **String** | The city of pickup address if available.  It is required for non-postal country Ireland (IE). |  [optional] |
|**stateProvince** | **String** | 1. It means district code for Hong Kong (HK) 2. It means county for Ireland (IE) 3. It means state or province for all the postal countries  It is required for non-postal countries including HK and IE. |  [optional] |
|**postalCode** | **String** | Postal Code for postal countries.  It does not apply to non-postal countries such as IE and HK |  [optional] |
|**countryCode** | **String** | The pickup country or territory code as defined by ISO-3166.  Refer to Country or Territory Codes in the Appendix for valid values.  Upper-case two-letter string. |  |






# DeliveryLocationAddressArtifactFormat

Information that specifies a physical location where package is delivered.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**consigneeName** | **String** | Consignee&#39;s name at the location where package is delivered. |  [optional] |
|**streetNumberLow** | **String** | Street number where package is delivered. |  [optional] |
|**streetPrefix** | **String** | Street prefix where package is delivered, e.g. N, SE. |  [optional] |
|**streetName** | **String** | Street name where package is delivered. |  [optional] |
|**streetType** | **String** | Street type where package is delivered. |  [optional] |
|**streetSuffix** | **String** | Street suffix where package is delivered, e.g. N, SE. |  [optional] |
|**buildingName** | **String** | Building name where package is delivered. |  [optional] |
|**addressExtendedInformation** | [**List&lt;AddressArtifactFormatAddressExtendedInformation&gt;**](AddressArtifactFormatAddressExtendedInformation.md) |  |  [optional] |
|**politicalDivision3** | **String** | The neighborhood, town, barrio etc. |  [optional] |
|**politicalDivision2** | **String** | City name where package is delivered. |  [optional] |
|**politicalDivision1** | **String** | Abbreviated state or province name where package is delivered. |  [optional] |
|**countryCode** | **String** | Abbreviated country or territory name where package is delivered. |  [optional] |
|**postcodePrimaryLow** | **String** | Postal Code where package is delivered. Required if the user does not submit the City, Alphanumeric State/Province address combination. |  [optional] |
|**postcodeExtendedLow** | **String** | 4 Digit postal code extension where package is delivered.� Valid for US only. |  [optional] |
|**residentialAddressIndicator** | **String** | Residential address indicator for the location where package is delivered. The presence indicates residential address, the absence indicates a business address. |  |




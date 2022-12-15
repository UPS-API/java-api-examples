

# OriginAddressAddressKeyFormat

Contains all of the basic information about the origin such as: Address Lines, City, State/Province, Postal Code and Country or Territory Code.  The element CountryCode is required.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**consigneeName** | **String** | Name. (Also includes the building name)Return if available. |  [optional] |
|**addressLine** | **String** | Address Line Information of the UPS location The address level or Intersection information. Only two address lines will be returned. The second line may contain such information as the building name, the suite, and room. |  |
|**addressLine2** | **String** | Additional Address Line Information. |  [optional] |
|**addressLine3** | **String** | Additional Address Line Information. |  [optional] |
|**politicalDivision3** | **String** | Subdivision within a City.� e.g., a Barrio. |  [optional] |
|**politicalDivision2** | **String** | City. |  |
|**politicalDivision1** | **String** | State/Province. |  |
|**postcodePrimaryLow** | **String** | Postal Code. |  |
|**postcodeExtendedLow** | **String** | 4 Digit postal code extension. Valid for US only. |  [optional] |
|**countryCode** | **String** | A country or territory code. Valid values to be returned are: US-United States (meaning US 50). |  |
|**singleLineAddress** | **String** | Single line search information. Can contain values of origin address in a single line. Will override other origin address information. |  [optional] |




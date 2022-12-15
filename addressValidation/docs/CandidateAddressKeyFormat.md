

# CandidateAddressKeyFormat

AddressKeyFormat Container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**consigneeName** | **String** | Name of business, company or person. Not returned if user selects the RegionalRequestIndicator. |  [optional] |
|**attentionName** | **String** | Name of building. Not returned if user selects the RegionalRequestIndicator. |  [optional] |
|**addressLine** | **String** | Address line (street number, street name and street type, and political division 1, political division 2 and postal code) used for street level information. Additional secondary information (apartment, suite, floor, etc.) Applicable to US and PR only.  Not returned if user selects the RegionalRequestIndicator. |  [optional] |
|**region** | **String** | Single entry containing in this order  Political Division 2, Political Division 1 and Post Code Primary Low and/or PostcodeExtendedLow. |  [optional] |
|**politicalDivision2** | **String** | City or Town name. |  [optional] |
|**politicalDivision1** | **String** | State/Province.  Returned if the location is within a State/Province/Territory.  For International: returned if user enters valid Country or Territory Code, and City/postal code and it has a match.  For Domestic addresses, the value must be a valid 2-character value (per US Mail standards).  For International the full State or Province name will be returned. |  [optional] |
|**postcodePrimaryLow** | **String** | Low-end Postal Code. Returned for countries or territories with Postal Codes. May be alphanumeric. |  [optional] |
|**postcodeExtendedLow** | **String** | Low-end extended postal code in a range. Example in quotes: Postal Code 30076-&#39;1234&#39;.  Only returned in candidate list. May be alphanumeric |  [optional] |
|**urbanization** | **String** | Puerto Rico Political Division 3. Only Valid for Puerto Rico. |  [optional] |
|**countryCode** | **String** | A country or territory code. Required to be returned. |  |




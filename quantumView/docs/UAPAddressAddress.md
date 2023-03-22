

# UAPAddressAddress

Information that specifies a physical location.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addressLine1** | **String** | Address Line 1 of the UPS Access Point. |  [optional] |
|**addressLine2** | **String** | Address Line 2 of the UPS Access Point. Usually room/floor information. |  [optional] |
|**addressLine3** | **String** | Address Line 3 of the UPS Access Point. Usually department information. |  [optional] |
|**city** | **String** | UPS Access Point City. |  [optional] |
|**stateProvinceCode** | **String** | UPS Access Point&#39;s state or province code. Must be valid US state. If the UPS Access Point country or territory is US or CA a two character code is required, otherwise, the StateProvinceCode is optional. |  [optional] |
|**postalCode** | **String** | UPS Access Point&#39;s postal code. If the address is US then 5 or 9 digits are required. CA addresses must provide a 6 character postal code that has the format of A#A#A#, where A is an alphabetic character and # is numeric digit. Otherwise, 1 to 16 alphanumeric characters are allowed. |  [optional] |
|**countryCode** | **String** | UPS Access Point&#39;s country or territory code. Valid values: CA,MX, PR, US, AT, BE, DE, DK, ES, FI, FR, GB, IE, IT, NL, PT, SE, MC, and VA |  [optional] |




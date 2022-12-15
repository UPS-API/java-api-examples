

# AccessPointSearchExcludeFromResult

This contains elements to exclude from UPS Access Point address or geocode search.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**businessClassificationCode** | **String** | This contains the business classification code to exclude from UPS Access Point Search by address or geocode. Multiple codes can are possible in separate elements. Please refer to Appendix D for detailed business codes. |  [optional] |
|**businessName** | **String** | This contains the business name to exclude from UPS Access Point Search by address or geocode. Partial names are accepted. |  [optional] |
|**radius** | **String** | Public Access points within Radius (in specified Unit of Measure) of any included private access points will be excluded from the results. Valid only if at least one IncludeCriteria/MerchantAccountNumber is provided. |  [optional] |
|**postalCodeList** | [**ExcludeFromResultPostalCodeList**](ExcludeFromResultPostalCodeList.md) |  |  [optional] |




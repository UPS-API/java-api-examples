

# LocatorRequest

N/A

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**request** | [**LocatorRequestRequest**](LocatorRequestRequest.md) |  |  |
|**originAddress** | [**LocatorRequestOriginAddress**](LocatorRequestOriginAddress.md) |  |  |
|**translate** | [**LocatorRequestTranslate**](LocatorRequestTranslate.md) |  |  |
|**unitOfMeasurement** | [**LocatorRequestUnitOfMeasurement**](LocatorRequestUnitOfMeasurement.md) |  |  [optional] |
|**locationID** | **String** | Location ID is the identification number of the UPS affiliated location. |  [optional] |
|**locationSearchCriteria** | [**LocatorRequestLocationSearchCriteria**](LocatorRequestLocationSearchCriteria.md) |  |  [optional] |
|**sortCriteria** | [**LocatorRequestSortCriteria**](LocatorRequestSortCriteria.md) |  |  [optional] |
|**allowAllConfidenceLevels** | **String** | Indicator to allow confidence level in search. |  [optional] |
|**searchOptionCode** | **String** | Valid values:  01-Proximity Search Details 02-Address Search Details 03-Proximity Search Summary 04-Address Search Summary 05-Freight Will Call Search.  Either OptionType 03 or 04 is required. |  [optional] |
|**serviceGeoUnit** | [**LocatorRequestServiceGeoUnit**](LocatorRequestServiceGeoUnit.md) |  |  [optional] |
|**freightIndicator** | **String** | FreightIndicator. Required for Freight Location Search. |  [optional] |




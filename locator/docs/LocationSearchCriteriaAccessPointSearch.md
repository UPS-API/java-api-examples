

# LocationSearchCriteriaAccessPointSearch

Applicable for request option 64 only. This contains inclusion and exclusion criteria for address search. It also contains Account Number and Access Point Public ID search elements.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**publicAccessPointID** | **String** | The Public Access Point ID to use for UPS Access Point Search. Once this parameter is present , address or geocode search is ignored. It cannot be combined with AccountNumber search parameter. |  [optional] |
|**accessPointStatus** | **String** | Status of UPS Access Point. Valid values are:  01-Active-available 07-Active-unavailable. |  [optional] |
|**accountNumber** | **String** | The account number to use for UPS Access Point Search in the country or territory. Used to locate a private network for the account. Once this parameter is present any access point address or geocode search is ignored. It cannot be combined with PublicAccessPointID search parameter. |  [optional] |
|**includeCriteria** | [**AccessPointSearchIncludeCriteria**](AccessPointSearchIncludeCriteria.md) |  |  [optional] |
|**excludeFromResult** | [**AccessPointSearchExcludeFromResult**](AccessPointSearchExcludeFromResult.md) |  |  [optional] |
|**exactMatchIndicator** | **String** | Presence of this tag represents that \&quot;AccessPointSearchByAddress\&quot; service is requested. The value of this tag is ignored. |  [optional] |
|**existIndicator** | **String** | Presence of this tag represents that \&quot;AccessPointAvailability\&quot; service is requested. The value of this tag is ignored. |  [optional] |




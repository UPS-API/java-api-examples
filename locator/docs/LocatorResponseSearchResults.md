

# LocatorResponseSearchResults

Container for search results.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**geocodeCandidate** | [**SearchResultsGeocodeCandidate**](SearchResultsGeocodeCandidate.md) |  |  [optional] |
|**disclaimer** | **String** | Disclaimer. In the event the user requested Ground and Air service types and the maximum UPS locations list size has not been met, the list of locations will continue with locations that provide either ground or air within the search radius.   The disclaimer will note this deviation from the requested search criteria. The disclaimer is also the location where the user will receive information regarding a one-time pickup option if the first location is greater than 20 miles from the origin. |  [optional] |
|**dropLocation** | [**List&lt;SearchResultsDropLocation&gt;**](SearchResultsDropLocation.md) |  |  [optional] |
|**availableLocationAttributes** | [**SearchResultsAvailableLocationAttributes**](SearchResultsAvailableLocationAttributes.md) |  |  [optional] |
|**activeAvailableAccessPointIndicator** | **String** | Indicates whether the country or territory has AccessPoints or not.   This tag is populated in the Response only if tag \&quot;ExistIndicator\&quot; was present in the Locator request. |  [optional] |




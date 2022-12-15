

# SearchResultsGeocodeCandidate

If the origin address provided in the location request document does not have a match, a list of candidate addresses, geocodes and optionally a landmark will be returned.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addressKeyFormat** | [**GeocodeCandidateAddressKeyFormat**](GeocodeCandidateAddressKeyFormat.md) |  |  |
|**geocode** | [**GeocodeCandidateGeocode**](GeocodeCandidateGeocode.md) |  |  |
|**landmarkName** | **String** | If a Landmark code was provided in the request, a candidate list of Landmark Names will be returned along with the corresponding address and Geocode. |  [optional] |




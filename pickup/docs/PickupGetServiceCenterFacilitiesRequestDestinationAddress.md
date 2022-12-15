

# PickupGetServiceCenterFacilitiesRequestDestinationAddress

DestinationAddress container.  Conditionally required for pickup location search.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**city** | **String** | Indicates the address of the consignee to allow for the nearest Pickup facility Search.  Required for non-postal country Ireland (IE). |  [optional] |
|**stateProvince** | **String** | Indicates the address of the consignee to allow for the nearest Pickup facility Search. 1 &#x3D; District code for Hong Kong (HK) 2 &#x3D; County for Ireland (IE) 3 &#x3D; State or province for all the postal countries  Required for non-postal countries including HK and IE. |  [optional] |
|**postalCode** | **String** | Indicates the address of the consignee to allow for the nearest Pickup facility Search  It does not apply to non-postal countries. Example: IE and HK. |  [optional] |
|**countryCode** | **String** | The pickup country or territory code as defined by ISO-3166. Please check check separate pickup country or territory list to find out all the pickup eligible countries. |  |




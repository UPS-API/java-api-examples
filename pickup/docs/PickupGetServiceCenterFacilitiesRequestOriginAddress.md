

# PickupGetServiceCenterFacilitiesRequestOriginAddress

Indicates the address of the shipper to allow for the nearest Drop off facility Search.  Conditionally required for drop off location search.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**streetAddress** | **String** | Indicates the address of the shipper to allow for the nearest Drop off facility Search.  Conditionally required if proximitySearchIndicator is present. |  [optional] |
|**city** | **String** | Indicates the address of the shipper to allow for the nearest Drop off facility Search  Conditionally required if proximitySearchIndicator is present. |  [optional] |
|**stateProvince** | **String** | Indicates the address of the shipper to allow for the nearest Drop off facility Search.  Conditionally required if proximitySearchIndicator is present and if country or territory is US/CA/IE/HK. |  [optional] |
|**postalCode** | **String** | Indicates the address of the shipper to allow for the nearest Drop off facility Search  Conditionally required if proximitySearchIndicator is present and if country or territory has postal code.It does not apply to non-postal countries such as IE and HK. |  [optional] |
|**countryCode** | **String** | Indicates the address of the shipper to allow for the nearest Drop off facility Search |  |
|**originSearchCriteria** | [**OriginAddressOriginSearchCriteria**](OriginAddressOriginSearchCriteria.md) |  |  [optional] |






# PickupGetServiceCenterFacilitiesRequest

This request is to retrieve UPS Facility location information including location address, phone number, SLIC, and hours of operation for pick-up and drop-off requests

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**request** | [**PickupGetServiceCenterFacilitiesRequestRequest**](PickupGetServiceCenterFacilitiesRequestRequest.md) |  |  |
|**pickupPiece** | [**PickupGetServiceCenterFacilitiesRequestPickupPiece**](PickupGetServiceCenterFacilitiesRequestPickupPiece.md) |  |  |
|**originAddress** | [**PickupGetServiceCenterFacilitiesRequestOriginAddress**](PickupGetServiceCenterFacilitiesRequestOriginAddress.md) |  |  [optional] |
|**destinationAddress** | [**PickupGetServiceCenterFacilitiesRequestDestinationAddress**](PickupGetServiceCenterFacilitiesRequestDestinationAddress.md) |  |  [optional] |
|**locale** | **String** | Origin Country or Territory Locale.  Locale should be Origin Country. Example: en_US.  The Last 50 instruction will be send based on this locale. Locale is required if PoximityIndicator is present for Drop Off facilities. |  |
|**proximitySearchIndicator** | **String** | Proximity Indicator.  Indicates the� user requested the proximity search for UPS Worldwide Express Freight and UPS Worldwide Express Freight Midday locations for the origin address and/or the airport code, and the sort code for destination address. |  [optional] |






# PickupRateRequest

This request is used to rate an on-callpickup.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**request** | [**PickupRateRequestRequest**](PickupRateRequestRequest.md) |  |  |
|**shipperAccount** | [**PickupRateRequestShipperAccount**](PickupRateRequestShipperAccount.md) |  |  [optional] |
|**pickupAddress** | [**PickupRateRequestPickupAddress**](PickupRateRequestPickupAddress.md) |  |  |
|**alternateAddressIndicator** | **String** | Indicates if the pickup address is different than the address specified in the customer&#39;s profile.   Valid values: Y &#x3D; Alternate address N &#x3D; Original pickup address (default) |  |
|**serviceDateOption** | **String** | Indicates the pickup timeframe. 01 &#x3D; Same-Day Pickup 02 &#x3D; Future-Day Pickup 03 &#x3D; A Specific-Day Pickup  If 03 is selected, then PickupDate, EarliestReadyTime, and LatestClosetime must be specified. |  |
|**pickupDateInfo** | [**PickupRateRequestPickupDateInfo**](PickupRateRequestPickupDateInfo.md) |  |  [optional] |
|**taxInformationIndicator** | **String** | Indicates whether to return detailed taxes for on-callpickups. Valid values: Y &#x3D; Rate this pickup with taxes N &#x3D; Do not rate this pickup with taxes (default) |  [optional] |
|**userLevelDiscountIndicator** | **String** | Indicates whether to return user level promo discount for the on-callpickups.  Valid values: Y &#x3D; Rate this pickup with user level promo discount N &#x3D; Do not rate this pickup with user level promo discount(default) |  [optional] |






# IncludeCriteriaSearchFilter

Container to hold one or more search criteria for UPS Access Points that allow DCR, Shipping and ClickAndCollect access. Only applicable when the UPS access point candidate list is obtained in search by address or geocode search.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**dcRIndicator** | **String** | DCR/DCO Availability indicator for UPS Access Point. Either this indicator is present or not present. Presence indicates a search for access points with DCR. Any data in the element is ignored. |  [optional] |
|**shippingAvailabilityIndicator** | **String** | Shipping Availability indicator for UPS Access Point. Either this indicator is present or not present. Presence indicates a search of access points with shipping availability. Any data in it is ignored. |  [optional] |
|**shipperPreparationDelay** | **String** | Value for the number of days to check for shipping availability from� the current day. When this value is present, ShippingAvailabilityIndicator is implied implicitly. |  [optional] |
|**clickAndCollectSortWithDistance** | **String** | This contains the distance (in given UnitOfMeasurement) wherin to sort the click and collect access point locations above other� access point locations� when a UPS Access Point candidate list is obtained in search by address or geocode search. |  [optional] |




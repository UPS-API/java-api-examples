

# PickupCreationRequestFreightOptions

Container will be used to indicate Service options, add optional Original service center, destination address and shipment details related to the UPS Worldwide Express Freight and UPS Worldwide Express Freight Midday.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**shipmentServiceOptions** | [**FreightOptionsShipmentServiceOptions**](FreightOptionsShipmentServiceOptions.md) |  |  [optional] |
|**originServiceCenterCode** | **String** | Origin SLIC. This will be obtained from submitting a pickup service center request. See PickupGetFacilitiesServiceCenterRequest. |  [optional] |
|**originServiceCountryCode** | **String** | Country or territory of Service Center SLIC chosen to drop off. |  [optional] |
|**destinationAddress** | [**FreightOptionsDestinationAddress**](FreightOptionsDestinationAddress.md) |  |  [optional] |
|**shipmentDetail** | [**FreightOptionsShipmentDetail**](FreightOptionsShipmentDetail.md) |  |  |




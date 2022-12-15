

# ShipmentDeliveryTimeInformation

Container for requesting Time In Transit Information. Required to view time in transit information.  Required to view any time in transit information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**packageBillType** | **String** | Valid values are: 02 - Document only  03 - Non-Document 04 - WWEF Pallet 07 - Domestic Pallet If 04 is included, Worldwide Express Freight and UPS Worldwide Express Freight Midday services (if applicable) will be included in the response. |  |
|**pickup** | [**DeliveryTimeInformationPickup**](DeliveryTimeInformationPickup.md) |  |  [optional] |
|**returnContractServices** | [**DeliveryTimeInformationReturnContractServices**](DeliveryTimeInformationReturnContractServices.md) |  |  [optional] |




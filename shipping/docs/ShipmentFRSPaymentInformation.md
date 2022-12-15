

# ShipmentFRSPaymentInformation

Container to hold the Payment information for the Ground Freight Pricing Shipments.  Required for Ground Freight Pricing Shipments only.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** | Container to hold the Ground Freight Pricing payment type information.  It is required if the request has Ground Freight Pricing shipment indicator. |  |
|**accountNumber** | **String** | The UPS account number.  If the Ground Freight Pricing indicator and FreightShipmentInformation/DensityEligibleIndicator is present in the request, this account number must be validated to check if it is Ground Freight Pricing Density Based Rating enabled. |  |
|**address** | [**FRSPaymentInformationAddress**](FRSPaymentInformationAddress.md) |  |  [optional] |




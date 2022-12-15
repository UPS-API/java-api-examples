

# ShipmentResultsPackageResults

Returned Package Information.   Applicable only for ShipmentResponse and ShipAcceptResponse.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**trackingNumber** | **String** | Package 1Z number.   For Mail Innovations shipments, please use the USPSPICNumber when tracking packages (a non-1Z number Mail Manifest Id is returned).  Applicable only for ShipmentResponse and ShipAcceptResponse. |  |
|**rateModifier** | [**PackageResultsRateModifier**](PackageResultsRateModifier.md) |  |  [optional] |
|**baseServiceCharge** | [**PackageResultsBaseServiceCharge**](PackageResultsBaseServiceCharge.md) |  |  [optional] |
|**serviceOptionsCharges** | [**PackageResultsServiceOptionsCharges**](PackageResultsServiceOptionsCharges.md) |  |  [optional] |
|**shippingLabel** | [**PackageResultsShippingLabel**](PackageResultsShippingLabel.md) |  |  [optional] |
|**shippingReceipt** | [**PackageResultsShippingReceipt**](PackageResultsShippingReceipt.md) |  |  [optional] |
|**usPSPICNumber** | **String** | USPSPICNumber is USPS Package Identification; it should be used for tracking Mail Innovations shipments. |  [optional] |
|**cn22Number** | **String** | USPS defined CN22 ID number format varies based on destination country or territory.  Not applicable as of Jan 2015.  Mail Innovations shipments US to VI, PR, and GU are not considered international. |  [optional] |
|**accessorial** | [**PackageResultsAccessorial**](PackageResultsAccessorial.md) |  |  [optional] |
|**form** | [**PackageResultsForm**](PackageResultsForm.md) |  |  [optional] |
|**itemizedCharges** | [**List&lt;PackageResultsItemizedCharges&gt;**](PackageResultsItemizedCharges.md) |  |  [optional] |
|**negotiatedCharges** | [**PackageResultsNegotiatedCharges**](PackageResultsNegotiatedCharges.md) |  |  [optional] |




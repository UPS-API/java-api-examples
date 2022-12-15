

# PackagePackageServiceOptions

PackageServiceOptions container.  N/A

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**deliveryConfirmation** | [**PackageServiceOptionsDeliveryConfirmation**](PackageServiceOptionsDeliveryConfirmation.md) |  |  [optional] |
|**accessPointCOD** | [**PackageServiceOptionsAccessPointCOD**](PackageServiceOptionsAccessPointCOD.md) |  |  [optional] |
|**COD** | [**PackageServiceOptionsCOD**](PackageServiceOptionsCOD.md) |  |  [optional] |
|**declaredValue** | [**PackageServiceOptionsDeclaredValue**](PackageServiceOptionsDeclaredValue.md) |  |  [optional] |
|**shipperDeclaredValue** | [**PackageServiceOptionsShipperDeclaredValue**](PackageServiceOptionsShipperDeclaredValue.md) |  |  [optional] |
|**shipperReleaseIndicator** | **String** | The presence indicates that the package may be released by driver without a signature from the consignee.  Empty Tag. Only available for US50/PR to US50/PR packages without return service. |  [optional] |
|**proactiveIndicator** | **String** | Any value associated with this element will be ignored.   If present, the package is rated for UPS Proactive Response and proactive package tracking.  Contractual accessorial for health care companies to allow package monitoring throughout the UPS system.  Shippers account needs to have valid contract for UPS Proactive Response. |  [optional] |
|**refrigerationIndicator** | **String** | Presence/Absence Indicator. Any value is ignored. If present, indicates that the package contains an item that needs refrigeration.  Shippers account needs to have a valid contract for Refrigeration. |  [optional] |
|**upSPremiumCareIndicator** | **String** | An UPSPremiumCareIndicator indicates special handling is required for shipment having controlled substances.  Empty Tag means indicator is present.   Valid only for Canada to Canada movements.  Available for the following Return Services: Returns Exchange (available with a contract) Print Return Label Print and Mail Electronic Return Label Return Service Three Attempt  May be requested with following UPS services:  UPS Express� Early UPS Express UPS Express Saver UPS Standard.   Not available for packages with the following: Delivery Confirmation - Signature Required Delivery Confirmation - Adult Signature Required. |  [optional] |
|**hazMat** | [**PackageServiceOptionsHazMat**](PackageServiceOptionsHazMat.md) |  |  [optional] |
|**dryIce** | [**PackageServiceOptionsDryIce**](PackageServiceOptionsDryIce.md) |  |  [optional] |




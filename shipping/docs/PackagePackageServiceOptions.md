

# PackagePackageServiceOptions

Package Service Options container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**deliveryConfirmation** | [**PackageServiceOptionsDeliveryConfirmation**](PackageServiceOptionsDeliveryConfirmation.md) |  |  [optional] |
|**declaredValue** | [**PackageServiceOptionsDeclaredValue**](PackageServiceOptionsDeclaredValue.md) |  |  [optional] |
|**COD** | [**PackageServiceOptionsCOD**](PackageServiceOptionsCOD.md) |  |  [optional] |
|**accessPointCOD** | [**PackageServiceOptionsAccessPointCOD**](PackageServiceOptionsAccessPointCOD.md) |  |  [optional] |
|**shipperReleaseIndicator** | **String** | The presence indicates that the package may be released by driver without a signature from the consignee.  Empty Tag. Only available for US50/PR to US50/PR packages without return service. |  [optional] |
|**notification** | [**PackageServiceOptionsNotification**](PackageServiceOptionsNotification.md) |  |  [optional] |
|**hazMat** | [**PackageServiceOptionsHazMat**](PackageServiceOptionsHazMat.md) |  |  [optional] |
|**dryIce** | [**PackageServiceOptionsDryIce**](PackageServiceOptionsDryIce.md) |  |  [optional] |
|**upSPremiumCareIndicator** | **String** | An UPSPremiumCareIndicator indicates special handling is required for shipment having controlled substances.  Empty Tag means indicator is present.   The UPSPremiumCareIndicator cannot be requested for package with Delivery Confirmation - Adult Signature Required and Delivery Confirmation- Signature Required.   UPSPremiumCareIndicator is valid for following Return services:�  Returns Exchange (available with a contract) Print Return Label Print and Mail Electronic Return Label  Return Service Three Attempt  The UPSPremiumCareIndicator can be requested with following UPS services:  UPS Express� Early UPS Express UPS Express Saver  UPS Standard Valid only for Canada to Canada movements. |  [optional] |
|**proactiveIndicator** | **String** | Presence/Absence Indicator. Any value is ignored. If present, the package is rated for UPS Proactive Response and proactive package tracking. Contractual accessorial for health care companies to allow package monitoring throughout the UPS system.  Shippers account needs to have valid contract for UPS Proactive Reponse. |  [optional] |
|**packageIdentifier** | **String** | Identifies the package containing Dangerous Goods.  Required for Hazmat shipment if SubVersion is greater than or equal to 1701. |  [optional] |
|**clinicalTrialsID** | **String** | Unique identifier for clinical trials |  [optional] |
|**refrigerationIndicator** | **String** | Presence/Absence Indicator. Any value is ignored. If present, indicates that the package contains an item that needs refrigeration.  Shippers account needs to have a valid contract for Refrigeration. |  [optional] |




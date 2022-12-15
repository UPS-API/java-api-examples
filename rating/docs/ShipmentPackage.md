

# ShipmentPackage

Package Container.  Only one Package allowed for Simple Rate

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**packagingType** | [**PackagePackagingType**](PackagePackagingType.md) |  |  [optional] |
|**dimensions** | [**PackageDimensions**](PackageDimensions.md) |  |  [optional] |
|**dimWeight** | [**PackageDimWeight**](PackageDimWeight.md) |  |  [optional] |
|**packageWeight** | [**PackagePackageWeight**](PackagePackageWeight.md) |  |  [optional] |
|**commodity** | [**PackageCommodity**](PackageCommodity.md) |  |  [optional] |
|**largePackageIndicator** | **String** | This element does not require a value and if one is entered it will be ignored.  If present, it indicates the shipment will be categorized as a Large Package. |  [optional] |
|**packageServiceOptions** | [**PackagePackageServiceOptions**](PackagePackageServiceOptions.md) |  |  [optional] |
|**additionalHandlingIndicator** | **String** | A flag indicating if the packages require additional handling. True if AdditionalHandlingIndicator tag exists; false otherwise. Additional Handling indicator indicates it�s a non-corrugated package.  Empty Tag. |  [optional] |
|**upSPremier** | [**PackageUPSPremier**](PackageUPSPremier.md) |  |  [optional] |
|**oversizeIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored. It indicates if packge is oversized.  Applicable for UPS Worldwide Economy DDU service |  [optional] |
|**minimumBillableWeightIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored. It indicates if packge is qualified for minimum billable weight.  Applicable for UPS Worldwide Economy DDU service |  [optional] |




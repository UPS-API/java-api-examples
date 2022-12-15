

# ShipmentPackage

Package Information container.  For Return Shipments up to and including 20 packages are allowed.� US/PR origin return movements are limited to only one package. For Mail Innovations and Simple Rate shipments only one package is allowed.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Merchandise description of package.  Required for shipment with return service. |  [optional] |
|**palletDescription** | **String** | Description of articles &amp; special marks. Applicable for Air Freight only |  [optional] |
|**numOfPieces** | **String** | Number of Pieces. Applicable for Air Freight only |  [optional] |
|**unitPrice** | **String** | Unit price of the commodity. Applicable for Air Freight only  Limit to 2 digit after the decimal. The maximum length of the field is 12 including �.� and can hold up to 2 decimal place. (e.g. 999999999.99) |  [optional] |
|**packaging** | [**PackagePackaging**](PackagePackaging.md) |  |  |
|**dimensions** | [**PackageDimensions**](PackageDimensions.md) |  |  [optional] |
|**dimWeight** | [**PackageDimWeight**](PackageDimWeight.md) |  |  [optional] |
|**packageWeight** | [**PackagePackageWeight**](PackagePackageWeight.md) |  |  [optional] |
|**largePackageIndicator** | **String** | Presence of the indicator mentions that the package is Large Package.  This is an empty tag, any value inside is ignored. |  [optional] |
|**referenceNumber** | [**PackageReferenceNumber**](PackageReferenceNumber.md) |  |  [optional] |
|**additionalHandlingIndicator** | **String** | Additional Handling Required. The presence indicates additional handling is required, the absence indicates no additional handling is required. Additional Handling indicator indicates it�s a non-corrugated package. |  [optional] |
|**upSPremier** | [**PackageUPSPremier**](PackageUPSPremier.md) |  |  [optional] |
|**packageServiceOptions** | [**PackagePackageServiceOptions**](PackagePackageServiceOptions.md) |  |  [optional] |
|**commodity** | [**PackageCommodity**](PackageCommodity.md) |  |  [optional] |
|**hazMatPackageInformation** | [**PackageHazMatPackageInformation**](PackageHazMatPackageInformation.md) |  |  [optional] |




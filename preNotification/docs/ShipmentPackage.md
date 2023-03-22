

# ShipmentPackage

Package Information container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**trackingNumber** | **String** | The packages tracking number. |  |
|**packageWeight** | [**PackagePackageWeight**](PackagePackageWeight.md) |  |  |
|**transportationMode** | **String** | Declares that a package was prepared according to ground, passenger aircraft, or cargo aircraft only. Only required when the CommodityRegulatedLevelCode is FR or LQ.  Valid entries include: GND, CAO, PAX. |  [optional] |
|**voidIndicator** | **String** | Indicator to specify that a Dangerous Goods package is voided. True if VoidIndicator tag exists; false otherwise. |  [optional] |
|**packagePoints** | **String** | Regulated Commodity Transport Package Score Quantity |  [optional] |
|**chemicalRecord** | [**PackageChemicalRecord**](PackageChemicalRecord.md) |  |  |




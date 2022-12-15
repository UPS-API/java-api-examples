

# PackageServiceOptionsHazMat

Container to hold HazMat information.  Applies only if SubVersion is greater than or equal to 1701.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**packageIdentifier** | **String** | Identifies the package containing Dangerous Goods.  Required if SubVersion is greater than or equal to 1701. |  [optional] |
|**qvalue** | **String** | QValue is required when a HazMat shipment specifies AllPackedInOneIndicator and the regulation set for that shipment is IATA.   Applies only if SubVersion is greater than or equal to 1701. Valid values are : 0.1; 0.2; 0.3; 0.4; 0.5; 0.6; 0.7; 0.8; 0.9; 1.0 |  [optional] |
|**overPackedIndicator** | **String** | Presence/Absence Indicator. Any value is ignored. Presence indicates that shipment is overpack.  Applies only if SubVersion is greater than or equal to 1701. |  [optional] |
|**allPackedInOneIndicator** | **String** | Presence/Absence Indicator. Any value is ignored. Indicates the hazmat shipment/package is all packed in one.  Applies only if SubVersion is greater than or equal to 1701. |  [optional] |
|**hazMatChemicalRecord** | [**HazMatHazMatChemicalRecord**](HazMatHazMatChemicalRecord.md) |  |  |




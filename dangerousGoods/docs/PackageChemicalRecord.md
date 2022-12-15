

# PackageChemicalRecord

Container to hold Chemical Record information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chemicalRecordIdentifier** | **String** | Identifies the Chemcial Record. |  |
|**reportableQuantity** | **String** | Required if CommodityRegulatedLevelCode &#x3D; LQ or FR and if the field applies to the material by regulation. If reportable quantity is met, RQ should be entered. |  [optional] |
|**classDivisionNumber** | **String** | This is the hazard class associated to the specified commodity.   Required if CommodityRegulatedLevelCode is �LQ� or �FR� |  [optional] |
|**subRiskClass** | **String** | Required if CommodityRegulatedLevelCode &#x3D; LQ or FR and if the field applies to the material by regulation.   Secondary hazardous characteristics of a package. (There can be more than one � separate each with a comma). |  [optional] |
|**idNumber** | **String** | This is the ID number (UN/NA/ID) for the specified commodity.   Required if CommodityRegulatedLevelCode &#x3D; LR, LQ or FR and if the field applies to the material by regulation.   UN/NA/ID Identification Number assigned to the specified regulated good. (Include the UN/NA/ID as part of the entry). |  [optional] |
|**packagingGroupType** | **String** | This is the packing group category associated to the specified commodity.  Required if CommodityRegulatedLevelCode &#x3D; LQ or FR and if the field applies to the material by regulation. Must be shown in Roman Numerals.  Valid values are:  I II III  blank |  [optional] |
|**quantity** | **String** | Required if CommodityRegulatedLevelCode &#x3D; LQ or FR. The numerical value of the mass capacity of the regulated good. |  [optional] |
|**UOM** | **String** | Required if CommodityRegulatedLevelCode &#x3D; LQ or FR. The unit of measure used for the mass capacity of the regulated good.    Example: ml, L, g, mg, kg, cylinder, pound, pint, quart, gallon, ounce etc. |  [optional] |
|**packagingInstructionCode** | **String** | The packing instructions related to the chemical record. Required if CommodityRegulatedLevelCode &#x3D; LQ or FR and if the field applies to the material by regulation. |  [optional] |
|**properShippingName** | **String** | The Proper Shipping Name assigned by ADR, CFR or IATA.   Required if CommodityRegulatedLevelCode &#x3D; LR, LQ or FR. |  [optional] |
|**technicalName** | **String** | The technical name (when required) for the specified commodity.   Required if CommodityRegulatedLevelCode &#x3D; LQ or FR and if the field applies to the material by regulation. |  [optional] |
|**additionalDescription** | **String** | Additional remarks or special provision information. Required if CommodityRegulatedLevelCode &#x3D; LQ or FR and if the field applies to the material by regulation.   Additional information that may be required by regulation about a hazardous material, such as, �Limited Quantity�, DOT-SP numbers, EX numbers. |  [optional] |
|**packagingType** | **String** | The package type code identifying the type of packaging used for the commodity. (Ex: Fiberboard Box).  Required if CommodityRegulatedLevelCode &#x3D; LQ or FR. |  [optional] |
|**hazardLabelRequired** | **String** | Defines the type of label that is required on the package for the commodity.   Not applicable if CommodityRegulatedLevelCode &#x3D; LR or EQ. |  [optional] |
|**packagingTypeQuantity** | **String** | The number of pieces of the specific commodity.   Required if CommodityRegulatedLevelCode &#x3D; LQ or FR.  Valid values: 1 to 999 |  [optional] |
|**commodityRegulatedLevelCode** | **String** | Indicates the type of commodity.  Valid values: LR, FR, LQ, EQ  FR &#x3D; Fully Regulated LQ &#x3D; Limited Quantity EQ &#x3D; Excepted Quantity LR &#x3D; Lightly Regulated |  |
|**transportCategory** | **String** | Transport Category.  Valid values: 0 to 4 |  [optional] |
|**tunnelRestrictionCode** | **String** | Defines what is restricted to pass through a tunnel. |  [optional] |
|**allPackedInOneIndicator** | **String** | Indicates the hazmat shipment/package is all packed in one. |  [optional] |




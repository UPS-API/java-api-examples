

# PackageChemicalRecord

Dangerous Goods Accessorial Commodity Container

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**reportableQuantity** | **String** | Indicates whether or not a material being transported meets the definition of a hazardous material and meets or exceeds a reportable quantity threshold. If reportable quantity is met, �RQ� should be entered.  Any other value will be  interpreted as �Non Reportable� quantity. |  [optional] |
|**classDivisionNumber** | **String** | This is the hazard class associated to the specified commodity. Required if CommodityRegulatedLevelCode is �LQ� or �FR� |  [optional] |
|**subRiskClass** | **String** | Secondary hazardous characteristics of a package. (There can be more than one � separate each with a comma.) |  [optional] |
|**idNumber** | **String** | This is the ID number (UN/NA/ID) for the specified commodity.  UN/NA/ID Identification Number assigned to the specified regulated good. (Include the UN/NA/ID as part of the entry). |  [optional] |
|**packagingGroupType** | **String** | This is the packing group category associated to the specified commodity.  Must be shown in Roman Numerals.  Valid values are: I, II, III and blank. |  [optional] |
|**quantity** | **String** | Required if CommodityRegulatedLevelCode &#x3D; LQ or FR. The numerical value of the mass capacity of the regulated good. |  [optional] |
|**UOM** | **String** | Required if CommodityRegulatedLevelCode &#x3D; LQ or FR. The unit of measure used for the mass capacity of the regulated good. |  [optional] |
|**packagingInstructionCode** | **String** | The packing instructions related to the chemical record. |  [optional] |
|**emergencyPhone** | **String** | 24 Hour Emergency Phone Number of the shipper.   Valid values for this field are (0) through (9) with trailing blanks.   For numbers within the U.S., the layout is 1, area code, 7-digit number. For all other countries the layout is country code, area code, number.                                                                                                                                                                                                                                                                       The following are restricted in the phone number   period �.�, dash �-�, plus sign �+� and conventional parentheses �(� and �)�, �EXT\&quot; or \&quot;OPT�  The following are restricted in the phone number   period �.�, dash �-�, plus sign �+� and conventional parentheses �(� and �)�, �EXT\&quot; or \&quot;OPT� |  [optional] |
|**emergencyContact** | **String** | The emergency information, contact name and/or contract number, required to be communicated when a call is placed to the EmergencyPhoneNumber. |  [optional] |
|**properShippingName** | **String** | The Proper Shipping Name assigned by ADR, CFR or IATA. Required if CommodityRegulatedLevelCode &#x3D; LQ or FR. |  [optional] |
|**technicalName** | **String** | The technical name (when required) for the specified commodity. |  [optional] |
|**additionalDescription** | **String** | Additional remarks or special provision information. |  [optional] |
|**packagingType** | **String** | The type of package used to contain the regulated good. (Ex: Fiberboard Box). |  [optional] |
|**hazardLabelRequired** | **String** | Defines the type of label that is required on the package for the commodity. |  [optional] |
|**packagingTypeQuantity** | **String** | The number of pieces of the specific commodity. Required if CommodityRegulatedLevelCode &#x3D; LQ or FR.  Valid values are 1 to 999. |  [optional] |
|**commodityRegulatedLevelCode** | **String** | Indicates the type of commodity, Fully Regulated (FR), Limited Quantity (LQ), Lightly Regulated (LR)  Valid values are LR, FR and LQ. |  |
|**transportCategory** | **String** | Transport Category.   Valid values are 0 to 4. |  [optional] |
|**tunnelRestrictionCode** | **String** | Defines what is restricted to pass through a tunnel. |  [optional] |
|**qvalue** | **String** | When a HazMat shipment specifies AllPackedInOneIndicator and the regulation set for that shipment is IATA,  Q-Value specifies exactly one of the following values: 0.1; 0.2; 0.3; 0.4; 0.5; 0.6; 0.7; 0.8; 0.9; 1.0  Valid values are : 0.1; 0.2; 0.3; 0.4; 0.5; 0.6; 0.7; 0.8; 0.9; 1.0 |  [optional] |
|**overPackedIndicator** | **String** | Presence/Absence Indicator. Any value is ignored. Presence indicates that shipment is overpack. |  [optional] |
|**allPackedInOneIndicator** | **String** | Presence/Absence Indicator. Any value is ignored. Presence indicates if multiple, different hazmat/chemicals are contained within one box in a package |  [optional] |




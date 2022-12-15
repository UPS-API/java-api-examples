

# PackageServiceOptionsHazMat

Container to hold HazMat Chemical Records.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**packagingTypeQuantity** | **String** | The number of pieces of the specific commodity. Required if CommodityRegulatedLevelCode &#x3D; LQ or FR.  Valid values are 1 to 999. |  [optional] |
|**recordIdentifier1** | **String** | Reserved for future use. |  [optional] |
|**recordIdentifier2** | **String** | Reserved for future use. |  [optional] |
|**recordIdentifier3** | **String** | Reserved for future use. |  [optional] |
|**subRiskClass** | **String** | Recommended if CommodityRegulatedLevelCode &#x3D; LQ or FR and if the field applies to the material by regulation.   Secondary hazardous characteristics of a package. (There can be more than one � separate each with a comma). |  [optional] |
|**aDRItemNumber** | **String** | The type of regulated good for an ADR package where ADR is for Europe to Europe ground movement. |  [optional] |
|**aDRPackingGroupLetter** | **String** | Required if the field applies to the material by regulation. Field input is Arabic numerals, output is Roman numerals. Will be shown in Roman Numerals.  Valid values:  �1� &#x3D; �I�,  �2� &#x3D; �II�,  �3� &#x3D; �III�,  and blank. |  [optional] |
|**technicalName** | **String** | The technical name (when required) for the specified commodity. Recommended if CommodityRegulatedLevelCode &#x3D; LQ or FR and if the field applies to the material by regulation. |  [optional] |
|**hazardLabelRequired** | **String** | Defines the type of label that is required on the package for the commodity.   Not applicable if CommodityRegulatedLevelCode &#x3D; LR or EQ. |  [optional] |
|**classDivisionNumber** | **String** | This is the hazard class associated to the specified commodity.   Required if CommodityRegulatedLevelCode is &#39;EQ&#39;, �LQ� or �FR� |  [optional] |
|**referenceNumber** | **String** | Optional reference number. It will be displayed only on label. |  [optional] |
|**quantity** | **String** | Required if CommodityRegulatedLevelCode &#x3D; EQ, LQ or FR. The numerical value of the mass capacity of the regulated good.  Should be more than 0.0. Valid characters are 0-9 and \&quot;.\&quot; (Decimal point). Limit to 1 digit after the decimal. The maximum length of the field is 5 including \&quot;.\&quot; (Decimal point) and can hold up to 1 decimal place. |  [optional] |
|**UOM** | **String** | Required if CommodityRegulatedLevelCode &#x3D; LQ, EQ or FR. The unit of measure used for the mass capacity of the regulated good.   For Example: ml, L, g, mg, kg, cylinder, pound, pint, quart, gallon, ounce etc. |  [optional] |
|**packagingType** | **String** | The type of package used to contain the regulated good. (Ex: Fiberboard Box). Required if CommodityRegulatedLevelCode &#x3D; LQ or FR.   Ex. FIBERBOARD BOX, WOOD(EN) BOX, PLASTIC JERRICAN, METAL BOX, STEEL DRUM, OTHER, PLASTIC BOX, PLASTIC DRUM, STYROFOAM BOX, CYLINDERS, ENVIROTAINER, PLYWOOD BOX, ALUMINUM DRUM, ALUMINUM CYLINDERS, PLASTIC PAIL, PLYWOOD DRUM, FIBER DRUM, STEEL JERRICAN, ALUMINUM JERRICAN, STEEL BOX, CARTON, ALUMINUM BOX |  [optional] |
|**idNumber** | **String** | This is the ID number (UN/NA/ID) for the specified commodity.  Required if CommodityRegulatedLevelCode &#x3D; LR, LQ or FR and if the field applies to the material by regulation.  UN/NA/ID Identification Number assigned to the specified regulated good. (Include the UN/NA/ID as part of the entry). |  [optional] |
|**properShippingName** | **String** | The Proper Shipping Name assigned by ADR, CFR or IATA. Required if CommodityRegulatedLevelCode &#x3D; LR, LQ or FR. |  |
|**additionalDescription** | **String** | Additional remarks or special provision information. Recommended if CommodityRegulatedLevelCode &#x3D; LQ or FR and if the field applies to the material by regulation.  Additional information that may be required by regulation about a hazardous material, such as, �Limited Quantity�, DOT-SP numbers, EX numbers. |  [optional] |
|**packagingGroupType** | **String** | This is the packing group category associated to the specified commodity. Recommended if CommodityRegulatedLevelCode &#x3D; LQ or FR and if the field applies to the material by regulation. Must be shown in Roman Numerals.   Valid values: I II III blank |  [optional] |
|**packagingInstructionCode** | **String** | The packing instructions related to the chemical record. Required if CommodityRegulatedLevelCode &#x3D; LQ or FR and if the field applies to the material by regulation. |  [optional] |
|**emergencyPhone** | **String** | 24 Hour Emergency Phone Number of the shipper. Valid values for this field are (0) through (9) with trailing blanks. For numbers within the U.S., the layout is 1, area code, 7-digit number. For all other countries or territories the layout is country or territory code, area code, number.                        The following are restricted in the phone number   period �.�, dash �-�, plus sign �+� and conventional parentheses �(� and �)�, �EXT\&quot; or \&quot;OPT� |  [optional] |
|**emergencyContact** | **String** | The emergency information, contact name and/or contract number, required to be communicated when a call is placed to the EmergencyPhoneNumber. The information is required if there is a value in the EmergencyPhoneNumber field above and the shipment is with a US50 or PR origin and/or destination and the RegulationSet is IATA. |  [optional] |
|**reportableQuantity** | **String** | Recommended if CommodityRegulatedLevelCode &#x3D; LQ or FR and if the field applies to the material by regulation. If reportable quantity is met, &#39;RQ&#39; should be entered. |  [optional] |
|**regulationSet** | **String** | The Regulatory set associated with every regulated shipment. It must be same across the shipment.  Valid values:  ADR &#x3D; Europe to Europe Ground Movement  CFR &#x3D; HazMat regulated by US Dept. of Transportation within the U.S. or ground shipments to Canada  IATA&#x3D; Worldwide Air movement  TDG&#x3D; Canada to Canada ground movement or Canada to U.S. standard movement.  Valid values are ADR, CFR, IATA and TDG. For multiple Chemical Records per package or multiple packages containing different RegulationSet, RegulationSet of first Chemical Record would be considered for validating and rating the entire shipment. |  |
|**transportationMode** | **String** | Not applicable for ADR regulation set. Required for any other regulation set. Declares that a package was prepared according to ground passenger aircraft or cargo aircraft only.  Valid values:  Highway&#x3D;Highway  Ground&#x3D;Ground  PAX&#x3D;Passenger Aircraft  Passenger Aircraft&#x3D;Passenger Aircraft  CAO&#x3D;Cargo Aircraft Only  Cargo Aircraft Only&#x3D;Cargo Aircraft Only  Valid entries include: Highway, Ground, PAX, Passenger Aircraft, CAO and Cargo Aircraft Only. |  |
|**commodityRegulatedLevelCode** | **String** | Indicates the type of commodity - Fully Regulated (FR), Limited Quantity (LQ), Excepted Quantity (EQ) or Lightly Regulated (LR).  Valid values are LR, FR, LQ and EQ. Required for subversion 1701 or greater. LR and EQ are validated if subversion is 1701 or greater. FR, LQ will be validated if subversion is 1807 or greater |  [optional] |
|**transportCategory** | **String** | Transport Category.  Valid values are 0 to 4. |  [optional] |
|**tunnelRestrictionCode** | **String** | Defines what is restricted to pass through a tunnel. |  [optional] |
|**chemicalRecordIdentifier** | **String** | Identifies the Chemical Record.  Required if SubVersion is greater than or equal to 1701. |  [optional] |
|**localTechnicalName** | **String** | Technical name in local language. |  [optional] |
|**localProperShippingName** | **String** | Proper shipping name in local langauge. |  [optional] |




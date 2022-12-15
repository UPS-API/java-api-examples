

# ChemicalDataChemicalDetail

Container to hold Chemical details.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**regulationSet** | **String** | The Regulatory set associated with every regulated shipment.   Possible values are ADR, 49CFR, IATA. It will be returned if applies for a given chemical record.  ADR &#x3D; Europe to Europe Ground Movement 49CFR &#x3D; HazMat regulated by US Dept. of Transportation within the U.S. or ground shipments to Canada,   IATA&#x3D; Worldwide Air movement. |  [optional] |
|**idNumber** | **String** | This is the ID number (UN/NA/ID) for the specified commodity. UN/NA/ID Identification Number assigned to the specified regulated good. (Include the UN/NA/ID as part of the entry).  It will be returned if applies for a given chemical record. |  [optional] |
|**hazardousMaterialsDescription** | **String** | Free form text containing the full name that are used to describe a regulated chemical record.  It will be returned if applies for a given chemical record. |  [optional] |
|**classDivisionNumber** | **String** | This is the hazard class associated to the specified commodity.  It will be returned if applies for a given chemical record. |  [optional] |
|**subRiskClass** | **String** | Secondary hazardous characteristics of a package. (There can be more than one � separate each with a comma).  It will be returned if applies for a given chemical record. |  [optional] |
|**packagingGroupType** | **String** | This is the packing group category associated to the specified commodity. This code represents the potential degree of danger represented by a regulated commodity being transported.  It will be returned if applies for a given chemical record. |  [optional] |
|**specialPermit** | **String** | Indicates whether or not related entity requires special permit in order to transport the chemical.   It will be returned if applies for a given chemical record.  Valid values:  AIR GND BOTH |  [optional] |
|**technicalNameRequiredIndicator** | **String** | Indicates whether TechnicalName is required or not.  It will be returned if applies for a given chemical record.  Y &#x3D; TechnicalName is required. N &#x3D; TechnicalName is not required. |  [optional] |
|**additionalShippingInformationRequiredIndicator** | **String** | Indicates whether or not additional text is required for the shipping papers for the related entity.   It will be returned if applies for a given chemical record.  Valid values:  N &#x3D; No, additional information for the shipping papers are not required. Y &#x3D; Yes, additional information for the shipping papers are required. |  [optional] |
|**tunnelRestrictionCode** | **String** | Defines what is restricted to pass through a tunnel.  EXAMPLES OF VALUES: (B),(D),(E),(B/D),(B/E),(C,D),(C/E),(D/E),Blank |  [optional] |
|**transportCategory** | **String** | Code representing a category of transportation, assigned by a regulation set for each regulated commodity.� Each value of this category is associated with a multiplier that is used to calculate a value.�This value is then used to determine the placarding to be place on the vehicle or container that holds the related regulated commodity  EXAMPLES OF VALUES: 0 &#x3D; No multiplier - must use placarding 1 &#x3D; Use a multiplier of 50 2 &#x3D; Use a multiplier of 3 3 &#x3D; Use a multiplier of 1 4 &#x3D; Use a multiplier of 0 - do not apply a placard |  [optional] |
|**transportMultiplierQuantity** | **String** | The quantity that represents a multiplication factor used to calculate a value to determine� the placarding to be place on the vehicle or container that holds the related regulated commodity.� This factor is associated with a code value represented by Regulated Commodity Transport Category Code.�   EXAMPLES OF VALUES: 0 &#x3D; No multiplier - must use placarding 1 &#x3D; Use a multiplier of 50 2 &#x3D; Use a multiplier of 3 3 &#x3D; Use a multiplier of 1 4 &#x3D; Use a multiplier of 0 - do not apply a placard |  [optional] |
|**channelTunnelAcceptedIndicator** | **String** | ChannelTunnelAcceptedIndicator indicates if the chemical is accepted through channel tunnel or not  Y&#x3D; Accepted through channel tunnel N&#x3D;Not accepted through channel tunnel |  [optional] |
|**chemicalType** | **String** | A set of chemical records in HMMS that correspond to a sub-set of chemicals for a regulation set, or the entire set of chemicals for a regulation set  EXAMPLES OF VALUES: FREIGHT TDG IATA US DOMESTIC AIR 49CFR ADR IATA INTERNATIONAL AIR |  [optional] |
|**caToUSShipmentAllowedIndicator** | **String** | CAToUSShipmentAllowedIndicator indicates whether this checmical is allowed from CA to US Applicable only for TDG shipments  Y &#x3D; Permitted from CA to US N &#x3D; Not Permitted from CA to US |  [optional] |




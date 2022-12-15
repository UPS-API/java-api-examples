

# PackageServiceOptionsDryIce

Container for Dry Ice.  Maximum 1 Dry Ice is allowed. Lane check will happen based on postal code/ city.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**regulationSet** | **String** | Regulation set for dryIce Shipment. Valid values: CFR &#x3D; HazMat regulated by US Dept. of Transportation within the U.S. or ground shipments to Canada, IATA&#x3D; Worldwide Air movement.  The following values are valid: IATA, CFR. |  |
|**dryIceWeight** | [**DryIceDryIceWeight**](DryIceDryIceWeight.md) |  |  |
|**medicalUseIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored. Relevant only in CFR regulation set. If present it is used to designate the dry Ice is for any medical use and rates are adjusted for DryIce weight more than 2.5 Kgs or 5.7 Lbs. |  [optional] |




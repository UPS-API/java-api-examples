

# ChemicalReferenceDataRequest

Contains Chemical Reference Data request criteria components.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**idNumber** | **String** | This is the ID number (UN/NA/ID) for the specified commodity. UN/NA/ID Identification Number assigned to the specified regulated good. (Include the UN/NA/ID as part of the entry).  At least one of the information - IDNumber or ProperShippingName should be provided to retrieve Chemical Reference Data. |  [optional] |
|**properShippingName** | **String** | The Proper Shipping Name assigned by ADR, CFR or IATA.   At least one of the information - IDNumber or ProperShippingName should be provided to retrieve Chemical Reference Data. |  [optional] |
|**shipperNumber** | **String** | Shipper�s six digit account number.  Your UPS Account Number must have correct Dangerous goods contract to successfully use this Webservice. |  |




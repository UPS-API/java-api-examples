

# ChemicalDataPackageQuantityLimitDetail

Container to hold Package Quantity Limit Detail information.  It will be returned if applies for a given chemical record.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**packageQuantityLimitTypeCode** | **String** | The type of package quantity limit.   It will be returned if applies for a given chemical record.  Valid values: CAO - Cargo Aircraft Only LTD QTY - Limited Quantity GND - Ground PAX - Passenger Aircraft COMAT CAO - Company Material CAO COMAT LTD - Company Material LTD COMAT PAX - Company Material PAX |  [optional] |
|**quantity** | **String** | The numerical value of the mass capacity of the regulated good.  It will be returned if applies for a given chemical record. |  [optional] |
|**UOM** | **String** | The unit of measure used for the mass capacity of the regulated good.   It will be returned if applies for a given chemical record. Example: ml, L, g, mg, kg, cylinder, pound, pint, quart, gallon, ounce etc. |  [optional] |
|**packagingInstructionCode** | **String** | The packing instructions related to the chemical record.  It will be returned if applies for a given chemical record. |  [optional] |




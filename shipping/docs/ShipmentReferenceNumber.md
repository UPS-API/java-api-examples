

# ShipmentReferenceNumber

Reference Number information container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**barCodeIndicator** | **String** | If the indicator is present then the reference numbers value will be bar coded on the label.  This is an empty tag, any value inside is ignored.   Only one shipment-level or package-level reference number can be bar coded per shipment.   In order to barcode a reference number, its value must be no longer than 14 alphanumeric characters or 24 numeric characters and cannot contain spaces. |  [optional] |
|**code** | **String** | Reference number type code, for the entire shipment. The code specifies the Reference name.   Refer to the Reference Number Code table.  Valid if the origin/destination pair is US/US or PR/PR and character should be alpha-numeric. |  [optional] |
|**value** | **String** | Customer supplied reference number.  Valid if the origin/destination pair is US/US or PR/PR. |  |






# PackageReferenceNumber

Package reference number information container.  For Mail Innovation shipments, up to 3 reference numbers are supported. If 5 reference numbers are specified (CostCenter, PackageID, and 3 ReferenceNumbers) the 3 desigated by the ReferenceNumber container will not be visible on 4x6 label supported by the API. These additional reference numbers are only be visible on the 4x8 label..  For non-Mail Innovation shipments only the first 2 reference numbers will be visible on labels.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**barCodeIndicator** | **String** | If the indicator is present then the reference numbers value will be bar coded on the label.  This is an empty tag, any value inside is ignored.   Only one shipment-level or package-level reference number can be bar coded per shipment.   In order to barcode a reference number, its value must be no longer than 14 alphanumeric characters or 24 numeric characters and cannot contain spaces. |  [optional] |
|**code** | **String** | Reference number type code, for the entire shipment. The code specifies the Reference name.   Refer to the Reference Number Code table.  Valid if the origin/destination pair is US/US or PR/PR and character should be alpha-numeric. |  [optional] |
|**value** | **String** | Customer supplied reference number.  Valid if the origin/destination pair is US/US or PR/PR. |  |




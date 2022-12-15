

# ShipmentDGSignatoryInfo

DGSignatoryInfo Container  DGPaperImage will be returned if DGSignatoryInfo container present

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the person signing the declaration.   Note: The name of person or department he/she is employed with, are both acceptable. |  [optional] |
|**title** | **String** | Title of the person signing the declaration. Note: The title of the person or department he/she is employed with, are both acceptable. |  [optional] |
|**place** | **String** | The city of the Signatory. |  [optional] |
|**date** | **String** | Date of signing the declaration form.  Valid format is YYYYMMDD. |  [optional] |
|**shipperDeclaration** | **String** | Valid values: 01 &#x3D; Shipment level 02 &#x3D; Package level                                              Valid only for the Shipper Declaration paper. If missing or invalid DGPaperImage will be returned at package level. |  [optional] |
|**uploadOnlyIndicator** | **String** | Dangerous Goods Paper Upload Only Indicator. DG Paper will not be returned in response if UploadOnlyIndicator present. |  [optional] |




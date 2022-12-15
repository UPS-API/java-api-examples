

# LabelSpecificationLabelImageFormat

LabelImageFormat Container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | Label print method code determines the format in which Labels are to be generated. For EPL2 formatted Labels use EPL, for SPL formatted Labels use SPL, for ZPL formatted Labels use ZPL and for image formats use GIF.  For shipments without return service the valid value is GIF, ZPL, EPL and SPL. For shipments with PRL return service, the valid values are EPL, ZPL, SPL and GIF. For UPS Premier Silver shipment only ZPL is supported. |  |
|**description** | **String** | Description of the label image format code. |  [optional] |




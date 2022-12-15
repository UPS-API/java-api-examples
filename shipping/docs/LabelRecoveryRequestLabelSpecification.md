

# LabelRecoveryRequestLabelSpecification

Container that is used to define the properties required by the user to print and/ or display the UPS shipping label.  Required for the shipment without return service, or shipment with PRL return service.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**htTPUserAgent** | **String** | Browser HTTPUserAgent String. This is the preferred way of identifying GIF image type to be generated.  Required if &lt;Root node&gt;/ LabelSpecification/LabelImageFormat/Code &#x3D; Gif. Default to Mozilla/4.5 if this field is missing or has invalid value. |  [optional] |
|**labelImageFormat** | [**LabelSpecificationLabelImageFormat**](LabelSpecificationLabelImageFormat.md) |  |  [optional] |
|**labelStockSize** | [**LabelSpecificationLabelStockSize**](LabelSpecificationLabelStockSize.md) |  |  [optional] |




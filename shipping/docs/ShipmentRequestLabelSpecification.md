

# ShipmentRequestLabelSpecification

Container used to define the properties required by the user to print and/or display the UPS shipping label.  Required for shipment without return service or shipments with PRL return service. Required for Electronic Return Label or Electronic Import Control Label shipments with SubVersion greater than or equal to 1707.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**labelImageFormat** | [**LabelSpecificationLabelImageFormat**](LabelSpecificationLabelImageFormat.md) |  |  |
|**htTPUserAgent** | **String** | Browser HTTPUserAgent String. This is the preferred way of identifying GIF image type to be generated.  Required if /ShipmentRequest/LabelSpecificationLabelSpecification/LabelImageFormat/Code &#x3D; Gif. Default to Mozilla/4.5 if this field is missing or has invalid value. |  [optional] |
|**labelStockSize** | [**LabelSpecificationLabelStockSize**](LabelSpecificationLabelStockSize.md) |  |  |
|**instruction** | [**LabelSpecificationInstruction**](LabelSpecificationInstruction.md) |  |  [optional] |
|**characterSet** | **String** | Language character set expected on label. Valid values: dan &#x3D; Danish (Latin-1) nld &#x3D; Dutch (Latin-1) fin &#x3D; Finnish (Latin-1) fra &#x3D; French (Latin-1) deu &#x3D; German (Latin-1) itl &#x3D; Italian (Latin-1) nor &#x3D; Norwegian (Latin-1) pol  &#x3D; Polish (Latin-2) por &#x3D; Poruguese (Latin-1) spa &#x3D; Spanish (Latin-1)  swe &#x3D; Swedish (Latin-1)  ces &#x3D; Czech (Latin-2) hun &#x3D; Hungarian (Latin-2) slk &#x3D; Slovak (Latin-2) rus &#x3D; Russian (Cyrillic) tur &#x3D; Turkish (Latin-5) ron &#x3D; Romanian (Latin-2) bul &#x3D; Bulgarian (Latin-2) est &#x3D; Estonian (Latin-2) ell &#x3D; Greek (Latin-2) lav &#x3D; Latvian (Latin-2) lit &#x3D; Lithuanian (Latin-2) eng &#x3D; English (Latin-1)  Default is English (Latin-1). |  [optional] |




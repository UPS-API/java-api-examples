

# PackageResultsShippingLabel

The container for UPS shipping label. Returned for following shipments - Forward shipments, Shipments with PRL returns service,  Electronic Return Label or Electronic Import Control Label shipments with SubVersion greater than or equal to 1707. Shipping label wont be returned if BarCodeImageIndicator is present. Applicable only for ShipmentResponse and ShipAcceptResponse.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**imageFormat** | [**ShippingLabelImageFormat**](ShippingLabelImageFormat.md) |  |  |
|**graphicImage** | **String** | Base 64 encoded graphic image.   Applicable only for ShipmentResponse and ShipAcceptResponse. |  |
|**graphicImagePart** | **String** | Base 64 encoded graphic image.  Applicable only for ShipmentResponse and ShipAcceptResponse for Mail Innovations CN22 Combination Forward Label with more than 3 commodities. |  |
|**internationalSignatureGraphicImage** | **String** | Base 64 encoded graphic image of the Warsaw text and signature box. EPL2, ZPL and SPL labels. The image will be returned for non-US based shipments. One image will be given per shipment and it will be in the first PackageResults container.   Applicable only for ShipmentResponse and ShipAcceptResponse. |  [optional] |
|**htMLImage** | **String** | Base 64 encoded html browser image rendering software. This is only returned for gif and png image formats.   Applicable only for ShipmentResponse and ShipAcceptResponse. |  [optional] |
|**PDF417** | **String** | PDF-417 is a two-dimensional barcode, which can store up to about 1,800 printable ASCII characters or 1,100 binary characters per symbol. The symbol is rectangular. The image is Base 64 encoded and returned if the LabelImageFormat code is GIF.� Shipment with PRL return service only.�   Applicable only for ShipmentResponse and ShipAcceptResponse. |  [optional] |




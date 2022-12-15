

# LabelResultsMailInnovationsLabelImage

Container to hold Mail Innovations shipments label. The elements needed to render a label on a printer or in a browser. Specifies the format in which GraphicImage is represented. If LabelImageFormat is GIF, LabelImage contains GraphicImage and HTMLImage. Otherwise, it contains only GraphicImage.   Applicable for Single Mail Innovations Returns and Dual Mail Innovations Returns shipment. Returned only if MailInnovationsTrackingNumber is provided in request. If LabelImageFormat requested was PDF and TrackingNumber was present along with MailInnovationsTrackingNumber in the request, only LabelImage container is returned. MailInnovationsLabelImage will not be returned. In that case, the labels for Small Package Tracking Number and Mail Innovations Tracking Number will be stitched in single PDF file.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**labelImageFormat** | [**MailInnovationsLabelImageLabelImageFormat**](MailInnovationsLabelImageLabelImageFormat.md) |  |  |
|**graphicImage** | **String** | Base 64 encoded graphic image. |  |
|**htMLImage** | **String** | Base 64 encoded html browser image rendering software. This is only returned for GIF image formats. |  [optional] |
|**PDF417** | **String** | PDF-417 is a two-dimensional barcode, which can store up to about 1,800 printable ASCII characters or 1,100 binary characters per symbol. The symbol is rectangular. The PDF417 image will be returned when the shipment is trans-border and the service option is one of the following: Standard, Express Saver or Express Plus.  The image is Base 64 encoded and only returned for GIF image format |  [optional] |
|**internationalSignatureGraphicImage** | **String** | Base 64 encoded graphic image of the Warsaw text and signature box.  EPL2, ZPL and SPL labels. The image will be returned for non-US based shipments. One image will be given per shipment and it will be in the first PackageResults container. |  [optional] |
|**URL** | **String** | This is only returned if the label link is requested to be returned and only at the first package result  Applicable for following types of shipments: Print/Electronic Return Label |  [optional] |




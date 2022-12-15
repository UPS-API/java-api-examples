

# LabelResultsLabelImage

The elements needed to render a label on a printer or in a browser. Specifies the format in which GraphicImage is represented. If LabelImageFormat is GIF, LabelImage contains GraphicImage and HTMLImage. Otherwise, it contains only GraphicImage. If LabelImageFormat is PDF, LabelImage is only returned at the first package result. If entered in the request, the response mirrors, else the default values are returned.  Returned only if TrackingNumber or Combination of Reference Number and Shipper Number present in request.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**labelImageFormat** | [**LabelImageLabelImageFormat**](LabelImageLabelImageFormat.md) |  |  |
|**graphicImage** | **String** | Base 64 encoded graphic image. |  |
|**htMLImage** | **String** | Base 64 encoded html browser image rendering software. This is only returned for GIF image formats. |  [optional] |
|**PDF417** | **String** | PDF-417 is a two-dimensional barcode, which can store up to about 1,800 printable ASCII characters or 1,100 binary characters per symbol. The symbol is rectangular.   The PDF417 image will be returned when the shipment is trans-border and the service option is one of the following: Standard Express, Saver Express Plus. The image is Base 64 encoded and only returned for GIF image format. |  [optional] |
|**internationalSignatureGraphicImage** | **String** | Base 64 encoded graphic image of the Warsaw text and signature box. |  [optional] |
|**URL** | **String** | This is only returned if the label link is requested to be returned and only at the first package result  Applicable for following types of shipments: Print/Electronic Return Label Print/Electronic Import Control Label Forward shipment except for Mail Innovations Forward |  [optional] |




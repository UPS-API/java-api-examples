

# RateRequestShipment

Container for Shipment Information.  N/A

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**originRecordTransactionTimestamp** | **String** | The time that the request was made from the originating system. UTC time down to milliseconds. Example - 2016-07-14T12:01:33.999  Applicable only for HazMat request and with subversion greater than or equal to 1701. |  [optional] |
|**shipper** | [**ShipmentShipper**](ShipmentShipper.md) |  |  |
|**shipTo** | [**ShipmentShipTo**](ShipmentShipTo.md) |  |  |
|**shipFrom** | [**ShipmentShipFrom**](ShipmentShipFrom.md) |  |  [optional] |
|**alternateDeliveryAddress** | [**ShipmentAlternateDeliveryAddress**](ShipmentAlternateDeliveryAddress.md) |  |  [optional] |
|**shipmentIndicationType** | [**ShipmentShipmentIndicationType**](ShipmentShipmentIndicationType.md) |  |  [optional] |
|**paymentDetails** | **Object** | Payment details container for detailed shipment charges. The two shipment charges that are available for specification are Transportation charges and Duties and Taxes.  This container is used for Who Pays What functionality. |  [optional] |
|**frSPaymentInformation** | [**ShipmentFRSPaymentInformation**](ShipmentFRSPaymentInformation.md) |  |  [optional] |
|**freightShipmentInformation** | [**ShipmentFreightShipmentInformation**](ShipmentFreightShipmentInformation.md) |  |  [optional] |
|**goodsNotInFreeCirculationIndicator** | **String** | Goods Not In Free Circulation indicator.  This is an empty tag, any value inside is ignored. This indicator is invalid for a package type of UPS Letter and DocumentsOnly. |  [optional] |
|**service** | [**ShipmentService**](ShipmentService.md) |  |  [optional] |
|**numOfPieces** | **String** | Total number of pieces in all pallets. Required for UPS Worldwide Express Freight and UPS Worldwide Express Freight Midday shipments. |  [optional] |
|**shipmentTotalWeight** | [**ShipmentShipmentTotalWeight**](ShipmentShipmentTotalWeight.md) |  |  [optional] |
|**documentsOnlyIndicator** | **String** | Valid values are Document and Non-document. If the indicator is present then the value is Document else Non-Document. Note: Not applicable for FRS rating  requests.  Empty Tag. |  [optional] |
|**_package** | **Object** |  |  |
|**shipmentServiceOptions** | [**ShipmentShipmentServiceOptions**](ShipmentShipmentServiceOptions.md) |  |  [optional] |
|**shipmentRatingOptions** | [**ShipmentShipmentRatingOptions**](ShipmentShipmentRatingOptions.md) |  |  [optional] |
|**invoiceLineTotal** | [**ShipmentInvoiceLineTotal**](ShipmentInvoiceLineTotal.md) |  |  [optional] |
|**ratingMethodRequestedIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored. RatingMethodRequestedIndicator is an indicator. If present, Billable Weight Calculation method and Rating Method information would be returned in response. |  [optional] |
|**taxInformationIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored. TaxInformationIndicator is an indicator.   The Tax related information includes any type of Taxes, corresponding Monetary Values, Total Charges with Taxes and disclaimers (if applicable) would be returned in response.  If present, any taxes that may be applicable to a shipment would be returned in response.   If this indicator is requested with NegotiatedRatesIndicator, Tax related information, if applicable, would be returned only for Negotiated Rates and not for Published Rates. |  [optional] |
|**promotionalDiscountInformation** | [**ShipmentPromotionalDiscountInformation**](ShipmentPromotionalDiscountInformation.md) |  |  [optional] |
|**deliveryTimeInformation** | [**ShipmentDeliveryTimeInformation**](ShipmentDeliveryTimeInformation.md) |  |  [optional] |
|**masterCartonIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored. MasterCartonIndicator is an indicator and presence implies that shipment is Master Carton type.  If present, the shipment will be rated as a Master Carton Type. If this indicator is requested with NegotiatedRatesIndicator, rates would be returned only for Negotiated Rates and not for Published Rates. |  [optional] |
|**wwEShipmentIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored. WWEShipmentIndicator is an indicator and presence implies that WWE service details requested for RequestOption&#x3D;Shop or  RequestOption&#x3D;Shoptimeintransit  RequestOption&#x3D;Shop or  RequestOption&#x3D;Shoptimeintransit |  [optional] |




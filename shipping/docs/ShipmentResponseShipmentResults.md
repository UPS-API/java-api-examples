

# ShipmentResponseShipmentResults

Shipment Results container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**disclaimer** | [**ShipmentResultsDisclaimer**](ShipmentResultsDisclaimer.md) |  |  [optional] |
|**shipmentCharges** | [**ShipmentResultsShipmentCharges**](ShipmentResultsShipmentCharges.md) |  |  [optional] |
|**negotiatedRateCharges** | [**ShipmentResultsNegotiatedRateCharges**](ShipmentResultsNegotiatedRateCharges.md) |  |  [optional] |
|**frSShipmentData** | [**ShipmentResultsFRSShipmentData**](ShipmentResultsFRSShipmentData.md) |  |  [optional] |
|**ratingMethod** | **String** | RatingMethod is to indicate whether the Shipment was rated as shipment level or package level. This information will be returned only if RatingMethodRequestedIndicator is present in the request.  Valid values: 01 &#x3D; Shipment level 02 &#x3D; Package level |  [optional] |
|**billableWeightCalculationMethod** | **String** | BillableWeightCalculationMethod is to indicate whether the billable weight calculation method utilized was - the package level or shipment level. This information will be returned only if RatingMethodRequestedIndicator is present in the request.  Valid values: 01 &#x3D; Shipment Billable Weight 02 &#x3D; Package Billable Weight |  [optional] |
|**billingWeight** | [**ShipmentResultsBillingWeight**](ShipmentResultsBillingWeight.md) |  |  |
|**shipmentIdentificationNumber** | **String** | Returned UPS shipment ID number.1Z Number of the first package in the shipment. |  [optional] |
|**miDualReturnShipmentKey** | **String** | MIDualReturnShipmentKey is unique key required to process Mail Innovations Dual Return Shipment.   The unique identifier (key) would be returned in response of first phase of Mail Innovations Dual Return Shipments.   This unique identifier (key) would be part of request for second phase of Mail Innovations Dual Return Shipments and would be played back in response for second phase of Mail Innovations Dual Return Shipment.  If the shipment is a Package return shipment, the package tracking number will be concatenated with the system time (in the format YYYY-MM-DDHH.MM.SS.NNN) and followed by service code.   If the shipment is an MI Returns shipment, the Mail Manifest ID (MMI) will be concatenated with the system time. |  [optional] |
|**barCodeImage** | **String** | Bar Code Image will be returned as Base 64 encoded graphic image. Bar Code Image will be returned if BarCodeImageIndicator or BarCodeAndLabelIndicator is present. |  [optional] |
|**packageResults** | [**ShipmentResultsPackageResults**](ShipmentResultsPackageResults.md) |  |  [optional] |
|**controlLogReceipt** | [**ShipmentResultsControlLogReceipt**](ShipmentResultsControlLogReceipt.md) |  |  [optional] |
|**form** | [**ShipmentResultsForm**](ShipmentResultsForm.md) |  |  [optional] |
|**coDTurnInPage** | [**ShipmentResultsCODTurnInPage**](ShipmentResultsCODTurnInPage.md) |  |  [optional] |
|**highValueReport** | [**ShipmentResultsHighValueReport**](ShipmentResultsHighValueReport.md) |  |  [optional] |
|**labelURL** | **String** | URL will point to a page wherein label, receipt and other documents, if applicable, such as HighValueReport, CustomsInvoice and ImportControl instructions can be requested. LabelURL is returned only if the LabelLinksIndicator is requested for following shipments: Print/Electronic ImportControl shipment Print/Electronic Return shipment.  Forward shipment except for Mail Innovations Forward. |  [optional] |
|**localLanguageLabelURL** | **String** | URL will point to a page wherein label, receipt and other documents, if applicable, such as HighValueReport, CustomsInvoice and ImportControl instructions can be requested. LocalLanguageLabelURL is returned only if the LabelLinksIndicator is requested for following shipments: Print/Electronic ImportControl shipment Print/Electronic Return shipment.  Forward shipment except for Mail Innovations Forward.  Not returned if LabelLinksIndicator is requested with Locale element. |  [optional] |
|**receiptURL** | **String** | URL will point to a page wherein label, receipt and other documents, if applicable, such as HighValueReport, CustomsInvoice and ImportControl instructions can be requested. ReceiptURL is returned only if the LabelLinksIndicator is requested for following shipments: Print/Electronic ImportControl shipment Print/Electronic Return shipment. |  [optional] |
|**localLanguageReceiptURL** | **String** | URL will point to a page wherein label, receipt and other documents, if applicable, such as HighValueReport, CustomsInvoice and ImportControl instructions can be requested. LocalLanguageReceiptURL is returned only if the LabelLinksIndicator is requested for following shipments: Print/Electronic ImportControl shipment Print/Electronic Return shipment.   Not returned if LabelLinksIndicator is requested with Locale element. |  [optional] |
|**dgPaperImage** | **String** | Dangrous Good Paper Image in pdf format. One multipage PDF document will be returned that will contain all required Dangrous Goods shipping paper copies for all Dangerous Goods packages.  Only returned when DGSignatoryInfo is present. |  [optional] |
|**masterCartonID** | **String** | Master Carton ID. MasterCartonID will be return if MasterCartonIndicator is present in request. |  [optional] |




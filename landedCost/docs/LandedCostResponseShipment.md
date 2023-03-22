

# LandedCostResponseShipment

Every Landed Cost response must be based on a shipment.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currencyCode** | **String** | Specifies the Currency Code set at the commodity level. This currency is applicable for all duty, tax, VAT, and fee at the shipment and commodity level. |  |
|**importCountryCode** | **String** | Specifies the Import/Ship To/Destination/Final country of the shipment. Check Country List in the Appendices section. |  |
|**id** | **String** | Specifies the Shipment ID in the Landed Cost quote |  |
|**brokerageFeeItems** | [**List&lt;BrokerageFeeItems&gt;**](BrokerageFeeItems.md) | An Array of Brokerage fee |  |
|**totalBrokerageFees** | **BigDecimal** | Grand Total of all applicable Brokerage Fees |  |
|**totalDuties** | **BigDecimal** | Total duty amount of this shipment |  |
|**totalCommodityLevelTaxesAndFees** | **BigDecimal** | Total tax and other fees at commodity level |  |
|**totalShipmentLevelTaxesAndFees** | **BigDecimal** | Total tax and other fees at shipment level |  |
|**totalVAT** | **BigDecimal** | Total VAT of this shipment |  |
|**totalDutyAndTax** | **BigDecimal** | Grand Total combined duty, VAT, tax, and other fees of all commodities of this shipment including shipment level taxes and fee |  |
|**grandTotal** | **BigDecimal** | (TotalDutyAndTax+ totalBrokerageFees) |  |
|**shipmentItems** | [**List&lt;ResponseShipmentItems&gt;**](ResponseShipmentItems.md) | An Array or List of Landed Cost result for all valid commodities |  |
|**transID** | **String** | An identifier unique to the request |  [optional] |
|**perfStats** | [**LandedCostResponseShipmentPerfStats**](LandedCostResponseShipmentPerfStats.md) |  |  [optional] |
|**alVersion** | **Integer** | Version number of the instance that processed this request. Default by 1 |  [optional] |
|**errors** | [**Errors**](Errors.md) |  |  [optional] |






# EstimateResponseShipmentEstimate

Container for the estimated cost

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currencyCode** | **String** | Currency Code provided by user in the LandedCostRequest/QueryRequest/Shipment/Result Currency. If not specified, it is shipment destination country or territory&#39;s currency code. |  |
|**shipmentCharges** | [**ShipmentEstimateShipmentCharges**](ShipmentEstimateShipmentCharges.md) |  |  |
|**productsCharges** | [**ShipmentEstimateProductsCharges**](ShipmentEstimateProductsCharges.md) |  |  |
|**totalLandedCost** | **String** | The total Landed Cost ...sum of shipment level charge and all Product level charges.  Valid characters are 0-9, Decimal Point (\&quot;.\&quot;), and Thousand separator (\&quot;,\&quot;).  Limit to 4 characters after the decimal point. |  |




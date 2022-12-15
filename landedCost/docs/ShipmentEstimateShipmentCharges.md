

# ShipmentEstimateShipmentCharges

Container for the shipment level cost

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**taxesAndFees** | **String** | Shipment Level Taxes and Fees.  Valid characters are 0-9, Decimal Point (\&quot;.\&quot;), and Thousand separator (\&quot;,\&quot;).  Limit to 4 digits after the decimal. |  |
|**additionalInsuranceCost** | **String** | Insurance cost value in the result currency.  Valid characters are 0-9, Decimal Point (\&quot;.\&quot;), and Thousand separator (\&quot;,\&quot;).  Limit to 4 digits after the decimal. |  [optional] |
|**transportationCost** | **String** | Transportation cost value in the result currency.  Valid characters are 0-9, Decimal Point (\&quot;.\&quot;), and Thousand separator (\&quot;,\&quot;).  Limit to 4 digits after the decimal. |  [optional] |
|**subTotal** | **String** | Shipment level charge... sum of Shipment TaxesAndFees, AddtionalInsuranceCost and TransportationCost.  Valid characters are 0-9, Decimal Point (\&quot;.\&quot;), and Thousand separator (\&quot;,\&quot;).  Limit to 4 characters after the decimal point. |  |




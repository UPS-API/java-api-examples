

# ShipmentResultsShipmentCharges

Shipment charges Container. Shipment charges info.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**rateChart** | **String** | Rate Type with which Shipment is rated. Possible RateChart values for different regions will be:  US 48 origin:  1 � Daily Rates  3 � Standard List Rates  4 � Retail Rates.  Alaska/Hawaii origin:  1 � Daily Rates  3 � Standard List Rates  4 � Retail Rates.   All Other origins:  1 � Rates  5 - Regional Rates  6 - General List Rates.  3 and 4 do not apply. |  [optional] |
|**baseServiceCharge** | [**ShipmentChargesBaseServiceCharge**](ShipmentChargesBaseServiceCharge.md) |  |  [optional] |
|**transportationCharges** | [**ShipmentChargesTransportationCharges**](ShipmentChargesTransportationCharges.md) |  |  |
|**itemizedCharges** | [**List&lt;ShipmentChargesItemizedCharges&gt;**](ShipmentChargesItemizedCharges.md) |  |  [optional] |
|**serviceOptionsCharges** | [**ShipmentChargesServiceOptionsCharges**](ShipmentChargesServiceOptionsCharges.md) |  |  |
|**taxCharges** | [**ShipmentChargesTaxCharges**](ShipmentChargesTaxCharges.md) |  |  [optional] |
|**totalCharges** | [**ShipmentChargesTotalCharges**](ShipmentChargesTotalCharges.md) |  |  |
|**totalChargesWithTaxes** | [**ShipmentChargesTotalChargesWithTaxes**](ShipmentChargesTotalChargesWithTaxes.md) |  |  [optional] |




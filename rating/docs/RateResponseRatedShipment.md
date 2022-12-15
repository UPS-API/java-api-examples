

# RateResponseRatedShipment

RatedShipment Container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**disclaimer** | [**RatedShipmentDisclaimer**](RatedShipmentDisclaimer.md) |  |  [optional] |
|**service** | [**RatedShipmentService**](RatedShipmentService.md) |  |  |
|**guaranteedDelivery** | [**RatedShipmentGuaranteedDelivery**](RatedShipmentGuaranteedDelivery.md) |  |  [optional] |
|**rateChart** | **String** | Rate Type with which Shipment is rated. Possible RateChart values for different regions will be:  US 48 origin:  1 � Daily Rates  3 � Standard List Rates  4 � Retail Rates.  Alaska/Hawaii origin: 1 � Daily Rates  3 � Standard List Rates  4 � Retail Rates.   All Other origins: 1 � Rates  5 - Regional Rates  6 - General List Rates.  3 and 4 do not apply |  [optional] |
|**ratedShipmentAlert** | [**RatedShipmentRatedShipmentAlert**](RatedShipmentRatedShipmentAlert.md) |  |  [optional] |
|**billableWeightCalculationMethod** | **String** | Indicates whether the billable weight calculation method is utilized at the package or shipment level.  This information will be returned only if RatingMethodRequestedIndicator is present in the request.  Possible values: 01 &#x3D; Shipment Billable Weight 02 &#x3D; Package Billable Weight |  [optional] |
|**ratingMethod** | **String** | Indicates whether the Shipment was rated at the shipment-level or the package-level. This information will be returned only if RatingMethodRequestedIndicator is present in the request.  Possible values: 01 &#x3D; Shipment level 02 &#x3D; Package level |  [optional] |
|**billingWeight** | [**RatedShipmentBillingWeight**](RatedShipmentBillingWeight.md) |  |  |
|**transportationCharges** | [**RatedShipmentTransportationCharges**](RatedShipmentTransportationCharges.md) |  |  |
|**baseServiceCharge** | [**RatedShipmentBaseServiceCharge**](RatedShipmentBaseServiceCharge.md) |  |  [optional] |
|**itemizedCharges** | [**List&lt;RatedShipmentItemizedCharges&gt;**](RatedShipmentItemizedCharges.md) |  |  [optional] |
|**frSShipmentData** | [**RatedShipmentFRSShipmentData**](RatedShipmentFRSShipmentData.md) |  |  [optional] |
|**serviceOptionsCharges** | [**RatedShipmentServiceOptionsCharges**](RatedShipmentServiceOptionsCharges.md) |  |  |
|**taxCharges** | [**RatedShipmentTaxCharges**](RatedShipmentTaxCharges.md) |  |  [optional] |
|**totalCharges** | [**RatedShipmentTotalCharges**](RatedShipmentTotalCharges.md) |  |  |
|**totalChargesWithTaxes** | [**RatedShipmentTotalChargesWithTaxes**](RatedShipmentTotalChargesWithTaxes.md) |  |  [optional] |
|**negotiatedRateCharges** | [**RatedShipmentNegotiatedRateCharges**](RatedShipmentNegotiatedRateCharges.md) |  |  [optional] |
|**ratedPackage** | [**List&lt;RatedShipmentRatedPackage&gt;**](RatedShipmentRatedPackage.md) |  |  |
|**timeInTransit** | [**RatedShipmentTimeInTransit**](RatedShipmentTimeInTransit.md) |  |  [optional] |




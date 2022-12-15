

# ShipmentShipmentRatingOptions

ShipmentRatingOptions container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**negotiatedRatesIndicator** | **String** | Negotiated Rates option indicator. If the indicator is present and the Shipper is authorized then Negotiated Rates should be returned in the response.  Negotiated Rates are of two types Account Based Rates (ABR) and Web Discount Rates. Negotiated Rates are only returned for qualified Shipper Account Numbers.   Eligibility is determined using the combination of UserId and the Shipper�s Shipper Account Number. If the user is qualified, both Published rates and Negotiated rates are returned to the user. If the UserId and Shipper Account   Number are not qualified for Negotiated rates, a warning message is returned that indicates ineligibility and only the Published rates are returned in the response. As per discount eligibility of user, negotiated rates in the response may contain ABR or Web discount rates. |  [optional] |
|**frSShipmentIndicator** | **String** | Ground Freight Pricing Rates option indicator. If the Ground Freight Pricing Shipment indicator is enabled and Shipper number is authorized then Ground Freight Pricing�rates should be returned in the response.  The Shipper account number must be qualified to receive Ground Freight Pricing Density Based Shipment rates. Only the Shipper account number taken from /ShipmentRequest/Shipment/FRSPaymentInformation/AccountNumber is used when checking qualification for Ground Freight Pricing Density Based rates. |  [optional] |
|**rateChartIndicator** | **String** | RateChartIndicator, if present in request, response will contain RateChart element. |  [optional] |
|**tpFCNegotiatedRatesIndicator** | **String** | This indicator applies for a third party (3P) / Freight collect (FC) shipment only.   For 3P/FC shipment if the shipper wishes to request for the negotiated rates of the third party then this indicator should be included in the request.   If authorized the 3P/FC negotiated rates will be applied to the shipment and rates will be returned in response. |  [optional] |
|**userLevelDiscountIndicator** | **String** | If this indicator is present user level discount will be applied to rates if applicable  Conditions checked: This indicator should be present Shipper number should not be present User should be eligible for user level discount |  [optional] |




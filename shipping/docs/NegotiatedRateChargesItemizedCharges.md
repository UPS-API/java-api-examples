

# NegotiatedRateChargesItemizedCharges

Itemized Charges are returned only when the Subversion element is present and greater than or equal to 1601.  Negotiated itemized charges are only returned for certain contract-only shipments as well as Worldwide Express Freight, Ground Freight Pricing, and Hazmat movements.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | Identification code for itemized charge. |  |
|**description** | **String** | Description of Itemized Charge that had been charged. |  [optional] |
|**currencyCode** | **String** | The IATA currency code associated with the Itemized Charge costs for the shipment. |  |
|**monetaryValue** | **String** | Itemized Charges value amount. |  |
|**subType** | **String** | The sub-type of ItemizedCharges type. |  [optional] |




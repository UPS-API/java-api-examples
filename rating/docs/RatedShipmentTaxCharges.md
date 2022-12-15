

# RatedShipmentTaxCharges

TaxCharges container are returned only when TaxInformationIndicator is present in request and when Negotiated Rates are not applicable. TaxCharges container contains Tax information for a given shipment.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** | Tax Type code. The code represents the type of Tax applied to a shipment. Please refer to Appendix I for possible Tax Type codes. |  |
|**monetaryValue** | **String** | Tax Monetary Value represent the Tax amount.  Valid values are from 0 to 99999999999999.99 |  |




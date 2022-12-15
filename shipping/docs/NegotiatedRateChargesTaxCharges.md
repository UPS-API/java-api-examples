

# NegotiatedRateChargesTaxCharges

TaxCharges container are returned only when TaxInformationIndicator is present in request. TaxCharges container contains Tax information for a given shipment.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** | Tax Type code. The code represents the type of Tax applied to a shipment.   Refer to Tax Type Values/Abbreviations in the Appendix for valid values. |  |
|**monetaryValue** | **String** | Tax Monetary Value represent the Tax amount.  Valid values are from 0 to 99999999999999.99 |  |




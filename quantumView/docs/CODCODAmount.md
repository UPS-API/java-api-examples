

# CODCODAmount

The monetary amount of the COD.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currencyCode** | **String** | The IATA currency code associated with the COD amount for the package. Required if the value for COD amount exists in MonetaryValue tag. Must match one of the IATA currency codes.  For additional information, refer to Currency Codes in the Appendix for valid values. |  [optional] |
|**monetaryValue** | **String** | The COD value for the package. Required if CODCode is 1.Absolute maximum value is for a 32 bit float is� 3.40282347e+38f. |  [optional] |




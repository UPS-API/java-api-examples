

# PickupRateResponseRateResult

The result of rating an on-callpickup.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**disclaimer** | [**RateResultDisclaimer**](RateResultDisclaimer.md) |  |  [optional] |
|**rateType** | **String** | Indicates the pickup is rated as same-day or future-day pickup. SD &#x3D; Same-day Pickup FD &#x3D; Future-day Pickup |  [optional] |
|**currencyCode** | **String** | IATA currency codes for the pickup charge. Such as USD |  |
|**chargeDetail** | [**List&lt;RateResultChargeDetail&gt;**](RateResultChargeDetail.md) |  |  [optional] |
|**taxCharges** | [**RateResultTaxCharges**](RateResultTaxCharges.md) |  |  [optional] |
|**totalTax** | **String** | The sum of all taxes. |  [optional] |
|**grandTotalOfAllCharge** | **String** | The grand total of each charge and applied tax. |  [optional] |
|**grandTotalOfAllIncentedCharge** | **String** | The grand total of each incented charge and applied tax. Only present if 1. UserLevelDiscountIndicator &#x3D; Y and User Level Promotion is applied to the pickup or 2 .if any incentive rate is applied to the pickup and SubVersion on the request is greater than or equal to 1707. |  [optional] |
|**preTaxTotalCharge** | **String** | Total of charges before taxes. Only present when tax details requested in input. |  [optional] |
|**preTaxTotalIncentedCharge** | **String** | Total of incented charges before taxes. Only present if 1. UserLevelDiscountIndicator &#x3D; Y and User Level Promotion is applied to the pickup or 2 .if any incentive rate is applied to the pickup and SubVersion on the request is greater than or equal to 1707. |  [optional] |




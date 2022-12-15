

# RateResultChargeDetail

Detailed charges.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**chargeCode** | **String** | Indicates the general charge type A &#x3D; ACCESSORIAL TYPE B &#x3D; BASE CHARGE TYPE S &#x3D; SURCHARGE TYPE |  |
|**chargeDescription** | **String** | Description of each charge.The possible descriptions are: BASE CHARGE EXTENDED AREA SURCHARGE FUEL SURCHARGE REMOTE AREA SURCHARGE RESIDENTIAL SURCHARGE                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      SATURDAY ON-CALL STOP CHARGE |  [optional] |
|**chargeAmount** | **String** | Monetary value of the charge. |  |
|**incentedAmount** | **String** | Monetary value of the incented charge. Only present if 1. UserLevelDiscountIndicator &#x3D; Y and User Level Promotion is applied to the pickup or 2 .if any incentive rate is applied to the pickup and SubVersion on the request is greater than or equal to 1707. |  [optional] |
|**taxAmount** | **String** | Monetary value of the tax if apply. |  [optional] |




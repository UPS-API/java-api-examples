

# RateRequestPickupType

Pickup Type container tag.  N/A

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | Pickup Type Code.  Valid values:  01 - Daily Pickup (Default - used when an invalid pickup type code is provided) 03 - Customer Counter 06 - One Time Pickup 19 - Letter Center 20 - Air Service Center Length is not validated.  When negotiated rates are requested, 07 (onCallAir) will be ignored.  Refer to the Rate Types Table in the Appendix for rate type based on Pickup Type and Customer Classification Code. |  |
|**description** | **String** | Pickup Type Description.  Ignored if provided in the Request. |  [optional] |




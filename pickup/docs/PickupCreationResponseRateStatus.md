

# PickupCreationResponseRateStatus

The rating result of on-callpickup

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | The rating status. 01 &#x3D; Rate available 02 &#x3D; Rate not available 03 &#x3D; Rate not apply 04 &#x3D; Rate not requested - If 01 is returned, then OnCallPickupRateResult will also be returned with rate details. - If 02 is returned, then OnCallPickupRateResult will not be returned. - If 03 is returned, then OnCallPickupRateResult will not be returned. The rate option is not appliable to this return pickup. The requester will not be charged. - If 04 is returned, then OnCallPickupRateResult will not be returned. The requester did not ask for rating this on-callpickup. |  |
|**description** | **String** | The matching description of rating status code (see above). |  [optional] |






# XAVRequestRequest

XAV Request Container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**subVersion** | **String** | Not Used. |  [optional] |
|**requestOption** | **String** | Identifies the optional processing to be performed. If not present or invalid value then an error will be sent back.  Valid values:  1 - Address Validation 2 - Address Classification 3 - Address Validation and Address Classification.  For a list of valid values, refer to Address Validation API�Supported Countries or Territories in the Appendix. |  |
|**transactionReference** | [**RequestTransactionReference**](RequestTransactionReference.md) |  |  [optional] |




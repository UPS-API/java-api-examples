

# XAVResponse

XAV Response Container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**response** | [**XAVResponseResponse**](XAVResponseResponse.md) |  |  |
|**validAddressIndicator** | **String** | Indicates query found a valid match. |  [optional] |
|**ambiguousAddressIndicator** | **String** | Indicates query could not find exact match. Candidate list follows. |  [optional] |
|**noCandidatesIndicator** | **String** | No Candidate found. |  [optional] |
|**addressClassification** | [**XAVResponseAddressClassification**](XAVResponseAddressClassification.md) |  |  [optional] |
|**candidate** | [**XAVResponseCandidate**](XAVResponseCandidate.md) |  |  [optional] |




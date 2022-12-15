

# XAVRequest



## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**request** | [**XAVRequestRequest**](XAVRequestRequest.md) |  |  |
|**regionalRequestIndicator** | **String** | If this indicator is present then either the region element or any combination of Political Division 1, Political Division 2, PostcodePrimaryLow and the PostcodeExtendedLow fields will be recognized for validation in addition to the urbanization element.  If this tag is present, US and PR street level address validation will not occur. The default is to provide street level address validation.  Not valid with the address classification request option. |  [optional] |
|**maximumCandidateListSize** | **String** | The maximum number of Candidates to return for this request. Valid values: 0 - 50 Default: 15 |  [optional] |
|**addressKeyFormat** | [**XAVRequestAddressKeyFormat**](XAVRequestAddressKeyFormat.md) |  |  |




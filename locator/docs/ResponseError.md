

# ResponseError

If an error is encountered during the interchange, the Response contains an error. If the error is present, then the ErrorSeverity and ErrorCode are required.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**errorSeverity** | **String** | Describes the severity of the error.  For additional information, refer to Locator Error Codes in the Appendix. |  |
|**errorCode** | **String** | A numeric value that describes the error. Each tool defines a range of error codes.  For additional information, refer to Locator Error Codes in the Appendix. |  |
|**errorDescription** | **String** | Describes the error code. |  [optional] |
|**minimumRetrySeconds** | **String** | Number of seconds to wait until retry.   This field is populated on special conditions of the Transient Error only, as defined by the service.  A number between 1 and 86400 (24 hours) |  [optional] |
|**errorLocation** | [**ErrorErrorLocation**](ErrorErrorLocation.md) |  |  [optional] |
|**errorDigest** | **String** | The contents of the element in error. |  [optional] |




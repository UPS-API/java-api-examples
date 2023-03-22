

# ResponseError

If an error is encountered during the interchange, the Response contains an error.� If the error is present, then the ErrorSeverity and ErrorCodes are required.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**errorSeverity** | **String** | Describes the severity of the error.�� Required if the error is present. |  [optional] |
|**errorCode** | **String** | A numeric value that describes the error.� Each tool defines a range of error codes. Required if the error is present. |  [optional] |
|**errorDescription** | **String** | Describes the error code. |  [optional] |
|**minimumRetrySeconds** | **String** | Number of seconds to wait until retry.� This field is populated on special conditions of the Transient Error only, as defined by the service.� A number between 1 and 86400 (24 hours) |  [optional] |
|**errorLocation** | [**List&lt;ErrorErrorLocation&gt;**](ErrorErrorLocation.md) |  |  |
|**errorDigest** | **List&lt;String&gt;** | The contents of the element in error. |  [optional] |




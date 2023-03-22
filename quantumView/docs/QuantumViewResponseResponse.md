

# QuantumViewResponseResponse

Contains Errors information tags along with the success/fail status of the QuantumView request.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**transactionReference** | [**ResponseTransactionReference**](ResponseTransactionReference.md) |  |  |
|**responseStatusCode** | **String** | Identifies the success or failure of the interchange.  1 &#x3D; Success, 0 &#x3D; Failure |  |
|**responseStatusDescription** | **String** | &#39;Success&#39; or &#39;Failure&#39; |  [optional] |
|**error** | [**List&lt;ResponseError&gt;**](ResponseError.md) |  |  [optional] |




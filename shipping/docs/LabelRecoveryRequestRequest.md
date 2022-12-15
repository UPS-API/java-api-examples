

# LabelRecoveryRequestRequest

Request Container.  N/A

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**subVersion** | **String** | When UPS introduces new elements in the response that are not associated with new request elements, Subversion is used. This ensures backward compatibility.  To get such elements you need to have the right Subversion. The value of the subversion is explained in the Response element Description.  Format: YYMM &#x3D; Year and month of the release. Example: 1701 &#x3D; 2017 January  Supported values: 1701, 1707, 1903 |  [optional] |
|**requestOption** | **String** | Request option is no longer used. |  [optional] |
|**transactionReference** | [**LRRequestTransactionReference**](LRRequestTransactionReference.md) |  |  [optional] |




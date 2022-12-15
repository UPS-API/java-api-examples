

# PickupCreationRequestRequest

Common element for all services

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**subVersion** | **String** | When UPS introduces new elements in the response that are not associated with new request elements, Subversion is used. This ensures backward compatibility.  To get such elements you need to have the right Subversion. The value of the subversion is explained in the Response element Description. Supported values: 1607, 1707,2007  Example: Itemized Charges are returned only when the Subversion element is present and greater than or equal to &#39;1601&#39;.   Format: YYMM &#x3D; Year and month of the release. Example: 1601 &#x3D; 2016 January |  [optional] |
|**transactionReference** | [**RequestTransactionReference**](RequestTransactionReference.md) |  |  [optional] |






# QuantumViewResponse

Container for QuantumView response information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**response** | [**QuantumViewResponseResponse**](QuantumViewResponseResponse.md) |  |  |
|**quantumViewEvents** | [**QuantumViewResponseQuantumViewEvents**](QuantumViewResponseQuantumViewEvents.md) |  |  |
|**bookmark** | **String** | Bookmarks the file for next retrieval, It is a base64Encoded String. It contains the combination of SubscriberID + SubscriptionName + File Name if the request is for all data. It contains SubscriberID if the request is for unread data. When a response comes back with a bookmark it indicates that there is more data. To fetch the remaining data, the requester should come back with the bookmark added to the original request. |  [optional] |




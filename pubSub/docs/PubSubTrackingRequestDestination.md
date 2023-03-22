

# PubSubTrackingRequestDestination

The destination container related to the subscription endpoint.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**url** | **String** | The URL which is used for destination-subscription endpoint, and it has to be available 24/7 or scans that are sent when the client endpoint is unavailable will be lost. |  |
|**credential** | **String** | The credential used for destination-subscription endpoint.  If for any reason this credential changes then any subscription that was previously sent with the old credential should be resent with the new credential, otherwise scans sent using the old credential will be rejected when sent to the client endpoint and will be lost. |  |
|**credentialType** | **String** | The type of credential used for destinaton-subscription endpoint |  |




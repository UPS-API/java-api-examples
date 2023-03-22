

# SubscriptionEventsSubscriptionFile

Container holds all of the unread files associated with the subscription.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**fileName** | **String** | File name belonging to specific subscription requested by user. Format: YYMMDD_HHmmssnnn |  |
|**statusType** | [**SubscriptionFileStatusType**](SubscriptionFileStatusType.md) |  |  |
|**manifest** | **Object** | Manifest of a shipment |  [optional] |
|**origin** | [**List&lt;SubscriptionFileOrigin&gt;**](SubscriptionFileOrigin.md) |  |  [optional] |
|**exception** | [**List&lt;SubscriptionFileException&gt;**](SubscriptionFileException.md) |  |  [optional] |
|**delivery** | [**List&lt;SubscriptionFileDelivery&gt;**](SubscriptionFileDelivery.md) |  |  [optional] |
|**generic** | [**List&lt;SubscriptionFileGeneric&gt;**](SubscriptionFileGeneric.md) |  |  [optional] |




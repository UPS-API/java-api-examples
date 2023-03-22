

# QuantumViewEventsSubscriptionEvents

The event that a user receives a subset of Tracking information specific to either packages coming or packages going, after subscription request is made.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | A name uniquely defined associated to the Subscription ID, for each subscription.� Required if the SubscriptionEvents container is present. |  [optional] |
|**number** | **String** | A number uniquely defined associated to the Subscriber ID, for each subscription.� Required if the SubscriptionEvents container is present. |  [optional] |
|**subscriptionStatus** | [**SubscriptionEventsSubscriptionStatus**](SubscriptionEventsSubscriptionStatus.md) |  |  |
|**dateRange** | [**SubscriptionEventsDateRange**](SubscriptionEventsDateRange.md) |  |  [optional] |
|**subscriptionFile** | [**List&lt;SubscriptionEventsSubscriptionFile&gt;**](SubscriptionEventsSubscriptionFile.md) |  |  [optional] |




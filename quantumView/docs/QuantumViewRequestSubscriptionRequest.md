

# QuantumViewRequestSubscriptionRequest

Subscription requested by user to retrieve Inbound or/and Outbound XML formed subscription information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of subscription requested by user, as one type of request criteria. Required when the customer wants to request data for a specific subscription name. Subscription name consists of up to 21 alphanumerics. |  [optional] |
|**dateTimeRange** | [**SubscriptionRequestDateTimeRange**](SubscriptionRequestDateTimeRange.md) |  |  [optional] |
|**fileName** | **String** | File name of specific subscription requested by user. Format: YYMMDD_HHmmssnnn. (nnn - sequence number: usually &#x3D; 001) |  [optional] |






# SubscriptionRequestDateTimeRange

The range of date time of subscription requested by user, as one type of request criteria, valid up to but not exceeding 7 days into the past, starting from current day.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**beginDateTime** | **String** | Beginning date time for the retrieval criteria of the subscriptions. It is required for date time request criteria. Format: YYYYMMDDHHmmss. |  [optional] |
|**endDateTime** | **String** | Ending date time for the retrieval criteria of the subscriptions. Format: YYYYMMDDHHmmss.  When a null or empty EndDateTime is passed in the request, it is defaulted to 7 days from the given begin date. |  [optional] |




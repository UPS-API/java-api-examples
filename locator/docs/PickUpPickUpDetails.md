

# PickUpPickUpDetails

Container to hold information regarding pickup time and pickup availability indicator.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**pickUpTime** | **String** | Time of pickup in military format (HHMM) e.g. 0930, 1700, 1845 etc. with exception for midnight. For midnight the time will be returned as 0. |  [optional] |
|**noPickUpIndicator** | **String** | Indicates whether or not there is a pickup time for the specified day of the week. Valid values:  True-there is a pickup time False-there is not a pickup time. |  |




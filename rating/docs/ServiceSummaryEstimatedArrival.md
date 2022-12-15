

# ServiceSummaryEstimatedArrival

Container for the Time-In-Transit arrival information by service

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**arrival** | [**EstimatedArrivalArrival**](EstimatedArrivalArrival.md) |  |  |
|**businessDaysInTransit** | **String** | Number of business days from Origin to Destination Locations. |  |
|**pickup** | [**EstimatedArrivalPickup**](EstimatedArrivalPickup.md) |  |  |
|**dayOfWeek** | **String** | Day of week for arrival. Valid values are:  MON TUE WED THU FRI SAT |  |
|**customerCenterCutoff** | **String** | Customer Service call time. Returned for domestic as well as international requests. |  [optional] |
|**delayCount** | **String** | Number of days delayed at customs. Returned for International requests. |  [optional] |
|**holidayCount** | **String** | Number of National holidays during transit. Returned for International requests. |  [optional] |
|**restDays** | **String** | Number of rest days, i.e. non movement. Returned for International requests. |  [optional] |
|**totalTransitDays** | **String** | The total number of days in transit from one location to the next. Returned for International requests. |  [optional] |




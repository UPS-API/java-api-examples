

# FacilityTimeDayOfWeek

Facility Hours of Operation Container

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**day** | **String** | Day of the week. Mon-Sun |  |
|**earliestDropOfforPickup** | **String** | Earliest time that a customer can pick up a package. |  [optional] |
|**latestDropOfforPickup** | **String** | Latest time that a customer can pick up a package. |  [optional] |
|**openHours** | **String** | Facility Open Hours. The latest local open time. Format: HHmm Hour: 0-23 Minute: 0-59 |  |
|**closeHours** | **String** | Facility Close Hours. The latest local close time. Format: HHmm Hour: 0-23 Minute: 0-59 |  |
|**prepTime** | **String** | Preparation time for hold for pickup  Conditionally required if request is for hold for pickup. |  [optional] |
|**lastDrop** | **String** | Latest time a package, requiring preparation can be dropped off (Close time - Prep time). |  [optional] |




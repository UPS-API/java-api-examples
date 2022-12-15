

# Services


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**serviceLevel** | **String** | Service level code     Valid domestic service codes: \&quot;1DMS\&quot;,\&quot;1DAS\&quot;,\&quot;1DM\&quot;,\&quot;1DA\&quot;,\&quot;1DP\&quot;,\&quot;2DM\&quot;,\&quot;2DA\&quot;,\&quot;3DS\&quot;,\&quot;GND\&quot;.      Valid International service codes (not a complete list) ,\&quot;01\&quot;,\&quot;02\&quot;,\&quot;03\&quot;,\&quot;05\&quot;,\&quot;08\&quot;,\&quot;09\&quot;,\&quot;10\&quot;,\&quot;11\&quot;,\&quot;18\&quot;,\&quot;19\&quot;,\&quot;20\&quot;,\&quot;21\&quot;,\&quot;22\&quot;,\&quot;23\&quot;,\&quot;24\&quot;,\&quot;25\&quot;,\&quot;26\&quot;,\&quot;28\&quot;,\&quot;29\&quot;,\&quot;33\&quot;,\&quot;68\&quot;.  |  |
|**serviceLevelDescription** | **String** | Service name, examples are: UPS Next Day Air, UPS Ground, UPS Expedited, UPS Worldwide Express Frieght |  |
|**shipDate** | **String** | The date the shipment is tendered to UPS for shipping (can be dropped off at UPS or picked up by UPS).  This date may or may not be the UPS business date.     Valid Format: YYYY-MM-DD |  |
|**deliveryDate** | **String** | Scheduled delivery date.     Valid format: YYYY-MM-DD |  |
|**commitTime** | **String** | Scheduled commit time.     For international shipments the value always come back from SE (OPSYS data) but for domestic, value may be used from NRF commit time.      Valid format: HH:MM:SS |  |
|**deliveryTime** | **String** | Scheduled Delivery Time, value may be later then commit time.     Valid format: HH:MM:SS |  |
|**deliveryDayOfWeek** | **String** | Three character scheduled delivery day of week.     Valid values: \&quot;MON\&quot;,\&quot;TUE\&quot;,\&quot;WED\&quot;,\&quot;THU\&quot;,\&quot;FRI\&quot;, \&quot;SAT\&quot; |  |
|**nextDayPickupIndicator** | **String** | Returns a \&quot;1\&quot; if the requested shipped on date was changed. This data is available only for international transactions.     When this flag is set, WWDTDisclaimer.getNextDayDisclaimer method could be called to return the next day disclaimer message. |  |
|**saturdayPickupIndicator** | **String** | Returns \&quot;1\&quot; if Saturday Pickup is available for an extra charge otherwise it will return \&quot;0\&quot;.     When this flag is set, WWDTDisclaimer.getSaturdayPickupDisclaimer method could be called to return the Saturday pickup extra charge message |  |
|**saturdayDeliveryDate** | **String** | Delivery date of Saturday Delivery     Valid Format: YYYY-MM-DD |  [optional] |
|**saturdayDeliveryTime** | **String** | Delivery time of Saturday deliver     Valid format: HH:MM:SS |  [optional] |
|**serviceRemarksText** | **String** | Service remarks text. The contents of this field will represent text that the back end application/function needs to display to clarify the time in transit calculation. |  [optional] |
|**guaranteeIndicator** | **String** | Return \&quot;1\&quot; Guaranteed, or \&quot;0\&quot; Not Guaranteed based on below conditions:     If the ship date, delivery date, and system date are not within a defined peak date range, and a value for service guaranetee is available in SE (OPSYS data) that will be returned.     If the ship date or delivery date or system date are within a defined peak date range and the service is within the list of servies to remove guarantees for, \&quot;0\&quot; wil be returned. |  |
|**totalTransitDays** | **Integer** | Available for International requests. Number of calendar days from origin location to destination location.  TotalTransitDays &#x3D; BusinessTransitDays + RestDaysCount + HolidayCount.     Defaults to 0. |  |
|**businessTransitDays** | **Integer** | Returns the number of UPS business days from origin location to destination location. |  |
|**restDaysCount** | **Integer** | Returns the number of rest days encountered at the origin location.  this data is available only for international transactions.     Defaults to 0. |  |
|**holidayCount** | **Integer** | Returns the number of holidays encountered at the origin and destination location, if it effects the time and transit.  This data is available only for international transactions.     Defaults to 0. |  |
|**delayCount** | **Integer** | Returns the number of delay needed for customs encounter at the origin or destination location.  This data is available only for international transactions.      Defaults to 0. |  |
|**pickupDate** | **String** | Planned pickup date.     Note: This value may not equal the shipped on value requested.  This could happen when the requested shipped on date is a holiday or for locations needing 24 hour notice before a pickup could be made. |  |
|**pickupTime** | **String** | Latest possible pickup time. This data is available only for international transactions. If the package was not actually picked by UPS before this time, the services will not meet the guarantee commitment. |  |
|**cstccutoffTime** | **String** | Latest time a customer can contact UPS CST needs to be notified for requesting a pickup. This data is available only for international transactions. If customer does not notify UPS for a pickup before this time, the services will not meet the guarantee commitment. |  |
|**poddate** | **String** | Returns the date proof of delivery informatino will be available.  This data is available only for international transactions. |  [optional] |
|**poddays** | **Integer** | Returns the number of days proof of delivery information will be available.  This data is available only for international transactions. |  [optional] |






# RatedShipmentTimeInTransit

Container for returned Time in Transit information.  Will only be returned if request option was either \"ratetimeintransit\" or \"shoptimeintransit\" and DeliveryTimeInformation container was present in request.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**pickupDate** | **String** | The date the user requests UPS to pickup the package from the origin. Format: YYYYMMDD. In the event this Pickup date differs from the Pickup date in the Estimated Arrival Container, a warning will be returned.  In the event this Pickup date differs from the Pickup date in the Estimated Arrival Container, a warning will be returned. |  |
|**documentsOnlyIndicator** | **String** | If the indicator is present then the shipment was processed as Document Only. |  [optional] |
|**packageBillType** | **String** | Package bill type for the shipment. Valid values: 02 - Document only  03 - Non-Document 04 - Pallet |  [optional] |
|**serviceSummary** | [**TimeInTransitServiceSummary**](TimeInTransitServiceSummary.md) |  |  |
|**autoDutyCode** | **String** | Required output for International requests. If Documents indicator is set for Non-document a duty is automatically calculated. The possible values to be returned are:  01 - Dutiable 02 - Non-Dutiable 03 - Low-value 04 - Courier Remission 05 - Gift 06 - Military 07 - Exception 08 - Line Release 09 - Section 321 low value. |  [optional] |
|**disclaimer** | **String** | The Disclaimer is provided based upon the origin and destination country or territory codes provided in the request document. The possible disclaimers that can be returned are available in the Service Guaranteed Disclaimers table. |  [optional] |






# PickupPendingStatusResponsePendingStatus

The result of retrieving pending pickups.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**pickupType** | **String** | Specify the type of pending pickup. 01 &#x3D; on-callPickup |  |
|**serviceDate** | **String** | Local service date Format: yyyyMMdd yyyy &#x3D; Year applicable MM &#x3D; 01� 12 dd &#x3D; 01� 31 |  |
|**PRN** | **String** | Returned PRN |  |
|**gwNStatusCode** | **String** | Status code for Smart Pickup. |  [optional] |
|**onCallStatusCode** | **String** | A unique string identifier to identify a success pre-notification processing. Only available if end result is success. |  [optional] |
|**pickupStatusMessage** | **String** | The status for on-callpickup. PickupPendingStatusResponse will only display incomplete status for today and tomorrow only.  002 and 012 are the most common responses. 001 &#x3D; Received at dispatch 002 &#x3D; Dispatched to driver 003 &#x3D; Order successfully completed 004 &#x3D; Order unsuccessfully completed 005 &#x3D; Missed commit � Updated ETA supplied by driver 007 &#x3D; Cancelled 008 &#x3D; Order has invalid order status 012 &#x3D; Your pickup request is being processed |  |
|**billingCode** | **String** | Pickup billing classification for on call 01 &#x3D; Regular 02 &#x3D; Return 03 &#x3D; Alternate Address (Not supported for now) |  [optional] |
|**contactName** | **String** | on-callpickup contact name |  [optional] |
|**referenceNumber** | **String** | Customer provided reference number for on-call pickup |  [optional] |




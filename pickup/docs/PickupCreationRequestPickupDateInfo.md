

# PickupCreationRequestPickupDateInfo

The container of desired pickup date

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**closeTime** | **String** | Pickup location&#39;s local close time. - User provided Close Time must be later than the Earliest Allowed Customer Close Time.  - Earliest Allowed Customer Close Time is defined by UPS pickup operation system.  - CloseTime minus ReadyTime must be greater than the LeadTime.  - LeadTime is determined by UPS pickup operation system. LeadTime is the minimum amount of time UPS requires between customer�s request for a pickup and driver arriving at the location for the pickup.  Format: HHmm Hour: 0-23 Minute: 0-59 |  |
|**readyTime** | **String** | Pickup location&#39;s local ready time.  ReadyTime means the time when your shipment(s) can be ready for UPS to pick up.  - User provided ReadyTime must be earlier than CallByTime.  - CallByTime is determined by UPS pickup operation system. CallByTime is the Latest time a Customer can call UPS or self-serve on UPS.com and complete a Pickup Request and UPS can still make the Pickup service request.  - If ReadyTime is earlier than current local time, UPS uses the current local time as the ReadyTime.  Format: HHmm Hour: 0-23 Minute: 0-59 |  |
|**pickupDate** | **String** | Local pickup date of the location.  Format: yyyyMMdd yyyy &#x3D; Year Appliable MM &#x3D; 01� 12 dd &#x3D; 01�31 |  |




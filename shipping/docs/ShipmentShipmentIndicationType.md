

# ShipmentShipmentIndicationType

Container for Shipment Indication Type.  Required to indicate whether shipment is \"Hold For Pickup At UPS Access Point\" for use by approved shippers to identify a UPS Access Point location as an alternate delivery option during shipment preparation or \"UPS Access Point� Delivery�, ship parcels directly to a UPS Access Point location for collection by the receiver.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | Valid values:  &#39;01&#39; - Hold for Pickup at UPS Access Point aka Direct to Retail (D2R) &#39;02&#39; - UPS Access Point� Delivery aka Retail to Retail (R2R)  If &#39;01&#39; code is present indicates shipment will be send to Retail location where it is held to consignee to claim. |  |
|**description** | **String** | Description for the code. |  [optional] |




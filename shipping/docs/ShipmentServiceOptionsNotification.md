

# ShipmentServiceOptionsNotification

Container for the Quantum View Notification (QVN) is valid for all shipments including Return service, Import Control and Returns Flexible Access.  Valid return service types are: ERL, PRL, PNM, RS1, or RS3.   The shipment level notification is valid for forward and return international shipments as well as for domestic shipments (for US and PR).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**notificationCode** | **String** | Notification Code.  Valid values: 3 - Receiver Return Notification 6 - QV Email Notification 7 - QV Exception Notification 8 - QV Delivery Notification  For Mail Innovations forward shipments, QV Email Notifications are allowed for First Class, Priority Mail, and Expedited Mail Innovation services. |  |
|**email** | [**NotificationEMail**](NotificationEMail.md) |  |  |
|**voiceMessage** | [**NotificationVoiceMessage**](NotificationVoiceMessage.md) |  |  [optional] |
|**textMessage** | [**NotificationTextMessage**](NotificationTextMessage.md) |  |  [optional] |
|**locale** | [**NotificationLocale**](NotificationLocale.md) |  |  [optional] |






# SubscriptionFileGeneric

Container for generic record information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**activityType** | **String** | Unique identifier that defines the type of activity.  VM &#x3D; Void for Manifest  UR &#x3D; Undeliverable Returns IR &#x3D; Invoice Removal Successful  TC &#x3D; Transport Company USPS scan PS &#x3D; &#39;Postal Service Possession Scan&#39; FN &#x3D; UPS Access Point/Alternate Delivery Location Email Notification Failure DS &#x3D; Destination Scan AG &#x3D; Package is in transit to a UPS facility RE &#x3D; UPS Returns Exchange  RP &#x3D; Retail Pickup UD &#x3D; Updated delivery date                                                                                              OD &#x3D; Out for Delivery                                                                                                        SD &#x3D; Scheduled for Delivery                                                                                              FM &#x3D; Tendered to FMP |  |
|**trackingNumber** | **String** | Package&#39;s tracking number. |  |
|**shipperNumber** | **String** | Shipper&#39;s alphanumeric account number. |  [optional] |
|**shipmentReferenceNumber** | [**List&lt;GenericShipmentReferenceNumber&gt;**](GenericShipmentReferenceNumber.md) |  |  [optional] |
|**packageReferenceNumber** | [**List&lt;GenericPackageReferenceNumber&gt;**](GenericPackageReferenceNumber.md) |  |  [optional] |
|**service** | [**GenericService**](GenericService.md) |  |  [optional] |
|**activity** | [**GenericActivity**](GenericActivity.md) |  |  [optional] |
|**billToAccount** | [**GenericBillToAccount**](GenericBillToAccount.md) |  |  [optional] |
|**shipTo** | [**GenericShipTo**](GenericShipTo.md) |  |  [optional] |
|**rescheduledDeliveryDate** | **String** | If Activity Type is \&quot;DS\&quot; or \&quot;UD\&quot;, this element will contain Rescheduled Delivery Date.  Format will be YYYYMMDD.                                                                                               If Activity Type is \&quot;OD\&quot;, this element will contain Rescheduled Delivery Date. Format will be YYYYMMDD.                                                                                                                     If Activity Type is \&quot;SD\&quot;, this element will contain agreed upon date with Customer for delivery Date . Format will be YYYYMMDD. |  [optional] |
|**failureNotification** | [**GenericFailureNotification**](GenericFailureNotification.md) |  |  [optional] |




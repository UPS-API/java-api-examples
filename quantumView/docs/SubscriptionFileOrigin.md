

# SubscriptionFileOrigin

Information about shipment's origin.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**packageReferenceNumber** | [**List&lt;OriginPackageReferenceNumber&gt;**](OriginPackageReferenceNumber.md) |  |  [optional] |
|**shipmentReferenceNumber** | [**List&lt;OriginShipmentReferenceNumber&gt;**](OriginShipmentReferenceNumber.md) |  |  [optional] |
|**shipperNumber** | **String** | Shipper&#39;s six digit alphanumeric account number. |  |
|**trackingNumber** | **String** | Package&#39;s 1Z tracking number. |  |
|**date** | **String** | Date that the package is picked up at the origin. Date format is YYYYMMDD. |  |
|**time** | **String** | Time that the package is picked up at the origin. Time format is HHMMSS. |  |
|**activityLocation** | [**OriginActivityLocation**](OriginActivityLocation.md) |  |  [optional] |
|**billToAccount** | [**OriginBillToAccount**](OriginBillToAccount.md) |  |  [optional] |
|**scheduledDeliveryDate** | **String** | Scheduled delivery date for destination address. Date format is YYYYMMDD. |  [optional] |
|**scheduledDeliveryTime** | **String** | Scheduled delivery time for destination address. Time format is HHMMSS. |  [optional] |




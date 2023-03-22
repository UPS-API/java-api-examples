

# SubscriptionFileDelivery

Container for delivery information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**packageReferenceNumber** | [**List&lt;DeliveryPackageReferenceNumber&gt;**](DeliveryPackageReferenceNumber.md) |  |  [optional] |
|**shipmentReferenceNumber** | [**List&lt;DeliveryShipmentReferenceNumber&gt;**](DeliveryShipmentReferenceNumber.md) |  |  [optional] |
|**shipperNumber** | **String** | Shipper&#39;s six digit alphanumeric account number. |  |
|**trackingNumber** | **String** | Package&#39;s 1Z tracking number. |  |
|**date** | **String** | Date that the package is delivered. Date format is YYYYMMDD. |  |
|**time** | **String** | Time that the package is delivered. Time format is HHMMSS |  |
|**driverRelease** | **String** | Information about driver release note / signature. |  [optional] |
|**activityLocation** | [**DeliveryActivityLocation**](DeliveryActivityLocation.md) |  |  [optional] |
|**deliveryLocation** | [**DeliveryDeliveryLocation**](DeliveryDeliveryLocation.md) |  |  [optional] |
|**COD** | [**DeliveryCOD**](DeliveryCOD.md) |  |  [optional] |
|**billToAccount** | [**DeliveryBillToAccount**](DeliveryBillToAccount.md) |  |  [optional] |
|**lastPickupDate** | **String** | Last pickup by Date from the UPS Access Point Location. |  [optional] |
|**accessPointLocationID** | **String** | UPS Access Point Location ID. |  [optional] |




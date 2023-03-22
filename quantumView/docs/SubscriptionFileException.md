

# SubscriptionFileException

Shipment exception data.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**packageReferenceNumber** | [**List&lt;ExceptionPackageReferenceNumber&gt;**](ExceptionPackageReferenceNumber.md) |  |  [optional] |
|**shipmentReferenceNumber** | [**List&lt;ExceptionShipmentReferenceNumber&gt;**](ExceptionShipmentReferenceNumber.md) |  |  [optional] |
|**shipperNumber** | **String** | Shipper&#39;s six digit alphanumeric account number. |  |
|**trackingNumber** | **String** | Package&#39;s 1Z tracking number. |  |
|**date** | **String** | Date that the package is delivered. Date format is YYYYMMDD. |  |
|**time** | **String** | Time that the package is delivered. Time format is HHMMSS |  |
|**updatedAddress** | [**ExceptionUpdatedAddress**](ExceptionUpdatedAddress.md) |  |  [optional] |
|**statusCode** | **String** | Code for status of updating shipping address issue. |  [optional] |
|**statusDescription** | **String** | Description for status of updating shipping address issue. |  [optional] |
|**reasonCode** | **String** | Code for reason of updating shipping address issue. |  [optional] |
|**reasonDescription** | **String** | Description for reason of updating shipping address issue. |  [optional] |
|**resolution** | [**ExceptionResolution**](ExceptionResolution.md) |  |  [optional] |
|**rescheduledDeliveryDate** | **String** | Rescheduled delivery date for updated shipping address. Date format is YYYYMMDD. |  [optional] |
|**rescheduledDeliveryTime** | **String** | Rescheduled delivery time for updated shipping address. Time format is HHMMSS |  [optional] |
|**activityLocation** | [**ExceptionActivityLocation**](ExceptionActivityLocation.md) |  |  [optional] |
|**billToAccount** | [**ExceptionBillToAccount**](ExceptionBillToAccount.md) |  |  [optional] |
|**accessPointLocationID** | **String** | The UPS Access Point Location ID. |  [optional] |




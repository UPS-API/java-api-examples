

# PreNotificationRequestShipment

Shipment Container

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**shipperNumber** | **String** | Shipper�s six digit account number. |  |
|**shipmentIdentificationNumber** | **String** | 1Z Number of the first package in the shipment. |  |
|**shipToAddress** | [**ShipmentShipToAddress**](ShipmentShipToAddress.md) |  |  |
|**shipFromAddress** | [**ShipmentShipFromAddress**](ShipmentShipFromAddress.md) |  |  |
|**pickupDate** | **String** | Date of the On Call Air Pickup. Format is YYYYMMDD |  |
|**service** | [**ShipmentService**](ShipmentService.md) |  |  |
|**regulationSet** | **String** | The Regulatory set associated with every regulated shipment. It must be same across the shipment. Valid values are:                                                                                                                                                                                                                                                                                                         ADR � European Agreement concerning the International Carriage of Dangerous Goods by Road.  49CFR � Title 49 of the United States Code of Federal Regulations.   IATA � International Air Transport Association (IATA) Dangerous Goods Regulations. |  |
|**_package** | [**ShipmentPackage**](ShipmentPackage.md) |  |  |




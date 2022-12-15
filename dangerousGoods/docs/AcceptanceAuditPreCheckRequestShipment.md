

# AcceptanceAuditPreCheckRequestShipment

Contains shipment information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**shipperNumber** | **String** | Shipper�s six digit account number.  Your UPS Account Number must have correct Dangerous goods contract to successfully use this Webservice. |  |
|**shipFromAddress** | [**ShipmentShipFromAddress**](ShipmentShipFromAddress.md) |  |  |
|**shipToAddress** | [**ShipmentShipToAddress**](ShipmentShipToAddress.md) |  |  |
|**service** | [**ShipmentService**](ShipmentService.md) |  |  |
|**regulationSet** | **String** | The Regulatory set associated with every regulated shipment. It must be same across the shipment. Not required when the CommodityRegulatedLevelCode is EQ.  Valid values: ADR, 49CFR, IATA.  ADR &#x3D; Europe to Europe Ground Movement 49CFR &#x3D; HazMat regulated by US Dept. of Transportation within the U.S. or ground shipments to Canada    IATA&#x3D; Worldwide Air movement. |  [optional] |
|**_package** | [**ShipmentPackage**](ShipmentPackage.md) |  |  |




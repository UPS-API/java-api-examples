

# ShipmentServiceOptionsAccessPointCOD

Access Point COD indicates Shipment level Access Point COD is requested for a shipment.  Valid only for \"01 - Hold For Pickup At UPS Access Point\" Shipment Indication type.  Shipment Access Point COD is valid only for countries or territories within E.U.  Not valid with (Shipment) COD.  Not available to shipment with return service.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currencyCode** | **String** | Access Point COD Currency Code.  Required if Access Point COD container is present. UPS does not support all international currency codes. Refer to the appendix for a list of valid codes. |  |
|**monetaryValue** | **String** | Access Point COD Monetary Value.  Required if Access Point COD container is present. |  |




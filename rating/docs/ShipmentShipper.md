

# ShipmentShipper

Shipper container. Information associated with the UPS account number.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Shipper&#39;s name or company name.  Length is not validated. |  [optional] |
|**attentionName** | **String** | Shipper&#39;s attention name.  Length is not validated. |  [optional] |
|**shipperNumber** | **String** | Shipper&#39;s UPS account number.  A valid account number is required to receive negotiated rates. Optional otherwise. Cannot be present when requesting UserLevelDiscount. |  [optional] |
|**address** | [**ShipperAddress**](ShipperAddress.md) |  |  |




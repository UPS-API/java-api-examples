

# QueryRequestShipmentProduct

Container for the  the Product level. Must be in    the same order as in the QueryRequest.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**productName** | **String** | The name of the product |  [optional] |
|**productDescription** | **String** | The description of the product |  [optional] |
|**tariffInfo** | [**ProductTariffInfo**](ProductTariffInfo.md) |  |  |
|**productCountryCodeOfOrigin** | **String** | ISO country or territory code of the country or territory that the tariff    information belongs to. |  [optional] |
|**quantity** | [**ProductQuantity**](ProductQuantity.md) |  |  |
|**weight** | [**ProductWeight**](ProductWeight.md) |  |  [optional] |
|**unitPrice** | [**ProductUnitPrice**](ProductUnitPrice.md) |  |  |
|**tariffCodeAlert** | **String** | Contains the indicator for individual product element Tariff Code Alerts 0 &#x3D; true, send tariff code alerts for this products tariff code in the request 1 &#x3D; false, do not send tariff code alerts for this products tariff code in the request. This indicator setting is superseded by the TariffCodeAlert settings at the Global/Shipment level.  Note: Invalid values will result in the value being set to true. |  [optional] |




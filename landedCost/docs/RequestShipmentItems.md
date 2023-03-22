

# RequestShipmentItems


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**commodityId** | **String** | Commodity ID is used to associate tariffs with product in the output. Should be unique for each commodity in a request. It is an arbitrary string provided by the user of the API that will be returned with the Landed Cost Quote to indicate which commodity tariffs apply to. |  |
|**grossWeight** | **BigDecimal** | Specifies the gross weight of the commodity as any non-negative value. |  [optional] |
|**grossWeightUnit** | **String** | Specifies the units of the gross weight. Required if GrossWeight is used. If GrossWeight is not specified, this value must not be set to anything but null. Supported values: LB, KG |  [optional] |
|**priceEach** | **BigDecimal** | Specifies the price for each commodity unit in the settlement currency. The total price of the entire number of shipmentItems may not exceed 999999999999.99 |  |
|**commodityCurrencyCode** | **String** | Specifies the Currency Code used for commodity price. All commodities must have the same currency code. |  |
|**quantity** | **Integer** | Specifies the number of product units to be shipped. The total price of the entire number of shipmentItems may not exceed 999999999999.99, 1 or greater than 1 |  |
|**UOM** | **String** | Specify unit of measure. Check UOM List in the Appendices section |  |
|**hsCode** | **String** | Specifies a valid HS or HTS code for the shipment’s destination or import country. This field is required if description is not provided. Valid HTS Code with or without periods |  [optional] |
|**description** | **String** | This field is populated with description of the commodity. This field is required if hsCode is not provided. |  [optional] |
|**originCountryCode** | **String** | Country of Manufacture or origin. |  |




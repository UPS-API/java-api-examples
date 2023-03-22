

# LandedCostRequest

The root element for the Landed Cost document.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currencyCode** | **String** | Specifies the currency of transaction or purchase. |  |
|**transID** | **String** | Unique transaction ID for the request. |  |
|**allowPartialLandedCostResult** | **Boolean** | This is the optional flag to indicate that partial landed cost  calculations are acceptable to be used by upstream systems. When set to “false”, the system will return an error when at least  one commodity in the shipment is invalid (all or none); no results  will be sent back for that request. When set to “true”, the system will return partial calculations  when applicable Valid values: true &#x3D; Partial Landed Cost result will return false &#x3D; All or No result will return - (default) |  [optional] |
|**alversion** | **Integer** | Version number of the instance that processed this request. This must match the major number of the corresponding ICD version. |  |
|**shipment** | [**LandedCostRequestShipment**](LandedCostRequestShipment.md) |  |  |




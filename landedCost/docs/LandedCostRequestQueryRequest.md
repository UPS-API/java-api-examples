

# LandedCostRequestQueryRequest

Container for the billing and shipment data. Should be in the first round request of LandedCost. It cannot co-exist with EstimateRequest. If EstimateRequest is not present, this tag must be present.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**shipment** | [**QueryRequestShipment**](QueryRequestShipment.md) |  |  |
|**transactionReferenceID** | **String** | User reference ID. |  [optional] |
|**suppressQuestionIndicator** | **String** | Contains the indicator to suppress questions Y-Yes (suppress questions) N-No (do not suppress questions) If not set, defaults to �N� |  [optional] |




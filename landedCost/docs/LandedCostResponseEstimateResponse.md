

# LandedCostResponseEstimateResponse

Container for landed Cost quote. It cannot co-exist with QueryResponse. If QueryRespnse is not present, this tag must be present.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**transactionInfo** | [**EstimateResponseTransactionInfo**](EstimateResponseTransactionInfo.md) |  |  |
|**shipmentEstimate** | [**EstimateResponseShipmentEstimate**](EstimateResponseShipmentEstimate.md) |  |  |
|**suppressQuestionIndicator** | **String** | Contains the indicator to suppress questions Y-Yes (suppress questions) N-No (do not suppress questions) If not set, defaults to �N� |  [optional] |




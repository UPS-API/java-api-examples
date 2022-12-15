

# LandedCostResponseQueryResponse

Container for the question, used to give a more accurate landed cost quote. It cannot co-exist with EstimateResponse.  If EstimateRespnse is not present, this tag must be present.  QueryResponse can be returned up to twice before the landed cost quote is given.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**shipment** | [**QueryResponseShipment**](QueryResponseShipment.md) |  |  |
|**transactionDigest** | **String** | Encoded shipment parameters that are required in    LandedCostRequest/EstimateRequest. |  |
|**suppressQuestionIndicator** | **String** | Contains the indicator to suppress questions Y-Yes (suppress questions) N-No (do not suppress questions) If not set, defaults to �N� |  [optional] |




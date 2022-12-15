

# LandedCostRequestEstimateRequest

Container for the answers to the questions from the previous transaction.  Cannot be in the first round request of LandedCost. It cannot co-exist with QueryRequest. If QueryRequest is not present, this tag must be present.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**shipment** | [**EstimateRequestShipment**](EstimateRequestShipment.md) |  |  |
|**transactionDigest** | **String** | Encoded shipment parameters returned in    LandedCostResponse/QueryResponse |  |




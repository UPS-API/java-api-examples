

# AcceptanceAuditPreCheckResponse

Dangerous Goods Utility Response container for Acceptance Audit Pre-check.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**response** | [**AcceptanceAuditPreCheckResponseResponse**](AcceptanceAuditPreCheckResponseResponse.md) |  |  |
|**shipperNumber** | **String** | Shipper�s six digit account number. This is same account number present in the request that is played back in response. |  [optional] |
|**service** | [**AcceptanceAuditPreCheckResponseService**](AcceptanceAuditPreCheckResponseService.md) |  |  [optional] |
|**regulationSet** | **String** | The Regulatory set associated with every regulated shipment. This is same Regulation set present in the request that is played back in response.  Valid values: ADR 49CFR IATA TDG |  [optional] |
|**packageResults** | [**AcceptanceAuditPreCheckResponsePackageResults**](AcceptanceAuditPreCheckResponsePackageResults.md) |  |  [optional] |






# PushToImageRepositoryRequest

Paperless Document API request container for push to Image Repository.  N/A

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**request** | [**PushToImageRepositoryRequestRequest**](PushToImageRepositoryRequestRequest.md) |  |  |
|**shipperNumber** | **String** | The Shipper&#39;s UPS Account Number.  Your UPS Account Number must have &#39;Upload Forms Created Offline&#39; enabled to use this webservice. |  |
|**formsHistoryDocumentID** | [**PushToImageRepositoryRequestFormsHistoryDocumentID**](PushToImageRepositoryRequestFormsHistoryDocumentID.md) |  |  |
|**formsGroupID** | **String** | FormsGroupID would be required in Push Request if user needs to update uploaded DocumentID(s) in Forms History.  N/A |  [optional] |
|**shipmentIdentifier** | **String** | Shipment Identifier is required for this request.  N/A |  |
|**shipmentDateAndTime** | **String** | The date and time of the processed shipment. Required only for small package shipments. The valid format is yyyy-MM-dd-HH.mm.ss  N/A |  [optional] |
|**shipmentType** | **String** | Valid values are: 1 &#x3D; small package, 2 &#x3D; freight.  N/A |  |
|**prQConfirmationNumber** | **String** | PRQ Confirmation being specified by client. Required for freight shipments.  N/A |  [optional] |
|**trackingNumber** | **String** | UPS Tracking Number associated with this shipment. Required only for small package shipment.  N/A |  [optional] |




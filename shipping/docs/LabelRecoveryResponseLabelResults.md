

# LabelRecoveryResponseLabelResults

Container that stores the label results. Information containing the results of the user's Label Recovery Request.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**trackingNumber** | **String** | Package Tracking number.  Package 1Z number. Returned only if TrackingNumber or Combination of Reference Number and Shipper Number present in request. |  [optional] |
|**labelImage** | [**LabelResultsLabelImage**](LabelResultsLabelImage.md) |  |  [optional] |
|**mailInnovationsTrackingNumber** | **String** | Mail Innovations Tracking Number.  Applicable for Single Mail Innovations Returns and Dual Mail Innovations Returns shipment. Returned only if MailInnovationsTrackingNumber is provided in request. |  [optional] |
|**mailInnovationsLabelImage** | [**LabelResultsMailInnovationsLabelImage**](LabelResultsMailInnovationsLabelImage.md) |  |  [optional] |
|**receipt** | [**LabelResultsReceipt**](LabelResultsReceipt.md) |  |  [optional] |
|**form** | [**LabelResultsForm**](LabelResultsForm.md) |  |  [optional] |




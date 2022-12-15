

# LabelRecoveryRequest

Request for obtaining the Label for the return shipment.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**request** | [**LabelRecoveryRequestRequest**](LabelRecoveryRequestRequest.md) |  |  |
|**labelSpecification** | [**LabelRecoveryRequestLabelSpecification**](LabelRecoveryRequestLabelSpecification.md) |  |  [optional] |
|**translate** | [**LabelRecoveryRequestTranslate**](LabelRecoveryRequestTranslate.md) |  |  [optional] |
|**labelDelivery** | [**LabelRecoveryRequestLabelDelivery**](LabelRecoveryRequestLabelDelivery.md) |  |  [optional] |
|**trackingNumber** | **String** | Small Package Tracking Number. Required if Mail Innovations Tracking Number or ReferenceNumber/Value and ShipperNumber is not provided.  If only TrackingNumber is provided, the request will be treated as Small Package Shipment. Label Recovery will return label for Small Package Tracking Number. If both, TrackingNumber and MailInnovationsTrackingNumber are provided, the request will be treated as Dual Mail Innovations Return Shipment. Label Recovery will return two labels one each for - Small Package Tracking Number and Mail Innovations Return Tracking Number. |  [optional] |
|**mailInnovationsTrackingNumber** | **String** | Mail Innovations Tracking Number.  Required if Tracking Number or ReferenceNumber/Value is not populated.  If only MailInnovationsTrackingNumber is provided, the request will be treated as Single Mail Innovations Return Shipment. Label Recovery will return label for Mail Innovations Return Tracking Number. If both, TrackingNumber and MailInnovationsTrackingNumber are provided, the request will be treated as Dual Mail Innovations Return Shipment. Label Recovery will return two labels one each for - Small Package Tracking Number and Mail Innovations Return Tracking Number. |  [optional] |
|**referenceValues** | [**LabelRecoveryRequestReferenceValues**](LabelRecoveryRequestReferenceValues.md) |  |  [optional] |
|**locale** | **String** | Represents 5 character ISO Locale that allows the user to request Reference Number Code on Label, Label instructions, Receipt instructions (if available for given tracking number) and High Value Report (if available for given tracking number) in desired language.  Locale is specified by the combination of language code and country or territory code - 2 character language code and 2 character country code seperated by an underscore (&#39;_&#39;) character. Example - de_DE. Please refer to Appendix for supported values for Locale.  Either Translate container or Locale element can be present in a given request. Both can&#39;t be requested together in same request. |  [optional] |
|**upSPremiumCareForm** | [**LabelRecoveryRequestUPSPremiumCareForm**](LabelRecoveryRequestUPSPremiumCareForm.md) |  |  [optional] |




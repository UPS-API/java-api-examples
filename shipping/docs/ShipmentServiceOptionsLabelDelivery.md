

# ShipmentServiceOptionsLabelDelivery

Container for the Label Delivery accessorial. Note - LabelDelivery is not applicable for GFP and Mail Innovations Forward shipment.  Required for shipments with either Electronic Return Label Return Service or ImportControl Electronic LabelMethod type. Optional for shipments with Print Return Label Return Service or ImportControl Print LabelMethod type or Forward movement.  If this container is present for shipments with either Electronic Return Label Return Service or ImportControl Electronic LabelMethod type, either of the LabelLinksIndicator or EMail container should be provided. For shipments with Print Return Label Return Service or ImportControl Print LabelMethod type or Forward movement, only LabelLinksIndicator is valid option for LabelDelivery container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**email** | [**LabelDeliveryEMail**](LabelDeliveryEMail.md) |  |  [optional] |
|**labelLinksIndicator** | **String** | Indicates the Label and Receipt URLs are to be returned in the XML response. |  [optional] |




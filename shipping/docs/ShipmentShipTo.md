

# ShipmentShipTo

Ship To Container.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Consignee�s company name.  All other accounts must be either a daily pickup account or an occasional account. |  |
|**attentionName** | **String** | Contact name at the consignee�s location.  Required for: UPS Next Day Air� Early service, and when ShipTo country or territory is different than ShipFrom country or territory.   Required if Invoice International form is requested. |  [optional] |
|**companyDisplayableName** | **String** | Not applicable for ShipTo |  [optional] |
|**taxIdentificationNumber** | **String** | Consignee�s tax identification number. |  [optional] |
|**phone** | [**ShipToPhone**](ShipToPhone.md) |  |  [optional] |
|**faxNumber** | **String** | Consignee�s fax number.  If ShipTo country or territory is US 10 digits allowed, otherwise 1-15 digits allowed. |  [optional] |
|**emailAddress** | **String** | Consignee�s email address. |  [optional] |
|**address** | [**ShipToAddress**](ShipToAddress.md) |  |  |
|**locationID** | **String** | Location ID is a unique identifier referring to a specific shipping/receiving location.  Location ID must be alphanumeric characters. All letters must be capitalized. |  [optional] |




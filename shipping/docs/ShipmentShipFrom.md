

# ShipmentShipFrom

Ship From Container.  Required for return shipment.   Required if pickup location is different from the shipper�s address.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | The ship from location�s name or company name.  35 characters are accepted, but for return Shipment only 30 characters will be printed on the label.  Required if ShipFrom tag is in the XML. |  |
|**attentionName** | **String** | The ship from Attention name.  35 characters are accepted, but for return Shipment only 30 characters will be printed on the label.  Required if ShipFrom tag is in the XML and Invoice or CO International forms is requested. If not present, will default to the Shipper Attention Name. |  [optional] |
|**companyDisplayableName** | **String** | Not applicable for ShipFrom. |  [optional] |
|**taxIdentificationNumber** | **String** | Company�s Tax Identification Number at the pick up location.  Conditionally required if EEI form (International forms) is requested.  Applies to EEI Form only. |  [optional] |
|**taxIDType** | [**ShipFromTaxIDType**](ShipFromTaxIDType.md) |  |  [optional] |
|**phone** | [**ShipFromPhone**](ShipFromPhone.md) |  |  [optional] |
|**faxNumber** | **String** | The Ship from fax number.  If Ship from country or territory is US 10 digits allowed, otherwise 1-15 digits allowed. |  [optional] |
|**address** | [**ShipFromAddress**](ShipFromAddress.md) |  |  |
|**vendorInfo** | [**ShipFromVendorInfo**](ShipFromVendorInfo.md) |  |  [optional] |




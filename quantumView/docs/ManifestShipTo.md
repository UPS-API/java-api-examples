

# ManifestShipTo

Address and contact information describing the location where a return is to be delivered.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**shipperAssignedIdentificationNumber** | **String** | An identification number specified by shipper. |  [optional] |
|**companyName** | **String** | Consignee&#39;s company name. |  [optional] |
|**attentionName** | **String** | Contact name at the consignee&#39;s location. |  [optional] |
|**phoneNumber** | **String** | Consignee&#39;s Phone Number. US Phone numbers must be 10 digits. No formatting is allowed. Required if origin and destination countries or territories are different. |  [optional] |
|**taxIdentificationNumber** | **String** | Consignee&#39;s Tax Identification Number. |  [optional] |
|**faxNumber** | **String** | Consignee&#39;s Fax Number. US Fax numbers must be 10 digits. No formatting is allowed. Required if origin and destination countries or territories are different. |  [optional] |
|**emailAddress** | **String** | Consignee&#39;s email address. |  [optional] |
|**address** | [**ShipToAddress**](ShipToAddress.md) |  |  [optional] |
|**locationID** | **String** | Location name that the package is shipped to. |  [optional] |
|**receivingAddressName** | **String** | Alias of the location where the package is received. |  [optional] |




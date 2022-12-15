

# ShipmentShipper

Container for the Shipper�s information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Shippers company name.   For forward Shipment 35 characters are accepted, but only 30 characters will be printed on the label. |  |
|**attentionName** | **String** | Shippers Attention Name.   For forward Shipment 35 characters are accepted, but only 30 characters will be printed on the label.  Required if destination is international. Required if Invoice and CO International forms are requested and the ShipFrom address is not present. |  [optional] |
|**companyDisplayableName** | **String** | Shipper&#39;s CompanyDisplayableName.  The CompanyDisplayableName will be displayed in tracking results and notification messages in place of the name associated with the shipper account.  The original shipper account name will be displayed for all Return Services and Import Control Shipments.  This is available for Shipper accounts enabled by UPS and applies to Forward Shipments. |  [optional] |
|**taxIdentificationNumber** | **String** | Shipper�s Tax Identification Number.  Conditionally required if EEI form (International forms) is requested and ship From is not mentioned. |  [optional] |
|**phone** | [**ShipperPhone**](ShipperPhone.md) |  |  [optional] |
|**shipperNumber** | **String** | Shipper�s six digit alphanumeric account number.  Must be associated with the UserId specified in the AccessRequest XML.   The account must be a valid UPS account number that is active.   For US, PR and CA accounts, the account must be either a daily pickup account, an occasional account, or a customer B.I.N account.   Drop Shipper accounts are valid for return service shipments only if the account is Trade Direct (TD) enabled.   All other accounts must be either a daily pickup account or an occasional account. |  |
|**faxNumber** | **String** | Shipper�s Fax Number. |  [optional] |
|**emailAddress** | **String** | Shipper�s email address.  Must be associated with the UserId specified in the AccessRequest XML. |  [optional] |
|**address** | [**ShipperAddress**](ShipperAddress.md) |  |  |




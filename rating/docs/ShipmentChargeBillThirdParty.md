

# ShipmentChargeBillThirdParty

Container for the third party billing option.  This element or its sibling element, BillShipper, BillReceiver or Consignee Billed, must be present but no more than one can be present.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountNumber** | **String** | The UPS account number of the third party shipper.  The account must be a valid UPS account number that is active. For US, PR and CA accounts, the account must be either a daily pickup account, an occasional account, or a customer B.I.N account, or a drop shipper account. All other accounts must be either a daily pickup account, an occasional account, a drop shipper account, or a non-shipping account. |  |
|**address** | [**BillThirdPartyAddress**](BillThirdPartyAddress.md) |  |  |






# ShipmentChargeBillReceiver

Container for the BillReceiver billing option.  This element or its sibling element, BillShipper, BillThirdParty or Consignee Billed, must be present but no more than one can be present. For a return shipment, Bill Receiver is invalid for Transportation charges.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accountNumber** | **String** | The UPS account number.  The account must be a valid UPS account number that is active. For US, PR and CA accounts, the account must be a daily pickup account, an occasional account, a customer B.I.N account, or a dropper shipper account. All other accounts must be either a daily pickup account, an occasional account, a drop shipper account, or a non-shipping account. |  |
|**address** | [**BillReceiverAddress**](BillReceiverAddress.md) |  |  [optional] |




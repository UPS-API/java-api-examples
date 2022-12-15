

# PaymentDetailsShipmentCharge

Shipment charge container.  If Duty and Tax charges are applicable to a shipment and a payer is not specified, the default payer of Duty and Tax charges is Bill to Receiver. There will be no default payer of Duty and Tax charges for DDU and DDP service.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **String** | Values are 01 &#x3D; Transportation,� 02 &#x3D; Duties and Taxes |  |
|**billShipper** | [**ShipmentChargeBillShipper**](ShipmentChargeBillShipper.md) |  |  [optional] |
|**billReceiver** | [**ShipmentChargeBillReceiver**](ShipmentChargeBillReceiver.md) |  |  [optional] |
|**billThirdParty** | [**ShipmentChargeBillThirdParty**](ShipmentChargeBillThirdParty.md) |  |  [optional] |
|**consigneeBilledIndicator** | **String** | Consignee Billing payment option indicator. The presence indicates consignee billing option is selected. The absence indicates one of the other payment options is selected.  Empty Tag. This element or its sibling element, BillShipper, BillReceiver or BillThirdParty, must be present but no more than one can be present. This billing option is valid for a shipment charge type of Transportation only. Only applies to US/PR and PR/US shipment origins and destination. |  [optional] |






# ShipmentShipmentServiceOptions

Container for Shipment Service Options.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**saturdayDeliveryIndicator** | **String** | Saturday delivery indicator. The presence indicates Saturday delivery is requested and the absence indicates Saturday delivery is not requested.  This is an empty tag, any value inside is ignored. |  [optional] |
|**saturdayPickupIndicator** | **String** | Saturday pickup indicator. The presence indicates Saturday pickup is requested and the absence indicates Saturday pickup is not requested.  This is an empty tag, any value inside is ignored. |  [optional] |
|**COD** | [**ShipmentServiceOptionsCOD**](ShipmentServiceOptionsCOD.md) |  |  [optional] |
|**accessPointCOD** | [**ShipmentServiceOptionsAccessPointCOD**](ShipmentServiceOptionsAccessPointCOD.md) |  |  [optional] |
|**deliverToAddresseeOnlyIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored. DeliverToAddresseeOnlyIndicator is shipper specified restriction that requires the addressee to be the one who takes final delivery of the \&quot;Hold For PickUp at UPS Access Point\&quot; package.� Presence of indicator means shipper restriction will apply to the shipment.  Only valid for Shipment Indication type \&quot;01 - Hold For PickUp at UPS Access Point\&quot;. |  [optional] |
|**directDeliveryOnlyIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored. Direct Delivery Only (DDO) accessorial in a request would ensure that delivery is made only to the ship to address on the shipping label.  This accessorial is not valid with Shipment Indication Type \&quot;01 - Hold For Pickup At UPS Access Point\&quot; and \&quot;02 - UPS Access Point� Delivery\&quot;. |  [optional] |
|**notification** | [**ShipmentServiceOptionsNotification**](ShipmentServiceOptionsNotification.md) |  |  [optional] |
|**labelDelivery** | [**ShipmentServiceOptionsLabelDelivery**](ShipmentServiceOptionsLabelDelivery.md) |  |  [optional] |
|**internationalForms** | [**ShipmentServiceOptionsInternationalForms**](ShipmentServiceOptionsInternationalForms.md) |  |  [optional] |
|**deliveryConfirmation** | [**ShipmentServiceOptionsDeliveryConfirmation**](ShipmentServiceOptionsDeliveryConfirmation.md) |  |  [optional] |
|**returnOfDocumentIndicator** | **String** | The flag indicates the ReturnOfDocument accessorial has been requested.  Valid for Poland to Poland forward shipment only. |  [optional] |
|**importControlIndicator** | **String** | Indicates that the Shipment is an ImportControl shipment. |  [optional] |
|**labelMethod** | [**ShipmentServiceOptionsLabelMethod**](ShipmentServiceOptionsLabelMethod.md) |  |  [optional] |
|**commercialInvoiceRemovalIndicator** | **String** | CommercialInvoiceRemovalIndicator allows a shipper to dictate UPS to remove the Commercial Invoice from the user&#39;s shipment before the shipment is delivered to the ultimate consignee. |  [optional] |
|**upScarbonneutralIndicator** | **String** | UPS carbon neutral indicator presence at shipment level is required to create carbon neutral Shipments. |  [optional] |
|**preAlertNotification** | [**ShipmentServiceOptionsPreAlertNotification**](ShipmentServiceOptionsPreAlertNotification.md) |  |  [optional] |
|**exchangeForwardIndicator** | **String** | Exchange forward indicator presence at shipment level is required to create exchange forward Shipments.  In the label routing Instruction text will be defaulted to \&quot;EXCHANGE-LIKE ITEM ONLY\&quot;. |  [optional] |
|**holdForPickupIndicator** | **String** | Hold For Pickup indicator. The empty tag means indicator is present.  This accessorial is only valid for UPS Worldwide Express Freight and UPS Worldwide Express Freight Midday Shipment. |  [optional] |
|**dropoffAtUPSFacilityIndicator** | **String** | Drop off At UPS Facility indicator. The empty tag means indicator is present.  This accessorial is only valid for UPS Worldwide Express Freight and UPS Worldwide Express Freight Midday Shipment. |  [optional] |
|**liftGateForPickUpIndicator** | **String** | Lift Gate For Pick Up indicator. The empty tag means indicator is present.  Lift Gate for Pickup is not allowed with Drop Off At UPS Facility for a UPS Worldwide Express Freight and UPS Worldwide Express Freight Midday shipment.   When both Hold for Pickup and Drop Off At Facility are selected, neither of the Lift Gate accessorial (Pick Up or Delivery) are allowed for a UPS Worldwide Express Freight and UPS Worldwide Express Freight Midday shipment.   This accessorial is only valid for UPS Worldwide Express Freight and UPS Worldwide Express Freight Midday Shipment. |  [optional] |
|**liftGateForDeliveryIndicator** | **String** | Lift Gate For Delivery indicator. The empty tag means indicator is present.  Lift Gate for Delivery is not allowed with Hold For Pickup for a UPS Worldwide Express Freight and UPS Worldwide Express Freight Midday shipment.   When both Hold for Pickup and Drop Off At UPS Facility are selected, neither of the Lift Gate accessorial (Pick Up or Delivery) are allowed for a UPS Worldwide Express Freight and UPS Worldwide Express Freight Midday shipment.   This accessorial is only valid for UPS Worldwide Express Freight and UPS Worldwide Express Freight Midday Shipment. |  [optional] |
|**sdLShipmentIndicator** | **String** | The presence of the tag SDLShipmentIndicator indicates Shipment is SDL. SDLShipmentIndicator presence means EEI form/ EEI Filing option required. |  [optional] |
|**epRAReleaseCode** | **String** | Package Release code allows the consignee or claimant to pick-up a package at a UPS Access Point�.� The shipper must provide the Package Release Code to the consignee so that they can provide the code to the UPS Access Point personnel as another item for authentication before the package is released to them. Package Release Code is only valid with ShipmentIndicationType�01 - Hold for Pickup at UPS Access Point�.  The release code must be between length 4 and 6 and only contain numbers. |  [optional] |
|**restrictedArticles** | [**ShipmentServiceOptionsRestrictedArticles**](ShipmentServiceOptionsRestrictedArticles.md) |  |  [optional] |
|**insideDelivery** | **String** | Inside delivery accessory. Valid values: 01 - White Glove 02 - Room of Choice 03 - Installation Default is Room of Choice.  Shippers account needs to have a valid contract for Heavy Goods Service. |  [optional] |
|**itemDisposal** | **String** | Presence/Absence indicator. True if present; false otherwise. Any value is ignored. If present, indicates that the customer would like items disposed.  Shippers account needs to have a valid contract for Heavy Goods Service. |  [optional] |




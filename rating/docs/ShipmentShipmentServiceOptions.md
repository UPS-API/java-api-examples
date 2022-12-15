

# ShipmentShipmentServiceOptions

Shipment level Accessorials are included in this container.  N/A

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**saturdayPickupIndicator** | **String** | A flag indicating if the shipment requires a Saturday pickup. True if SaturdayPickupIndicator tag exists; false otherwise. Not available for GFP rating requests.  Empty Tag. |  [optional] |
|**saturdayDeliveryIndicator** | **String** | A flag indicating if a shipment must be delivered on a Saturday. True if SaturdayDeliveryIndicator tag exists; false otherwise  Empty Tag. |  [optional] |
|**sundayDeliveryIndicator** | **String** | A flag indicating if a shipment must be delivered on a Sunday. True if SundayDeliveryIndicator tag exists; false otherwise  Empty Tag. |  [optional] |
|**availableServicesOption** | **String** | If we need diferent available services in response, this option is used for shop request option. SaturdayDeliveryIndicator/ SundayDeliveryIndicator will be ignored in that case.  Valid Values: 1- Weekday+Saturday services 2- Weekday+Sunday services 3- Weekday+Sat services+Sun services |  [optional] |
|**accessPointCOD** | [**ShipmentServiceOptionsAccessPointCOD**](ShipmentServiceOptionsAccessPointCOD.md) |  |  [optional] |
|**deliverToAddresseeOnlyIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored.   DeliverToAddresseeOnlyIndicator is shipper specified restriction that requires the addressee to be the one who takes final delivery of the \&quot;Hold For PickUp at UPS Access Point\&quot; package.    Presence of indicator means shipper restriction will apply to the shipment.  Only valid for Shipment Indication type \&quot;01 - Hold For PickUp at UPS Access Point\&quot;. |  [optional] |
|**directDeliveryOnlyIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored. Direct Delivery Only (DDO) accessorial in a request would ensure that delivery is made only to the Ship To address on the shipping label.  This accessorial is not valid with Shipment Indication Types: 01 - Hold For Pickup At UPS Access Point 02 - UPS Access Point� Delivery\&quot; |  [optional] |
|**COD** | [**ShipmentServiceOptionsCOD**](ShipmentServiceOptionsCOD.md) |  |  [optional] |
|**deliveryConfirmation** | [**ShipmentServiceOptionsDeliveryConfirmation**](ShipmentServiceOptionsDeliveryConfirmation.md) |  |  [optional] |
|**returnOfDocumentIndicator** | **String** | Return of Documents Indicator - If the flag is present, the shipper has requested the ReturnOfDocument accessorial be added to the shipment  Valid for Poland to Poland shipment. |  [optional] |
|**upScarbonneutralIndicator** | **String** | UPS carbon neutral indicator. Indicates the shipment will be rated as carbon neutral. |  [optional] |
|**certificateOfOriginIndicator** | **String** | The empty tag in request indicates that customer would be using UPS prepared SED form.  Valid for UPS World Wide Express Freight shipments. |  [optional] |
|**pickupOptions** | [**ShipmentServiceOptionsPickupOptions**](ShipmentServiceOptionsPickupOptions.md) |  |  [optional] |
|**deliveryOptions** | [**ShipmentServiceOptionsDeliveryOptions**](ShipmentServiceOptionsDeliveryOptions.md) |  |  [optional] |
|**restrictedArticles** | [**ShipmentServiceOptionsRestrictedArticles**](ShipmentServiceOptionsRestrictedArticles.md) |  |  [optional] |
|**shipperExportDeclarationIndicator** | **String** | The empty tag in request indicates that customer would be using UPS prepared SED form.  Valid for UPS World Wide Express Freight shipments. |  [optional] |
|**commercialInvoiceRemovalIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored.  CommercialInvoiceRemovalIndicator - empty tag means indicator is present.  CommercialInvoiceRemovalIndicator allows a shipper to dictate that UPS remove the Commercial Invoice from the user&#39;s shipment before the shipment is delivered to the ultimate consignee. |  [optional] |
|**importControl** | [**ShipmentServiceOptionsImportControl**](ShipmentServiceOptionsImportControl.md) |  |  [optional] |
|**returnService** | [**ShipmentServiceOptionsReturnService**](ShipmentServiceOptionsReturnService.md) |  |  [optional] |
|**sdLShipmentIndicator** | **String** | Empty Tag means the indicator is present. This field is a flag to indicate if the receiver needs SDL rates in response. True if SDLShipmentIndicator tag exists; false otherwise.  If present, the State Department License (SDL) rates will be returned in the response.  This service requires that the account number is enabled for SDL. |  [optional] |
|**epRAIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored. This field is a flag to indicate Package Release Code is requested for shipment.  This accessorial is only valid with ShipmentIndicationType �01� - Hold for Pickup at UPS Access Point�. |  [optional] |
|**insideDelivery** | **String** | Inside Delivery accessory. Valide values:                                         01- White Glove                        02 - Room of Choice                   03 - Installation  Shippers account needs to have a valid contract for Heavy Goods Service. |  [optional] |
|**itemDisposalIndicator** | **String** | Presence/Absence Indicator. Any value inside is ignored. If present, indicates that the customer would like items disposed.   Shippers account needs to have a valid contract for Heavy Goods Service. |  [optional] |




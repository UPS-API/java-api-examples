

# SubscriptionFileManifest

Container represents all data that is relevant for the shipment, such as origin, destination, shipper, payment method etc. It will be return when available.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**shipper** | [**ManifestShipper**](ManifestShipper.md) |  |  |
|**shipTo** | [**ManifestShipTo**](ManifestShipTo.md) |  |  |
|**referenceNumber** | [**List&lt;ManifestReferenceNumber&gt;**](ManifestReferenceNumber.md) |  |  [optional] |
|**service** | [**ManifestService**](ManifestService.md) |  |  [optional] |
|**pickupDate** | **String** | Should be set equal to the date on while the packages were picked up (may be prior days date if the transmission occurs after midnight). Formatted as YYYYMMDD. |  [optional] |
|**scheduledDeliveryDate** | **String** | The date the shipment originally was scheduled for delivery. Formatted as YYYYMMDD. |  [optional] |
|**scheduledDeliveryTime** | **String** | Schedule delivery time. Time format is HHMMSS |  [optional] |
|**documentsOnly** | **String** | If the tag is present then the shipment is a document, otherwise the shipment is a non-document.  Valid values:�  1 &#x3D; Letter 2 &#x3D; Document (Non-Letter Document) 3 &#x3D; Non-Document 4 &#x3D; Pallet |  [optional] |
|**_package** | [**List&lt;ManifestPackage&gt;**](ManifestPackage.md) |  |  [optional] |
|**shipmentServiceOptions** | [**ManifestShipmentServiceOptions**](ManifestShipmentServiceOptions.md) |  |  [optional] |
|**manufactureCountry** | **String** | Country or Territory  of Manufacture of the contents of the package. |  [optional] |
|**harmonizedCode** | **String** | Harmonized code of the package. |  [optional] |
|**customsValue** | [**ManifestCustomsValue**](ManifestCustomsValue.md) |  |  [optional] |
|**specialInstructions** | **String** | User-defined special instructions for delivery. |  [optional] |
|**shipmentChargeType** | **String** | Shipment charge type. Valid values: C/F - Cost and Freight C/B - Consignee Billed Package F/C - Freight Collect DDP - Delivered Duty Paid VAT Unpaid FOB - Free On Board P/P - Prepaid F/D - Free Domicile T/P - Third Party Billing |  [optional] |
|**billToAccount** | [**ManifestBillToAccount**](ManifestBillToAccount.md) |  |  [optional] |
|**consigneeBillIndicator** | **String** | Indicates if consignee will be billed the shipment. |  |
|**collectBillIndicator** | **String** | Indicates whether or not to collect bill at time of delivery. |  |
|**locationAssured** | **String** | Indicates Location Assured Values: Y - Location Assured accessorial requested |  [optional] |
|**importControl** | **String** | Import Control Indication is used to designate that the shipment is an Import Control shipment. If the shipment is an import control shipment then this element will have value. For no import shipment this will not be appear |  [optional] |
|**labelDeliveryMethod** | **String** | Indicates Label Delivery Method, Values are: LDE Electronic Label .LDO One Attempt. LDP Print Label. LDT Three Attempt. LPM� Print and Mail Label. |  [optional] |
|**commercialInvoiceRemoval** | **String** | Commercial Invoice Removal (CIR) is an accessorial or indication that will allow a shipper to dictate that UPS remove the Commercial Invoice from the user&#39;s shipment before the shipment is delivered to the ultimate consignee. If shipment is CIR then this element will have value. For no CIR this element will not be appear |  [optional] |
|**postalServiceTrackingID** | **String** | Postal Service Tracking ID transport company tracking number. |  [optional] |
|**returnsFlexibleAccess** | **String** | (RFA) UPS returns flexible access. This element will appear with value only when returns flexible access uploaded. For no returns flexible access this element will not be appear |  [optional] |
|**upScarbonneutral** | **String** | UPS carbon neutral is a term used to reflect a generic term for the tagging to be included on any document, label, e-mail, etc. used to identify that the UPS carbon neutral fee is applied. This element will appear only when shipment is UPS carbon neutral with value. For non UPS carbon neutral shipping this element appear. |  [optional] |
|**product** | **String** | This element will have value �PAC� for CAR shipments. For no CAR shipments this element will not be appeared. |  [optional] |
|**upSReturnsExchange** | **String** | UPS Return and Exchange � This element will appear with value Y only when UPS Return and Exchange was requested. For no UPS Returns and Exchange then this element will not be appeared |  [optional] |
|**liftGateOnDelivery** | **String** | Lift Gate On Delivery - This element will appear only when Lift Gate For Delivery was requested for UPS World Wide Express Freight Shipments. If no Lift Gate for Delivery was requested, this element will not appear. |  [optional] |
|**liftGateOnPickUp** | **String** | Lift Gate On PickUp - This element will appear only when Lift Gate For PickUp was requested for UPS World Wide Express Freight Shipments. If no Lift Gate for PickUp was requested, this element will not appear. |  [optional] |
|**pickupPreference** | **String** | Pickup Preference -This element will appear only when Dropoff At UPS Facility was requested for UPS World Wide Express Freight Shipments. If no Dropoff At UPS Facility was requested, this element will not appear. |  [optional] |
|**deliveryPreference** | **String** | Delivery Preference - This element will appear only when Hold for pick up was requested for UPS World Wide Express Freight Shipments. If no Hold for pick up was requested, this element will not appear. |  [optional] |
|**holdForPickupAtUPSAccessPoint** | **String** | \&quot;Y\&quot; Indicates Shipment is Direct to Retail. |  [optional] |
|**uaPAddress** | [**ManifestUAPAddress**](ManifestUAPAddress.md) |  |  [optional] |
|**deliverToAddresseeOnlyIndicator** | **String** | \&quot;Y\&quot; Indicates Shipment is Deliver to Addressee. |  [optional] |
|**upSAccessPointCODIndicator** | **String** | \&quot;Y\&quot; Indicates Shipment is Cash on Delivery in Direct to Retail |  [optional] |
|**clinicalTrialIndicator** | **String** | An accessorial Indicator flag: Y &#x3D; Clinical Trial accessorial provided in Manifest. Spaces &#x3D; Clinical Trial accessorial not provided in Manifest. |  [optional] |
|**clinicalTrialIndicationNumber** | **String** | An unique Clinical Trial associated with the shipment provided in Manifest. |  [optional] |
|**categoryAHazardousIndicator** | **String** | An accessorial Indicator flag: Y &#x3D; Category A Hazardous materials accessorial provided in Manifest. Spaces &#x3D; Category A Hazardous materials accessorial not provided in Manifest. |  [optional] |
|**directDeliveryIndicator** | **String** | An accessorial Indicator flag: Y &#x3D; Direct Delivery accessorisal provided in Manifest. Spaces &#x3D; Direct Delivery accessorial not provided in Manifest. |  [optional] |
|**packageReleaseCodeIndicator** | **String** | \&quot;Y\&quot; indicates Shipment has PackageReleaseCode Accessorial. |  [optional] |
|**proactiveResponseIndicator** | **String** | \&quot;Y\&quot; indicates that a UPS Proactive Response Accessorial is provided. |  [optional] |
|**whiteGloveDeliveryIndicator** | **String** | \&quot;Y\&quot; indicates that a Heavy Goods White Glove Delivery Accessorial is provided. |  [optional] |
|**roomOfChoiceIndicator** | **String** | \&quot;Y\&quot; indicates that a Heavy Goods Room of Choice Accessorial is provided. |  [optional] |
|**installationDeliveryIndicator** | **String** | \&quot;Y\&quot; indicates that a Heavy Goods Installation Delivery Accessorial is provided. |  [optional] |
|**itemDisposalIndicator** | **String** | \&quot;Y\&quot; indicates that a Heavy Goods Item Disposal Accessorial is provided. |  [optional] |
|**leadShipmentTrackingNumber** | **String** | Lead Tracking Number in shipment |  [optional] |
|**saturdayNonPremiumCommercialDeliveryIndicator** | **String** | \&quot;Y\&quot;  indicates that a SaturdayNonPremiumCommercialDeliveryIndicator is provided. |  [optional] |
|**sundayNonPremiumCommercialDeliveryIndicator** | **String** | \&quot;Y\&quot;  indicates that a SundayNonPremiumCommercialDeliveryIndicator is provided. |  [optional] |
|**upSPremierAccessorialIndicator** | **String** | �Y� indicates that the UPS Premier accessorial is provided. |  [optional] |
|**upSPremierCategoryCode** | **String** | Indicates the UPS Premier category applied to the package Valid values: &#39;PRS&#39; � UPS Premier Silver, &#39;PRG&#39; � UPS Premier Gold, &#39;PRP&#39; - UPS Premier Platinum |  [optional] |




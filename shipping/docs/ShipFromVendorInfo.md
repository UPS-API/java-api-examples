

# ShipFromVendorInfo

Vendor Information Container

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**vendorCollectIDTypeCode** | **String** | Code that identifies the type of Vendor Collect ID Number                                                                   Valid Values                                                                   0356 &#x3D; IOSS                                                 0357 &#x3D; VOEC                                                 0358 &#x3D; HMRC                                                    Vendor Collect ID Number type code will be printed on commercial invoice if present. |  |
|**vendorCollectIDNumber** | **String** | Shipper�s VAT Tax collection registration number to be entered by Shipper at time of shipment creation.   Presence of this number as part of the shipment information implies the shipper has collected/paid the required VAT tax (outside of UPS/UPS systems).  Vendor Colect ID Number will be printed on commercial invoice if present.                                   Sample Values:   �IMDEU1234567� (IOSS #),  �VOEC1234567� (VOEC #),  �GB1234567� (HMRC #)     Required if the shipment is subject to Vendor Collect ID collection |  |
|**consigneeType** | **String** | Consignee Type.                                             01 &#x3D; Business                                                 02 &#x3D; Consumer                                                           NA &#x3D; Not Applicable |  [optional] |




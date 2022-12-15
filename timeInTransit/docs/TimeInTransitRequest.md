

# TimeInTransitRequest

N/A

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**originCountryCode** | **String** | The country code of the origin shipment.   Valid Values:   Must conform to the ISO-defined country codes.  Refer to Country or Territory Codoes in the Appendix for valid values. |  |
|**originStateProvince** | **String** | The shipment origin state or province.  For U.S. addresses, the value must be a valid 2-character value (per U.S. Mail standards)   For non-U.S. addresses the full State or Province name should be provided. |  [optional] |
|**originCityName** | **String** | Required for International requests for those countries that do not utilize postal codes.  The shipment origin city. |  [optional] |
|**originTownName** | **String** | The shipment origin town.  Town is a subdivision of city. |  [optional] |
|**originPostalCode** | **String** | Required for Domestic requests.  The shipment origin postal code.    Either 5- or 9- digit US zip codes must be used for U.S. addresses.  For non-U.S. addresses, this is recommended for all countries that utilize postal codes. |  [optional] |
|**destinationCountryCode** | **String** | The country code of the destination.    Valid values:   Must conform to ISO-defined country codes. |  [optional] |
|**destinationStateProvince** | **String** | The shipment destination state or province.  For U.S. addresses, the value must be a valid 2-character value (per U.S. Mail standards).    For non-U.S. addresses the full State or Province name should be provided. |  [optional] |
|**destinationCityName** | **String** | Required for International Requests for those countries that do not utilize postal codes. The shipment destination city. |  [optional] |
|**destinationTownName** | **String** | The shipment destination town.  Town is a subdivision of city. |  [optional] |
|**destinationPostalCode** | **String** | The shipment destination postal code.    Required for Domestic requests. Either 5- or 9-digit U.S. zip codes must be used for U.S. addresses.  For non-U.S. addresses, this is recommended for all countries that utilize postal codes. |  [optional] |
|**residentialIndicator** | **String** | Required for Domestic requests.     Valid values: \&quot;01\&quot;, \&quot;02\&quot;   01 &#x3D; Residential   02 &#x3D; Commercial     Defaults to commercial for International Requests. |  [optional] |
|**shipDate** | **String** | The date the shipment is tendered to UPS for shipping (can be dropped off at UPS or picked up by UPS).  This date may or may not be the UPS business date.  Format is YYYY-MM-DD.  YYYY &#x3D; 4 digit year; MM &#x3D; 2 digit month, valid values 01-12; DD &#x3D; 2 digit day of month, valid values 01-31   If no value is provided, defaults to current system date. |  [optional] |
|**shipTime** | **String** | The time the shipment is tendered to UPS for shipping (can be dropped off at UPS or picked up by UPS).    Format is HH:MM:SS |  [optional] |
|**weight** | **BigDecimal** | Required for International requests.  The weight of the shipment.     Note: If decimal values are used, valid values will be rounded to the tenths.      Note: Maximum value is 70 kilograms or 150 pounds. |  [optional] |
|**weightUnitOfMeasure** | **String** | Required for International requests and when weight value is provided.     Valid Values: \&quot;LBS\&quot;, \&quot;KGS\&quot; |  [optional] |
|**shipmentContentsValue** | **BigDecimal** | The monetary value of shpment contents.     Required when origin country does not equal destination country and BillType is 03 (non-documented) or 04 (WWEF)     Required when origin country does not equal destination country, and destination country &#x3D; CA, and BIllType &#x3D; 02 (document).     Note: If decimal values are used, valid values will be rounded to the tenths. |  [optional] |
|**shipmentContentsCurrencyCode** | **String** | Required if ShipmentContentsValue is populated.  The unit of currency used for values.    Valid value: must conform to ISO standards. |  [optional] |
|**billType** | **String** | Required for International Requests.   Valid values: \&quot;02\&quot;,\&quot;03\&quot;,\&quot;04\&quot;   02 - Document   03 - Non Document   04 - WWEF (Pallet) |  [optional] |
|**avvFlag** | **Boolean** | Used to bypass address validation when the address has already been validated by the calling application.      Valid values: true, false     Defaults to true   Note: not to be exposed to external customers. |  [optional] |
|**numberOfPackages** | **Integer** | Sets the number of packages in shipment.  Default value is 1. |  [optional] |
|**dropOffAtFacilityIndicator** | **Integer** | Sets the indicator for an international Freight Pallet shipment that is going to be dropped off by shipper to a UPS facility.  The indicator is used when the Bill Type is \&quot;04\&quot;.      Valid values: \&quot;0\&quot;, \&quot;1\&quot;.     0 &#x3D; WWDTProcessIF.PICKUP_BY_UPS   1 &#x3D; WWDTProcessIf.DROPOFF_BY_SHIPPER     The default value is \&quot;0\&quot;  |  [optional] |
|**holdForPickupIndicator** | **Integer** | Sets the indicator for an international Freight Pallet shipment that is going to be pick-up by consignee in a destination facility.  The indicator is used when the Bill Type is \&quot;04\&quot;.      Valid values: \&quot;0\&quot;, \&quot;1\&quot;.     0 &#x3D; WWDTProcessIF.DELIVERY_BY_UPS   1 &#x3D; WWDTProcessIf.PICKUP_BY_CONSIGNEE     The default value is \&quot;0\&quot;  |  [optional] |
|**returnUnfilterdServices** | **Boolean** | Used to get back a full list of services - bypassing current WWDT business rules to remove services from the list being returned to clients for US domestic that are slower than UPS Ground.      Default value is false. |  [optional] |
|**maxList** | **Integer** | Sets the limit for the number of candidates returned in candidate list.      Default value is 200. |  [optional] |




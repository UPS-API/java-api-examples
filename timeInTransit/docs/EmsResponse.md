

# EmsResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**shipDate** | **String** | The date the shipment is tendered to UPS for shipping (can be dropped off at UPS or picked up by UPS).  This date may or may not be the UPS business date.     Valid Format: YYYY-MM-DD |  |
|**shipTime** | **String** | The time the shipment is tendered to UPS for shipping (can be dropped off at UPS or picked up by UPS).      Valid Format: HH:MM:SS |  |
|**serviceLevel** | **String** | Service Levels being returned.     A &#x3D; all service levels.     Blank is the default for all Service Level values. |  |
|**billType** | **String** | Represents the shipment type.     Valid values: \&quot;02\&quot;,\&quot;03\&quot;,\&quot;04\&quot;,\&quot;07\&quot;   02 - Document   03 - Non-Document   04 - WWEF   07 - Pallet |  |
|**dutyType** | **String** | Populated with valid duty types for international transactions only.      Valid Duty Types: \&quot;01\&quot;,\&quot;02\&quot;,\&quot;03\&quot;,\&quot;04\&quot;,\&quot;05\&quot;,\&quot;06\&quot;,\&quot;07\&quot;,\&quot;08\&quot;,\&quot;09\&quot;   01 - Dutiable   02 - Non Dutiable   03 - Low Value   04 - Courier Remission   05 - Gift   06 - Military   07 - Exception   08 - Line Release   09 - Low Value |  [optional] |
|**residentialIndicator** | **String** | residential Indicator that was sent in on the request.     Valid values: \&quot;01\&quot;,\&quot;02\&quot;     01 - Residential   02 - Commercial |  |
|**destinationCountryName** | **String** | Destination country name value |  |
|**destinationCountryCode** | **String** | Destination country code, conforms to ISO-defined country codes. |  |
|**destinationPostalCode** | **String** | The shipment destination postal code.  Required for US domestic requests.     Either 5- or 9-digit US zip codes must be used for U.S. addresses.  For non-US addresses, this is recommended for all countries that utilize postal codes. |  [optional] |
|**destinationPostalCodeLow** | **String** | The shipment destination postal code low range.  Value may or may not differ from destinationPostalCode.      Either 5- or 9-digit US zip codes must be used for U.S. addresses.  For non-US addresses, this is recommended for all countries that utilize postal codes. |  [optional] |
|**destinationPostalCodeHigh** | **String** | The shipment destination postal code high range.  Value may or may not differ from destinationPostalCode.      Either 5- or 9-digit US zip codes must be used for U.S. addresses.  For non-US addresses, this is recommended for all countries that utilize postal codes. |  [optional] |
|**destinationStateProvince** | **String** | The shipment destination state or province.     For U.S. addresses, the value will be a valid 2-Character value (per U.S. Mail Standards).     For non-U.S. addresses the full State or Province name will be returned. |  [optional] |
|**destinationCityName** | **String** | The shipment destination city.     Required for International requests for thsoe countries that do not utilize postal codes. |  [optional] |
|**originCountryName** | **String** | Origin country name value |  |
|**originCountryCode** | **String** | Origin country code, conforms to ISO-defined country codes. |  |
|**originPostalCode** | **String** | The shipment origin postal code.  Required for US domestic requests.     Either 5- or 9-digit US zip codes must be used for U.S. addresses.  For non-US addresses, this is recommended for all countries that utilize postal codes. |  [optional] |
|**originPostalCodeLow** | **String** | The shipment origin postal code low range.  Value may or may not differ from destinationPostalCode.      Either 5- or 9-digit US zip codes must be used for U.S. addresses.  For non-US addresses, this is recommended for all countries that utilize postal codes. |  [optional] |
|**originPostalCodeHigh** | **String** | The shipment origin postal code high range.  Value may or may not differ from destinationPostalCode.      Either 5- or 9-digit US zip codes must be used for U.S. addresses.  For non-US addresses, this is recommended for all countries that utilize postal codes. |  [optional] |
|**originStateProvince** | **String** | The shipment origin state or province.     For U.S. addresses, the value will be a valid 2-Character value (per U.S. Mail Standards).     For non-U.S. addresses the full State or Province name will be returned. |  [optional] |
|**originCityName** | **String** | The shipment origin city.     Required for International requests for thsoe countries that do not utilize postal codes. |  [optional] |
|**weight** | **String** | Shipment weight.  Value is only requried for international shipment.      Defaults to 0.0 |  [optional] |
|**weightUnitOfMeasure** | **String** | Returned on response when weight was present on the request. |  [optional] |
|**shipmentContentsValue** | **String** | Shipment contents value. Value is only required for international shipment.     Defaults to 0.0 |  [optional] |
|**shipmentContentsCurrencyCode** | **String** | Returned on response when shipmentContentsValue was present on the request. |  [optional] |
|**guaranteeSuspended** | **Boolean** | Returns TRUE if the shipment dates fall within a defined peak date range. When the guarantee is suspended, it is suspended for all services in the response.      The logic for determining if guarantees are suspended applies per origin country.     The following wil be used to determine if a shipment falls within a defined peak date range: shipDate (from the response), deliveryDate (from the response), server Date.     Defined peak date range (range for when guarantees are suspended) is inclusive of start and end dates. |  |
|**numberOfServices** | **Integer** | Number of services being returned in the services array. |  |
|**services** | [**List&lt;Services&gt;**](Services.md) |  |  [optional] |




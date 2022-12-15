

# ShipperAddress

Address Container.  If the ShipFrom container is not present then this address will be used as the ShipFrom. If this address is used as the ShipFrom, the shipment will be rated from this origin address.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addressLine** | **String** | The UPS Access Point&#39;s street address, including name and number (when applicable).  Length is not validated. |  |
|**city** | **String** | UPS Access Point city. |  [optional] |
|**stateProvinceCode** | **String** | UPS Access Point State or Province code. |  [optional] |
|**postalCode** | **String** | Postal Code for UPS accounts billing address.  Postal Code  may be present when the FRS Payment Information type &#x3D; 02 and type &#x3D; 03. |  [optional] |
|**countryCode** | **String** | Country or Territory code for the  UPS accounts &amp; billing address.  Country or Territory Code is required when the FRS Payment Information type &#x3D; 02 and type&#x3D; 03. |  |




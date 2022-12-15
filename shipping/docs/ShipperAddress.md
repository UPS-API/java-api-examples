

# ShipperAddress

Address tag Container.  The package should be returned to this address if the package is undeliverable.�   This address appears on the upper left hand corner of the label.  Note: If the ShipFrom container is not present then this address will be used as the ShipFrom address.�  If this address is used as the ShipFrom the shipment will be rated from this origin address.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**addressLine** | **String** | SoldTo location�s street address.  Applies to NAFTA CO. |  |
|**city** | **String** | SoldTo location�s city. |  |
|**stateProvinceCode** | **String** | SoldTo location�s state or province code.  Required for certain countries or territories. |  [optional] |
|**postalCode** | **String** | SoldTo location�s postal code. |  [optional] |
|**countryCode** | **String** | SoldTo location�s country or territory code. |  |




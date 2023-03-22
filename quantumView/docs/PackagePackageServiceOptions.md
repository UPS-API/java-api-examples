

# PackagePackageServiceOptions

Defines service options used for the package(s).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**COD** | [**PackageServiceOptionsCOD**](PackageServiceOptionsCOD.md) |  |  [optional] |
|**insuredValue** | [**PackageServiceOptionsInsuredValue**](PackageServiceOptionsInsuredValue.md) |  |  [optional] |
|**earliestDeliveryTime** | **String** | Earliest delivery time. Time format is HHMMSS. |  [optional] |
|**hazardousMaterialsCode** | **String** | Indicates if the package contains hazardous materials.  Valid values:  1 - Hazardous Material 2 - Electronically billed hazardous material.� If present, only one package may exist in the shipment. |  [optional] |
|**holdForPickup** | **String** | A flag indicating if a package should be held for pickup. True if tag exists, false otherwise. |  |
|**addShippingChargesToCODIndicator** | **String** | An indicator flag that represents a Collect on Delivery (COD) package. |  [optional] |




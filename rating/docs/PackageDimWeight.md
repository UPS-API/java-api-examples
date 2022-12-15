

# PackageDimWeight

Package Dimensional Weight container. Values in this container are ignored when package dimensions are provided. Please visit ups.com for instructions on calculating this value.  Only used for non-US/CA/PR shipments.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**unitOfMeasurement** | [**DimWeightUnitOfMeasurement**](DimWeightUnitOfMeasurement.md) |  |  [optional] |
|**weight** | **String** | Dimensional weight of the package. Decimal values are not accepted, however there is one implied decimal place for values in this field (i.e. 115 &#x3D; 11.5). |  [optional] |






# LocationSearchCriteriaSearchOption

SearchOption contains the information that forms the basis of the location search, It contains the criteria for search by Locations, Retail Locations, Additional Services, or Program Types.  There should be one container for each type of search the user may wish to do. The user can specify either search by Locations or Retail Locations, but not both.  If this container is missing, the default search would be for The UPS Store, UPS Center,� UPS Drop Box, and Authorized Shipping Outlet location types.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**optionType** | [**SearchOptionOptionType**](SearchOptionOptionType.md) |  |  |
|**optionCode** | [**SearchOptionOptionCode**](SearchOptionOptionCode.md) |  |  |
|**relation** | [**SearchOptionRelation**](SearchOptionRelation.md) |  |  [optional] |




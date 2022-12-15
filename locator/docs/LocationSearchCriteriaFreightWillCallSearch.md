

# LocationSearchCriteriaFreightWillCallSearch

Freight Will Call Search Container. Required if SearchOption is '05-Freight Will Call Search'

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**freightWillCallRequestType** | **String** | Valid values are:  1 - Postal Code 2 - Delivery SLIC 3 - Delivery City/State. 1: Freight Will Call Search based on Postal Code, this search is valid for Postal code countries. 2: Freight Will Call Search based on SLIC. 3: Freight Will Call Search based on City and/or State. This Search is valid for non-postal code Countries |  |
|**facilityAddress** | [**FreightWillCallSearchFacilityAddress**](FreightWillCallSearchFacilityAddress.md) |  |  |
|**originOrDestination** | **String** | OriginOrDestination is required for FreightWillCallRequestType 1 and type 3 . Valid values: 01-Origin facilities 02-Destination facilities. |  |
|**formatPostalCode** | **String** | FormatPostalCode would be required in the request when FreightWillCallRequestType is 1. Valid values are: NFR-No format requested FR-format requested FS-format and search NVR-No validation requested. |  |
|**dayOfWeekCode** | **String** | Day Of week Code. Valid Values are 1 to 7.  1-Sunday 2-Monday  3-Tuesday  4-Wednesday 5-Thursday 6-Friday 7-Saturday. |  [optional] |




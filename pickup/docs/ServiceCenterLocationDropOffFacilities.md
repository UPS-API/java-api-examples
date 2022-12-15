

# ServiceCenterLocationDropOffFacilities

Returns information for DropOff Facilities. This includes name of facility, address, business hours, and SLIC.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the Facility. |  |
|**address** | [**DropOffFacilitiesAddress**](DropOffFacilitiesAddress.md) |  |  |
|**SLIC** | **String** | SLIC code for the UPS Drop off facility. |  |
|**type** | **String** | FRT for Freight or PKG for Package |  |
|**timezone** | **String** | Facility�s Timezone Format: America/New_York Asia/Hong_Kong Europe/London |  |
|**phone** | **String** | Phone Number of the Drop off Facility |  |
|**fax** | **String** | Drop off Facilities Fax Number |  |
|**facilityTime** | [**DropOffFacilitiesFacilityTime**](DropOffFacilitiesFacilityTime.md) |  |  [optional] |
|**originOrDestination** | **String** | Type of Facility. |  |
|**localizedInstruction** | [**DropOffFacilitiesLocalizedInstruction**](DropOffFacilitiesLocalizedInstruction.md) |  |  [optional] |
|**distance** | [**DropOffFacilitiesDistance**](DropOffFacilitiesDistance.md) |  |  [optional] |




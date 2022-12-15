

# ServiceCenterLocationPickupFacilities

Returns information for Pickup Facilities. This includes name of facility, address, and business hours.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the facility |  |
|**address** | [**PickupFacilitiesAddress**](PickupFacilitiesAddress.md) |  |  |
|**SLIC** | **String** | SLIC code for the UPS Pickup facility |  |
|**type** | **String** | Freight or Package. |  |
|**timezone** | **String** | Facility�s Timezone. Format: America/New_York Asia/Hong_Kong Europe/London |  |
|**phone** | **String** | Phone Number of the Pickup Facility |  |
|**fax** | **String** | Pickup Facilities Fax Number |  |
|**facilityTime** | [**PickupFacilitiesFacilityTime**](PickupFacilitiesFacilityTime.md) |  |  [optional] |
|**airportCode** | **String** | AirPort Code for destination/pickup facility.  Example: ATL (Atlanta) If Airport code is not present \&quot;---\&quot; will be returned. |  [optional] |
|**sortCode** | **String** | Sort Code for destination/pickup facility.  Example: V1 |  [optional] |




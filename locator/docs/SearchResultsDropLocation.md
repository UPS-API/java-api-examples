

# SearchResultsDropLocation

When a location request is submitted with a valid origin address, UPS locations will be returned.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**locationID** | **String** | The location ID that corresponds to the UPS location. Do not expose the Location ID. |  |
|**originOrDestination** | **String** | OriginOrDestination will returned for FreightWillCallRequestType 1 Postal based and 3 City and/or State based search.   OriginOrDestination will be 01 for origin facilities and 02 for Destination facilities |  |
|**IVR** | [**DropLocationIVR**](DropLocationIVR.md) |  |  |
|**geocode** | [**DropLocationGeocode**](DropLocationGeocode.md) |  |  |
|**addressKeyFormat** | [**DropLocationAddressKeyFormat**](DropLocationAddressKeyFormat.md) |  |  |
|**phoneNumber** | **String** | The UPS locations Phone number.� A phone number of the location will be returned.�  10 digits allowed for US, otherwise 1..15 digits allowed.  The phone number will be returned as a string. |  |
|**faxNumber** | **String** | The UPS location&#39;s Fax number. A fax number of the location will be returned when available.  10 digits allowed for US, otherwise 1..15 digits allowed. The fax number will be returned as string. |  [optional] |
|**emailAddress** | **String** | Email address of the UPS location. Returned when available. |  [optional] |
|**locationAttribute** | [**DropLocationLocationAttribute**](DropLocationLocationAttribute.md) |  |  |
|**distance** | [**DropLocationDistance**](DropLocationDistance.md) |  |  |
|**specialInstructions** | **String** | Walking directions, last 50 feet. |  [optional] |
|**latestGroundDropOffTime** | **String** | The latest ground time the users can Drop-off the package at the location to be picked up. The time information is based on the time at the UPS location.  When a user specifies a Drop-off Time and Ground as the Service Type, the locations that have latest Drop-off times equal to or later than the specified Drop-off time and service type are returned. |  [optional] |
|**latestAirDropOffTime** | **String** | The latest airtime the users can Drop-off the package at the location to be picked up. The time information is based on the time at the UPS location.  When a user specifies a Drop-off Time and Air as the Service Type, the locations that have latest Drop-off times equal to or later than the specified Drop-off time and service type are returned. |  [optional] |
|**additionalChargeIndicator** | **String** | Presence or Absence Indicator. If present, Indicates if the UPS location would have an additional charge. ASO locations will require an additional charge. |  [optional] |
|**standardHoursOfOperation** | **String** | The standard hours of operation of the drop location will be returned when available. The location&#39;s time may differ because of holidays. |  [optional] |
|**nonStandardHoursOfOperation** | **String** | The non-standard hours of operation of the drop location. The location&#39;s time may differ because of holidays, weekends, or other factors that are beyond the locations control. Seven days preceding a given holiday the Non Standard Hours Of Operation will be returned along with the standard hours of operation if available. |  [optional] |
|**willCallHoursOfOperation** | **String** | The will call hours of operation of the drop location will be returned when available. The location&#39;s time may differ because of holidays. |  [optional] |
|**number** | **String** | The center number of the drop location if it is The UPS store. |  [optional] |
|**homePageURL** | **String** | The home page URL of the drop location if it is The UPS store. |  [optional] |
|**comments** | **String** | Comments returned about the location. Text will be displayed in English or the locale given in the request. If Country Code is FR, and locale passed in the request is �fr_FR� then text will be displayed in French language, else comment will be displayed in English language. |  [optional] |
|**additionalComments** | [**DropLocationAdditionalComments**](DropLocationAdditionalComments.md) |  |  [optional] |
|**disclaimer** | **String** | Textual disclaimer about the drop location. |  [optional] |
|**SLIC** | **String** | SLIC. |  [optional] |
|**timezone** | **String** | TimeZone. |  |
|**facilityType** | **String** | PKG/FRT. |  [optional] |
|**operatingHours** | [**DropLocationOperatingHours**](DropLocationOperatingHours.md) |  |  [optional] |
|**localizedInstruction** | [**DropLocationLocalizedInstruction**](DropLocationLocalizedInstruction.md) |  |  [optional] |
|**promotionInformation** | [**DropLocationPromotionInformation**](DropLocationPromotionInformation.md) |  |  [optional] |
|**sortCode** | [**DropLocationSortCode**](DropLocationSortCode.md) |  |  [optional] |
|**serviceOfferingList** | [**DropLocationServiceOfferingList**](DropLocationServiceOfferingList.md) |  |  [optional] |
|**displayPhoneNumberIndicator** | **String** | Valid Values:  0-Do not display phone number 1-Display phone number.  This indicator will be returned only for the contact type Telephone number. This indicator is used by the clients to determine whether to display the telephone number to the end user. |  [optional] |
|**accessPointInformation** | [**DropLocationAccessPointInformation**](DropLocationAccessPointInformation.md) |  |  [optional] |
|**locationImage** | [**DropLocationLocationImage**](DropLocationLocationImage.md) |  |  [optional] |
|**locationNewIndicator** | **String** | Indicator for new location. |  [optional] |
|**promotionalLinkURL** | **String** | Promotional link URL for specific location. |  [optional] |
|**featuredRank** | **String** | Feature Ranking values: Null or blank - Location is not featured.  1 - Featured Location ranked number 1. 2 - Featured Location ranked number 2. |  [optional] |
|**willCallLocationIndicator** | **String** | Will Call Location Indicator values: Y � Signifies a Will Call location that serves the customers address.  N - Signifies it is not a Will Call location. Will Call locations are only returned with a \&quot;Y\&quot; indicator if the request included EnhancedSearchOption code 10. |  [optional] |




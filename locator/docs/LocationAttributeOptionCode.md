

# LocationAttributeOptionCode

Option code is a container that contains the information of a particular type of Location or retail location or additional service or program type that the drop location contains.  If the OptionType is Location or Retail Location Type there will be one code since each location has only one location type or retail location type.  If the Option type is additional services or program types there can be one or more option codes.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**category** | **String** | N/A |  [optional] |
|**code** | **String** | The valid list of codes and description for Retail Locations or Additional Services or Pro-gram Types that are currently available in the database. This can be obtained by a separate type of request (Request Option 8, 16, 24, 32, 40, 48 and 56). |  |
|**description** | **String** | Description is only applicable for Program types and Additional Services. It is not provided with Location detail. It is only provided when the request is for All available additional ser-vices or all available Program types. Text will be displayed in the locale requested. |  |
|**name** | **String** | Name will indicate the name of Location/Retail Location or Additional Services or Program Types depending on the option code. Text will be displayed in the locale requested. |  [optional] |
|**transportationPickUpSchedule** | [**OptionCodeTransportationPickUpSchedule**](OptionCodeTransportationPickUpSchedule.md) |  |  [optional] |




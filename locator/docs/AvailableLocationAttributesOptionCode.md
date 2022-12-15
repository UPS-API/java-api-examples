

# AvailableLocationAttributesOptionCode

Option code is a container that contains the information of a particular retail location type or additional service or program type that is available currently. One or more of this container will be returned to give all the available codes for Retail Type or Additional Services or Program Type.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | The valid list of codes and description for Retail Locations or Additional Services or Pro-gram Types that are currently available in the database. This can be obtained by a separate type of request (Request Option 8, 16, 24, 32, 40, 48 and 56). |  |
|**description** | **String** | Description is only applicable for Program types and Additional Services. It is not provided with Location detail. It is only provided when the request is for All available additional ser-vices or all available Program types. Text will be displayed in the locale requested. |  |
|**name** | **String** | Name will indicate the name of Location/Retail Location or Additional Services or Program Types depending on the option code. Text will be displayed in the locale requested. |  [optional] |
|**category** | **String** | N/A |  [optional] |
|**transportationPickUpSchedule** | [**OptionCodeTransportationPickUpSchedule**](OptionCodeTransportationPickUpSchedule.md) |  |  [optional] |




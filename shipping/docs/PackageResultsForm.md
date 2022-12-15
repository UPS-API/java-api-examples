

# PackageResultsForm

Container tag for the International forms image.  Currently this container would be returned for UPS Premium Care shipments. Form is returned for following shipments - Forward shipments, Shipments with PRL ReturnService, Electronic Return Label or Electronic Import Control Label shipments with SubVersion greater than or equal to 1707. CN22 data for Worlwide economy services will be returned within the PDF417 barcode of the label.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | Code that indicates the type of form.�   Applicable only for ShipmentResponse and ShipAcceptResponse.  Valid values: 01 - All Requested International Forms. |  |
|**description** | **String** | Description that indicates the type of form. Possible Values. All Requested International Forms.     Applicable only for ShipmentResponse and ShipAcceptResponse. |  |
|**image** | [**FormImage**](FormImage.md) |  |  [optional] |
|**formGroupId** | **String** | Unique Id for later retrieval of saved version of the completed international forms. Always returned when code &#x3D; 01. 01 represents international forms.     Applicable only for ShipmentResponse and ShipAcceptResponse. |  [optional] |
|**formGroupIdName** | **String** | Contains description text which identifies the group of International forms. This element is part of both request and response. This element does not appear on the forms.    Applicable only for ShipmentResponse and ShipAcceptResponse. |  [optional] |




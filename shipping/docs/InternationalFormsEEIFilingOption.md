

# InternationalFormsEEIFilingOption

EEI Filing option.  Applicable for EEI form and is required.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | Required for EEI Form.  Applicable for EEI form. Valid values:  1 - Shipper filed, 2 - AES Direct,  3 - UPS filed. |  |
|**emailAddress** | **String** | Email Address where the notification is sent. Valid for UPS filed (option 3), Shipper filed (option 1- A , 1-C)  Applicable for EEI form. |  [optional] |
|**description** | **String** | Optional Description of Filing Code.  Applicable for EEI form. |  [optional] |
|**upSFiled** | [**EEIFilingOptionUPSFiled**](EEIFilingOptionUPSFiled.md) |  |  [optional] |
|**shipperFiled** | [**EEIFilingOptionShipperFiled**](EEIFilingOptionShipperFiled.md) |  |  [optional] |




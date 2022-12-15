

# ContactsSoldTo

SoldTo Container. The Sold To party�s country code must be the same as the Ship To party�s country code with the exception of Canada and satellite countries.  Applies to Invoice and NAFTA CO Forms. Required if Invoice or NAFTA CO (International Form) is requested.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Company Name. |  |
|**attentionName** | **String** | Sold to contact name. |  |
|**taxIdentificationNumber** | **String** | SoldTo Tax Identification Number. |  [optional] |
|**phone** | [**SoldToPhone**](SoldToPhone.md) |  |  [optional] |
|**option** | **String** | The text associated with the code will be printed in the sold to section of the NAFTA CO form.  The values indicate the following: 01 � Unknown.  Applies to NAFTA CO form. Possible Values are 01 and 02. |  [optional] |
|**address** | [**SoldToAddress**](SoldToAddress.md) |  |  |
|**emailAddress** | **String** | SoldTo email address. |  [optional] |




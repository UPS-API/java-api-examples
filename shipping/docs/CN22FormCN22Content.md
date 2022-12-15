

# CN22FormCN22Content

Container for CN22 content.  Required if the CN22 form container is present.  Note: The maximum number of goods printed on the CN22 form when a combined MI package and CN22 form label is requested is 30.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cn22ContentQuantity** | **String** | Total number of items associated with this content.  Required if the CN22 form container is present. |  |
|**cn22ContentDescription** | **String** | Detailed description of the content.  If the combined MI package and CN22 label is requested, only the first 30 characters will appear on the combined label.  Required if the CN22 form container is present. |  |
|**cn22ContentWeight** | [**CN22ContentCN22ContentWeight**](CN22ContentCN22ContentWeight.md) |  |  |
|**cn22ContentTotalValue** | **String** | Total value of the items associated with this content.  Required if the CN22 form container is present. |  |
|**cn22ContentCurrencyCode** | **String** | Currently only USD is supported.  Required if the CN22 form container is present. |  |
|**cn22ContentCountryOfOrigin** | **String** | Country or Territory of Origin from where the CN22 contents originated. |  [optional] |
|**cn22ContentTariffNumber** | **String** | The tariff number associated with the CN22 contents. |  [optional] |




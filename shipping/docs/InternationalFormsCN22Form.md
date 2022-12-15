

# InternationalFormsCN22Form

Container for the CN22 form.  Required if the customer wants to use the UPS generated CN22.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**labelSize** | **String** | Provide the valid values:  6 &#x3D; 4X6 1 &#x3D; 8.5X11   Required if the CN22 form container is present. |  |
|**printsPerPage** | **String** | Number of label per page. Currently 1 per page is supported.  Required if the CN22 form container is present. |  |
|**labelPrintType** | **String** | Valid Values are pdf, png, gif, zpl, star, epl2 and spl.   Required if the CN22 form container is present. |  |
|**cn22Type** | **String** | Valid values:  1 &#x3D; GIFT 2 &#x3D; DOCUMENTS 3 &#x3D; COMMERCIAL SAMPLE 4 &#x3D; OTHER  Required if the CN22 form container is present. |  |
|**cn22OtherDescription** | **String** | Required if CN22Type is OTHER.  Required if the CN22 form container is present. |  [optional] |
|**foldHereText** | **String** | String will replace default \&quot;Fold Here\&quot; text displayed on the label. |  [optional] |
|**cn22Content** | [**CN22FormCN22Content**](CN22FormCN22Content.md) |  |  |




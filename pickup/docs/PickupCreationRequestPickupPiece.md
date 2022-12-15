

# PickupCreationRequestPickupPiece

The container providing the information about how many items should be picked up.  The total number of return and forwarding packages cannot exceed 9,999.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**serviceCode** | **String** | Refer to Service Codes in the Appendix for valid values. |  |
|**quantity** | **String** | Number of pieces to be picked up.  Max per service: 999 |  |
|**destinationCountryCode** | **String** | The destination country code as defined by ISO-3166. Refer to Country or Territory Codes in the Appendix for valid values. |  |
|**containerCode** | **String** | Container type.  Valid values: 01 &#x3D; PACKAGE 02 &#x3D; UPS LETTER 03 &#x3D; PALLET Note: 03 is used for only WWEF services |  |




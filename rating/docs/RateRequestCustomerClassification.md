

# RateRequestCustomerClassification

Customer classification container. Valid if ShipFrom country or territory  is �US�  N/A

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | Customer classification code.  Valid values: 00 -  Rates Associated with Shipper Number 01 -  Daily Rates 04 -  Retail Rates 05 - Regional Rates 06 - General List Rates 53 -  Standard List Rates Length is not validated. If customer classification code is not a valid value please refer to Rate Types Table on page 11. |  |
|**description** | **String** | Customer classification description of the code above.  Ignored if provided in the Request. Length is not validated. |  [optional] |




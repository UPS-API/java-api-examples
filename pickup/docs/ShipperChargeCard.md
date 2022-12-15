

# ShipperChargeCard

Container for Charge Card payment method  Required if Payment method is 03. Credit/Charge card payment is valid for US, CA, PR and GB origin pickups.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**cardHolderName** | **String** | Charge card holder name. If the name is not provided, defaults to \&quot;No Name Provided\&quot;. |  [optional] |
|**cardType** | **String** | Charge card type. Valid values: 01 &#x3D; American Express 03 &#x3D; Discover 04 &#x3D; Mastercard 06 &#x3D; VISA  Discover card Pickup country US only. |  |
|**cardNumber** | **String** | Charge card number.  For Privileged clients, this element must be tokenized card number. |  |
|**expirationDate** | **String** | Credit card expiration date. Format: yyyyMM yyyy &#x3D; 4 digit year, valid value current year - 10 years. MM &#x3D; 2 digit month, valid values 01-12 |  |
|**securityCode** | **String** | Three or four digits that can be found either on top of credit card number or on the back of credit card.  Number of digits varies for different type of credit card.  Valid values are 3 or 4 digits. Security code is required if credit card information is provided. |  |
|**cardAddress** | [**ChargeCardCardAddress**](ChargeCardCardAddress.md) |  |  |




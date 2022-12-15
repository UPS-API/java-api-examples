

# PickupCreationRequest

This request is for scheduling an on-call pickup

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**request** | [**PickupCreationRequestRequest**](PickupCreationRequestRequest.md) |  |  |
|**ratePickupIndicator** | **String** | Indicates whether to rate the on-callpickup or not.  Valid values: Y &#x3D; Rate this pickup N &#x3D; Do not rate this pickup (default) |  |
|**taxInformationIndicator** | **String** | Indicates whether to return detailed taxes for the on-callpickups.  Valid values: Y &#x3D; Rate this pickup with taxes N &#x3D; Do not rate this pickup with taxes (default) |  [optional] |
|**userLevelDiscountIndicator** | **String** | Indicates whether to return user level promo discount for the on-callpickups.  Valid values: Y &#x3D; Rate this pickup with user level promo discount N &#x3D; Do not rate this pickup with user level promo discount(default) |  [optional] |
|**shipper** | [**PickupCreationRequestShipper**](PickupCreationRequestShipper.md) |  |  [optional] |
|**pickupDateInfo** | [**PickupCreationRequestPickupDateInfo**](PickupCreationRequestPickupDateInfo.md) |  |  |
|**pickupAddress** | [**PickupCreationRequestPickupAddress**](PickupCreationRequestPickupAddress.md) |  |  |
|**alternateAddressIndicator** | **String** | Indicates if pickup address is a different address than that specified in a customer&#39;s profile.  Valid values: Y &#x3D; Alternate address N &#x3D; Original pickup address (default) |  |
|**pickupPiece** | [**List&lt;PickupCreationRequestPickupPiece&gt;**](PickupCreationRequestPickupPiece.md) |  |  |
|**totalWeight** | [**PickupCreationRequestTotalWeight**](PickupCreationRequestTotalWeight.md) |  |  [optional] |
|**overweightIndicator** | **String** | Indicates if at least any package is over 70 lbs or 32 kgs.  Valid values:  Y &#x3D; Over weight  N &#x3D; Not over weight (default)  Not required for WWEF service. |  [optional] |
|**trackingData** | [**PickupCreationRequestTrackingData**](PickupCreationRequestTrackingData.md) |  |  [optional] |
|**trackingDataWithReferenceNumber** | [**PickupCreationRequestTrackingDataWithReferenceNumber**](PickupCreationRequestTrackingDataWithReferenceNumber.md) |  |  [optional] |
|**paymentMethod** | **String** | The payment method to pay for this on call pickup. 00 &#x3D; No payment needed 01 &#x3D; Pay by shipper account 03 &#x3D; Pay by charge card 04 &#x3D; Pay by 1Z tracking number 05 &#x3D; Pay by check or money order 06 &#x3D; Cash(applicable only for these countries - BE,FR,DE,IT,MX,NL,PL,ES,GB,CZ,HU,FI,NO) 07&#x3D;Pay by PayPal Refer to Appendix # for valid payment methods for CZ, HU, FI and NO   For countries and (or) zip codes where pickup is free of charge, please submit 00, means no payment needed as payment method.  - If 01 is the payment method, then ShipperAccountNumber and ShipperAccount CountryCode must be provided. - If 03 is selected, then CreditCard information should be provided. - If 04 is selected, then the shipper agreed to pay for the pickup packages. - If 05 is selected, then the shipper will pay for the pickup packages with a check or money order. |  |
|**specialInstruction** | **String** | Special handling instruction from the customer |  [optional] |
|**referenceNumber** | **String** | Information entered by a customer for Privileged reference |  [optional] |
|**notification** | [**PickupCreationRequestNotification**](PickupCreationRequestNotification.md) |  |  [optional] |
|**CSR** | [**PickupCreationRequestCSR**](PickupCreationRequestCSR.md) |  |  [optional] |
|**freightOptions** | [**PickupCreationRequestFreightOptions**](PickupCreationRequestFreightOptions.md) |  |  [optional] |
|**serviceCategory** | **String** | Service Category. Applicable to the following countries: BE, FR, DE, IT, MX, NL, PL, ES, GB  Valid values:  01 - domestic (default) 02 - international 03 - transborder |  [optional] |
|**cashType** | **String** | Describes the type of cash funds that the driver will collect. Applicable to the following countries: BE,FR,DE,IT,MX,NL,PL,ES,GB Valid values:  01 - Pickup only (default) 02 - Transportation only 03 - Pickup and Transportation |  [optional] |
|**shippingLabelsAvailable** | **String** | This element should be set to �Y� in the request to indicate that user has pre-printed shipping labels for all the packages, otherwise this will be treated as false. |  [optional] |




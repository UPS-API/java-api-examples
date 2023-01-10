

# PickupCancelRequest

This request is to cancel an on-callpickup.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**request** | [**PickupCancelRequestRequest**](PickupCancelRequestRequest.md) |  |  |
|**cancelBy** | **String** | Cancel pickup by Pickup Request Number (PRN). 01&#x3D; Account Number                                             02 &#x3D; PRN |  |
|**PRN** | **String** | The pickup request number (PRN) generated by UPS pickup system. Required if CancelBy &#x3D; 02 |  [optional] |



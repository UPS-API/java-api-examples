

# LabelRecoveryResponseTrackingCandidate

Information containing the results of the users Label Recovery Request. Returned in the event the Shipper Number and Reference Number are supplied in the request.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**trackingNumber** | **String** | Packaging Tracking Number  Only supported for the web small package shipment so only supported 18 digit |  |
|**destinationPostalCode** | **String** | Destination postal code candidate |  [optional] |
|**destinationCountryCode** | **String** | Destination country or territory code candidate, like US &#x3D; USA, CA &#x3D; Canada  Must be valid ups country or territory code |  [optional] |
|**pickupDateRange** | [**TrackingCandidatePickupDateRange**](TrackingCandidatePickupDateRange.md) |  |  [optional] |




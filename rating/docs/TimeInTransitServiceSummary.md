

# TimeInTransitServiceSummary

Container for all available service information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**service** | [**ServiceSummaryService**](ServiceSummaryService.md) |  |  |
|**guaranteedIndicator** | **String** | Empty Tag. Indicates whether the service will be guaranteed or not.  Required for International Requests. |  [optional] |
|**disclaimer** | **String** | The Disclaimer is provided based upon the origin and destination country or territory codes provided in the request document. The disclaimer is returned as a conditional statement to the validity of the service being guaranteed. The possible disclaimers that can be returned are available in the Service Guaranteed Disclaimers table. |  [optional] |
|**estimatedArrival** | [**ServiceSummaryEstimatedArrival**](ServiceSummaryEstimatedArrival.md) |  |  |
|**saturdayDelivery** | **String** | Saturday delivery information for a service. Values are 1 - Saturday Delivery Available with additional charges  0 - Saturday Delivery not available or no additional charge, please check Delivery Date to confirm if the Delivery will be Saturday  Please see Saturday Delivery business rules section for more information. |  [optional] |
|**saturdayDeliveryDisclaimer** | **String** | Saturday delivery disclaimer message. |  [optional] |
|**sundayDelivery** | **String** | Sunday delivery information for a service. Values are 1 - Sunday Delivery Available with additional charges  0 - Sunday Delivery not available or no additional charge, please check Delivery Date to confirm if the Delivery will be Sunday  Please see Saturday Delivery business rules section for more information.   Applies only if SubVersion is greater than or equal to 2007 |  [optional] |
|**sundayDeliveryDisclaimer** | **String** | Sunday delivery disclaimer message.  Applies only if SubVersion is greater than or equal to 2007 |  [optional] |




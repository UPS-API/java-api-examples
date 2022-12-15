

# ShipmentInvoiceLineTotal

Container to hold InvoiceLineTotal Information.  Required if the shipment is from US/PR Outbound to non US/PR destination with the PackagingType of UPS PAK(04).  Required for international shipments  when using request option \"ratetimeintransit\" or \"shoptimeintransit\".

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currencyCode** | **String** | Invoice Line Total Currency type. The Currency code should match the origin country&#39;s or territory&#39;s currency code, otherwise the currency code entered will be ignored.  Note: UPS doesn&#39;t support all international currency codes. Please check the developer guides for Supported Currency codes. |  |
|**monetaryValue** | **String** | Total amount of the invoice accompanying the shipment. Required when the InvoiceLineTotal container exists in the rate request.  Valid values are from 1 to 99999999. |  |




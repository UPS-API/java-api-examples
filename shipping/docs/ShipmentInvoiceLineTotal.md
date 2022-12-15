

# ShipmentInvoiceLineTotal

Container to hold InvoiceLineTotal Information.  Required for forward shipments whose origin is the US and destination is Puerto Rico or Canada. Not available for any other shipments. FOR OTHER DESTINATIONS the InvoiceLineTotal in the International Forms Container must be used.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**currencyCode** | **String** | Invoice Line Total currency type. |  |
|**monetaryValue** | **String** | Invoice Line Total amount for the entire shipment.  Valid values are from 1 to 99999999 |  |




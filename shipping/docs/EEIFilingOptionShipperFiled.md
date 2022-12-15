

# EEIFilingOptionShipperFiled

Indicates the EEI Shipper Filed option or AES Direct. (Option 1 or 2).  Applicable for EEI form.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | Indicates the EEI Shipper sub option.  Applicable for EEI form and is required. Valid value is: A- requires the ITN; B- requires the Exemption Legend; C- requires the post departure filing citation. |  |
|**description** | **String** | Description of ShipperFiled Code.  Applicable for EEI form. |  [optional] |
|**preDepartureITNNumber** | **String** | Input for Shipper Filed option A and AES Direct. The format is available from AESDirect website.  Valid and Required for Shipper Filed option A. EEI form only. |  [optional] |
|**exemptionLegend** | **String** | Input for Shipper Filed option B. 30.2(d)(2), 30.26(a), 30.36, 30.37(a), 30.37(b), 30.37(c), 30.37(d), 30.37(e), 30.37(f), 30.37(h), 30.37(i), 30.30(j), 30.37(k), 30.37(i), 30.37(j), 30.37(k), 30.37(l), 30.37(m), 30.37(n), 30.37(o), 30.37(p), 30.37(q), 30.37(r), 30.37(s), 30.37(t), 30.37(u), 30.37(x), 30.37(y)(1), 30.37(y)(2), 30.37(y)(3), 30.37(y)(4), 30.37(y)(5), 30.37(y)(6), 30.39, 30.40(a), 30.40(b), 30.40(c), 30.40(d), 30.8(b)  Valid and Required for Shipper Filed option B. EEI form only. |  [optional] |
|**eeIShipmentReferenceNumber** | **String** | Shipment Reference Number for use during interaction with AES. Valid for EEI form for Shipper Filed option &#39;C&#39; and AES Direct Filed. |  [optional] |




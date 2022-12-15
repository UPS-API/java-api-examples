

# InternationalFormsProduct

Contains the commodity/product information.  Applies to EEI, Invoice, Partial Invoice, CO and NAFTA CO. When any International form is requested, at least one Product must be present.   Maximum number of products allowed for different forms are:  50: Package Packing List  100: Commercial Invoice, NAFTA, CO, EEI  1000: Air Freight packing list  Note: For Partial Invoice this container is optional.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** | Description of the product.  Applies to all International Forms. Optional for Partial Invoice. Must be present at least once and can occur for a maximum of 3 times. |  |
|**unit** | [**ProductUnit**](ProductUnit.md) |  |  [optional] |
|**commodityCode** | **String** | 6-to-15-alphanumeric commodity code. Customs uses this code to determine what duties should be assessed on the commodity.  Applies to Invoice, Partial Invoice and NAFTA CO. Required for NAFTA CO and optional for Partial Invoice. Should be at least 6 alphanumeric. For NAFTA CO: For each good described in Description of Goods field, identify the H.S. tariff classification to six digits. If the good is subject to a specific rule of origin in Annex 401 that requires eight digits, identify to eight digits, using the H.S. tariff classification of the country or territory into whose territory the good is imported. |  [optional] |
|**partNumber** | **String** | The part number or reference number for the product contained in the invoice line, as indicated on the customs invoice.  Applies to Invoice and Partial Invoice. Required for Invoice forms and optional for Partial Invoice. |  [optional] |
|**originCountryCode** | **String** | The country or territory in which the good was manufactured, produced or grown. For detailed information on country or territory of origin, certificate of origin, rules of origin, and any related matters, please refer to the U.S. Customs and Border Protection Web site at www.customs.gov or contact your country or territory&#39;s Customs authority. |  [optional] |
|**jointProductionIndicator** | **String** | If present, JNT will be used as the origin of country or territory code on the NAFTA form and the Product/Origincountry or territoryCode tag will be ignored.  Applies to NAFTA CO only. |  [optional] |
|**netCostCode** | **String** | For each good described in the Description of Goods field, where the good is subject to a regional value content (RVC) requirement, indicate NC if the RVC is calculated according to the net cost method; otherwise, indicate NO. If the RVC is calculated over a period of time then indicate �NC with begin/end date� by passing code �ND�  Applies to NAFTA CO only. Required for NAFTA CO.  Valid values: NC, ND and NO. |  [optional] |
|**netCostDateRange** | [**ProductNetCostDateRange**](ProductNetCostDateRange.md) |  |  [optional] |
|**preferenceCriteria** | **String** | Indicates the criterion (A through F) for each good described in the Description of Goods field if applicable.   The rules of origin are contained in Chapter Four and Annex 401.   Additional rules are described in Annex 703.2 (certain agricultural goods), Annex 300-B, Appendix 6 (certain textile goods) and Annex 308.1 (certain automatic data processing goods and their parts).  Applies to NAFTA CO only. |  [optional] |
|**producerInfo** | **String** | Indicate the following:  Yes - If shipper is the producer of the good. If not, state 02, 03, and 04 depending on whether this certificate was based upon:   No [1] - Knowledge of whether the good qualifies as an originating good.  No [2] - Reliance on the producers written representation (other than a Certificate of Origin) that the good qualifies as an originating good.  No [3] - A completed and signed Certificate for the good voluntarily provided to the exporter by the producer.  Applicable for NAFTA CO and is required. Valid values: Yes, No [1], No [2], and No [3]. |  [optional] |
|**marksAndNumbers** | **String** | Any special marks, codes, and numbers that may appear on package.  Applies to CO Only. |  [optional] |
|**numberOfPackagesPerCommodity** | **String** | The total number of packages, cartons, or containers for the commodity.  Applicable for CO and is required. Should be numeric. Valid characters are 0 -9. |  [optional] |
|**productWeight** | [**ProductProductWeight**](ProductProductWeight.md) |  |  [optional] |
|**vehicleID** | **String** | Includes the following information for used self-propelled vehicles as defined in Customs regulations 19 CFR 192.1: The unique Vehicle Identification Number (VIN) in the proper format. Or The Product Identification Number (PIN) for those used self-propelled vehicles for which there are no VINs.  Or the Vehicle Title Number.  Applies to EEI forms only. |  [optional] |
|**scheduleB** | [**ProductScheduleB**](ProductScheduleB.md) |  |  [optional] |
|**exportType** | **String** | Code indicating Domestic: Exports that have been produced, manufactured, or grown in the United States or Puerto Rico. This includes imported merchandise which has been enhanced in value or changed from the form in which imported by further manufacture or processing in the United States or Puerto Rico. Foreign: Merchandise that has entered the United States and is being exported again in the same condition as when imported.   Applies to EEI forms only. Required for EEI form.  Valid values:  D: Domestic; F: Foreign. |  [optional] |
|**seDTotalValue** | **String** | This amount will always be USD.  Applies to EEI forms only. Required for EEI form. Valid characters are 0-9 and �.� (Decimal point). Limit to 2 digit after the decimal. The maximum length of the field is 15 including �.� and can hold up to 2 decimal places.  Note: This value is calculated based on the Product/Unit/Value and /Product/Unit/Number (Number of Units * Price per Unit). If the total value is incorrect it will be replaced by the actual calculated total value. |  [optional] |
|**excludeFromForm** | [**ProductExcludeFromForm**](ProductExcludeFromForm.md) |  |  [optional] |
|**packingListInfo** | [**ProductPackingListInfo**](ProductPackingListInfo.md) |  |  [optional] |
|**eeIInformation** | [**ProductEEIInformation**](ProductEEIInformation.md) |  |  [optional] |






# LocatorRequestLocationSearchCriteria

The Location search criteria container allows the user to further define the basis to which they wish to receive the UPS locations.  Only relevant when the user requests a Location search (request option 1).

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**searchOption** | [**LocationSearchCriteriaSearchOption**](LocationSearchCriteriaSearchOption.md) |  |  [optional] |
|**maximumListSize** | **String** | If present, indicates the maximum number of locations the client wishes to receive in response; ranges from 1 to 50 with a default value of 5. |  [optional] |
|**searchRadius** | **String** | Defines the maximum radius the user wishes to search for a UPS location. If the user does not specify, the default value is 100 miles. Whole numbers only.   Valid values are: 5-100 for UnitOfMeasure MI 5-150 for UnitOfMesaure KM |  [optional] |
|**serviceSearch** | [**LocationSearchCriteriaServiceSearch**](LocationSearchCriteriaServiceSearch.md) |  |  [optional] |
|**freightWillCallSearch** | [**LocationSearchCriteriaFreightWillCallSearch**](LocationSearchCriteriaFreightWillCallSearch.md) |  |  [optional] |
|**accessPointSearch** | [**LocationSearchCriteriaAccessPointSearch**](LocationSearchCriteriaAccessPointSearch.md) |  |  [optional] |
|**openTimeCriteria** | [**LocationSearchCriteriaOpenTimeCriteria**](LocationSearchCriteriaOpenTimeCriteria.md) |  |  [optional] |
|**brexitFilter** | **String** | Brexit Filter. Applicable for country code GB; Pass the PostalCode for the address in the location search if Brexit functionality is desired. UAPs with postal code starts with BT returned when brexit filter starts with BT, else UAPs returned with non BT postal code. Applicable for UAP and Proximal building search. |  [optional] |




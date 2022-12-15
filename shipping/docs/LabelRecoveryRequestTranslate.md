

# LabelRecoveryRequestTranslate

Translate container allows the user to specify the language he/she would like a specific portion of response to return.  The language is specified by the combination of language code and dialect code.  Valid combinations are: LanguageCode + DialectCode.  Either Translate container or Locale element can be present in a given request. Both can't be requested together in same request. Combinations:  eng GB = Queen's English  Spa 97 = Castilian Spanish  ita 97 = Italian  fra 97 = France French  fra CA = Canadian French  deu 97 = German  por 97 = Portugal Portuguese  nld 97 = Dutch  dan 97 = Danish  fin 97 = Finnish  swe 97 = Swedish  eng CA = Canadian English  Eng US = US English  Default language is Queen's English   If the Ship from country or territory is Canada, the Language defaults to Canadian English.   If the ship from country or territory is US, the language defaults to US English.  If shipping from some other country or territory, the language defaults to Queens English.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**languageCode** | **String** | The Language code. The language codes are three letter language codes.  Supported languages are:  eng - English  spa - Spanish  ita - Italian fra - French  deu - German  por -Portuguese  nld  Dutch dan - Danish  fin - Finnish  swe  Swedish  nor  Norwegian |  |
|**dialectCode** | **String** | Valid dialect codes are:  CA - Canada GB - Great Britain US - United States 97  Not Applicable |  |
|**code** | **String** | Used to specify what will be translated.  Valid code:  01 &#x3D; label direction instructions and receipt |  |




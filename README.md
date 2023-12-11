# UPS API Samples
Ron
This respository contains example java projects for our most commonly used APIs. 

The projects are self-contained and will run within a main method to transact with the UPS Customer Integration Environment (CIE).

Additionally the projects offer the following features:
- Threadsafe OAuth Access Token Management (Client Credential)
- POJO generation from UPS Open API Specifications
- Modifiable example requests
## Getting Started
### Prerequisites
- You will need to have Maven and the Java Development Kit installed.

### Download
- You can either download a local copy or clone the repository:

```sh
git clone https://github.com/UPS-API/java-api-examples.git
```

### Insert Your Information
- Update your OAuth Client information in <project home>/src/main/resources/application.properties file. These values can be found in the UPS Developer Portal under Apps and your specific application's information.

|Property Name |
| :------: |
|```api.oauth.partner.client.id```|
|```api.oauth.partner.secret```|

- Additionally, modify tags with "<>" in the provided .json files in the resources directory (<project home>/src/main/resources/) with your information. These fields will be listed in the individual API folders.

### Build and run

- Build the project using Maven
```sh
cd <project home>
mvn clean package
```

- Run the project that is generated in the <project home>/target directory.
```sh
java -jar <API name>.jar            
```
- Check the console for the application's REST response.

## License

Copyright 2022 UPS.

Code licensed under the MIT License: <http://opensource.org/licenses/MIT>


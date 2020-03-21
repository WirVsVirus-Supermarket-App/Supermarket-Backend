# Requirements
- Java 13+

# Dev
Copy `src/main/resources/application.properties.example` to `src/main/resources/application.properties` and edit
contents as necessary.

# API Docs
[docs/Readme.md](docs/Readme.md)

# Generate static API documentation
https://github.com/swagger-api/swagger-codegen#getting-started

## Static HTML
```shell script
java -jar "swagger-codegen-cli-2.4.12.jar" generate -i http://localhost:1337/v2/api-docs -o "Supermarket-Backend/Newfolder" -l html2
```

## Markdown
```shell script
java -jar "swagger-codegen-cli-2.4.12.jar" generate -i http://localhost:1337/v2/api-docs -o "Supermarket-Backend/Newfolder" -l go
```

Copy `Supermarket-Backend/Newfolder/docs/*.md` to `docs/`

## Swagger JSON
```shell script
java -jar "swagger-codegen-cli-2.4.12.jar" generate -i http://localhost:1337/v2/api-docs -o "Supermarket-Backend/Newfolder" -l swagger
```

Copy `Supermarket-Backend/Newfolder/jswagger.json` to `docs/`

# `:AsyncAPI:SecurityScheme` Node

-> represents an operation

## Properties

| Name               | Description                                                                                                                                                                              |
|--------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `type`             | type of the security scheme <br/> examples: `userPassword`, `apiKey`, `http` - [more at asyncapi.com](https://www.asyncapi.com/docs/reference/specification/v3.0.0#securitySchemeObject) |
| `name`             | `required` name of the security scheme (machine-friendly)                                                                                                                                |
| `in`               | `required` location of the api key                                                                                                                                                       |
| `description`      | short description of the security scheme                                                                                                                                                 |
| `scheme`           | `required` name of http authorization scheme                                                                                                                                             |
| `baererFormat`     | information/hint about the bearer format                                                                                                                                                 |
| `openIdConnectUrl` | `required` absolute url to OAuth2 configuration values                                                                                                                                   |
| `scopes`           | "oauth2" / "openIdConnect" <br/> -> needed scope names                                                                                                                                   |

## Relations

| Name              | Target Label(s)                                                | Cardinality | Description                                                     |
| ----------------- | -------------------------------------------------------------- | ----------- | --------------------------------------------------------------- |
| `SUPPORTS_FLOWS`  | [[Node - AsyncAPI OAuthFlow\|:AsyncAPI:OAuthFlow]]             | 0..1        | `required` property holding a link to an external documentation |
| `DEFINES_BINDING` | [[Node - AsyncAPI MessageBindings\|:AsyncAPI:MessageBindings]] | 0..*        | tags for grouping/categorization of operations                  |


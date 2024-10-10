# `:AsyncAPI:Server` Node

-> represents a server or message broker

## Properties

| Name              | Description                                         |
|-------------------|-----------------------------------------------------|
| `title`           | title of the server  (human-friendly)               |
| `summary`         | summary of the server                               |
| `description`     | description of the server                           |
| `host`            | host name of the server                             |
| `protocol`        | supported protocol of the server                    |
| `protocolVersion` | version of the supported protocol                   |
| `pathname`        | path of the server object in the file for reference |

## Relations

| Name                               | Target Label(s)                                                            | Cardinality | Description                                                        |
|------------------------------------|----------------------------------------------------------------------------|-------------|--------------------------------------------------------------------|
| `DEFINES_SERVER_VARIABLE`          | [[Node - AsyncAPI ServerVariable\|:AsyncAPI:ServerVariable]]               | 0..*        | variables names and values for server`s host and pathname template |
| `DEFINES_SECURITY_SCHEME`          | [[Node - AsyncAPI SecurityScheme\|:AsyncAPI:SecurityScheme]]               | 0..*        | list of usable security schemes                                    |
| `REFERS_TO_EXTERNAL_DOCUMENTATION` | [[Node - AsyncAPI ExternalDocumentation\|:AsyncAPI:ExternalDocumentation]] | 0..1        | property holding a link to an external documentation               |
| `HAS_TAG`                          | [[Node - AsyncAPI Tag\|:AsyncAPI:Tag]]                                     | 0..*        | tags for grouping/categorization of servers                        |
| `DEFINES_SERVER_BINDING`           | [[Node - AsyncAPI ServerBindings\|:AsyncAPI:ServerBindings]]               | 0..1        | all specific definitions for each supported protocol               |

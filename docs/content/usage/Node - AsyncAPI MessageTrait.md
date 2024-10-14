# `:AsyncAPI:MessageTrait` Node

-> represents a trait applicable to a Message Object

## Properties

| Name          | Description                                                    |
|---------------|----------------------------------------------------------------|
| `name`        | name of the message  (machine-friendly)                        |
| `description` | detailed description of the message                            |
| `title`       | title of the message (human-friendly)                          |
| `contentType` | content type for encoding/decoding the payload  of the message |
| `summary`     | short summary of the message                                   |

## Relations

| Name                               | Target Label(s)                                                                                                                                           | Cardinality | Description                                                                             |
|------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|-------------|-----------------------------------------------------------------------------------------|
| `HAS_CORRELATION_ID`               | [[Node - AsyncAPI CorrelationID\|:AsyncAPI:CorrelationID]]<br/>/[[Node - AsyncAPI Reference\|:AsyncAPI:Reference:CorrelationID]]                          | 0..1        | correlation id for tracing the mesage / reference                                       |
| `HAS_TAG`                          | [[Node - AsyncAPI Tag\|:AsyncAPI:Tag]]                                                                                                                    | 0..*        | tags for grouping/categorization of messages                                            |
| `REFERS_TO_EXTERNAL_DOCUMENTATION` | [[Node - AsyncAPI ExternalDocumentation\|:AsyncAPI:ExternalDocumentation]] <br/>/[[Node - AsyncAPI Reference\|:AsyncAPI:Reference:ExternalDocumentation]] | 0..1        | property holding a link to an external documentation / reference                        |
| `DEFINES_BINDINGS`                 | [[Node - AsyncAPI MessageBindings\|:AsyncAPI:MessageBindings]] <br/> /[[Node - AsyncAPI Reference\|:AsyncAPI:Reference:ReferenceBindings]]                | 0..1        | all specific definitions for each supported protocol / reference                        |
| `HAS_EXAMPLE`                      | [[Node - AsyncAPI MessageExample\|:AsyncAPI:MessageExample]]                                                                                              | 0..*        | message examples                                                                        |
| `USES_HEADERS`                     | [[Node - AsyncAPI MessageHeaders\|:AsyncAPI:MessageHeaders]]<br/>/[[Node - AsyncAPI Reference\|:AsyncAPI:Reference:MessageHeaders]]                       | 0..*        | definition of the application headers - schema object / reference - `not yet supported` |


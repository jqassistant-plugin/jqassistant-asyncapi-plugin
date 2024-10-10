# `:AsyncAPI:Operation` Node

-> represents an operation

## Properties

| Name          | Description                             |
|---------------|-----------------------------------------|
| `action`      | `required` "send" / "receive"           |
| `title`       | title of the operation (human-friendly) |
| `summary`     | short summary of the operation          |
| `description` | detailed description of the operation   |

## Relations

| Name                               | Target Label(s)                                                            | Cardinality | Description                                                             |
| ---------------------------------- | -------------------------------------------------------------------------- | ----------- | ----------------------------------------------------------------------- |
| `REFERS_TO_EXTERNAL_DOCUMENTATION` | [[Node - AsyncAPI ExternalDocumentation\|:AsyncAPI:ExternalDocumentation]] | 0..1        | property holding a link to an external documentation                    |
| `HAS_TAG`                          | [[Node - AsyncAPI ExternalDocumentation\|:AsyncAPI:ExternalDocumentation]] | 0..*        | tags for grouping/categorization of operations                          |
| `ON_CHANNEL`                       | [[Node - AsyncAPI Reference\|:AsyncAPI:Channel:Reference]]                 | 0..1        | reference to the channel definition in which the operation is performed |
| `SUPPORTS_BINDINGS`                | [[Node - AsyncAPI OperationBindings\|:AsyncAPI:OperationBindings]]         | 0..1        | all specific definitions for each supported protocol                    |
| `USING_MESSAGE`                    | [[Node - AsyncAPI Reference\|:AsyncAPI:Message:Reference]]                 | 0..*        | reference to processable messages                                       |
| `USING_TRAIT`                      | [[Node - AsyncAPI OperationTrait\|:AsyncAPI:OperationTrait]]               | 0..*        | applicable trait for the operation                                      |
| `USING_REPLY`                      | [[Node - AsyncAPI OperationReply\|:AsyncAPI:OperationReply]]               | 0..1        | definition of the reply in case of a request operation                  |
| `USING_SECURITY_SCHEME`            | [[Node - AsyncAPI SecurityScheme\|:AsyncAPI:SecurityScheme]]               | 0..1        | declaration of the security schemes of the operation                    |
|                                    |                                                                            |             |                                                                         |


# `:AsyncAPI:Components` Node

-> holds every schema, server, channel, operation, message, security scheme, server variable, parameters object, reply,
reply address, external documentation, tag, operation trait, message trait, channel binding, server binding, operation
binding and message binding stored in the components section of the API

## Relations

| Name                               | Target Label(s)                                                            | Cardinality | Description                                          |
|------------------------------------|----------------------------------------------------------------------------|-------------|------------------------------------------------------|
| `DEFINES_SCHEMA`                   | [[Node - AsyncAPI Schemas\|:AsyncAPI:Schemas]]<br>                         | 0..*        | schema property - `not yet supported`                |
| `DEFINES_SERVERS`                  | [[Node - AsyncAPI Server\|:AsyncAPI:Server]]                               | 0..*        | a server of the AsyncApi                             |
| `DEFINES_CHANNEL`                  | [[Node - AsyncAPI Channel\|:AsyncAPI:Channel]]                             | 0..*        | a channel of the AsyncApi                            |
| `DEFINES_OPERATION`                | [[Node - AsyncAPI Operation\|:AsyncAPI:Operation]]                         | 0..*        | an operation of the AsyncApi                         |
| `DEFINES_MESSAGE`                  | [[Node - AsyncAPI Server\|:AsyncAPI:Server]]                               | 0..*        | a message of the AsyncApi                            |
| `DEFINES_SECURITY_SCHEME`          | [[Node - AsyncAPI SecurityScheme\|:AsyncAPI:SecurityScheme]]               | 0..*        | declaration of a security scheme                     |
| `DEFINES_SERVER_VARIABLE`          | [[Node - AsyncAPI ServerVariable\|:AsyncAPI:ServerVariable]]               | 0..*        | set of server variables                              |
| `DEFINES_PARAMETERS`               | [[Node - AsyncAPI Parameters\|:AsyncAPI:Parameters]]                       | 0..*        | set of parameters                                    |
| `DEFINES_CORRELATION_ID`           | [[Node - AsyncAPI CorrelationID\|:AsyncAPI:CorrelationID]]                 | 0..*        | a correlation id of the AsyncAPI                     |
| `DEFINES_REPLY`                    | [[Node - AsyncAPI OperationReply\|:AsyncAPI:OperationReply]]               | 0..*        | an operation reply property                          |
| `DEFINES_REPLY_ADDRESS`            | [[Node - AsyncAPI OperationReplyAddress\|:AsyncAPI:OperationReplyAddress]] | 0..*        | an operation reply address property                  |
| `REFERS_TO_EXTERNAL_DOCUMENTATION` | [[Node - AsyncAPI ExternalDocumentation\|:AsyncAPI:ExternalDocumentation]] | 0..1        | property holding a link to an external documentation |
| `HAS_TAG`                          | [[Node - AsyncAPI Tag\|:AsyncAPI:Tag]]                                     | 0..*        | a tag holding metadata                               |
| `DEFINES_OPERATION_TRAIT`          | [[Node - AsyncAPI OperationTrait\|:AsyncAPI:OperationTrait]]               | 0..*        | a operation trait declaration                        |
| `DEFINES_MESSAGE_TRAIT`            | [[Node - AsyncAPI MessageTrait\|:AsyncAPI:MessageTrait]]                   | 0..*        | a message trait declaration                          |
| `DEFINES_CHANNEL_BINDINGS`         | [[Node - AsyncAPI ChannelBindings\|:AsyncAPI:ChannelBindings]]             | 0..1        | set of declaration of available message bindings     |
| `DEFINES_SERVER_BINDINGS`          | [[Node - AsyncAPI ServerBindings\|:AsyncAPI:ServerBindings]]               | 0..1        | set of declaration of available server bindings      |
| `DEFINES_OPERATION_BINDINGS`       | [[Node - AsyncAPI OperationBindings\|:AsyncAPI:OperationBindings]]         | 0..1        | set of declaration of available operation bindings   |
| `DEFINES_MESSAGE_BINDINGS`         | [[Node - AsyncAPI MessageBindings\|:AsyncAPI:MessageBindings]]             | 0..1        | set of declaration of available message bindings     |
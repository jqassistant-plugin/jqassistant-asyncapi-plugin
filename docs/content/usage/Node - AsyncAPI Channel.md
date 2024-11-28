# `:AsyncAPI:Channel` Node

-> represents a communication channel

## Properties

| Name          | Description                           |
|---------------|---------------------------------------|
| `address`     | address of the channel                |
| `title`       | title of the channel (human-friendly) |
| `summary`     | short summary of the channel          |
| `description` | detailed description of the channel   |

## Relations

| Name                               | Target Label(s)                                                                                                                                          | Cardinality | Description                                                                                                |
|------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|-------------|------------------------------------------------------------------------------------------------------------|
| `HAS_TAG`                          | [[Node - AsyncAPI Tag\|:AsyncAPI:Tag]]                                                                                                                   | 0..*        | tags for grouping of tags                                                                                  |
| `INCLUDES_PARAMETER`               | [[Node - AsyncAPI Parameter\|:AsyncAPI:Parameter]]                                                                                                       | 0..*        | a parameter included in the channel address - only present if address contains channel address expressions |
| `REFERS_TO_EXTERNAL_DOCUMENTATION` | [[Node - AsyncAPI ExternalDocumentation\|:AsyncAPI:ExternalDocumentation]]<br/>/[[Node - AsyncAPI Reference\|:AsyncAPI:Reference:ExternalDocumentation]] | 0..1        | property holding a link to an external documentation / reference                                           |
| `DEFINES_BINDINGS`                 | [[Node - AsyncAPI ChannelBindings\|:AsyncAPI:ChannelBindings]]<br/>/[[Node - AsyncAPI Reference\|:AsyncAPI:Reference:ChannelBindings]]                   | 0..1        | all specific definitions for each supported protocol  / reference                                          |
| `SUPPORTS_MESSAGE"`                | [[Node - AsyncAPI Message\|:AsyncAPI:Message]]                                                                                                           | 0..*        | messages that can be sent to the channel                                                                   |
| `IN_SERVER"`                       | [[Node - AsyncAPI Server\|:AsyncAPI:Server:Reference]]                                                                                                   | 0..*        | reference to the server definition in which the channel is available                                       |




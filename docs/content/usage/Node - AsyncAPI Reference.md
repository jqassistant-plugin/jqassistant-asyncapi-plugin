# `:AsyncAPI:Reference` Node

-> reference node that references the actual definition of the object or another reference

## Explanation

Many of the objects found in an AsyncAPI document can also appear in the
form of a *[:REFERENCES]* relation to the actual object definition,
rather than being fully defined at every occurrence in the document.

To resolve these references, you can use [[Concept - ReferenceResolvesToTarget]].

## Example

```cypher
(:Operation)-[:ON_CHANNEL]->(channelReference:Reference:Channel)
-[:REFERENCES]->(actualChannelDefinition:Channel)
```

## Occurrences

| Source Label(s)                           | Relation     | Target Label(s)                                                            |
|-------------------------------------------|--------------|----------------------------------------------------------------------------|
| :AsyncAPI:Reference:ExternalDocumentation | `REFERENCES` | [[Node - AsyncAPI ExternalDocumentation\|:AsyncAPI:ExternalDocumentation]] |
| :AsyncAPI:Reference:Server                | `REFERENCES` | [[Node - AsyncAPI Server\|:AsyncAPI:Server]]                               |
| :AsyncAPI:Reference:Schemas               | `REFERENCES` | [[Node - AsyncAPI Schemas\|:AsyncAPI:Schemas]]                             |
| :AsyncAPI:Reference:Channel               | `REFERENCES` | [[Node - AsyncAPI Channel\|:AsyncAPI:]]                                    |
| :AsyncAPI:Reference:Operation             | `REFERENCES` | [[Node - AsyncAPI Operation\|:AsyncAPI:Operation]]                         |
| :AsyncAPI:Reference:Message               | `REFERENCES` | [[Node - AsyncAPI Message\|:AsyncAPI:Message]]                             |
| :AsyncAPI:Reference:SecurityScheme        | `REFERENCES` | [[Node - AsyncAPI SecurityScheme\|:AsyncAPI:SecurityScheme]]               |
| :AsyncAPI:Reference:ServerVariable        | `REFERENCES` | [[Node - AsyncAPI ServerVariable\|:AsyncAPI:ServerVariable]]               |
| :AsyncAPI:Reference:Parameters            | `REFERENCES` | [[Node - AsyncAPI Parameters\|:AsyncAPI:Parameters]]                       |
| :AsyncAPI:Reference:CorrelationID         | `REFERENCES` | [[Node - AsyncAPI CorrelationID\|:AsyncAPI:CorrelationID]]                 |
| :AsyncAPI:Reference:OperationReply        | `REFERENCES` | [[Node - AsyncAPI OperationReply\|:AsyncAPI:OperationReply]]               |
| :AsyncAPI:Reference:OperationReplyAddress | `REFERENCES` | [[Node - AsyncAPI OperationReplyAddress\|:AsyncAPI:OperationReplyAddress]] |
| :AsyncAPI:Reference:Tag                   | `REFERENCES` | [[Node - AsyncAPI Tag\|:AsyncAPI:Tag]]                                     |
| :AsyncAPI:Reference:OperationTrait        | `REFERENCES` | [[Node - AsyncAPI OperationTrait\|:AsyncAPI:OperationTrait]]               |
| :AsyncAPI:Reference:MessageTrait          | `REFERENCES` | [[Node - AsyncAPI MessageTrait\|:AsyncAPI:MessageTrait]]                   |
| :AsyncAPI:Reference:ChannelBindings       | `REFERENCES` | [[Node - AsyncAPI ChannelBindings\|:AsyncAPI:ChannelBindings]]             |
| :AsyncAPI:Reference:ServerBindings        | `REFERENCES` | [[Node - AsyncAPI ServerBindings\|:AsyncAPI:ServerBindings]]               |
| :AsyncAPI:Reference:OperationBindings     | `REFERENCES` | [[Node - AsyncAPI OperationBindings\|:AsyncAPI:OperationBindings]]         |
| :AsyncAPI:Reference:MessageBindings       | `REFERENCES` | [[Node - AsyncAPI MessageBindings\|:AsyncAPI:MessageBindings]]             |
| :AsyncAPI:Reference:Tag                   | `REFERENCES` | [[Node - AsyncAPI Tag\|:AsyncAPI:Tag]]                                     |



# `jqassistant-plugin-asyncapi:OperationSendsToOperation` Concept

-> merges sending operations to the receiving operation by adding a *[:SENDS_TO]-relation


## Required Concepts & Used Nodes
- [[Concept - ChannelMapsToChannel]]
- [[Concept - ReferenceResolvesToTarget]]
- [[Node - AsyncAPI Operation]]
- [[Node - AsyncAPI Channel]]

## Query
```cypher
MATCH
    (operationSend:Operation:AsyncAPI{action:"send"})
    -[:ON_CHANNEL|RESOLVES_TO*]->(:Channel:AsyncAPI)
    -[:MAPS_TO*0..1]->(:Channel:AsyncAPI)<-[:RESOLVES_TO|ON_CHANNEL*]
    -(operationReceive:Operation:AsyncAPI{action:"receive"})
MERGE
    (operationSend)-[:SENDS_TO]->(operationReceive)
RETURN
    operationSend AS SendOperation, operationReceive AS ReceiveOperation
```
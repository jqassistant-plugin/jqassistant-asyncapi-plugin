# `jqassistant-plugin-asyncapi:ChannelMapsToChannel` Concept

-> checks channels across all scanned files for matches based on their channel addresses and 
   creates bidirectional *[:MAPS_TO]* relations between them


## Required Concepts & Used Nodes
- [[Node - AsyncAPI Channel]]

## Query
```cypher
MATCH
    (c1:Channel:AsyncAPI),(c2:Channel:AsyncAPI)
WHERE
    c1.address=c2.address AND c1<>c2
MERGE
    (c1)-[:MAPS_TO]->(c2)
RETURN
    c1 AS Channel1, c2 AS Channel2
```
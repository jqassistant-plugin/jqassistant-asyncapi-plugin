# `jqassistant-plugin-asyncapi:ReferenceResolvesToTarget` Concept

-> merges reference objects with the acutal objects they're refering to by adding 
   a *[:RESOLVES_TO]*-relation over any path length

## Required Concepts & Used Nodes
- [[Node - AsyncAPI Reference]]

## Query
```cypher
MATCH
    (source:Reference:AsyncAPI)-[:REFERENCES*]->(target:AsyncAPI)
WHERE NOT
    (target:Reference)
MERGE
    (source)-[:RESOLVES_TO]->(target)
RETURN
    source AS ReferencingObject, target AS ReferencedObject
```
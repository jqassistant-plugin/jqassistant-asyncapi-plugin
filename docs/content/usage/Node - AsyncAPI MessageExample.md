# `:AsyncAPI:MessageExample` Node

-> represents a message example

-> must contain either payload or headers field

## Properties

| Name          | Description                          |
|---------------|--------------------------------------|
| `name`        | name of the message example          |
| `summary`     | short summary of the message example |

## Relations

| Name                               | Target Label(s)                                                    | Cardinality | Description                                                                      |
|------------------------------------|--------------------------------------------------------------------|-------------|----------------------------------------------------------------------------------|
| `HAS_PAYLOAD`                      | [[Node - AsyncAPI MessagePayload\|:AsyncAPI:MessagePayload]]       | 0..*        | definition of the payload of the message - schema object - `not yet supported`   |
| `USES_HEADERS`                     | [[Node - AsyncAPI MessageHeaders\|:AsyncAPI:MessageHeaders]]       | 0..*        | definition of the application headers - schema object - `not yet supported`      |


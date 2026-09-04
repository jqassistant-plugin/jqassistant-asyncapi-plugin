# `:AsyncAPI:KafkaChannel` Node

-> configuration information for a kafka channel

## Properties

| Name              | Description                          |
|-------------------|--------------------------------------|
| `topic`           | topic name if different from channel |
| `partitions`      | number of partitions                 |
| `replicas`        | number of replicas                   |
| `binding version` | binding version                      |

## Relations

| Name                    | Target Label(s)                                                      | Cardinality | Description         |
|-------------------------|----------------------------------------------------------------------|-------------|---------------------|
| `DEFINES_CONFIGURATION` | [[Node - AsyncAPI TopicConfiguration\|:AsyncAPI:TopicConfiguration]] | 0..1        | `not yet supported` |



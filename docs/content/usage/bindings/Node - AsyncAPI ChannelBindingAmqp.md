# `:AsyncAPI:AmqpChannel` Node

-> configuration information for a websockets channel

## Properties

| Name             | Description                           |
|------------------|---------------------------------------|
| `is`             | "queue"/"routingKey": type of channel |
| `bindingVersion` | binding version                       |

## Relations

| Name               | Target Label(s)                                          | Cardinality | Description         |
|--------------------|----------------------------------------------------------|-------------|---------------------|
| `DEFINES_EXCHANGE` | [[Node - AsyncAPI AmqpExchange\|:AsyncAPI:AmqpExchange]] | 1           | `not yet supported` |
| `DEFINES_QUEUE`    | [[Node - AsyncAPI AmqpQueue\|:AsyncAPI:AmqpQueue]]       | 1           | `not yet supported` |


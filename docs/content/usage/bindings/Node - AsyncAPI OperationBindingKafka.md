# `:AsyncAPI:KafkaOperation` Node

-> information about a kafka operation

## Properties

| Name                      | Description               |
|---------------------------|---------------------------|
| `bindingVersion`          | binding version           |

## Relations

| Name            | Target Label(s)                                                                                        | Cardinality | Description |
|-----------------|--------------------------------------------------------------------------------------------------------|-------------|-------------|
| `HAS_GROUP_ID`  | [[Node - AsyncAPI Schema\|:AsyncAPI:Schema]] [[Node - AsyncAPI Reference\|:AsyncAPI:Schema:Reference]] | 0..1        | group id    |
| `HAS_CLIENT_ID` | [[Node - AsyncAPI Schema\|:AsyncAPI:Schema]] [[Node - AsyncAPI Reference\|:AsyncAPI:Schema:Reference]] | 0..1        | client id   |
# `:AsyncAPI:KafkaOperation` Node

-> information about a kafka operation

## Properties

| Name                      | Description               |
|---------------------------|---------------------------|
| `bindingVersion`          | binding version           |

## Relations

| Name            | Target Label(s)                                                                                        | Cardinality | Description           |
|-----------------|--------------------------------------------------------------------------------------------------------|-------------|-----------------------|
| `HAS_GROUP_ID`  | [[Node - AsyncAPI Schema\|:AsyncAPI:Schema]] [[Node - AsyncAPI Reference\|:AsyncAPI:Reference:Schema]] | 0..1        | group id / reference  |
| `HAS_CLIENT_ID` | [[Node - AsyncAPI Schema\|:AsyncAPI:Schema]] [[Node - AsyncAPI Reference\|:AsyncAPI:Reference:Schema]] | 0..1        | client id / reference |
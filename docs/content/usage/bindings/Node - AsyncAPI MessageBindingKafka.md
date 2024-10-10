# `:AsyncAPI:KafkaMessage` Node

-> information about a kafka message

## Properties

| Name                      | Description               |
|---------------------------|---------------------------|
| `schemaIdLocation`        | location of the schema id |
| `schemaIdPayloadEncoding` | number of bytes           |
| `schemaLookupStrategy`    | freeform string           |
| `bindingVersion`          | binding version           |

## Relations

| Name      | Target Label(s)                                                                                        | Cardinality | Description |
|-----------|--------------------------------------------------------------------------------------------------------|-------------|-------------|
| `HAS_KEY` | [[Node - AsyncAPI Schema\|:AsyncAPI:Schema]] [[Node - AsyncAPI Reference\|:AsyncAPI:Schema:Reference]] | 0..1        | message key |
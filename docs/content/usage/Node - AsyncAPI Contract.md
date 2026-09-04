
# `:AsyncAPI:Contract` Node

-> represents a top-level AsyncAPI declaration that is described by an AsyncAPI version, id, default content type, info, components, channels, operations and servers


## Properties

| Name       | Description                                   |
|------------|-----------------------------------------------|
| `asyncapi` | version of the AsyncApi                       |
| `id`       | id of the AsyncAPI                            |
| `defaultContentType`| default content type of the accessor property |

## Relations

| Name                 | Target Label(s)                                      | Cardinality | Description                    |
|----------------------|------------------------------------------------------|-------------|--------------------------------|
| `DEFINES_INFO`       | [[Node - AsyncAPI Info\|:AsyncAPI:Info]]<br>         | 0..1        | the info of the AsyncApi       |
| `DEFINES_COMPONENTS` | [[Node - AsyncAPI Components\|:AsyncAPI:Components]] | 0..1        | all components of the AsyncApi |
| `DEFINES_CHANNEL`    | [[Node - AsyncAPI Channel\|:AsyncAPI:Channel]]       | 0..*        | a channel of the AsyncApi      |
| `DEFINES_OPERATION`  | [[Node - AsyncAPI Operation\|:AsyncAPI:Operation]]   | 0..*        | an operation of the AsyncApi   |
| `DEFINES_SERVER`     | [[Node - AsyncAPI Server\|:AsyncAPI:Server]]         | 0..*        | a server of the AsyncApi       |

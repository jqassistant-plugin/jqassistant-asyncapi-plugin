# `:AsyncAPI:OperationReply` Node

-> represents the reply of a request operation

## Relations

| Name            | Target Label(s)                                                                                                                                       | Cardinality | Description                                                             |
|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|-------------|-------------------------------------------------------------------------|
| `HAS_ADDRESS`   | [[Node - AsyncAPI OperationReplyAddress\|:AsyncAPI:OperationReplyAddress]] / [[Node - AsyncAPI Reference\|:AsyncAPI:Reference:OperationReplyAddress]] | 0..1        | address that must be used for the reply  / reference                    |
| `ON_CHANNEL`    | [[Node - AsyncAPI Reference\|:AsyncAPI:Reference:Channel]]                                                                                            | 0..1        | reference to the channel definition in which the operation is performed |
| `USING_MESSAGE` | [[Node - AsyncAPI Reference\|:AsyncAPI:Reference:Message]]                                                                                            | 0..*        | reference to processable messages                                       |

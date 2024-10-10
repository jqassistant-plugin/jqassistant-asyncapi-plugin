# `:AsyncAPI:OperationReply` Node

-> represents the reply of a request operation

## Relations

| Name            | Target Label(s)                                                                                                                                       | Cardinality | Description                                                             |
|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|-------------|-------------------------------------------------------------------------|
| `HAS_ADDRESS`   | [[Node - AsyncAPI OperationReplyAddress\|:AsyncAPI:OperationReplyAddress]] / [[Node - AsyncAPI Reference\|:AsyncAPI:OperationReplyAddress:Reference]] | 0..1        | address that must be used for the reply                                 |
| `ON_CHANNEL`    | [[Node - AsyncAPI Reference\|:AsyncAPI:Channel:Reference]]                                                                                            | 0..1        | reference to the channel definition in which the operation is performed |
| `USING_MESSAGE` | [[Node - AsyncAPI Reference\|:AsyncAPI:Message:Reference]]                                                                                            | 0..*        | reference to processable messages                                       |

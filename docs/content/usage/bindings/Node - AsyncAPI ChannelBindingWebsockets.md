# `:AsyncAPI:WebsocketsChannel` Node

-> configuration information for a websockets channel

## Properties

| Name             | Description                      |
|------------------|----------------------------------|
| `method`         | "GET"/"POST": http method to use |
| `bindingVersion` | binding version                  |

## Relations

| Name         | Target Label(s)                                                                                          | Cardinality | Description                                                            |
|--------------|----------------------------------------------------------------------------------------------------------|-------------|------------------------------------------------------------------------|
| `HAS_QUERY`  | [[Node - AsyncAPI Schema\|:AsyncAPI:Schema]] / [[Node - AsyncAPI Reference\|:AsyncAPI:Reference:Schema]] | 0..1        | definitions for each query parameter / reference - `not yet supported` |
| `HAS_HEADER` | [[Node - AsyncAPI Schema\|:AsyncAPI:Schema]] / [[Node - AsyncAPI Reference\|:AsyncAPI:Reference:Schema]] | 0..1        | definitions of the http headers / reference - `not yet supported`      |


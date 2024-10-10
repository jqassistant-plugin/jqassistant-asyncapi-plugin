# `:AsyncAPI:ServerBindings` Node

-> holds all available server bindings
-> there are just some bindings supported at the moment

## Relations

| Name                    | Target Label(s)                                        | Cardinality | Description                   |
|-------------------------|--------------------------------------------------------|-------------|-------------------------------|
| `DEFINES_KAFKA_BINDING` | [[Node - AsyncAPI KafkaServer\|:AsyncAPI:KafkaServer]] | 0..1        | binding information for kafka |
| `DEFINES_JMS_BINDING`   | [[Node - AsyncAPI JmsServer\|:AsyncAPI:JmsServer]]     | 0..1        | binding information for jms   |

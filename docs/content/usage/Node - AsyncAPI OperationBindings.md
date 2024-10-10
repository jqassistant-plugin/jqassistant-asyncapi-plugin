# `:AsyncAPI:OperationBindings` Node

-> holds all available message bindings
-> there are just some bindings supported at the moment

## Relations

| Name                               | Target Label(s)                                                     | Cardinality | Description                   |
|------------------------------------|---------------------------------------------------------------------|-------------|-------------------------------|
| `DEFINES_AMQP_BINDING` | [[Node - AsyncAPI OperationBindingAMQP\|:AsyncAPI:AMQPOperation]]   | 0..1        | binding information for amqp  |
| `DEFINES_KAFKA_BINDING`                          | [[Node - AsyncAPI OperationBindingKafka\|:AsyncAPI:KafkaOperation]] | 0..*        | binding information for kafka |

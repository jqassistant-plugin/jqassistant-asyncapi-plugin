# `:AsyncAPI:MessageBindings` Node

-> holds all available message bindings
-> there are just some bindings supported at the moment

## Relations

| Name                    | Target Label(s)                                                 | Cardinality | Description                   |
| ----------------------- | --------------------------------------------------------------- | ----------- | ----------------------------- |
| `DEFINES_AMQP_BINDING`  | [[Node - AsyncAPI MessageBindingAMQP\|:AsyncAPI:AMQPMessage]]   | 0..1        | binding information for amqp  |
| `DEFINES_KAFKA_BINDING` | [[Node - AsyncAPI MessageBindingKafka\|:AsyncAPI:KafkaMessage]] | 0..1        | binding information for kafka |
| `DEFINES_JMS_BINDING`   | [[Node - AsyncAPI MessageBindingJMS\|:AsyncAPI:JmsMessage]]     | 0..1        | binding information for jms   |

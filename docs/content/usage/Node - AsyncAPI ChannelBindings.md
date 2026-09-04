# `:AsyncAPI:ChannelBindings` Node

-> holds all available channel bindings
-> there are just some bindings supported at the moment

## Relations

| Name                         | Target Label(s)                                                           | Cardinality | Description                        |
|------------------------------|---------------------------------------------------------------------------|-------------|------------------------------------|
| `DEFINES_AMQP_BINDING`       | [[Node - AsyncAPI ChannelBindingAMQP\|:AsyncAPI:AMQPChannel]]             | 0..1        | binding information for amqp       |
| `DEFINES_KAFKA_BINDING`      | [[Node - AsyncAPI ChannelBindingKafka\|:AsyncAPI:KafkaChannel]]           | 0..*        | binding information for kafka      |
| `DEFINES_WEBSOCKETS_BINDING` | [[Node - AsyncAPI ChannelBindingWebsockets\|:AsyncAPI:WebsocketsChannel]] | 0..1        | binding information for websockets |
| `DEFINES_JMS_BINDING`        | [[Node - AsyncAPI ChannelBindingJMS\|:AsyncAPI:JMSChannel]]               | 0..*        | binding information for jms        |

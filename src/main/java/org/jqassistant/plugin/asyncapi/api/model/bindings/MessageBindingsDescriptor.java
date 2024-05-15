package org.jqassistant.plugin.asyncapi.api.model.bindings;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.amqp.AmqpMessageBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaMessageBindingsDescriptor;

@Label("Message_Binding")
public interface MessageBindingsDescriptor extends AsyncApiDescriptor {

    @Relation("HAS_AMQP_BINDING")
    AmqpMessageBindingsDescriptor getAmqp();

    void setAmqp(AmqpMessageBindingsDescriptor amqp);

    @Relation("HAS_KAFKA_OPERATION")
    KafkaMessageBindingsDescriptor getKafka();

    void setKafka(KafkaMessageBindingsDescriptor kafka);

}

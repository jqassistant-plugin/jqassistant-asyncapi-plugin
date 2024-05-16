package org.jqassistant.plugin.asyncapi.api.model.bindings;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.amqp.AmqpMessageBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsMessageBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaMessageBindingsDescriptor;

@Label("Message_Binding")
public interface MessageBindingsDescriptor extends ReferenceableDescriptor {

    @Relation("HAS_AMQP_BINDING")
    AmqpMessageBindingsDescriptor getAmqp();

    void setAmqp(AmqpMessageBindingsDescriptor amqp);

    @Relation("HAS_KAFKA_BINDING")
    KafkaMessageBindingsDescriptor getKafka();

    void setKafka(KafkaMessageBindingsDescriptor kafka);

    @Relation("HAS_JMS_BINDING")
    JmsMessageBindingsDescriptor getJms();

    void setJms(JmsMessageBindingsDescriptor jms);

}

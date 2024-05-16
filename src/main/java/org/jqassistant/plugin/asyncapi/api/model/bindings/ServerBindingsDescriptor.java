package org.jqassistant.plugin.asyncapi.api.model.bindings;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.amqp.AmqpServerBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsServerBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaServerBindingsDescriptor;

@Label("Server_Binding")
public interface ServerBindingsDescriptor extends ReferenceableDescriptor {

    @Relation("HAS_AMQP_BINDING")
    AmqpServerBindingsDescriptor getAmqp();

    void setAmqp(AmqpServerBindingsDescriptor amqp);

    @Relation("HAS_KAFKA_BINDING")
    KafkaServerBindingsDescriptor getKafka();

    void setKafka(KafkaServerBindingsDescriptor kafka);

    @Relation("HAS_JMS_BINDING")
    JmsServerBindingsDescriptor getJms();

    void setJms(JmsServerBindingsDescriptor jms);
}

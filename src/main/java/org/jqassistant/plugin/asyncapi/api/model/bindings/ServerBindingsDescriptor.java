package org.jqassistant.plugin.asyncapi.api.model.bindings;

import com.buschmais.jqassistant.core.store.api.model.Descriptor;
import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.amqp.AmqpServerBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaServerBindingsDescriptor;

@Label("Server_Binding")
public interface ServerBindingsDescriptor extends Descriptor, AsyncApiDescriptor {

    @Relation("HAS_AMQP_SERVER")
    AmqpServerBindingsDescriptor getAmqp();

    void setAmqp(AmqpServerBindingsDescriptor amqp);

    @Relation("HAS_KAFKA_SERVER")
    KafkaServerBindingsDescriptor getKafka();

    void setKafka(KafkaServerBindingsDescriptor kafka);
}

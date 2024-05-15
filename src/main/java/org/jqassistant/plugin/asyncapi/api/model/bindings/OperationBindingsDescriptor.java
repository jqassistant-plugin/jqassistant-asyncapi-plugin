package org.jqassistant.plugin.asyncapi.api.model.bindings;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.amqp.AmqpOperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaOperationBindingsDescriptor;

@Label("Operation_Binding")
public interface OperationBindingsDescriptor extends AsyncApiDescriptor {

    @Relation("HAS_AMQP_BINDING")
    AmqpOperationBindingsDescriptor getAmqp();

    void setAmqp(AmqpOperationBindingsDescriptor amqp);

    @Relation("HAS_KAFKA_OPERATION")
    KafkaOperationBindingsDescriptor getKafka();

    void setKafka(KafkaOperationBindingsDescriptor kafka);

}

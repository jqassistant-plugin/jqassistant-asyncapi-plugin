package org.jqassistant.plugin.asyncapi.api.model.bindings;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsServerBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaServerBindingsDescriptor;

@Label("ServerBindings")
public interface ServerBindingsDescriptor extends ReferenceableDescriptor {

    @Relation("DEFINES_KAFKA_BINDING")
    KafkaServerBindingsDescriptor getKafka();

    void setKafka(KafkaServerBindingsDescriptor kafka);

    @Relation("DEFINES_JMS_BINDING")
    JmsServerBindingsDescriptor getJms();

    void setJms(JmsServerBindingsDescriptor jms);



}

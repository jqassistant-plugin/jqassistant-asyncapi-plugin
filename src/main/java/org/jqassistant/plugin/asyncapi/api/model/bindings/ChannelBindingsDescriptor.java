package org.jqassistant.plugin.asyncapi.api.model.bindings;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.amqp.AmqpChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaChannelBindingsDescriptor;

@Label("Channel_Bindings")
public interface ChannelBindingsDescriptor extends AsyncApiDescriptor { //unter Annahme, dass bindings je protocol type nur einmal ja channel deklariert werden

    @Relation("HAS_KAFKA_BINDING")
    KafkaChannelBindingsDescriptor getKafka();

    void setKafka(KafkaChannelBindingsDescriptor bindings);

    @Relation("HAS_AMQP_BINDING")
    AmqpChannelBindingsDescriptor getAmqp();

    void setAmqp(AmqpChannelBindingsDescriptor amqp);

}

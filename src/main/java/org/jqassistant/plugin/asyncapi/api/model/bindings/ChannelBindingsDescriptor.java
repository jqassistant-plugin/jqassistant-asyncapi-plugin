package org.jqassistant.plugin.asyncapi.api.model.bindings;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.amqp.AmqpChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.websockets.WsChannelBindingsDescriptor;

@Label("ChannelBindings")
public interface ChannelBindingsDescriptor
        extends ReferenceableDescriptor { //unter Annahme, dass bindings je protocol type nur einmal ja channel deklariert werden

    @Relation("DEFINES_KAFKA_BINDING")
    KafkaChannelBindingsDescriptor getKafka();

    void setKafka(KafkaChannelBindingsDescriptor bindings);

    @Relation("DEFINES_AMQP_BINDING")
    AmqpChannelBindingsDescriptor getAmqp();

    void setAmqp(AmqpChannelBindingsDescriptor amqp);

    @Relation("DEFINES_WEBSOCKETS_BINDING")
    WsChannelBindingsDescriptor getWs();

    void setWs(WsChannelBindingsDescriptor ws);

    @Relation("DEFINES_JMS_BINDING")
    JmsChannelBindingsDescriptor getJms();

    void setJms(JmsChannelBindingsDescriptor jms);

}

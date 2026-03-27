package org.jqassistant.plugin.asyncapi.api.model.bindings.amqp;

import com.buschmais.xo.neo4j.api.annotation.Label;

import com.buschmais.xo.neo4j.api.annotation.Relation;
import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp.AMQPChannelExchange;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp.AMQPChannelQueue;

@Label("AmqpChannel")
public interface AmqpChannelBindingsDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    String getIs();

    void setIs(String is);

    @Relation("DEFINES_EXCHANGE")
    AMQPChannelExchange getExchange();

    void setExchange(AMQPChannelExchange exchange);

    @Relation("DEFINES_QUEUE")
    AMQPChannelQueue getQueue();

    void setQueue(AMQPChannelQueue queue);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
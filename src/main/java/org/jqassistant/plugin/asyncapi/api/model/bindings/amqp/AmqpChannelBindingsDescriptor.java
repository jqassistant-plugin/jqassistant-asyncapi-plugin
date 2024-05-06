package org.jqassistant.plugin.asyncapi.api.model.bindings.amqp;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp.AMQPChannelExchange;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.amqp.AMQPChannelQueue;

@Label("AMQP_Channel")
public interface AmqpChannelBindingsDescriptor extends ChannelBindingsDescriptor {

    String getIs();

    void setIs(String is);

    AMQPChannelExchange getExchange();

    void setExchange(AMQPChannelExchange exchange);

    AMQPChannelQueue getQueue();

    void setQueue(AMQPChannelQueue queue);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
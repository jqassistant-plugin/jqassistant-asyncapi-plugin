package org.jqassistant.plugin.asyncapi.api.model.bindings.amqp;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;

@Label("AMQPChannelExchange")
public interface AmqpExchangeDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    String getName();

    void setName(String name);

    String getType();

    void setType(String type);

    boolean getDurable();

    void setDurable(boolean durable);

    boolean getAutoDelete();

    void setAutoDelete(boolean autoDelete);

    String getVhost();

    void setVhost(String vhost);

}
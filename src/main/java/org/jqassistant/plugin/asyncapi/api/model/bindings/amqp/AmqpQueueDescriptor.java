package org.jqassistant.plugin.asyncapi.api.model.bindings.amqp;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;

@Label("AMQP_Channel_Queue")
public interface AmqpQueueDescriptor extends ReferenceableDescriptor {

    String getName();

    void setName(String name);

    String getType();

    void setType(String type);

    boolean getDurable();

    void setDurable(boolean durable);

    boolean getExclusive();

    void setExclusive(boolean exclusive);

    boolean getAutoDelete();

    void setAutoDelete(boolean autoDelete);

    String getVhost();

    void setVhost(String vhost);

}
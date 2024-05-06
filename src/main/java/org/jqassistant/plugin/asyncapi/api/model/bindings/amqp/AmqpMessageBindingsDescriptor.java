package org.jqassistant.plugin.asyncapi.api.model.bindings.amqp;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;

@Label("AMQP_Message")
public interface AmqpMessageBindingsDescriptor extends ChannelBindingsDescriptor {

    String getContentEncoding();

    void setContentEncoding(String encoding);

    String getMessageType();

    void setMessageType(String MessageType);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
package org.jqassistant.plugin.asyncapi.api.model.bindings.amqp;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;

@Label("AmqpMessage")
public interface AmqpMessageBindingsDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    String getContentEncoding();

    void setContentEncoding(String encoding);

    String getMessageType();

    void setMessageType(String messageType);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
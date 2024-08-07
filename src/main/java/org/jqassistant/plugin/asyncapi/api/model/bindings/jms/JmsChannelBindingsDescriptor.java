package org.jqassistant.plugin.asyncapi.api.model.bindings.jms;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;

@Label("JmsChannel")
public interface JmsChannelBindingsDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    String getDestination();

    void setDestination(String destination);

    String getDestinationType();

    void setDestinationType(String destinationType);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
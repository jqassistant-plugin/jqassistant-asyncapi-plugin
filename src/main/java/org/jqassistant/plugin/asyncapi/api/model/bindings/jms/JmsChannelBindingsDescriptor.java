package org.jqassistant.plugin.asyncapi.api.model.bindings.jms;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;

@Label("Jms_Channel")
public interface JmsChannelBindingsDescriptor extends ReferenceableDescriptor {

    String getDestination();

    void setDestination(String destination);

    String getDestinationType();

    void setDestinationType(String destinationType);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
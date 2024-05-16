package org.jqassistant.plugin.asyncapi.api.model.bindings.jms;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;

@Label("jms_Server")
public interface JmsServerBindingsDescriptor extends ReferenceableDescriptor {

    String getJmsConnectionFactory();

    void setJmsConnectionFactory(String jmsConnectionFactory);

    String getProperties(); //Array of Properties, List better solution?

    void setProperties(String properties);

    String getClientId();

    void setClientId(String clientId);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
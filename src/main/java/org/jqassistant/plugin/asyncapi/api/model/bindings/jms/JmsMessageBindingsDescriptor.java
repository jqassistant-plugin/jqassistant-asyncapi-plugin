package org.jqassistant.plugin.asyncapi.api.model.bindings.jms;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.SchemaDescriptor;

@Label("JmsMessage")
public interface JmsMessageBindingsDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    //can be SchemaObject, Reference Object OR AVRO Schema Object
    SchemaDescriptor getHeaders();

    void setHeaders(SchemaDescriptor headers);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
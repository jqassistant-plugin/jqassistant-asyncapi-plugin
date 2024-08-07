package org.jqassistant.plugin.asyncapi.api.model.bindings.kafka;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;

@Label("KafkaServer")
public interface KafkaServerBindingsDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    String getSchemaRegistryUrl();

    void setSchemaRegistryUrl(String schemaRegistryUrl);

    String getSchemaRegistryVendor();

    void setSchemaRegistryVendor(String schemaRegistryVendor);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
package org.jqassistant.plugin.asyncapi.api.model.bindings.kafka;

import com.buschmais.jqassistant.core.store.api.model.Descriptor;
import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.ServerBindingsDescriptor;

@Label("Kafka_Server")
public interface KafkaServerBindingsDescriptor extends ServerBindingsDescriptor, Descriptor, AsyncApiDescriptor {

    String getSchemaRegistryUrl();

    void setSchemaRegistryUrl(String schemaRegistryUrl);

    String getSchemaRegistryVendor();

    void setSchemaRegistryVendor(String schemaRegistryVendor);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
package org.jqassistant.plugin.asyncapi.api.model.bindings.kafka;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.ServerBindingsDescriptor;

@Label("Kafka_Server")
public interface KafkaServerBindingsDescriptor extends ServerBindingsDescriptor , ReferenceDescriptor {


    String getSchemaRegistryUrl();

    void setSchemaRegistryUrl(String schemaRegistryUrl);

    String getSchemaRegistryVendor();

    void setSchemaRegistryVendor(String schemaRegistryVendor);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
package org.jqassistant.plugin.asyncapi.api.model.bindings.kafka;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.SchemaDescriptor;

@Label("Kafka_Operation")
public interface KafkaOperationBindingsDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    SchemaDescriptor getGroupId();

    void setGroupId(SchemaDescriptor groupId);

    SchemaDescriptor getClientId();

    void setClientId(SchemaDescriptor clientId);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
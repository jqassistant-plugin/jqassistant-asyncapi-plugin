package org.jqassistant.plugin.asyncapi.api.model.bindings.kafka;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.SchemaDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.OperationBindingsDescriptor;

@Label("Kafka_Operation")
public interface KafkaOperationBindingsDescriptor extends OperationBindingsDescriptor, ReferenceDescriptor {

    SchemaDescriptor getGroupId();

    void setGroupId(SchemaDescriptor groupId);

    SchemaDescriptor getClientId();

    void setClientId(SchemaDescriptor clientId);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
package org.jqassistant.plugin.asyncapi.api.model.bindings.kafka;

import com.buschmais.xo.neo4j.api.annotation.Label;

import com.buschmais.xo.neo4j.api.annotation.Relation;
import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.SchemaDescriptor;

@Label("KafkaOperation")
public interface KafkaOperationBindingsDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    @Relation("HAS_GROUP_ID")
    SchemaDescriptor getGroupId();

    void setGroupId(SchemaDescriptor groupId);

    @Relation("HAS_CLIENT_ID")
    SchemaDescriptor getClientId();

    void setClientId(SchemaDescriptor clientId);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
package org.jqassistant.plugin.asyncapi.api.model.bindings.kafka;

import com.buschmais.xo.neo4j.api.annotation.Label;

import com.buschmais.xo.neo4j.api.annotation.Relation;
import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.SchemaDescriptor;

@Label("KafkaMessage")
public interface KafkaMessageBindingsDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    //can be SchemaObject, Reference Object OR AVRO Schema Object
    @Relation("HAS_KEY")
    SchemaDescriptor getKey();
    void setKey(SchemaDescriptor key);

    String getSchemaIdLocation();

    void setSchemaIdLocation(String schemaIdLocation);

    String getSchemaIdPayloadEncoding();

    void setSchemaIdPayloadEncoding(String schemaIdPayloadEncoding);

    String getSchemaLookupStrategy();

    void setSchemaLookupStrategy(String schemaLookupStrategy);

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
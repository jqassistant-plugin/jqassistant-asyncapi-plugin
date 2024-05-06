package org.jqassistant.plugin.asyncapi.api.model.bindings.kafka;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.SchemaDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;

@Label("Kafka_Message")
public interface KafkaMessageBindingsDescriptor extends ChannelBindingsDescriptor, ReferenceDescriptor {

    //can be SchemaObject, Reference Object OR AVRO Schema Object
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
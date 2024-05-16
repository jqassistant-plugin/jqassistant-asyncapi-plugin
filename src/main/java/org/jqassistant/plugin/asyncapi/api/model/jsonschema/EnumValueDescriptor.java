package org.jqassistant.plugin.asyncapi.api.model.jsonschema;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("EnumValue")
public interface EnumValueDescriptor extends JsonSchemaDescriptor {
    String getEnumName();
    void setEnumName(String enumName);
}
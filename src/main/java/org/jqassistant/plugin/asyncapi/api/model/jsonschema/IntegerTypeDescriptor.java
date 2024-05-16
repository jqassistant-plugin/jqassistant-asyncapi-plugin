package org.jqassistant.plugin.asyncapi.api.model.jsonschema;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("Integer")
public interface IntegerTypeDescriptor extends TypeDescriptor {

    String TYPE_NAME = "integer";
}
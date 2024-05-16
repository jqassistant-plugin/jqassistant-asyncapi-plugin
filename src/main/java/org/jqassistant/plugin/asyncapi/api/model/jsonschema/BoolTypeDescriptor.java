package org.jqassistant.plugin.asyncapi.api.model.jsonschema;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("Boolean")
public interface BoolTypeDescriptor extends TypeDescriptor {
    String TYPE_NAME = "boolean";
}
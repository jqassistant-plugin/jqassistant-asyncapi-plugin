package org.jqassistant.plugin.asyncapi.api.model.jsonschema;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

@Label("Object")
public interface ObjectTypeDescriptor extends TypeDescriptor {

    String TYPE_NAME = "object";

    @Relation("HAS_PROPERTY")
    List<PropertyDescriptor> getProperties();

}
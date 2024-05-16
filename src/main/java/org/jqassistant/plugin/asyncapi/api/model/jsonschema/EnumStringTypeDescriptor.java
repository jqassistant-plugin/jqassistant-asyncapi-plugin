package org.jqassistant.plugin.asyncapi.api.model.jsonschema;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

@Label("Enum")
public interface EnumStringTypeDescriptor extends StringTypeDescriptor {
    @Relation("HAS_VALUES")
    List<EnumValueDescriptor> getValues();

    void setValues(List<EnumValueDescriptor> values);
}
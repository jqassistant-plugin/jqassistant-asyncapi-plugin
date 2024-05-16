package org.jqassistant.plugin.asyncapi.api.model.jsonschema;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

@Label("Discriminator")
public interface DiscriminatorDescriptor extends JsonSchemaDescriptor {
    @Relation("REFERS_TO_PROPERTY")
    PropertyDescriptor getProperty();
    void setProperty(PropertyDescriptor property);

    @Relation("MAPPING")
    List<DiscriminatorMappingDescriptor> getMapping();

}
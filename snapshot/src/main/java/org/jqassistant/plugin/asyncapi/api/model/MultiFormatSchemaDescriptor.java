package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("MultiFormatSchema")
public interface MultiFormatSchemaDescriptor extends SchemasDescriptor {

    String getSchemaFormat();

    void setSchemaFormat(String schemaFormat);

    Object getSchema();

    void setSchema(Object reference);

}

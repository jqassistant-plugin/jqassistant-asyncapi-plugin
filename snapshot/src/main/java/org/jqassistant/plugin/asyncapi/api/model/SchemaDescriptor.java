package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("Schema")
public interface SchemaDescriptor extends SchemasDescriptor {

    String getDiscriminator();

    void setDiscriminator(String discriminator);

    boolean getDeprecated();

    void setDeprecated(boolean deprecated);

    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);
}

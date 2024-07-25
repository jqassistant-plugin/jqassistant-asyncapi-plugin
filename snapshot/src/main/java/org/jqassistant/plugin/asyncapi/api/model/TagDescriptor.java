package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

@Label("Tag")
public interface TagDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor  {

    String getName();
    void setName(String name);

    String getDescription();

    void setDescription(String description);

    @Relation("REFERS_TO_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);
}
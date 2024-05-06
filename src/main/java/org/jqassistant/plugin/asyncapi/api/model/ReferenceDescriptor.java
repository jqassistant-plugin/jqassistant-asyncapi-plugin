package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

@Label("Reference")
public interface ReferenceDescriptor extends AsyncApiDescriptor {

    @Relation("REFERENCES")
    String getReference();

    void setReference(String reference);

}

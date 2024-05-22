package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("Reference")
public interface ReferenceDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    String getReference();

    void setReference(String reference);

}

package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.jqassistant.core.store.api.model.Descriptor;
import com.buschmais.xo.api.annotation.Abstract;
import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("Referenceable")
@Abstract
public interface ReferenceableDescriptor extends Descriptor {

    String getReferenceableKey();

    void setReferenceableKey(String referenceableKey);

    String getPath();

    void setPath(String path);

}

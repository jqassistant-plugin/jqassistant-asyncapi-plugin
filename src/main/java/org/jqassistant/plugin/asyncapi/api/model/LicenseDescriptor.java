package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("License")
public interface LicenseDescriptor extends ReferenceableDescriptor {

    String getName();
    void setName(String name);

    String getUrl();
    void setUrl(String url);
}

package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("CorrelationID")
public interface CorrelationIDDescriptor extends AsyncApiDescriptor {

    String getDescription();

    void setDescription(String description);

    String getLocation();

    void setLocation(String location);
}

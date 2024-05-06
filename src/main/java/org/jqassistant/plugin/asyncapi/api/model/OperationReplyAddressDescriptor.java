package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("OperationReplyAddress")
public interface OperationReplyAddressDescriptor extends AsyncApiDescriptor, ReferenceDescriptor {

    String getDescription();

    void setDescription(String description);

    String getLocation();

    void setLocation(String location);

}

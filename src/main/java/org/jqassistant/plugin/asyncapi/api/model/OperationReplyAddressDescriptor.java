package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("Operation_Reply_Address")
public interface OperationReplyAddressDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor  {

    String getDescription();

    void setDescription(String description);

    String getLocation();

    void setLocation(String location);

}

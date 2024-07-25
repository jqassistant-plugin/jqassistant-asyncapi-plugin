package org.jqassistant.plugin.asyncapi.api.model;

import java.util.Map;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("MessageExample")
public interface MessageExampleDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor  {

    Map<String, Object> getHeaders();

    void setHeaders(Map<String, Object> headers);

    Map<String, Object> getPayload();

    void setPayload(Map<String, Object> payload);

    String getName();

    void setName(String name);

    String getSummary();

    void setSummary(String summary);
}

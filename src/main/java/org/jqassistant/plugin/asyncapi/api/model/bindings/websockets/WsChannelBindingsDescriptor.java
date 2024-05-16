package org.jqassistant.plugin.asyncapi.api.model.bindings.websockets;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;

@Label("Websockets_Channel")
public interface WsChannelBindingsDescriptor extends ReferenceableDescriptor {

    String getMethod();

    void setMethod(String method);

    /**
     * saved for later usage with schemas
     **/
   /* @Relation("HAS_QUERY")
    SchemaDescriptor getQuery();

    void setQuery (SchemaDescriptor query);

    @Relation("HAS_HEADER")
    SchemaObjectDescriptor getHeaders();

    void setHeaders (SchemaObjectDescriptor headers);*/

    String getBindingVersion();

    void setBindingVersion(String bindingVersion);

}
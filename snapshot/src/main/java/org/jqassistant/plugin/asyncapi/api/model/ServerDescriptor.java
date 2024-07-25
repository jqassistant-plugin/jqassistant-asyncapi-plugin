package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;
import org.jqassistant.plugin.asyncapi.api.model.bindings.ServerBindingsDescriptor;

import java.util.List;

@Label("Server")
public interface ServerDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {
    String getTitle();

    void setTitle(String title);

    String getSummary();

    void setSummary(String summary);

    String getDescription();

    void setDescription(String description);

    String getHost();

    void setHost(String host);

    String getProtocol();

    void setProtocol(String protocol);

    String getProtocolVersion();

    void setProtocolVersion(String protocolVersion);

    String getPathName();

    void setPathName(String pathName);

    @Relation("DEFINES_SERVER_VARIABLE")
    List<ServerVariableDescriptor> getVariables();

    @Relation("DEFINES_SECURITY_SCHEME")
    List<SecuritySchemeDescriptor> getSecurity();


    @Relation("REFERS_TO_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);

    @Relation("HAS_TAG")
    List<TagDescriptor> getTags();

    @Relation("DEFINES_SERVER_BINDING")
    ServerBindingsDescriptor getBindings();

    void setBindings(ServerBindingsDescriptor bindings);
}

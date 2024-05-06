package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ServerBindingsDescriptor;

@Label("Server")
public interface ServerDescriptor extends AsyncApiDescriptor {
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

    @Relation("USES_SERVER_VARIABLES")
    List<ServerVariableDescriptor> getVariables();

    @Relation("HAS_SECURITY_SCHEME")
    SecuritySchemeDescriptor getSecurity();

    void setSecurity(SecuritySchemeDescriptor security);

    @Relation("HAS_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);

    @Relation("HAS_TAG")
    List<TagDescriptor> getTags();

    @Relation("USES_SERVER_BINDINGS")
    List<ServerBindingsDescriptor> getBindings();
}

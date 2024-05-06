package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;

@Label("Channel")
public interface ChannelDescriptor extends AsyncApiDescriptor, ReferenceDescriptor {

    String getAddress();

    void setAddress(String address);

    String getTitle();

    void setTitle(String title);

    String getSummary();

    void setSummary(String summary);

    String getDescription();

    void setDescription(String description);

    @Relation("HAS_TAG")
    List<TagDescriptor> getTags();

    @Relation("HAS_PARAMETER")
    List<ParametersDescriptor> getParameters();

    @Relation("HAS_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);

    @Relation("HAS_BINDINGS")
    List<ChannelBindingsDescriptor> getBindings();

    void setBindings(List<ChannelBindingsDescriptor> bindings);

    @Relation("DEFINES_MESSAGES")
    List<MessageDescriptor> getMessages();

    @Relation("REFERENCES_SERVER")
    List<ServerDescriptor> getServers();

    void setServers(List<ServerDescriptor> servers);
}


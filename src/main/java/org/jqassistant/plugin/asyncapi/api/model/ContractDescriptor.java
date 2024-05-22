package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.jqassistant.core.store.api.model.Descriptor;
import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

@Label("Contract")
public interface ContractDescriptor extends AsyncApiDescriptor, Descriptor {
    String getAsyncApiVersion();

    void setAsyncApiVersion(String asyncApiVersion);

    String getId();

    void setId(String id);

    String getDefaultContentType();

    void setDefaultContentType(String defaultContentType);

    @Relation("DEFINES_INFO")
    InfoDescriptor getInfo();

    void setInfo(InfoDescriptor info);

    @Relation("DEFINES_COMPONENTS")
    ComponentsDescriptor getComponents();

    void setComponents(ComponentsDescriptor components);

    @Relation("DEFINES_CHANNEL")
    List<ChannelDescriptor> getChannels();

    @Relation("DEFINES_OPERATION")
    List<OperationDescriptor> getOperations();

    @Relation("DEFINES_SERVER")
    List<ServerDescriptor> getServers();

}

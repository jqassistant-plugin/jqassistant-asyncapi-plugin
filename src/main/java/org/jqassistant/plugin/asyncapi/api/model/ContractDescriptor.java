package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

@Label("Contract")
public interface ContractDescriptor extends AsyncApiDescriptor {
    String getAsyncApiVersion();

    void setAsyncApiVersion(String asyncApiVersion);

    String getId();

    void setId(String id);

    String getDefaultContentType();

    void setDefaultContentType(String defaultContentType);

    @Relation("HAS_INFO")
    InfoDescriptor getInfo();

    void setInfo(InfoDescriptor info);

    @Relation("HAS_COMPONENTS")
    ComponentsDescriptor getComponents();

    void setComponents(ComponentsDescriptor components);

    @Relation("HAS_CHANNEL")
    List<ChannelDescriptor> getChannels();

    @Relation("USES_OPERATION")
    List<OperationDescriptor> getOperations();

    @Relation("HAS_SERVER")
    List<ServerDescriptor> getServers();

}

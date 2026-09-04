package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.MessageBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.OperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.ServerBindingsDescriptor;

@Label("Components")
public interface ComponentsDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor  {

    @Relation("DEFINES_SCHEMA")
    SchemasDescriptor getSchemas();

    @Relation("DEFINES_SERVERS")
    List<ServerDescriptor> getServers();

    @Relation("DEFINES_CHANNEL")
    List<ChannelDescriptor> getChannels();

    @Relation("DEFINES_OPERATION")
    List<OperationDescriptor> getOperations();

    @Relation("DEFINES_MESSAGE")
    List<MessageDescriptor> getMessages();

    @Relation("DEFINES_SECURITY_SCHEME")
    List<SecuritySchemeDescriptor> getSecuritySchemes();

    @Relation("DEFINES_SERVER_VARIABLE")
    List<ServerVariableDescriptor> getServerVariables();

    @Relation("DEFINES_PARAMETER")
    List<ParameterDescriptor> getParameter();

    @Relation("DEFINES_CORRELATION_ID")
    List<CorrelationIDDescriptor> getCorrelationIds();

    @Relation("DEFINES_REPLY")
    List<OperationReplyDescriptor> getOperationReplies();

    @Relation("DEFINES_REPLY_ADDRESS")
    List<OperationReplyAddressDescriptor> getOperationReplyAddresses();

    @Relation("REFERS_TO_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);

    @Relation("HAS_TAG")
    List<TagDescriptor> getTags();

    @Relation("DEFINES_OPERATION_TRAIT")
    List<OperationTraitDescriptor> getOperationTraits();

    @Relation("DEFINES_MESSAGE_TRAIT")
    List<MessageTraitDescriptor> getMessageTraits();

    @Relation("DEFINES_CHANNEL_BINDINGS")
    ChannelBindingsDescriptor getChannelBindings();

    void setChannelBindings(ChannelBindingsDescriptor channelBindings);

    @Relation("DEFINES_SERVER_BINDINGS")
    ServerBindingsDescriptor getServerBindings();

    @Relation("DEFINES_OPERATION_BINDINGS")
    OperationBindingsDescriptor getOperationBindings();

    @Relation("DEFINES_MESSAGE_BINDINGS")
    MessageBindingsDescriptor getMessageBindings();

}

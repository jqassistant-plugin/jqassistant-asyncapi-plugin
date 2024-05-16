package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.MessageBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.OperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.ServerBindingsDescriptor;

@Label("Components")
public interface ComponentsDescriptor extends ReferenceableDescriptor {

    @Relation("DEFINES_SCHEMA")
    SchemasDescriptor getSchemas();

    @Relation("HAS_SERVERS")
    List<ServerDescriptor> getServers();

    @Relation("HAS_CHANNEL")
    List<ChannelDescriptor> getChannels();

    @Relation("HAS_OPERATION")
    List<OperationDescriptor> getOperations();

    @Relation("HAS_MESSAGE")
    List<MessageDescriptor> getMessages();

    @Relation("HAS_SECURITY_SCHEME")
    List<SecuritySchemeDescriptor> getSecuritySchemes();

    @Relation("HAS_SERVER_VARIABLE")
    List<ServerVariableDescriptor> getServerVariables();

    @Relation("HAS_PARAMETERS")
    List<ParametersDescriptor> getParameters();

    @Relation("HAS_CORRELATION_ID")
    List<CorrelationIDDescriptor> getCorrelationIds();

    @Relation("HAS_REPLY")
    List<OperationReplyDescriptor> getOperationReplies();

    @Relation("HAS_REPLY_ADDRESS")
    List<OperationReplyAddressDescriptor> getOperationReplyAddresses();

    @Relation("HAS_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);

    @Relation("HAS_TAG")
    List<TagDescriptor> getTags();

    @Relation("HAS_OPERATION_TRAIT")
    List<OperationTraitDescriptor> getOperationTraits();

    @Relation("HAS_MESSAGE_TRAIT")
    List<MessageTraitDescriptor> getMessageTraits();

    @Relation("HAS_CHANNEL_BINDING")
    ChannelBindingsDescriptor getChannelBindings();

    void setChannelBindings(ChannelBindingsDescriptor channelBindings);

    @Relation("HAS_SERVER_BINDINGS")
    ServerBindingsDescriptor getServerBindings();

    @Relation("HAS_OPERATION_BINDINGS")
    OperationBindingsDescriptor getOperationBindings();

    @Relation("HAS_MESSAGE_BINDINGS")
    MessageBindingsDescriptor getMessageBindings();

}

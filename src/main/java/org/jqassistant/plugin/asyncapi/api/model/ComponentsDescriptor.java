package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import java.util.List;

@Label("Components")
public interface ComponentsDescriptor extends AsyncApiDescriptor {

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

   /* @Relation("DEFINES_SECURITY_SCHEME")
    List<SecuritySchemeDescriptor> getSecuritySchemes();*/

    @Relation("DEFINES_SERVER_VARIABLE")
    List<ServerVariableDescriptor> getServerVariables();

    @Relation("HAS_PARAMETER")
    List<ParametersDescriptor> getParameters();

    @Relation("HAS_CORRELATION_ID")
    List<CorrelationIDDescriptor> getCorrelationIds();

    @Relation("HAS_REPLY")
    List<OperationReplyDescriptor> getOperationReplies();

    @Relation("HAS_REPLY_ADDRESS")
    List<OperationReplyAddressDescriptor> getOperationReplyAddresses();

    //probably list needed - source: map with several docs
    @Relation("HAS_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);

    @Relation("HAS_TAG")
    List<TagDescriptor> getTags();

    @Relation("HAS_OPERATION_TRAITS")
    List<OperationTraitsDescriptor> getOperationTraits();

    @Relation("HAS_MESSAGE_TRAITS")
    List<MessageTraitDescriptor> getMessageTraits();

  /*   @Relation("HAS_SERVER_BINDINGS")
    List<ServerBindingsDescriptor> getServerBindings();

    @Relation("HAS_CHANNEL_BINDINGS")
    List<ChannelBindingsDescriptor> getChannelBindings();

    @Relation("HAS_OPERATION_BINDINGS")
    List<OperationBindingsDescriptor> getOperationBindings();

    @Relation("HAS_MESSAGE_BINDINGS")
    List<MessageBindingsDescriptor> getMessageBindings(); */

}

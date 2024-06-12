package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.bindings.OperationBindingsDescriptor;

@Label("Operation")
public interface OperationDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor  {
    String getTitle();

    void setTitle(String title);

    String getSummary();

    void setSummary(String summary);

    String getDescription();

    void setDescription(String description);

    String getAction();

    void setAction(String action);

    @Relation("REFERS_TO_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);

    @Relation("HAS_TAG")
    List<TagDescriptor> getTags();

    @Relation("ON_CHANNEL")
    ChannelDescriptor getChannel();
    void setChannel(ChannelDescriptor channel);
    //only ReferenceObject

    @Relation("SUPPORTS_BINDINGS")
    OperationBindingsDescriptor getBindings();

    void setBindings(OperationBindingsDescriptor bindings);

    @Relation("USING_MESSAGE")
    List<MessageDescriptor> getMessages();

    @Relation("DEFINES_TRAIT")
    List<OperationTraitDescriptor> getOperationTraits();

    @Relation("USING_REPLY")
    OperationReplyDescriptor getOperationReply();

    void setOperationReply(OperationReplyDescriptor operationReply);

    @Relation("USING_SECURITY_SCHEME")
    SecuritySchemeDescriptor getSecurityScheme();

    void setSecurityScheme(SecuritySchemeDescriptor scheme);

}

package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.bindings.OperationBindingsDescriptor;

@Label("Operation")
public interface OperationDescriptor extends AsyncApiDescriptor {
    String getTitle();

    void setTitle(String title);

    String getSummary();

    void setSummary(String summary);

    String getDescription();

    void setDescription(String description);

    String getAction();

    void setAction(String action);

    @Relation("HAS_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);

    @Relation("HAS_TAG")
    List<TagDescriptor> getTags();

    @Relation("DEFINES_CHANNEL")
    List<ChannelDescriptor> getChannel();
    //only ReferenceObject

    @Relation("HAS_BINDING")
    OperationBindingsDescriptor getBindings();

    void setBindings(OperationBindingsDescriptor bindings);

    @Relation("USES_MESSAGE")
    List<MessageDescriptor> getMessages();

    @Relation("HAS_OPERATION_TRAIT")
    List<OperationTraitDescriptor> getOperationTraits();

    @Relation("USES_REPLY")
    OperationReplyDescriptor getOperationReply();

    void setOperationReply(OperationReplyDescriptor operationReply);

    @Relation("HAS_SECURITY_SCHEME")
    SecuritySchemeDescriptor getSecurityScheme();

    void setSecurityScheme(SecuritySchemeDescriptor scheme);

}

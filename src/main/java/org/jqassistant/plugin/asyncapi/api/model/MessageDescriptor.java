package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;
import org.jqassistant.plugin.asyncapi.api.model.bindings.MessageBindingsDescriptor;

import java.util.List;

@Label("Message")
public interface MessageDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

  /*  @Relation("USES_HEADERS")
    Object getHeaders();
    void setHeaders(Object headers); ein ParentObject fuer Schema und Multi Format Schema?
    auch referenceable


    @Relation("HAS_PAYLOAD")
    Object getPayload();
    void setPayload(Object payload);*/

    @Relation("HAS_CORRELATION_ID")
    CorrelationIDDescriptor getCorrelationId();

    void setCorrelationId(CorrelationIDDescriptor correlationId);

    String getTitle();

    void setTitle(String title);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    String getSummary();

    void setSummary(String summary);

    String getContentType();

    void setContentType(String contentType);

    @Relation("HAS_TAG")
    List<TagDescriptor> getTags();

    void setTags(List<TagDescriptor> tags);

    @Relation("REFERS_TO_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);

    @Relation("DEFINES_BINDINGS")
    MessageBindingsDescriptor getBindings();

    void setBindings(MessageBindingsDescriptor bindings);

    @Relation("DEFINES_TRAIT")
    List<MessageTraitDescriptor> getTraits();

    void setTraits(List<MessageTraitDescriptor> traits);

    @Relation("HAS_EXAMPLE")
    List<MessageExampleDescriptor> getExamples();

    void setExamples(List<MessageExampleDescriptor> examples);

}
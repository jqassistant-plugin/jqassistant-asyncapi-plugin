package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.bindings.MessageBindingsDescriptor;

@Label("Message")
public interface MessageDescriptor extends AsyncApiDescriptor, ReferenceDescriptor {

  /*  @Relation("USES_HEADERS")
    Object getHeaders();
    void setHeaders(Object headers); ein ParentObject für Schema und Multi Format Schema?
    auch referenceable


    @Relation("HAS_PAYLOAD")
    Object getPayload();
    void setPayload(Object payload);*/

    @Relation("HAS_CorrelationID")
    CorrelationIDDescriptor getCorrelationID();

    void setCorrelationID(CorrelationIDDescriptor correlationId);

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

    @Relation("HAS_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocumentation();

    void setExternalDocumentation(ExternalDocsDescriptor externalDocumentation);

    @Relation("HAS_BINDINGS")
    List<MessageBindingsDescriptor> setBindings();

    @Relation("HAS_TRAITS")
    List<MessageTraitDescriptor> getTraits();

    void setTraits(List<MessageTraitDescriptor> traits);

    @Relation("HAS_EXAMPLES")
    List<MessageExampleDescriptor> getExamples();

    void setExamples(List<MessageExampleDescriptor> examples);

}
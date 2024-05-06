package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

@Label("MessageTrait")
public interface MessageTraitDescriptor extends AsyncApiDescriptor {

    /*  @Relation("USES_HEADERS")
    Object getHeaders();
    void setHeaders(Object headers); ein ParentObject für Schema und Multi Format Schema?
    auch referenceable siehe messageDescriptor*/

    @Relation("HAS_CorrelationID")
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

    @Relation("HAS_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);


   /* @Relation("HAS_BINDINGS")
    List<MessageBindingsDescriptor> setBindings(); */

    @Relation("HAS_EXAMPLES")
    List<MessageExampleDescriptor> getExamples();
}

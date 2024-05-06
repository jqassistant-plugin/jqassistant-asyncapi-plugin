package org.jqassistant.plugin.asyncapi.api.model;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

@Label("OperationTrait")
public interface OperationTraitsDescriptor extends AsyncApiDescriptor, ReferenceDescriptor {

    String getTitle();

    void setTitle(String title);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    String getSummary();

    void setSummary(String summary);

    @Relation("HAS_TAG")
    List<TagDescriptor> getTags();

    void setTags(List<TagDescriptor> tags);

    @Relation("HAS_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);


   /* @Relation("HAS_BINDINGS")
    List<MessageBindingsDescriptor> setBindings();
    void getBindings (List<MessageBindingsDescriptor> bindings);*/

}

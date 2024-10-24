package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import java.util.List;

@Label("OperationTrait")
public interface OperationTraitDescriptor extends ReferenceableDescriptor, AsyncApiDescriptor {

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    String getSummary();

    void setSummary(String summary);

    @Relation("HAS_TAG")
    List<TagDescriptor> getTags();

    void setTags(List<TagDescriptor> tags);

    @Relation("REFERS_TO_EXTERNAL_DOCUMENTATION")
    ExternalDocsDescriptor getExternalDocs();

    void setExternalDocs(ExternalDocsDescriptor externalDocs);

    @Relation("HAS_SECURITY_SCHEME")
    SecuritySchemeDescriptor getSecurity();

    void setSecurity(SecuritySchemeDescriptor security);


   /* @Relation("HAS_BINDINGS")
    List<OperationBindingsDescriptor> setBindings();
    void getBindings (List<OperationBindingsDescriptor> bindings);*/

}

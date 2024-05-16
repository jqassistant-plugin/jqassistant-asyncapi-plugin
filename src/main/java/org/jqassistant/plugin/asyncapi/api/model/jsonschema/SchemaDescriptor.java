package org.jqassistant.plugin.asyncapi.api.model.jsonschema;

import java.util.List;

import com.buschmais.xo.neo4j.api.annotation.Label;
import com.buschmais.xo.neo4j.api.annotation.Relation;

import org.jqassistant.plugin.asyncapi.api.model.ExternalDocsDescriptor;

@Label("Schema")
public interface SchemaDescriptor extends JsonSchemaDescriptor {

    @Relation("DISCRIMINATOR")
    String getDiscriminator();
    void setDiscriminator(String discriminator);

    @Relation("REFERENCES_EXTERNAL_DOCS")
    ExternalDocsDescriptor getExternalDocs();
    void setExternalDocs(ExternalDocsDescriptor externalDoc);

    boolean getDeprecated();
    void setDeprecated(boolean deprecated);

    String getTitle();
    void setTitle(String title);





    @Relation("IS")
    TypeDescriptor getIsType();
    void setIsType(TypeDescriptor typeDescriptor);



    @Relation("ALL_OF")
    List<TypeDescriptor> getAllOfSchemas();

    @Relation("ONE_OF")
    List<TypeDescriptor> getOneOfSchemas();

    @Relation("ANY_OF")
    List<TypeDescriptor> getAnyOfSchemas();
}

package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("Server_Variable")
public interface ServerVariableDescriptor extends AsyncApiDescriptor , ReferenceDescriptor{

    String getEnumValues();

    void setEnumValues(String enumValues);

    String getDefaultValue();

    void setDefaultValue(String defaultValue);

    String getDescription();

    void setDescription(String description);

    String getExamples();

    void setExamples(String examples);
}

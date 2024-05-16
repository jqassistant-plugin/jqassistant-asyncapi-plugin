package org.jqassistant.plugin.asyncapi.api.model;

import com.buschmais.xo.neo4j.api.annotation.Label;

@Label("Parameters")
public interface ParametersDescriptor extends ReferenceableDescriptor{

    String getEnum();

    void setEnum(String en);

    String getDefault();

    void setDefault(String defalt);

    String getDescription();

    void setDescription(String description);

    String getExamples();

    void setExamples(String examples);

    String getLocation();

    void setLocation(String location);

    String getName();

    void setName(String name);

}
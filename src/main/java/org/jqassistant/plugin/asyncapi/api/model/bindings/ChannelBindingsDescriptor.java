package org.jqassistant.plugin.asyncapi.api.model.bindings;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.AsyncApiDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.ReferenceDescriptor;

@Label("Channel_Binding")
public interface ChannelBindingsDescriptor extends AsyncApiDescriptor, ReferenceDescriptor {

}

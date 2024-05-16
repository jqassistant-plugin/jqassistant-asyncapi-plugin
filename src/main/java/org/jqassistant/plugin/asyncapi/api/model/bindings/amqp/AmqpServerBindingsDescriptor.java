package org.jqassistant.plugin.asyncapi.api.model.bindings.amqp;

import com.buschmais.xo.neo4j.api.annotation.Label;

import org.jqassistant.plugin.asyncapi.api.model.ReferenceableDescriptor;

@Label("AMQP_Server")
public interface AmqpServerBindingsDescriptor extends ReferenceableDescriptor {

    /** AsyncApi Spec: This object MUST NOT contain any properties.
     Its name is reserved for future use.**/

}
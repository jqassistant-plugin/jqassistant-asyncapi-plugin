package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.server;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsServerBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.jms.JMSServerBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.serverBindings.JmsServerBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class JmsServerBindingsMapperDecorator extends AbstractReferenceObjectMapperDecorator<JMSServerBinding, JmsServerBindingsDescriptor>
        implements JmsServerBindingsMapper {

    protected JmsServerBindingsMapperDecorator(JmsServerBindingsMapper mapper) {
        super("kafka", JmsServerBindingsDescriptor.class, mapper);
    }

    @Override
    public JmsServerBindingsDescriptor toDescriptor(JMSServerBinding binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

}
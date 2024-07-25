package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.message;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.jms.JmsMessageBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.jms.JMSMessageBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.messageBindings.JmsMessageBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class JmsMessageBindingsMapperDecorator extends AbstractReferenceObjectMapperDecorator<JMSMessageBinding, JmsMessageBindingsDescriptor>
        implements JmsMessageBindingsMapper {

    protected JmsMessageBindingsMapperDecorator(JmsMessageBindingsMapper mapper) {
        super("kafka", JmsMessageBindingsDescriptor.class, mapper);
    }

    @Override
    public JmsMessageBindingsDescriptor toDescriptor(JMSMessageBinding binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

}
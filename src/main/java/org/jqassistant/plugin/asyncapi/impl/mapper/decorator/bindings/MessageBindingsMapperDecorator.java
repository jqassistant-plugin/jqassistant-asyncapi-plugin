package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.MessageBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.OperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.MessageBindings;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBindings;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.MessageBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.OperationBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class MessageBindingsMapperDecorator extends AbstractReferenceObjectMapperDecorator<MessageBindings, MessageBindingsDescriptor> implements
        MessageBindingsMapper {

    public MessageBindingsMapperDecorator(MessageBindingsMapper mapper) {
        super("bindings", MessageBindingsDescriptor.class, mapper);
    }

    @Override
    public MessageBindingsDescriptor toDescriptor(MessageBindings binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

}
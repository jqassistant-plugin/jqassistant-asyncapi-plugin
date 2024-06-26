package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.OperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBindings;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.OperationBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class OperationBindingsMapperDecorator extends AbstractReferenceObjectMapperDecorator<OperationBindings, OperationBindingsDescriptor>
        implements OperationBindingsMapper {

    protected OperationBindingsMapperDecorator(OperationBindingsMapper mapper) {
        super("bindings", OperationBindingsDescriptor.class, mapper);
    }

    @Override
    public OperationBindingsDescriptor toDescriptor(OperationBindings binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

}
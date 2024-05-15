package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ServerBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ServerBindings;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.ServerBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class ServerBindingsMapperDecorator extends AbstractReferenceObjectMapperDecorator<ServerBindings, ServerBindingsDescriptor>
        implements ServerBindingsMapper {

    public ServerBindingsMapperDecorator(ServerBindingsMapper mapper) {
        super("bindings", ServerBindingsDescriptor.class, mapper);
    }

    @Override
    public ServerBindingsDescriptor toDescriptor(ServerBindings binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

}
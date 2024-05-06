package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ComponentsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.components.Components;
import org.jqassistant.plugin.asyncapi.impl.mapper.ComponentsMapper;
import org.mapstruct.Context;

public abstract class ComponentsMapperDecorator extends AbstractReferenceObjectMapperDecorator<Components, ComponentsDescriptor> implements ComponentsMapper {

    public ComponentsMapperDecorator(ComponentsMapper mapper) {
        super("components", mapper);
    }

    @Override
    public ComponentsDescriptor toDescriptor(Components components, @Context Scanner scanner) {
        return super.toDescriptor(components, scanner);
    }

}
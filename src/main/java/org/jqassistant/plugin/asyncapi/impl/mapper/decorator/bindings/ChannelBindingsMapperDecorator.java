package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings;

import java.util.List;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBindings;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.ChannelBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class ChannelBindingsMapperDecorator extends AbstractReferenceObjectMapperDecorator<ChannelBindings, ChannelBindingsDescriptor>
        implements ChannelBindingsMapper {

    protected ChannelBindingsMapperDecorator(ChannelBindingsMapper mapper) {
        super("bindings", ChannelBindingsDescriptor.class, mapper);
    }

    @Override
    public ChannelBindingsDescriptor toDescriptor(ChannelBindings binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

    @Override
    public List<ChannelBindingsDescriptor> toDescriptors(List<ChannelBindings> bindings, @Context Scanner scanner) {
        return super.toDescriptors(bindings, scanner);
    }
}
package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ChannelDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.ChannelObject;
import org.jqassistant.plugin.asyncapi.impl.mapper.ChannelMapper;
import org.mapstruct.Context;

public abstract class ChannelMapperDecorator extends AbstractReferenceObjectMapperDecorator<ChannelObject, ChannelDescriptor> implements ChannelMapper {

    protected ChannelMapperDecorator(ChannelMapper mapper) {
        super("channel", ChannelDescriptor.class, mapper);
    }

    @Override
    public ChannelDescriptor toDescriptor(ChannelObject channel, @Context Scanner scanner) {
        return super.toDescriptor(channel, scanner);
    }

    @Override
    public List<ChannelDescriptor> toDescriptors(Map<String, ChannelObject> channels, @Context Scanner scanner) {
        return super.toDescriptors(channels, scanner);
    }

    @Override
    public List<ChannelDescriptor> toDescriptors(List<ChannelObject> channels, @Context Scanner scanner) {
        return super.toDescriptors(channels, scanner);
    }
}
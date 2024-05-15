package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ChannelDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.ChannelObject;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.ChannelBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ChannelsMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { TagMapper.class, ExternalDocsMapper.class, ParametersMapper.class, CorrelationIdMapper.class, MessagesMapper.class, ServerMapper.class,
        ChannelBindingsMapper.class }, config = DescriptorMapperConfig.class)
@DecoratedWith(ChannelsMapperDecorator.class)
public interface ChannelsMapper extends ReferenceableObjectMapper<ChannelObject, ChannelDescriptor> {

    ChannelsMapper INSTANCE = Mappers.getMapper(ChannelsMapper.class);


    @Mapping(target = "path", ignore = true)
    @Mapping(target = "name", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference" })
    @Override
    ChannelDescriptor toDescriptor(ChannelObject channel, @Context Scanner scanner);

    @Override
    default List<ChannelDescriptor> toDescriptors(Map<String, ChannelObject> channels, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<ChannelDescriptor> toDescriptors(List<ChannelObject> channels, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}


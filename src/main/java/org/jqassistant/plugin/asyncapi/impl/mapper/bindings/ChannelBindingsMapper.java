package org.jqassistant.plugin.asyncapi.impl.mapper.bindings;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBindings;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings.JmsChannelBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings.KafkaChannelBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings.WsChannelBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.ChannelBindingsMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;

@Mapper(uses = { KafkaChannelBindingsMapper.class, WsChannelBindingsMapper.class, JmsChannelBindingsMapper.class })
@DecoratedWith(ChannelBindingsMapperDecorator.class)
public interface ChannelBindingsMapper extends ReferenceableObjectMapper<ChannelBindings, ChannelBindingsDescriptor> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @Mapping(target = "amqp", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference", "amqp" })
    @Override
    ChannelBindingsDescriptor toDescriptor(ChannelBindings channelBinding, @Context Scanner scanner);

    @Override
    default List<ChannelBindingsDescriptor> toDescriptors(Map<String, ChannelBindings> bindings, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<ChannelBindingsDescriptor> toDescriptors(List<ChannelBindings> bindings, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}
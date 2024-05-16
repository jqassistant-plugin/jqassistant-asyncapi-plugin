package org.jqassistant.plugin.asyncapi.impl.mapper.bindings;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ServerBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ServerBindings;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.serverBindings.JmsServerBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.serverBindings.KafkaServerBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.ServerBindingsMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;

@Mapper(uses = {KafkaServerBindingsMapper.class, JmsServerBindingsMapper.class})
@DecoratedWith(ServerBindingsMapperDecorator.class)
public interface ServerBindingsMapper extends ReferenceableObjectMapper<ServerBindings, ServerBindingsDescriptor> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @Mapping(target = "amqp", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = {"reference", "amqp", "pulsar"})
    @Override
    ServerBindingsDescriptor toDescriptor(ServerBindings binding, @Context Scanner scanner);

    @Override
    default List<ServerBindingsDescriptor> toDescriptors(Map<String, ServerBindings> bindings, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<ServerBindingsDescriptor> toDescriptors(List<ServerBindings> bindings, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}
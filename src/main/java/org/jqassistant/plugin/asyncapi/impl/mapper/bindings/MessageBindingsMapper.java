package org.jqassistant.plugin.asyncapi.impl.mapper.bindings;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.MessageBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.MessageBindings;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.messageBindings.JmsMessageBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.messageBindings.KafkaMessageBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.MessageBindingsMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;

@Mapper(uses = { KafkaMessageBindingsMapper.class, JmsMessageBindingsMapper.class })
@DecoratedWith(MessageBindingsMapperDecorator.class)
public interface MessageBindingsMapper extends ReferenceableObjectMapper<MessageBindings, MessageBindingsDescriptor> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @Mapping(target = "amqp", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference", "amqp" })
    @Override
    MessageBindingsDescriptor toDescriptor(MessageBindings bindings, @Context Scanner scanner);

    @Override
    default List<MessageBindingsDescriptor> toDescriptors(Map<String, MessageBindings> bindings, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<MessageBindingsDescriptor> toDescriptors(List<MessageBindings> bindings, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}
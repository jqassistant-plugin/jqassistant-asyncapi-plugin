package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.MessageExampleDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageExample;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.MessageExampleMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
@DecoratedWith(MessageExampleMapperDecorator.class)
public interface MessageExampleMapper extends ReferenceableObjectMapper<MessageExample, MessageExampleDescriptor> {

    MessageExampleMapper INSTANCE = Mappers.getMapper(MessageExampleMapper.class);

    @Mapping(target = "reference", ignore = true)
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference", "headers", "payload" })
    @Override
    MessageExampleDescriptor toDescriptor(MessageExample message, @Context Scanner scanner);

    @Override
    default List<MessageExampleDescriptor> toDescriptors(Map<String, MessageExample> examples, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<MessageExampleDescriptor> toDescriptors(List<MessageExample> examples, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}
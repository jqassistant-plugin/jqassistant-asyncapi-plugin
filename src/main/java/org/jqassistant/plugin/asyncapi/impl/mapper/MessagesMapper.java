package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.MessageDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageObject;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.MessageBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.MessagesMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CorrelationIdMapper.class, TagMapper.class, ExternalDocsMapper.class, MessageTraitMapper.class,
        MessageExampleMapper.class, MessageBindingsMapper.class}, config = DescriptorMapperConfig.class)
@DecoratedWith(MessagesMapperDecorator.class)
public interface MessagesMapper extends ReferenceableObjectMapper<MessageObject, MessageDescriptor> {

    MessagesMapper INSTANCE = Mappers.getMapper(MessagesMapper.class);

    @ReferenceableObjectMapping
    @BeanMapping(ignoreUnmappedSourceProperties = {"reference", "messageId", "payload", "headers"})
    @Override
    MessageDescriptor toDescriptor(MessageObject message, @Context Scanner scanner);

    default List<MessageDescriptor> toDescriptors(Map<String, MessageObject> messages, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    default List<MessageDescriptor> toDescriptors(List<MessageObject> messages, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}
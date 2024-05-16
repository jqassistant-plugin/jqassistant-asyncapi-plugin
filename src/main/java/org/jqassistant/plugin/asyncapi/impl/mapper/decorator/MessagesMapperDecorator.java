package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.MessageDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageObject;
import org.jqassistant.plugin.asyncapi.impl.mapper.MessagesMapper;
import org.mapstruct.Context;

public abstract class MessagesMapperDecorator extends AbstractReferenceObjectMapperDecorator<MessageObject, MessageDescriptor> implements MessagesMapper {

    protected MessagesMapperDecorator(MessagesMapper mapper) {
        super("messages", MessageDescriptor.class, mapper);
    }

    @Override
    public List<MessageDescriptor> toDescriptors(Map<String, MessageObject> messages, @Context Scanner scanner) {
        return super.toDescriptors(messages, scanner);
    }

    @Override
    public List<MessageDescriptor> toDescriptors(List<MessageObject> messages, @Context Scanner scanner) {
        return super.toDescriptors(messages, scanner);
    }

}
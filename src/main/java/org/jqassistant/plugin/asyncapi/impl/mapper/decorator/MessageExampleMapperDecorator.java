package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.MessageExampleDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageExample;
import org.jqassistant.plugin.asyncapi.impl.mapper.MessageExampleMapper;
import org.mapstruct.Context;

public abstract class MessageExampleMapperDecorator extends AbstractReferenceObjectMapperDecorator<MessageExample, MessageExampleDescriptor>
        implements MessageExampleMapper {

    public MessageExampleMapperDecorator(MessageExampleMapper mapper) {
        super("examples", mapper);
    }

    @Override
    public List<MessageExampleDescriptor> toDescriptors(Map<String, MessageExample> examples, @Context Scanner scanner) {
        return super.toDescriptors(examples, scanner);
    }

    //TODO: handle varying pathname "traits" and "messageTraits"
}
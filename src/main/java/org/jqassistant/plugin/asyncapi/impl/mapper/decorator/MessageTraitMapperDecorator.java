package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.MessageTraitDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageTrait;
import org.jqassistant.plugin.asyncapi.impl.mapper.MessageTraitMapper;
import org.mapstruct.Context;

public abstract class MessageTraitMapperDecorator extends AbstractReferenceObjectMapperDecorator<MessageTrait, MessageTraitDescriptor>
        implements MessageTraitMapper {

    public MessageTraitMapperDecorator(MessageTraitMapper mapper) {
        super("traits", mapper);
    }

    @Override
    public List<MessageTraitDescriptor> toDescriptors(Map<String, MessageTrait> traits, @Context Scanner scanner) {
        return super.toDescriptors(traits, scanner);
    }

    //TODO: handle varying pathname "traits" and "messageTraits"
}
package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.MessageTraitDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageTrait;
import org.jqassistant.plugin.asyncapi.impl.mapper.ComponentsMessageTraitMapper;
import org.mapstruct.Context;

public abstract class ComponentsMessageTraitMapperDecorator extends AbstractReferenceObjectMapperDecorator<MessageTrait, MessageTraitDescriptor>
        implements ComponentsMessageTraitMapper {

    protected ComponentsMessageTraitMapperDecorator(ComponentsMessageTraitMapper mapper) {
        super("messageTraits", MessageTraitDescriptor.class, mapper);
    }

    @Override
    public List<MessageTraitDescriptor> toDescriptors(Map<String, MessageTrait> traits, @Context Scanner scanner) {
        return super.toDescriptors(traits, scanner);
    }
}
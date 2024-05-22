package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.MessageTraitDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageTrait;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.MessageBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ComponentsMessageTraitMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { CorrelationIdMapper.class, TagMapper.class, ExternalDocsMapper.class, MessageExampleMapper.class, MessageBindingsMapper.class }, config = DescriptorMapperConfig.class)
@DecoratedWith(ComponentsMessageTraitMapperDecorator.class)
public interface ComponentsMessageTraitMapper extends ReferenceableObjectMapper<MessageTrait, MessageTraitDescriptor> {

    MessageTraitMapper INSTANCE = Mappers.getMapper(MessageTraitMapper.class);

    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference", "bindings", "headers" })
    @Override
    MessageTraitDescriptor toDescriptor(MessageTrait message, @Context Scanner scanner);

    @Override
    default List<MessageTraitDescriptor> toDescriptors(Map<String, MessageTrait> traits, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<MessageTraitDescriptor> toDescriptors(List<MessageTrait> traits, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}
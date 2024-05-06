package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.MessageTraitDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.message.MessageTrait;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { CorrelationIdMapper.class, TagMapper.class, ExternalDocsMapper.class, MessageExampleMapper.class }, config = DescriptorMapperConfig.class)
public interface MessageTraitMapper extends ReferenceableObjectMapper<MessageTrait, MessageTraitDescriptor> {

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
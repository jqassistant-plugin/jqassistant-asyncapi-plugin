package org.jqassistant.plugin.asyncapi.impl.mapper.bindings.messageBindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaMessageBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaMessageBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings.TopicConfigurationMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.message.KafkaMessageBindingsMapperDecorator;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = TopicConfigurationMapper.class)
@DecoratedWith(KafkaMessageBindingsMapperDecorator.class)
public interface KafkaMessageBindingsMapper extends DescriptorMapper<KafkaMessageBinding, KafkaMessageBindingsDescriptor> {

    KafkaMessageBindingsMapper INSTANCE = Mappers.getMapper(KafkaMessageBindingsMapper.class);

    @Mapping(target = "path", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "key", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference" }) //add Schema key
    @Override
    KafkaMessageBindingsDescriptor toDescriptor(KafkaMessageBinding kafka, @Context Scanner scanner);

}

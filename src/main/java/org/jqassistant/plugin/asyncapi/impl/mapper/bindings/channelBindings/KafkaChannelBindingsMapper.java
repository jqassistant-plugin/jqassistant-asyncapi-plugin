package org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.ReferenceableObjectMapping;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.channel.KafkaChannelBindingsMapperDecorator;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = TopicConfigurationMapper.class)
@DecoratedWith(KafkaChannelBindingsMapperDecorator.class)
public interface KafkaChannelBindingsMapper extends DescriptorMapper<KafkaChannelBinding, KafkaChannelBindingsDescriptor> {

    KafkaChannelBindingsMapper INSTANCE = Mappers.getMapper(KafkaChannelBindingsMapper.class);

    @ReferenceableObjectMapping
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference" })
    @Override
    KafkaChannelBindingsDescriptor toDescriptor(KafkaChannelBinding binding, @Context Scanner scanner);

}

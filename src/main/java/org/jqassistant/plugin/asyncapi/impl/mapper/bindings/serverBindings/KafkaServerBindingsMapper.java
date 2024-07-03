package org.jqassistant.plugin.asyncapi.impl.mapper.bindings.serverBindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaServerBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaServerBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.ReferenceableObjectMapping;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings.TopicConfigurationMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.server.KafkaServerBindingsMapperDecorator;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = TopicConfigurationMapper.class)
@DecoratedWith(KafkaServerBindingsMapperDecorator.class)
public interface KafkaServerBindingsMapper extends DescriptorMapper<KafkaServerBinding, KafkaServerBindingsDescriptor> {

    KafkaServerBindingsMapper INSTANCE = Mappers.getMapper(KafkaServerBindingsMapper.class);

    @ReferenceableObjectMapping
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference" })
    @Override
    KafkaServerBindingsDescriptor toDescriptor(KafkaServerBinding kafka, @Context Scanner scanner);

}

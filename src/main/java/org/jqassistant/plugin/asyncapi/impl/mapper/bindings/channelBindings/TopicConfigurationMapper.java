package org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.TopicConfigurationDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaChannelTopicConfiguration;
import org.jqassistant.plugin.asyncapi.impl.mapper.ReferenceableObjectMapping;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.channel.TopicConfigurationMapperDecorator;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
@DecoratedWith(TopicConfigurationMapperDecorator.class)
public interface TopicConfigurationMapper extends DescriptorMapper<KafkaChannelTopicConfiguration, TopicConfigurationDescriptor> {

    TopicConfigurationMapper INSTANCE = Mappers.getMapper(TopicConfigurationMapper.class);

    @ReferenceableObjectMapping
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    TopicConfigurationDescriptor toDescriptor(KafkaChannelTopicConfiguration topicConfig, @Context Scanner scanner);


}



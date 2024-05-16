package org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.TopicConfigurationDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaChannelTopicConfiguration;
import org.mapstruct.BeanMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TopicConfigurationMapper extends DescriptorMapper<KafkaChannelTopicConfiguration, TopicConfigurationDescriptor> {

    TopicConfigurationMapper INSTANCE = Mappers.getMapper(TopicConfigurationMapper.class);


    @Mapping(target = "path", ignore = true)
    @Mapping(target = "name", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    TopicConfigurationDescriptor toDescriptor(KafkaChannelTopicConfiguration topicConfig, @Context Scanner scanner);
       // insert usual mapping toDescriptors

}



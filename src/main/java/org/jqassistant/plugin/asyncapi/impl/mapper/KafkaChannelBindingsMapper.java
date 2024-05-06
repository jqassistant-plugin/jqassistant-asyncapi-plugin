package org.jqassistant.plugin.asyncapi.impl.mapper;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaChannelBinding;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KafkaChannelBindingsMapper extends DescriptorMapper<ChannelBinding, KafkaChannelBindingsDescriptor> {

    KafkaChannelBindingsMapper INSTANCE = Mappers.getMapper(KafkaChannelBindingsMapper.class);

    @Mapping(target = "name", ignore = true)
    @Override
    default KafkaChannelBindingsDescriptor toDescriptor(ChannelBinding binding, @Context Scanner scanner) {

        KafkaChannelBinding b = (KafkaChannelBinding) binding;
        KafkaChannelBindingsDescriptor kafkaChannelBindingsDescriptor = scanner.getContext()
                .getStore()
                .create(KafkaChannelBindingsDescriptor.class);
        if (b.getPartitions() != null) {
            kafkaChannelBindingsDescriptor.setPartitions(b.getPartitions());
        }
        if (b.getReplicas() != null) {
            kafkaChannelBindingsDescriptor.setReplicas(b.getReplicas());
        }
        if (b.getTopic() != null) {
            kafkaChannelBindingsDescriptor.setTopic(b.getTopic());
        }
        if (b.getBindingVersion() != null) {
            kafkaChannelBindingsDescriptor.setBindingVersion(b.getBindingVersion());
        }
        if (b.getTopicConfiguration() != null) {
            kafkaChannelBindingsDescriptor.setTopicConfiguration(TopicConfigurationMapper.INSTANCE.toDescriptor(b.getTopicConfiguration(), scanner));
        }

        return kafkaChannelBindingsDescriptor;

    }
}

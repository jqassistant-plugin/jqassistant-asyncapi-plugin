package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.TopicConfigurationDescriptor;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TopicConfigurationMapper extends DescriptorMapper<Object, TopicConfigurationDescriptor> {

    TopicConfigurationMapper INSTANCE = Mappers.getMapper(TopicConfigurationMapper.class);

    default TopicConfigurationDescriptor toDescriptor(Object topicConfig, @Context Scanner scanner) {
        Map<String, Object> config = (Map<String, Object>) topicConfig;
        if (config != null) {
            TopicConfigurationDescriptor topicConfigurationDescriptor = scanner.getContext()
                    .getStore()
                    .create(TopicConfigurationDescriptor.class);
            if (config.get("cleanup.policy") != null) {
                topicConfigurationDescriptor.setCleanupPolicy(config.get("cleanup.policy")
                        .toString());
            }
            if (config.get("retention.ms") != null) {
                long a = (int) config.get("retention.ms");
                topicConfigurationDescriptor.setRetentionMS(a);
            }
            if (config.get("retention.bytes") != null) {
                long a = (int) config.get("retention.bytes");
                topicConfigurationDescriptor.setRetentionBytes(a);
            }
            if (config.get("delete.retention.ms") != null) {
                long a = (int) config.get("delete.retention.ms");
                topicConfigurationDescriptor.setDeleteRetentionMS(a);
            }
            if (config.get("max.message.bytes") != null) {
                topicConfigurationDescriptor.setMaxMessageBytes((int) config.get("max.message.bytes"));
            }
            if (config.get("confluent.key.schema.validation") != null) {
                topicConfigurationDescriptor.setConfluentKeySchemaValidation((boolean) config.get("confluent.key.schema.validation"));
            }
            if (config.get("confluent.key.subject.name.strategy") != null) {
                topicConfigurationDescriptor.setConfluentKeySubjectNameStrategy((String) config.get("confluent.key.subject.name.strategy"));
            }
            if (config.get("confluent.value.schema.validation") != null) {
                topicConfigurationDescriptor.setConfluentValueSchemaValidation((boolean) config.get("confluent.value.schema.validation"));
            }
            return topicConfigurationDescriptor;
        }
        return null;
    }
}



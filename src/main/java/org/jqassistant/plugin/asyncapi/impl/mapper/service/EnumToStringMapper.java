package org.jqassistant.plugin.asyncapi.impl.mapper.service;

import java.util.List;

import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaChannelTopicCleanupPolicy;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaChannelTopicConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface EnumToStringMapper {

    default String map(KafkaChannelTopicCleanupPolicy e) {
        if (e != null) {
            return e.toString();
        }
        return null;
    }
}

package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.channel;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.TopicConfigurationDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaChannelTopicConfiguration;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings.TopicConfigurationMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class TopicConfigurationMapperDecorator extends AbstractReferenceObjectMapperDecorator<KafkaChannelTopicConfiguration, TopicConfigurationDescriptor>
        implements TopicConfigurationMapper {

    protected TopicConfigurationMapperDecorator(TopicConfigurationMapper mapper) {
        super("topicConfiguration", TopicConfigurationDescriptor.class, mapper);
    }

    @Override
    public TopicConfigurationDescriptor toDescriptor(KafkaChannelTopicConfiguration config, @Context Scanner scanner) {
        return super.toDescriptor(config, scanner);
    }

}
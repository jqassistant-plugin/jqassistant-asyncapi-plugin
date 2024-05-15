package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.channel;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.channelBindings.kafka.KafkaChannelBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class KafkaChannelBindingsMapperDecorator
        extends AbstractReferenceObjectMapperDecorator<KafkaChannelBinding, KafkaChannelBindingsDescriptor> implements KafkaChannelBindingsMapper {

    public KafkaChannelBindingsMapperDecorator(KafkaChannelBindingsMapper mapper) {
        super("kafka", KafkaChannelBindingsDescriptor.class, mapper);
    }

    @Override
    public KafkaChannelBindingsDescriptor toDescriptor(KafkaChannelBinding binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

}
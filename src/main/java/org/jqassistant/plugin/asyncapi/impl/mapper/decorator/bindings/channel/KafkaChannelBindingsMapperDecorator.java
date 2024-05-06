package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.channel;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaChannelBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.KafkaChannelBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.BindingsAbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class KafkaChannelBindingsMapperDecorator
        extends BindingsAbstractReferenceObjectMapperDecorator<KafkaChannelBinding, KafkaChannelBindingsDescriptor> implements KafkaChannelBindingsMapper {

    public KafkaChannelBindingsMapperDecorator(KafkaChannelBindingsMapper mapper) {
        super("kafka", mapper);
    }

    @Override
    public KafkaChannelBindingsDescriptor toDescriptor(KafkaChannelBinding binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

}
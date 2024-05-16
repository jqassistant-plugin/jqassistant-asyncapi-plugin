package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.server;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaServerBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaServerBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.serverBindings.KafkaServerBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class KafkaServerBindingsMapperDecorator extends AbstractReferenceObjectMapperDecorator<KafkaServerBinding, KafkaServerBindingsDescriptor>
        implements KafkaServerBindingsMapper {

    protected KafkaServerBindingsMapperDecorator(KafkaServerBindingsMapper mapper) {
        super("kafka", KafkaServerBindingsDescriptor.class, mapper);
    }

    @Override
    public KafkaServerBindingsDescriptor toDescriptor(KafkaServerBinding binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

}
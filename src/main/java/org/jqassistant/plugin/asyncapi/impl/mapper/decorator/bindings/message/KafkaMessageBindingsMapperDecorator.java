package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.message;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaMessageBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaOperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaMessageBinding;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaOperationBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.messageBindings.KafkaMessageBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.operationBindings.KafkaOperationBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class KafkaMessageBindingsMapperDecorator
        extends AbstractReferenceObjectMapperDecorator<KafkaMessageBinding, KafkaMessageBindingsDescriptor> implements KafkaMessageBindingsMapper {

    public KafkaMessageBindingsMapperDecorator(KafkaMessageBindingsMapper mapper) {
        super("kafka", KafkaMessageBindingsDescriptor.class, mapper);
    }

    @Override
    public KafkaMessageBindingsDescriptor toDescriptor(KafkaMessageBinding binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

}
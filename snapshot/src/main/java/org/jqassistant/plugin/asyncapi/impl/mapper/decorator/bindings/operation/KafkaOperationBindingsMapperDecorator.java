package org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.operation;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaOperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaOperationBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.operationBindings.KafkaOperationBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.AbstractReferenceObjectMapperDecorator;
import org.mapstruct.Context;

public abstract class KafkaOperationBindingsMapperDecorator
        extends AbstractReferenceObjectMapperDecorator<KafkaOperationBinding, KafkaOperationBindingsDescriptor> implements KafkaOperationBindingsMapper {

    protected KafkaOperationBindingsMapperDecorator(KafkaOperationBindingsMapper mapper) {
        super("kafka", KafkaOperationBindingsDescriptor.class, mapper);
    }

    @Override
    public KafkaOperationBindingsDescriptor toDescriptor(KafkaOperationBinding binding, @Context Scanner scanner) {
        return super.toDescriptor(binding, scanner);
    }

}
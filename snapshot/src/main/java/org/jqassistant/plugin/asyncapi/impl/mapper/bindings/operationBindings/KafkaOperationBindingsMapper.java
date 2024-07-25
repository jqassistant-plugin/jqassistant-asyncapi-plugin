package org.jqassistant.plugin.asyncapi.impl.mapper.bindings.operationBindings;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;
import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaOperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.kafka.KafkaOperationBinding;
import org.jqassistant.plugin.asyncapi.impl.mapper.ReferenceableObjectMapping;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.operation.KafkaOperationBindingsMapperDecorator;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
@DecoratedWith(KafkaOperationBindingsMapperDecorator.class)
public interface KafkaOperationBindingsMapper extends DescriptorMapper<KafkaOperationBinding, KafkaOperationBindingsDescriptor> {

    KafkaOperationBindingsMapper INSTANCE = Mappers.getMapper(KafkaOperationBindingsMapper.class);

    @ReferenceableObjectMapping
    @Mapping(target = "clientId", ignore = true)
    @Mapping(target = "groupId", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = {"reference"})
    @Override
    KafkaOperationBindingsDescriptor toDescriptor(KafkaOperationBinding binding, @Context Scanner scanner);
}

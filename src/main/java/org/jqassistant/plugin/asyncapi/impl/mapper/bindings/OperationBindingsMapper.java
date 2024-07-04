package org.jqassistant.plugin.asyncapi.impl.mapper.bindings;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.bindings.OperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBindings;
import org.jqassistant.plugin.asyncapi.impl.mapper.ReferenceableObjectMapping;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.operationBindings.KafkaOperationBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.OperationBindingsMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;

@Mapper(uses = { KafkaOperationBindingsMapper.class })
@DecoratedWith(OperationBindingsMapperDecorator.class)
public interface OperationBindingsMapper extends ReferenceableObjectMapper<OperationBindings, OperationBindingsDescriptor> {

    @ReferenceableObjectMapping
    @Mapping(target = "amqp", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference", "amqp" })
    @Override
    OperationBindingsDescriptor toDescriptor(OperationBindings binding, @Context Scanner scanner);

    @Override
    default List<OperationBindingsDescriptor> toDescriptors(Map<String, OperationBindings> bindings, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<OperationBindingsDescriptor> toDescriptors(List<OperationBindings> bindings, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}
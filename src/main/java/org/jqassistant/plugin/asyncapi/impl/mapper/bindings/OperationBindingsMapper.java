package org.jqassistant.plugin.asyncapi.impl.mapper.bindings;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.ChannelBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.api.model.bindings.OperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ChannelBindings;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBindings;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.operationBindings.KafkaOperationBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.bindings.OperationBindingsMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;

@Mapper(uses ={ KafkaOperationBindingsMapper.class })
@DecoratedWith(OperationBindingsMapperDecorator.class)
public interface OperationBindingsMapper extends ReferenceableObjectMapper<OperationBindings, OperationBindingsDescriptor> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @Mapping(target = "amqp", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = {"reference", "ws", "jms", "amqp"})
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
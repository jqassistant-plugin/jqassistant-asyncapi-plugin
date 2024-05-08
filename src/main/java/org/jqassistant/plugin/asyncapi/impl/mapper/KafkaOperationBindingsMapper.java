package org.jqassistant.plugin.asyncapi.impl.mapper;

import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.plugin.common.api.mapper.DescriptorMapper;

import org.jqassistant.plugin.asyncapi.api.model.bindings.kafka.KafkaOperationBindingsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.OperationBinding;
import org.mapstruct.BeanMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KafkaOperationBindingsMapper extends DescriptorMapper<OperationBinding, KafkaOperationBindingsDescriptor> {

    KafkaOperationBindingsMapper INSTANCE = Mappers.getMapper(KafkaOperationBindingsMapper.class);

    @Mapping(target = "groupId", ignore = true)
    @Mapping(target = "clientId", ignore = true)
    @Mapping(target = "bindingVersion", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    KafkaOperationBindingsDescriptor toDescriptor(OperationBinding binding, @Context Scanner scanner);
}

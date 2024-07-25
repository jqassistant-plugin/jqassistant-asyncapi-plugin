package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OperationDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.Operation;
import org.jqassistant.plugin.asyncapi.impl.mapper.bindings.OperationBindingsMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.OperationMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { ExternalDocsMapper.class, ChannelMapper.class, ParametersMapper.class, MessagesMapper.class, OperationTraitMapper.class,
        OperationReplyMapper.class, TagMapper.class, OperationBindingsMapper.class }, config = DescriptorMapperConfig.class)
@DecoratedWith(OperationMapperDecorator.class)
public interface OperationMapper extends ReferenceableObjectMapper<Operation, OperationDescriptor> {

    OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);

    @ReferenceableObjectMapping
    @Mapping(target = "security", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference", "security" })
    @Override
    OperationDescriptor toDescriptor(Operation operation, @Context Scanner scanner);

    @Override
    default List<OperationDescriptor> toDescriptors(Map<String, Operation> operations, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<OperationDescriptor> toDescriptors(List<Operation> operations, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}


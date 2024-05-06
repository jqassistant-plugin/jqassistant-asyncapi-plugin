package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OperationTraitsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.OperationTraits;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ComponentsOperationTraitsMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { CorrelationIdMapper.class, TagMapper.class, ExternalDocsMapper.class, MessageExampleMapper.class, SecuritySchemesMapper.class }, config = DescriptorMapperConfig.class)
@DecoratedWith(ComponentsOperationTraitsMapperDecorator.class)
public interface ComponentsOperationTraitsMapper extends ReferenceableObjectMapper<OperationTraits, OperationTraitsDescriptor> {

    ComponentsOperationTraitsMapper INSTANCE = Mappers.getMapper(ComponentsOperationTraitsMapper.class);

    @Mapping(target = "reference", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference", "bindings", "security" })
    @Override
    OperationTraitsDescriptor toDescriptor(OperationTraits traits, @Context Scanner scanner);

    @Override
    default List<OperationTraitsDescriptor> toDescriptors(Map<String, OperationTraits> traits, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<OperationTraitsDescriptor> toDescriptors(List<OperationTraits> traits, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}
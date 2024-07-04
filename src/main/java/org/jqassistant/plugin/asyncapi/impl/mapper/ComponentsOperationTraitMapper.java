package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OperationTraitDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.OperationTraits;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ComponentsOperationTraitMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { CorrelationIdMapper.class, TagMapper.class, ExternalDocsMapper.class, MessageExampleMapper.class,
        SecuritySchemesMapper.class }, config = DescriptorMapperConfig.class)
@DecoratedWith(ComponentsOperationTraitMapperDecorator.class)
public interface ComponentsOperationTraitMapper extends ReferenceableObjectMapper<OperationTraits, OperationTraitDescriptor> {

    ComponentsOperationTraitMapper INSTANCE = Mappers.getMapper(ComponentsOperationTraitMapper.class);

    @ReferenceableObjectMapping
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference", "bindings", "security" })
    @Override
    OperationTraitDescriptor toDescriptor(OperationTraits traits, @Context Scanner scanner);

    @Override
    default List<OperationTraitDescriptor> toDescriptors(Map<String, OperationTraits> traits, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<OperationTraitDescriptor> toDescriptors(List<OperationTraits> traits, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}
package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ExternalDocsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.ExternalDocumentation;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ExternalDocsMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import static java.util.Collections.emptyList;

@Mapper(config = DescriptorMapperConfig.class)
@DecoratedWith(ExternalDocsMapperDecorator.class)
public interface ExternalDocsMapper extends ReferenceableObjectMapper<ExternalDocumentation, ExternalDocsDescriptor> {

    ExternalDocsMapper INSTANCE = Mappers.getMapper(ExternalDocsMapper.class);

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    ExternalDocsDescriptor toDescriptor(ExternalDocumentation externalDocs, @Context Scanner scanner);

    @Override
    default List<ExternalDocsDescriptor> toDescriptors(List<ExternalDocumentation> values, Scanner scanner) {
        return emptyList();
    }

    @Override
    default List<ExternalDocsDescriptor> toDescriptors(Map<String, ExternalDocumentation> values, Scanner scanner) {
        return emptyList();
    }
}





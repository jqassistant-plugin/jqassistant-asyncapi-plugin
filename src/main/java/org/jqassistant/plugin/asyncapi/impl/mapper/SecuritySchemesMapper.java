package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.SecuritySchemeDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.SecurityScheme;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.SecuritySchemesMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {FlowsMapper.class}, config = DescriptorMapperConfig.class)
@DecoratedWith(SecuritySchemesMapperDecorator.class)
public interface SecuritySchemesMapper extends ReferenceableObjectMapper<SecurityScheme, SecuritySchemeDescriptor> {

    SecuritySchemesMapper INSTANCE = Mappers.getMapper(SecuritySchemesMapper.class);

    @Mapping(target = "OAuthFlows", source = "flows")
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference", "flows" })
    @Override
    SecuritySchemeDescriptor toDescriptor(SecurityScheme scheme, @Context Scanner scanner);

    @Override
    default List<SecuritySchemeDescriptor> toDescriptors(Map<String, SecurityScheme> schemes, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<SecuritySchemeDescriptor> toDescriptors(List<SecurityScheme> schemes, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}
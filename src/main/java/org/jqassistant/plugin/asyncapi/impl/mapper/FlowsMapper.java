package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OAuthFlowsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2.OAuthFlows;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.FlowsMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { FlowMapper.class }, config = DescriptorMapperConfig.class)
@DecoratedWith(FlowsMapperDecorator.class)
public interface FlowsMapper extends ReferenceableObjectMapper<OAuthFlows, OAuthFlowsDescriptor> {

    FlowsMapper INSTANCE = Mappers.getMapper(FlowsMapper.class);

    @Mapping(target = "passwordFlow", source = "password")
    @Mapping(target = "implicitFlow", source = "implicit")
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference" })
    @Override
    OAuthFlowsDescriptor toDescriptor(OAuthFlows flows, @Context Scanner scanner);

    @Override
    default List<OAuthFlowsDescriptor> toDescriptors(Map<String, OAuthFlows> flows, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<OAuthFlowsDescriptor> toDescriptors(List<OAuthFlows> flows, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}
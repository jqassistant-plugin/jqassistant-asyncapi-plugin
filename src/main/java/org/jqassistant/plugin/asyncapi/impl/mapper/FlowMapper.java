package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OAuthFlowDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2.OAuthFlow;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.FlowMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper( config = DescriptorMapperConfig.class)
@DecoratedWith(FlowMapperDecorator.class)
public interface FlowMapper extends ReferenceableObjectMapper<OAuthFlow, OAuthFlowDescriptor> {

    FlowMapper INSTANCE = Mappers.getMapper(FlowMapper.class);

    @ReferenceableObjectMapping
    @Mapping(target = "availableScopes", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = { "reference", "availableScopes" })
    @Override
    OAuthFlowDescriptor toDescriptor(OAuthFlow flow, @Context Scanner scanner);

    @Override
    default List<OAuthFlowDescriptor> toDescriptors(Map<String, OAuthFlow> flow, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<OAuthFlowDescriptor> toDescriptors(List<OAuthFlow> flow, @Context Scanner scanner) {
        return Collections.emptyList();
    }

}
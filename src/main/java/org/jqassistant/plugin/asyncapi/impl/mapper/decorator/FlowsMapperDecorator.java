package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OAuthFlowsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2.OAuthFlows;
import org.jqassistant.plugin.asyncapi.impl.mapper.FlowsMapper;
import org.mapstruct.Context;

public abstract class FlowsMapperDecorator extends AbstractReferenceObjectMapperDecorator<OAuthFlows, OAuthFlowsDescriptor> implements FlowsMapper {

    protected FlowsMapperDecorator(FlowsMapper mapper) {
        super("flows", OAuthFlowsDescriptor.class, mapper);
    }

    @Override
    public OAuthFlowsDescriptor toDescriptor(OAuthFlows flows, @Context Scanner scanner) {
        return super.toDescriptor(flows, scanner);
    }

    @Override
    public List<OAuthFlowsDescriptor> toDescriptors(Map<String, OAuthFlows> flows, @Context Scanner scanner) {
        return super.toDescriptors(flows, scanner);
    }
}
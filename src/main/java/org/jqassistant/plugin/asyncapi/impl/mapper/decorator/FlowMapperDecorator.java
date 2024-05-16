package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OAuthFlowDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.security_scheme.oauth2.OAuthFlow;
import org.jqassistant.plugin.asyncapi.impl.mapper.FlowMapper;
import org.mapstruct.Context;

public abstract class FlowMapperDecorator extends AbstractReferenceObjectMapperDecorator<OAuthFlow, OAuthFlowDescriptor> implements FlowMapper {

    protected FlowMapperDecorator(FlowMapper mapper) {
        super("flow", OAuthFlowDescriptor.class, mapper);
    }

    @Override
    public OAuthFlowDescriptor toDescriptor(OAuthFlow flows, @Context Scanner scanner) {
        return super.toDescriptor(flows, scanner);
    }

    @Override
    public List<OAuthFlowDescriptor> toDescriptors(Map<String, OAuthFlow> flows, @Context Scanner scanner) {
        return super.toDescriptors(flows, scanner);
    }
}
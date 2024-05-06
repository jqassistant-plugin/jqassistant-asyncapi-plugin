package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.CorrelationIDDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.CorrelationID;
import org.jqassistant.plugin.asyncapi.impl.mapper.ComponentsCorrelationIdMapper;
import org.mapstruct.Context;

public abstract class ComponentsCorrelationIdMapperDecorator extends AbstractReferenceObjectMapperDecorator<CorrelationID, CorrelationIDDescriptor>
        implements ComponentsCorrelationIdMapper {

    public ComponentsCorrelationIdMapperDecorator(ComponentsCorrelationIdMapper mapper) {
        super("correlationIds", mapper);
    }

    @Override
    public List<CorrelationIDDescriptor> toDescriptors(Map<String, CorrelationID> id, @Context Scanner scanner) {
        // super("correlationIds");
        return super.toDescriptors(id, scanner);
    }

    @Override
    public List<CorrelationIDDescriptor> toDescriptors(List<CorrelationID> ids, @Context Scanner scanner) {
        // super("correlationIds");
        return super.toDescriptors(ids, scanner);
    }

}
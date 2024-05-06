package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.CorrelationIDDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.CorrelationID;
import org.jqassistant.plugin.asyncapi.impl.mapper.CorrelationIdMapper;
import org.mapstruct.Context;

public abstract class CorrelationIdMapperDecorator extends AbstractReferenceObjectMapperDecorator<CorrelationID, CorrelationIDDescriptor>
        implements CorrelationIdMapper {

    public CorrelationIdMapperDecorator(CorrelationIdMapper mapper) {
        super("correlationId", mapper);
    }

    @Override
    public List<CorrelationIDDescriptor> toDescriptors(Map<String, CorrelationID> id, @Context Scanner scanner) {
        return super.toDescriptors(id, scanner);
    }

    @Override
    public List<CorrelationIDDescriptor> toDescriptors(List<CorrelationID> ids, @Context Scanner scanner) {
        return super.toDescriptors(ids, scanner);
    }

}
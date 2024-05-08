package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.CorrelationIDDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.CorrelationID;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.CorrelationIdMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;

@Mapper
@DecoratedWith(CorrelationIdMapperDecorator.class)
public interface CorrelationIdMapper extends ReferenceableObjectMapper<CorrelationID, CorrelationIDDescriptor> {


    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)

    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    CorrelationIDDescriptor toDescriptor(CorrelationID correlationID, @Context Scanner scanner);

    default List<CorrelationIDDescriptor> toDescriptors(Map<String, CorrelationID> id, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    default List<CorrelationIDDescriptor> toDescriptors(List<CorrelationID> ids, @Context Scanner scanner) {
        return Collections.emptyList();
    }
}

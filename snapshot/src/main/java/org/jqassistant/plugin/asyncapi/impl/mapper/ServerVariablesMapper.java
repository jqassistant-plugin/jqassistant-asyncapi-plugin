package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ServerVariableDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.server.ServerVariable;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ServerVariablesMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ListToStringMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;

@Mapper(uses = ListToStringMapper.class)
@DecoratedWith(ServerVariablesMapperDecorator.class)
public interface ServerVariablesMapper extends ReferenceableObjectMapper<ServerVariable, ServerVariableDescriptor> {

    @ReferenceableObjectMapping
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    ServerVariableDescriptor toDescriptor(ServerVariable serverVariable, @Context Scanner scanner);

    @Override
    default List<ServerVariableDescriptor> toDescriptors(Map<String, ServerVariable> serverVariables, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<ServerVariableDescriptor> toDescriptors(List<ServerVariable> serverVariables, @Context Scanner scanner) {
        return Collections.emptyList();
    }
}

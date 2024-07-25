package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ServerVariableDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.server.ServerVariable;
import org.jqassistant.plugin.asyncapi.impl.mapper.ServerVariablesMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.TreeNodeMapper;
import org.mapstruct.Context;

public abstract class ServerVariablesMapperDecorator extends AbstractReferenceObjectMapperDecorator<ServerVariable, ServerVariableDescriptor>
        implements ServerVariablesMapper, TreeNodeMapper {

    protected ServerVariablesMapperDecorator(ServerVariablesMapper mapper) {
        super("variables", ServerVariableDescriptor.class, mapper);
    }

    @Override
    public List<ServerVariableDescriptor> toDescriptors(Map<String, ServerVariable> vars, @Context Scanner scanner) {
        return super.toDescriptors(vars, scanner);
    }

}
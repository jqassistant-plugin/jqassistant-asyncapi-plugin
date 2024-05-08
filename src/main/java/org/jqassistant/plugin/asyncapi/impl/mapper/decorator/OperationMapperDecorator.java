package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OperationDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.Operation;
import org.jqassistant.plugin.asyncapi.impl.mapper.OperationMapper;
import org.mapstruct.Context;

public abstract class OperationMapperDecorator extends AbstractReferenceObjectMapperDecorator<Operation, OperationDescriptor> implements OperationMapper {

    public OperationMapperDecorator(OperationMapper mapper) {
        super("operations", OperationDescriptor.class, mapper);
    }

    @Override
    public List<OperationDescriptor> toDescriptors(Map<String, Operation> operations, @Context Scanner scanner) {
        return super.toDescriptors(operations, scanner);
    }

}
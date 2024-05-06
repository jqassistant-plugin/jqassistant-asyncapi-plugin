package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OperationTraitsDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.OperationTraits;
import org.jqassistant.plugin.asyncapi.impl.mapper.ComponentsOperationTraitsMapper;
import org.mapstruct.Context;

public abstract class ComponentsOperationTraitsMapperDecorator extends AbstractReferenceObjectMapperDecorator<OperationTraits, OperationTraitsDescriptor>
        implements ComponentsOperationTraitsMapper {

    public ComponentsOperationTraitsMapperDecorator(ComponentsOperationTraitsMapper mapper) {
        super("operationTraits", mapper);
    }

    @Override
    public OperationTraitsDescriptor toDescriptor(OperationTraits traits, @Context Scanner scanner) {
        return super.toDescriptor(traits, scanner);
    }

    @Override
    public List<OperationTraitsDescriptor> toDescriptors(Map<String, OperationTraits> replies, @Context Scanner scanner) {
        return super.toDescriptors(replies, scanner);
    }

    @Override
    public List<OperationTraitsDescriptor> toDescriptors(List<OperationTraits> replies, @Context Scanner scanner) {
        return super.toDescriptors(replies, scanner);
    }

}
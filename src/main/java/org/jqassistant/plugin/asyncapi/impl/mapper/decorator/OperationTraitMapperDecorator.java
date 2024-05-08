package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OperationTraitDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.OperationTraits;
import org.jqassistant.plugin.asyncapi.impl.mapper.OperationTraitMapper;
import org.mapstruct.Context;

public abstract class OperationTraitMapperDecorator extends AbstractReferenceObjectMapperDecorator<OperationTraits, OperationTraitDescriptor>
        implements OperationTraitMapper {

    public OperationTraitMapperDecorator(OperationTraitMapper mapper) {
        super("traits", OperationTraitDescriptor.class, mapper);
    }

    @Override
    public OperationTraitDescriptor toDescriptor(OperationTraits traits, @Context Scanner scanner) {
        return super.toDescriptor(traits, scanner);
    }

    @Override
    public List<OperationTraitDescriptor> toDescriptors(Map<String, OperationTraits> replies, @Context Scanner scanner) {
        return super.toDescriptors(replies, scanner);
    }

    @Override
    public List<OperationTraitDescriptor> toDescriptors(List<OperationTraits> replies, @Context Scanner scanner) {
        return super.toDescriptors(replies, scanner);
    }

}
package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OperationReplyAddressDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.OperationReplyAddress;
import org.jqassistant.plugin.asyncapi.impl.mapper.OperationReplyAddressMapper;
import org.mapstruct.Context;

public abstract class OperationReplyAddressMapperDecorator
        extends AbstractReferenceObjectMapperDecorator<OperationReplyAddress, OperationReplyAddressDescriptor> implements OperationReplyAddressMapper {

    public OperationReplyAddressMapperDecorator(OperationReplyAddressMapper mapper) {
        super("address", mapper);
    }

    @Override
    public List<OperationReplyAddressDescriptor> toDescriptors(Map<String, OperationReplyAddress> addresses, @Context Scanner scanner) {
        return super.toDescriptors(addresses, scanner);
    }

    @Override
    public List<OperationReplyAddressDescriptor> toDescriptors(List<OperationReplyAddress> addresses, @Context Scanner scanner) {
        return super.toDescriptors(addresses, scanner);
    }
}
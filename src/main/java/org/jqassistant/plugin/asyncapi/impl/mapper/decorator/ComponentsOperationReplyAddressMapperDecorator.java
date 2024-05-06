package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OperationReplyAddressDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.OperationReplyAddress;
import org.jqassistant.plugin.asyncapi.impl.mapper.ComponentsOperationReplyAddressMapper;
import org.mapstruct.Context;

public abstract class ComponentsOperationReplyAddressMapperDecorator
        extends AbstractReferenceObjectMapperDecorator<OperationReplyAddress, OperationReplyAddressDescriptor>
        implements ComponentsOperationReplyAddressMapper {

    public ComponentsOperationReplyAddressMapperDecorator(ComponentsOperationReplyAddressMapper mapper) {
        super("replyAddresses", mapper);
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
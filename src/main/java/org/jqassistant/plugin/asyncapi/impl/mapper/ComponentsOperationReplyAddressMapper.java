package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OperationReplyAddressDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.OperationReplyAddress;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ComponentsOperationReplyAddressMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;

@Mapper
@DecoratedWith(ComponentsOperationReplyAddressMapperDecorator.class)
public interface ComponentsOperationReplyAddressMapper extends ReferenceableObjectMapper<OperationReplyAddress, OperationReplyAddressDescriptor> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    OperationReplyAddressDescriptor toDescriptor(OperationReplyAddress replyAddress, @Context Scanner scanner);

    @Override
    default List<OperationReplyAddressDescriptor> toDescriptors(Map<String, OperationReplyAddress> address, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<OperationReplyAddressDescriptor> toDescriptors(List<OperationReplyAddress> address, @Context Scanner scanner) {
        return Collections.emptyList();
    }
}

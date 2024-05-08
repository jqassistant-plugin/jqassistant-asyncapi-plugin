package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OperationReplyDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.OperationReply;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ComponentsOperationReplyMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;

@Mapper(uses = { MessagesMapper.class, OperationReplyAddressMapper.class, ChannelsMapper.class })
@DecoratedWith(ComponentsOperationReplyMapperDecorator.class)
public interface ComponentsOperationReplyMapper extends ReferenceableObjectMapper<OperationReply, OperationReplyDescriptor> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "path", ignore = true)
    @Mapping(target = "address", source = "address", ignore = true)
    @Mapping(target = "channel", source = "channel", ignore = true)
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    OperationReplyDescriptor toDescriptor(OperationReply reply, @Context Scanner scanner);

    @Override
    default List<OperationReplyDescriptor> toDescriptors(Map<String, OperationReply> replies, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    @Override
    default List<OperationReplyDescriptor> toDescriptors(List<OperationReply> replies, @Context Scanner scanner) {
        return Collections.emptyList();
    }
}

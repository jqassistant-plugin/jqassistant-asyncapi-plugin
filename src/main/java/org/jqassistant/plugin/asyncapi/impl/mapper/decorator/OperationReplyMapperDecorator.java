package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.OperationReplyDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.operation.OperationReply;
import org.jqassistant.plugin.asyncapi.impl.mapper.OperationReplyMapper;
import org.mapstruct.Context;

public abstract class OperationReplyMapperDecorator extends AbstractReferenceObjectMapperDecorator<OperationReply, OperationReplyDescriptor>
        implements OperationReplyMapper {

    protected OperationReplyMapperDecorator(OperationReplyMapper mapper) {
        super("reply", OperationReplyDescriptor.class, mapper);
    }

    @Override
    public List<OperationReplyDescriptor> toDescriptors(Map<String, OperationReply> replies, @Context Scanner scanner) {
        return super.toDescriptors(replies, scanner);
    }
}
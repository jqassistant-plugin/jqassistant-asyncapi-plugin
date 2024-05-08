package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ParametersDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.ChannelParameter;
import org.jqassistant.plugin.asyncapi.impl.mapper.ParametersMapper;
import org.mapstruct.Context;

public abstract class ParametersMapperDecorator extends AbstractReferenceObjectMapperDecorator<ChannelParameter, ParametersDescriptor>
        implements ParametersMapper {

    public ParametersMapperDecorator(ParametersMapper mapper) {
        super("parameters", ParametersDescriptor.class, mapper);
    }

    @Override
    public List<ParametersDescriptor> toDescriptors(Map<String, ChannelParameter> parameters, @Context Scanner scanner) {
        return super.toDescriptors(parameters, scanner);
    }
}
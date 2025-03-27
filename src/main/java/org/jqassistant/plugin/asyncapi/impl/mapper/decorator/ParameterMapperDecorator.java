package org.jqassistant.plugin.asyncapi.impl.mapper.decorator;

import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ParameterDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.ChannelParameter;
import org.jqassistant.plugin.asyncapi.impl.mapper.ParameterMapper;
import org.mapstruct.Context;

public abstract class ParameterMapperDecorator extends AbstractReferenceObjectMapperDecorator<ChannelParameter, ParameterDescriptor>
        implements ParameterMapper {

    protected ParameterMapperDecorator(ParameterMapper mapper) {
        super("parameter", ParameterDescriptor.class, mapper);
    }

    @Override
    public List<ParameterDescriptor> toDescriptors(Map<String, ChannelParameter> parameter, @Context Scanner scanner) {
        return super.toDescriptors(parameter, scanner);
    }
}
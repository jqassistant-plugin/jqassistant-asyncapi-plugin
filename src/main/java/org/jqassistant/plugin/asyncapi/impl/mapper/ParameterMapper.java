package org.jqassistant.plugin.asyncapi.impl.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.buschmais.jqassistant.core.scanner.api.Scanner;

import org.jqassistant.plugin.asyncapi.api.model.ParameterDescriptor;
import org.jqassistant.plugin.asyncapi.impl.json.model.channel.ChannelParameter;
import org.jqassistant.plugin.asyncapi.impl.mapper.decorator.ParameterMapperDecorator;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ListToStringMapper;
import org.jqassistant.plugin.asyncapi.impl.mapper.service.ReferenceableObjectMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ListToStringMapper.class, config = DescriptorMapperConfig.class)
@DecoratedWith(ParameterMapperDecorator.class)
public interface ParameterMapper extends ReferenceableObjectMapper<ChannelParameter, ParameterDescriptor> {

    ParameterMapper INSTANCE = Mappers.getMapper(ParameterMapper.class);

    @ReferenceableObjectMapping
    @Mapping(target = "enum", source = "enumValues")
    @Mapping(target = "default", source = "defaultValue")
    @BeanMapping(ignoreUnmappedSourceProperties = "reference")
    @Override
    ParameterDescriptor toDescriptor(ChannelParameter parameter, @Context Scanner scanner);

    default List<ParameterDescriptor> toDescriptors(Map<String, ChannelParameter> parameter, @Context Scanner scanner) {
        return Collections.emptyList();
    }

    default List<ParameterDescriptor> toDescriptors(List<ChannelParameter> parameter, @Context Scanner scanner) {
        return Collections.emptyList();
    }
}
